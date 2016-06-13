package fiuba.algo3.algoFormers.tablero;

import java.util.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.vista.Aplicacion;
import fiuba.algo3.algoFormers.vista.HexGrid;
import fiuba.algo3.algoFormers.superficie.*;



public class Tablero {
	HashMap<Coordenada,Casillero> superficies = new HashMap<Coordenada,Casillero>();
	HashMap<Coordenada,Accionable> accionables = new HashMap<Coordenada,Accionable>();
	HashMap<Coordenada,Recolectable> recolectables = new HashMap<Coordenada, Recolectable>();

	public Tablero(int height,int width){
		GeneradorDeCoordenadas.generarCasillerosDelTablero(this.superficies,height,width);
		GeneradorDeCoordenadas.generarCoordenadasDelTablero(this.accionables,height,width);
		GeneradorDeCoordenadas.generarBonusDelTablero(this.recolectables, height, width);
	}

	public boolean estaVacio(Coordenada coordenada) {
		return !(this.accionables.get(coordenada).ocupaLugar()) && !(this.recolectables.get(coordenada).ocupaLugar());

	}

	public void colocarSuperficieEnTablero(SuperficieTierra superficie,Coordenada coordenada){
		this.superficies.get(coordenada).agregarSuperficie(superficie);
	}

	public void colocarSuperficieEnTablero(SuperficieAire superficie,Coordenada coordenada){
		this.superficies.get(coordenada).agregarSuperficie(superficie);
	}

	public void colocarEnTablero(Accionable accionable,Coordenada coordenada){
		try{
			this.accionables.get(coordenada).colisionar();
			accionable.recolectar(this.recolectables.get(coordenada));
			this.superficies.get(coordenada).producirEfecto(accionable);
			this.accionables.put(coordenada, accionable);
			if(this.recolectables.get(coordenada).consumido())
				this.eliminarRecolectableDeTablero(coordenada);
		}
		catch(Throwable g){
			throw new MovimientoInvalidoException();
		}
	}

	public void colocarEnTablero(Recolectable recolectable, Coordenada coordenada){
		if(!this.recolectables.get(coordenada).ocupaLugar())
			this.recolectables.put(coordenada, recolectable);
		else
			throw new MovimientoInvalidoException();

	}
	public void mover(Accionable accionable, Coordenada coordenadaFinal, int paso) {
		Coordenada coordInic = this.obtenerCoordenadaDeElemento(accionable);
		List<Coordenada> camino = GeneradorDeCaminos.calcularCaminoDeCostoMinimo(this.superficies, this.accionables, accionable, coordInic, coordenadaFinal);
		if(coordInic.distancia(coordenadaFinal)>paso)
			throw new MovimientoInvalidoException();
		this.colocarEnTablero(accionable,coordenadaFinal);
		this.accionables.put(coordInic,new Vacio());
	}


