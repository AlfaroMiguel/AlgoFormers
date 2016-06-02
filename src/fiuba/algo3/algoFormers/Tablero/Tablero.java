package fiuba.algo3.algoFormers.Tablero;
import java.util.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.Habitables.*;


public class Tablero {
	HashMap<Coordenada,Casillero> superficies = new HashMap<Coordenada,Casillero>();
	HashMap<Coordenada,HabitableDelMapa> habitables = new HashMap<Coordenada,HabitableDelMapa>();
	
	public Tablero(int height,int width){
		GeneradorDeCoordenadas.generarCasillerosDelTablero(this.superficies,height,width);
		GeneradorDeCoordenadas.generarCoordenadasDelTablero(this.habitables,height,width);
	}
	public boolean estaVacio(Coordenada coordenada) {
		return !(this.habitables.get(coordenada).ocupaLugar());

	}
	public void put(HabitableDelMapa habitable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).colisionar();
			//habitable.recibir(this.habitables.get(coordenada));
			this.habitables.put(coordenada,habitable);
		}
		catch(Throwable g){
			throw new MovimientoInvalidoException();
		}
	}
	public void put(Collectable collectable,Coordenada coordenada){
		if(!this.habitables.get(coordenada).ocupaLugar()){
			this.habitables.put(coordenada, collectable);
			return;
		}
		throw new MovimientoInvalidoException();

	}
	public void mover(HabitableDelMapa habitable, Coordenada coordenadaFinal, int paso) {
		Coordenada coordInic = this.obtenerCoordenadaDeHabitable(habitable);
		if(coordInic.distancia(coordenadaFinal)>paso)
			throw new MovimientoInvalidoException();
		this.put(habitable,coordenadaFinal);
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
		this.put(new Vacio(), coordenada);
	}
	
	public void combinarAlgoformers(Optimus optimus, Ratchet ratchet, Bumblebee bumblebee, int distMinimaCombinacion){
		Coordenada coordOptimus = this.obtenerCoordenadaDeHabitable(optimus);
		Coordenada coordRatchet = this.obtenerCoordenadaDeHabitable(ratchet);
		Coordenada coordBumblebee = this.obtenerCoordenadaDeHabitable(bumblebee);
		try{
			this.validarDistancias(coordOptimus, coordRatchet, coordBumblebee, distMinimaCombinacion);
		}
		catch (Throwable DistanciaInvalidaException){
			throw new NoCombinablesException();
		}
		Superion superion = new Superion(optimus, ratchet, bumblebee);
		this.put(superion, coordOptimus);
		this.vaciarCoordenada(coordRatchet);
		this.vaciarCoordenada(coordBumblebee);
	}
	
	public void combinarAlgoformers(Megatron megatron, Bonecrusher bonecrusher, Frenzy frenzy, int distMinimaCombinacion){
		Coordenada coordMegatron = this.obtenerCoordenadaDeHabitable(megatron);
		Coordenada coordBonecrusher = this.obtenerCoordenadaDeHabitable(bonecrusher);
		Coordenada coordFrenzy = this.obtenerCoordenadaDeHabitable(frenzy);
		try{
			this.validarDistancias(coordMegatron, coordBonecrusher, coordFrenzy, distMinimaCombinacion);
		}
		catch (Throwable DistanciaInvalidaException){
			throw new NoCombinablesException();
		}
		Menasor menasor = new Menasor(megatron, bonecrusher, frenzy);
		this.put(menasor, coordMegatron);
		this.vaciarCoordenada(coordBonecrusher);
		this.vaciarCoordenada(coordFrenzy);
	}


	
	

}
