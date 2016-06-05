package fiuba.algo3.algoFormers.Tablero;

import java.util.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.Habitables.*;
import fiuba.algo3.algoFormers.Tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.Vista.Aplicacion;
import fiuba.algo3.algoFormers.Vista.HexGrid;
import fiuba.algo3.algoFormers.Superficies.*;


public class Tablero {
	HashMap<Coordenada,Casillero> superficies = new HashMap<Coordenada,Casillero>();
	HashMap<Coordenada,HabitableDelMapa> habitables = new HashMap<Coordenada,HabitableDelMapa>();
	
	public Tablero(int height,int width){
		HexGrid.crearTablero(height,width);
		GeneradorDeCoordenadas.generarCasillerosDelTablero(this.superficies,height,width);
		GeneradorDeCoordenadas.generarCoordenadasDelTablero(this.habitables,height,width);
	}
	public boolean estaVacio(Coordenada coordenada) {
		return !(this.habitables.get(coordenada).ocupaLugar());

	}
	public void colocarSuperficieEnTablero(SuperficieTierra superficie,Coordenada coordenada){
		this.superficies.get(coordenada).agregarSuperficie(superficie);
	}
	public void colocarSuperficieEnTablero(SuperficieAire superficie,Coordenada coordenada){
		this.superficies.get(coordenada).agregarSuperficie(superficie);
	}
	public void colocarEnTablero(HabitableDelMapa habitable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).colisionar();
			//habitable.recibir(this.habitables.get(coordenada));
			this.superficies.get(coordenada).producirEfecto(habitable);
			this.habitables.put(coordenada,habitable);
		}
		catch(Throwable g){
			throw new MovimientoInvalidoException();
		}
	}
	public void colocarEnTablero(Collectable collectable,Coordenada coordenada){
		if(!this.habitables.get(coordenada).ocupaLugar()){
			this.habitables.put(coordenada, collectable);
			return;
		}
		throw new MovimientoInvalidoException();

	}
	public void mover(HabitableDelMapa habitable, Coordenada coordenadaFinal, int paso) {
		Coordenada coordInic = this.obtenerCoordenadaDeHabitable(habitable);
		List<Coordenada> camino = GeneradorDeCaminos.calcularCaminoDeCostoMinimo(this.superficies, this.habitables, habitable, coordInic, coordenadaFinal);
		if(coordInic.distancia(coordenadaFinal)>paso)
			throw new MovimientoInvalidoException();
		this.colocarEnTablero(habitable,coordenadaFinal);
		this.habitables.put(coordInic,new Vacio());
	}
	

	public Coordenada obtenerCoordenadaDeHabitable(HabitableDelMapa value){
        for(Map.Entry<Coordenada, HabitableDelMapa> entry : this.habitables.entrySet()) {
            if(value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}
	
	public void coordinateAttack(Autobot atacante, int range, HabitableDelMapa atacado, int ataque) {
		Coordenada coordInic = this.obtenerCoordenadaDeHabitable(atacante);
		Coordenada coordFinal = this.obtenerCoordenadaDeHabitable(atacado);
		if(coordInic.distancia(coordFinal)>range)
			throw new OutOfRangeException();
		atacado.serAtacado(atacante, ataque);
	}
	
	public void coordinateAttack(Decepticon atacante, int range, HabitableDelMapa atacado, int ataque) {
		Coordenada coordInic = this.obtenerCoordenadaDeHabitable(atacante);
		Coordenada coordFinal = this.obtenerCoordenadaDeHabitable(atacado);
		if(coordInic.distancia(coordFinal)>range)
			throw new OutOfRangeException();
		atacado.serAtacado(atacante, ataque);
	}
	
	public HabitableDelMapa obtenerHabitableEnCoordenada(Coordenada coordenada){
		return habitables.get(coordenada);
	}
	
	private void validarDistancias(Coordenada coordUno, Coordenada coordDos, Coordenada coordTres, int distMinima){
		if(coordUno.distancia(coordDos)>distMinima*2 || coordUno.distancia(coordTres)>distMinima*2 || coordDos.distancia(coordTres)>distMinima*2){
			throw new DistanciaInvalidaException();
		}
	}
	
	private void vaciarCoordenada(Coordenada coordenada){
		this.colocarEnTablero(new Vacio(), coordenada);
	}
	
	public void combinarAlgoformers(Superion superion, Optimus optimus, Ratchet ratchet, Bumblebee bumblebee, int distMinimaCombinacion){
		Coordenada coordOptimus = this.obtenerCoordenadaDeHabitable(optimus);
		Coordenada coordRatchet = this.obtenerCoordenadaDeHabitable(ratchet);
		Coordenada coordBumblebee = this.obtenerCoordenadaDeHabitable(bumblebee);
		try{
			this.validarDistancias(coordOptimus, coordRatchet, coordBumblebee, distMinimaCombinacion);
		}
		catch (Throwable DistanciaInvalidaException){
			throw new NoCombinableException();
		}
		this.colocarEnTablero(superion, coordOptimus);
		this.vaciarCoordenada(coordRatchet);
		this.vaciarCoordenada(coordBumblebee);
	}
	
	public void combinarAlgoformers(Menasor menasor, Megatron megatron, Bonecrusher bonecrusher, Frenzy frenzy, int distMinimaCombinacion){
		Coordenada coordMegatron = this.obtenerCoordenadaDeHabitable(megatron);
		Coordenada coordBonecrusher = this.obtenerCoordenadaDeHabitable(bonecrusher);
		Coordenada coordFrenzy = this.obtenerCoordenadaDeHabitable(frenzy);
		try{
			this.validarDistancias(coordMegatron, coordBonecrusher, coordFrenzy, distMinimaCombinacion);
		}
		catch (Throwable DistanciaInvalidaException){
			throw new NoCombinableException();
		}
		this.colocarEnTablero(menasor, coordMegatron);
		this.vaciarCoordenada(coordBonecrusher);
		this.vaciarCoordenada(coordFrenzy);
	}
	
	public void descombinarAlgoformers(Superion superion){
		Optimus optimus = superion.getOptimus();
		Bumblebee bumblebee = superion.getBumblebee();
		Ratchet ratchet = superion.getRatchet();
		
		Coordenada coordSuperion = this.obtenerCoordenadaDeHabitable(superion);
		
		this.colocarEnTablero(optimus, coordSuperion);
		this.colocarHabitableEnPosicionValidaDesde(bumblebee, coordSuperion);
		this.colocarHabitableEnPosicionValidaDesde(ratchet,coordSuperion);
	}
	
	public void descombinarAlgoformers(Menasor menasor){
		Megatron megatron = menasor.getMegatron();
		Bonecrusher bonecrusher = menasor.getBonecrusher();
		Frenzy frenzy = menasor.getFrenzy();
		
		Coordenada coordMenasor = this.obtenerCoordenadaDeHabitable(menasor);
		
		this.colocarEnTablero(megatron, coordMenasor);
		this.colocarHabitableEnPosicionValidaDesde(bonecrusher, coordMenasor);
		this.colocarHabitableEnPosicionValidaDesde(frenzy, coordMenasor);
	}
	
	public void colocarHabitableEnPosicionValidaDesde(HabitableDelMapa habitable, Coordenada coordInicial){
		Coordenada coordFinal = coordInicial;
		while(!this.estaVacio(coordFinal)){
			
		}
	}
	public List<Coordenada> buscarCamino(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		
		return GeneradorDeCaminos.calcularCaminoDeCostoMinimo(superficies, habitables, new Optimus(), coordenadaInicial, coordenadaFinal);
	}
	public void reposicionar(Algoformer algoformer) {
		Coordenada coordenada =	this.obtenerCoordenadaDeHabitable((HabitableDelMapa)algoformer);
		this.colocarEnTablero((HabitableDelMapa)algoformer, coordenada);
		
	}
	public void retirarAlgoformer(Algoformer algoformer) {
		Coordenada coordenadaActual =this.obtenerCoordenadaDeHabitable(algoformer);
		this.superficies.get(coordenadaActual).revertirEfecto(algoformer);
		
	}
	
	

}