	public Coordenada obtenerCoordenadaDeElemento(Accionable accionable){
        for(Map.Entry<Coordenada, Accionable> entry : this.accionables.entrySet()) {
            if(accionable.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}
	
	public Coordenada obtenerCoordenadaDeElemento(Recolectable recolectable){
        for(Map.Entry<Coordenada, Recolectable> entry : this.recolectables.entrySet()) {
            if(recolectable.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}

	public void coordinarAtaque(Autobot atacante, int range, Accionable atacado, int ataque) {
		Coordenada coordInic = this.obtenerCoordenadaDeElemento(atacante);
		Coordenada coordFinal = this.obtenerCoordenadaDeElemento(atacado);
		if(coordInic.distancia(coordFinal)>range)
			throw new FueraDeRangoException();
		try{
			atacado.serAtacado(atacante, ataque);
		}
		catch(SinVidaException exception){
			System.out.println("Elimino a Menasor del tablero");
			this.eliminarAccionableDeTablero(this.obtenerCoordenadaDeElemento(atacado));
			throw exception;
		}
	}

	public void coordinarAtaque(Decepticon atacante, int range, Accionable atacado, int ataque) {
		Coordenada coordInic = this.obtenerCoordenadaDeElemento(atacante);
		Coordenada coordFinal = this.obtenerCoordenadaDeElemento(atacado);
		if(coordInic.distancia(coordFinal)>range)
			throw new FueraDeRangoException();
		try{
			atacado.serAtacado(atacante, ataque);
		}
		catch(SinVidaException exception){
			this.eliminarAccionableDeTablero(this.obtenerCoordenadaDeElemento(atacado));
			throw exception;
		}
	}

	public Recolectable obtenerRecolectableEnCoordenada(Coordenada coordenada){
		return recolectables.get(coordenada);
	}
	
	public Accionable obtenerAccionableEnCoordenada(Coordenada coordenada){
		return accionables.get(coordenada);
	}
	
	private void validarDistancias(Coordenada coordUno, Coordenada coordDos, Coordenada coordTres, int distMinima){
		if(coordUno.distancia(coordDos)>distMinima*2 || coordUno.distancia(coordTres)>distMinima*2 || coordDos.distancia(coordTres)>distMinima*2){
			throw new DistanciaInvalidaException();
		}
	}

	private void vaciarCoordenadaAccionable(Coordenada coordenada){
		this.colocarEnTablero(new Vacio(), coordenada);
	}

	public void combinarAlgoformers(Superion superion, Optimus optimus, Ratchet ratchet, Bumblebee bumblebee, int distMinimaCombinacion){
		Coordenada coordOptimus = this.obtenerCoordenadaDeElemento(optimus);
		Coordenada coordRatchet = this.obtenerCoordenadaDeElemento(ratchet);
		Coordenada coordBumblebee = this.obtenerCoordenadaDeElemento(bumblebee);
		try{
			this.validarDistancias(coordOptimus, coordRatchet, coordBumblebee, distMinimaCombinacion);
		}
		catch (DistanciaInvalidaException exception){
			throw new NoCombinableException();
		}
		this.colocarEnTablero(superion, coordOptimus);
		this.vaciarCoordenadaAccionable(coordRatchet);
		this.vaciarCoordenadaAccionable(coordBumblebee);
	}

	public void combinarAlgoformers(Menasor menasor, Megatron megatron, Bonecrusher bonecrusher, Frenzy frenzy, int distMinimaCombinacion){
		Coordenada coordMegatron = this.obtenerCoordenadaDeElemento(megatron);
		Coordenada coordBonecrusher = this.obtenerCoordenadaDeElemento(bonecrusher);
		Coordenada coordFrenzy = this.obtenerCoordenadaDeElemento(frenzy);
		try{
			this.validarDistancias(coordMegatron, coordBonecrusher, coordFrenzy, distMinimaCombinacion);
		}
		catch (DistanciaInvalidaException exception){
			throw new NoCombinableException();
		}
		this.colocarEnTablero(menasor, coordMegatron);
		this.vaciarCoordenadaAccionable(coordBonecrusher);
		this.vaciarCoordenadaAccionable(coordFrenzy);
	}

	public void descombinarAlgoformers(Superion superion){
		Optimus optimus = superion.getOptimus();
		Bumblebee bumblebee = superion.getBumblebee();
		Ratchet ratchet = superion.getRatchet();

		Coordenada coordSuperion = this.obtenerCoordenadaDeElemento(superion);

		this.colocarEnTablero(optimus, coordSuperion);
		this.colocarAccionableEnPosicionValidaDesde(ratchet,coordSuperion);
		this.colocarAccionableEnPosicionValidaDesde(bumblebee, coordSuperion);
	}

	public void descombinarAlgoformers(Menasor menasor){
		Megatron megatron = menasor.getMegatron();
		Bonecrusher bonecrusher = menasor.getBonecrusher();
		Frenzy frenzy = menasor.getFrenzy();

		Coordenada coordMenasor = this.obtenerCoordenadaDeElemento(menasor);

		this.colocarEnTablero(megatron, coordMenasor);
		this.colocarAccionableEnPosicionValidaDesde(bonecrusher, coordMenasor);
		this.colocarAccionableEnPosicionValidaDesde(frenzy, coordMenasor);
	}

	public void colocarAccionableEnPosicionValidaDesde(Accionable accionable, Coordenada coordInicial){
		boolean sePudoUbicar = false;
		int radioDeVecindad = 1;
		while(!sePudoUbicar){
		@SuppressWarnings("static-access")
		ArrayList<Coordenada> coordenadasVecinos = coordInicial.neighborsInRange(coordInicial, radioDeVecindad);
		for(int i = 0; i < coordenadasVecinos.size(); i++){
			Coordenada coordVecino = coordenadasVecinos.get(i);
			if(this.accionables.containsKey(coordVecino)){
				if(this.estaVacio(coordVecino)){
					this.colocarEnTablero(accionable, coordVecino);
					sePudoUbicar = true;
					break;
					}
				}
			}
			radioDeVecindad++;
		}
	}

	public List<Coordenada> buscarCamino(Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		return GeneradorDeCaminos.calcularCaminoDeCostoMinimo(superficies, accionables, new Optimus(), coordenadaInicial, coordenadaFinal);
	}


	public void reposicionar(Algoformer algoformer) {
		Coordenada coordenada =	this.obtenerCoordenadaDeElemento(algoformer);
		this.colocarEnTablero(algoformer, coordenada);

	}
	
	public void desafectarAlgoformer(Accionable algoformer) {
		Coordenada coordenadaActual = this.obtenerCoordenadaDeElemento(algoformer);
		this.superficies.get(coordenadaActual).revertirEfecto(algoformer);
	}
	
	public SuperficieTierra obtenerSuperficieTierra(Coordenada coordenada){
		return this.superficies.get(coordenada).tierra;
	}
	public SuperficieAire obtenerSuperficieAire(Coordenada coordenada){
		return this.superficies.get(coordenada).aire;
	}
	
	public void eliminarAccionableDeTablero(Coordenada coordenada){
		this.accionables.replace(coordenada, new Vacio());
	}

	public void eliminarRecolectableDeTablero(Coordenada coordenada){
		this.recolectables.replace(coordenada, new BonusVacio());
	}
}
