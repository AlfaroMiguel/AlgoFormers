package fiuba.algo3.algoFormers.tablero;

import java.util.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.Observable;
import fiuba.algo3.algoFormers.generico.Observador;
import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.vista.Aplicacion;
import fiuba.algo3.algoFormers.vista.HexGrid;
import fiuba.algo3.algoFormers.superficie.*;

public class Tablero implements Observador{
	
	/* Atributos */
	/* Representacion del tablero que contiene a las superficies */
	HashMap<Coordenada,Casillero> superficies = new HashMap<Coordenada,Casillero>();
	/* Representacion del tablero que contiene a los accionables */
	HashMap<Coordenada,Accionable> accionables = new HashMap<Coordenada,Accionable>();
	/* Representacion del tablero que contiene a los recolectables */
	HashMap<Coordenada,Recolectable> recolectables = new HashMap<Coordenada, Recolectable>();
	private Observable observado;
	
	/* Constructor */
	/* Crea un tablero de tamanio alto*ancho. 
	 * Llena el tablero con posiciones "vacias" segun corresponda al tipo */
	public Tablero(int alto,int ancho){
		GeneradorDeCoordenadas.generarCasillerosDelTablero(this.superficies,alto,ancho);
		GeneradorDeCoordenadas.generarCoordenadasDelTablero(this.accionables,alto,ancho);
		GeneradorDeCoordenadas.generarBonusDelTablero(this.recolectables, alto, ancho);
	}
	
	/* Parametros: -coordenada: coordenada del tablero que se quiere averiguar si esta vacia.
	 * Devuelve: true si en la coordenada no hay un accionable o un colectable ocupando lugar. */
	public boolean estaVacio(Coordenada coordenada) {
		return !(this.accionables.get(coordenada).ocupaLugar()) && !(this.recolectables.get(coordenada).ocupaLugar());

	}
	/* Coloca una superficie en una coordenada del tablero.
	 * Parametros: -superficie: superficie a colocar.
	 * 			   -coordenada: coordenada donde se quiere colocar la superficie.*/
	public void colocarSuperficieEnTablero(SuperficieTierra superficie,Coordenada coordenada){
		this.superficies.get(coordenada).agregarSuperficie(superficie);
	}
	/* Coloca una superficie en una coordenada del tablero.
	 * Parametros: -superficie: superficie a colocar.
	 * 			   -coordenada: coordenada donde se quiere colocar la superficie.*/
	public void colocarSuperficieEnTablero(SuperficieAire superficie,Coordenada coordenada){
		this.superficies.get(coordenada).agregarSuperficie(superficie);
	}
	/* Coloca un accionable en una coordenada del tablero. 
	 * Parametros: accionable: accionable a colocar.
	 * 			   coordenada: coordenada donde se quiere colocar el accionable.
	 * Lanza: MovimientoInvalidoException si no se puede colocar.*/
	public void colocarEnTablero(Accionable accionable,Coordenada coordenada){
		try{
			this.accionables.get(coordenada).colisionar();
			Recolectable recolectableEnCoordenada = this.recolectables.get(coordenada);
			accionable.recolectar(recolectableEnCoordenada);
			this.superficies.get(coordenada).producirEfecto(accionable);
			this.accionables.put(coordenada, accionable);
			if(this.recolectables.get(coordenada).fueConsumido())
				this.eliminarRecolectableDeTablero(coordenada);
		}
		catch(Throwable g){
			throw new MovimientoInvalidoException();
		}
	}
	/* Coloca un recolectable en una coordenada del tablero. 
	 * Parametros: recolectable: recolectable a colocar.
	 * 			   recolectable: coordenada donde se quiere colocar el recolectable.
	 * Lanza: MovimientoInvalidoException si no se puede colocar.*/
	public void colocarEnTablero(Recolectable recolectable, Coordenada coordenada){
		if(!this.recolectables.get(coordenada).ocupaLugar())
			this.recolectables.put(coordenada, recolectable);
		else
			throw new MovimientoInvalidoException();

	}
	/* Mueve un accionable a una coordenada dependiendo de su velocidad.
	 * Parametros: -accionable: accionable a mover.
	 * 			   -coordenadaFinal: coordenada de destino del accionable.
	 * 			   -paso: velocidad del accionable.
	 * Lanza: MovimientoInvalidoException si no se puede mover a la posicion.*/
	public void mover(Accionable accionable, Coordenada coordenadaFinal, int paso) {
		Coordenada coordInic = this.obtenerCoordenadaDeElemento(accionable);
		
		List<Coordenada> camino = GeneradorDeCaminos.calcularCaminoDeCostoMinimo(this.superficies, this.accionables, accionable, coordInic, coordenadaFinal);
		if(!GeneradorDeCaminos.puedePagarCamino(camino, superficies, accionable, paso))
			throw new MovimientoInvalidoException();
		this.colocarEnTablero(accionable,coordenadaFinal);
		this.accionables.put(coordInic,new Vacio());
	}
	/* Devuelve la coordenada en la que se encuentra un accionable.
	 * Parametros: -accionable: accionable del que se quiere saber la posicion.
	 * Lanza: ElementoNoExisteException si no se encuentra el accionable en el tablero.*/
	public Coordenada obtenerCoordenadaDeElemento(Observable observado){
        for(Map.Entry<Coordenada, Accionable> entry : this.accionables.entrySet()) {
            if(observado.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}
	/* Devuelve la coordenada en la que se encuentra un recolectable.
	 * Parametros: -recolectable: recolectable del que se quiere saber la posicion.
	 * Lanza: ElementoNoExisteException si no se encuentra el recolectable en el tablero.*/
	public Coordenada obtenerCoordenadaDeElemento(Recolectable recolectable){
        for(Map.Entry<Coordenada, Recolectable> entry : this.recolectables.entrySet()) {
            if(recolectable.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}
	/* Coordina el ataque entre dos algoformers, verificando la distancia entre ellos y si
	 * alguno de los dos muere.
	 * Parametros: -atacante: autobot que ataca.
	 * 			   -atacado: accionable a atacar.
	 * 			   -rangoDeAtaque: distancia minima a la que deben estar los algoformers para atacarse.
	 * 			   -ataque: capacidad de ataque del atacante.
	 * Lanza: FueraDeRangoException si los algoformers se encuentran a una distancia mayor al rango.
	 * 		  SinVidaException si alguno de los algoformers muere durante el ataque. En caso de que esto
	 * 		                   suceda tambien elimina al algoformer muerto del tablero. */
	public void coordinarAtaque(Autobot atacante, Accionable atacado, int rangoDeAtaque, int ataque) {
		Coordenada coordInic = this.obtenerCoordenadaDeElemento(atacante);
		Coordenada coordFinal = this.obtenerCoordenadaDeElemento(atacado);
		if(coordInic.distancia(coordFinal)>rangoDeAtaque)
			throw new FueraDeRangoException();
		this.observarA(atacado);
		atacado.serAtacado(atacante, ataque);
	}
	/* Coordina el ataque entre dos algoformers, verificando la distancia entre ellos y si
	 * alguno de los dos muere.
	 * Parametros: -atacante: decepticon que ataca.
	 * 			   -atacado: accionable a atacar.
	 * 			   -rangoDeAtaque: distancia minima a la que deben estar los algoformers para atacarse.
	 * 			   -ataque: capacidad de ataque del atacante.
	 * Lanza: FueraDeRangoException si los algoformers se encuentran a una distancia mayor al rango.
	 * 		  SinVidaException si alguno de los algoformers muere durante el ataque. En caso de que esto
	 * 		                   suceda tambien elimina al algoformer muerto del tablero. */
	public void coordinarAtaque(Decepticon atacante, Accionable atacado, int rangoDeAtaque, int ataque) {
		Coordenada coordInic = this.obtenerCoordenadaDeElemento(atacante);
		Coordenada coordFinal = this.obtenerCoordenadaDeElemento(atacado);
		if(coordInic.distancia(coordFinal)>rangoDeAtaque)
			throw new FueraDeRangoException();
		this.observarA(atacado);
		atacado.serAtacado(atacante, ataque);
	}
	/* Devuelve el recolectable que se encuentra en una coordenada.
	 * Parametros: coordenada: coordenada en la que se busca un recolectable.*/
	public Recolectable obtenerRecolectableEnCoordenada(Coordenada coordenada){
		return recolectables.get(coordenada);
	}
	/* Devuelve el accionable que se encuentra en una coordenada.
	 * Parametros: coordenada: coordenada en la que se busca un accionable.*/
	public Accionable obtenerAccionableEnCoordenada(Coordenada coordenada){
		return accionables.get(coordenada);
	}
	/* Valida que tres elementos del tablero esten uno al lado del otro con una dada distancia entre el del medio y 
	 * los dos de los costados. Los parametros no tienen que mantener ningun orden relativo al tablero.
	 * Parametros: coordUno: coordenada del primer elemento.
	 * 			   coordDos: coordenada del segundo elemento.
	 * 			   coordTres: coordenada del tercer elemento. 
	 * 			   distMinima: distancia a la que tienen que estar los algoformers.
	 * Lanza: DistanciaInvalidaException si no se cumple que esten a la distancia dada para cualquiera de los 
	 * 									 elementos.*/
	private void validarDistancias(Coordenada coordUno, Coordenada coordDos, Coordenada coordTres, int distMinima){
		if(coordUno.distancia(coordDos)>distMinima*2 || coordUno.distancia(coordTres)>distMinima*2 || coordDos.distancia(coordTres)>distMinima*2){
			throw new DistanciaInvalidaException();
		}
	}
	/* Coloca en el tablero un Superion a partir de los autobots si se encuentran a la distancia correcta para 
	 * realizar esta accion. Elimina del tablero a los algoformers individuales.
	 * Parametros: -superion: autobot combinado a colocar.
	 * 			   -optimus: optimus que compone al combinado.
	 * 			   -ratchet: ratchet que compone al combinado.
	 * 			   -bumblebee: bumblebee que compone al combinado.
	 * 			   -distMinimaCombinacion: distancia minima a la que tienen que estar los 3 autobots individuales para
	 * 									   poder combinarse.
	 * Lanza: NoCombinableException si no estan a la distancia correcta y por lo tanto no se pueden combinar.*/
	public void combinarAlgoformers(Superion superion, Optimus optimus, Ratchet ratchet, Bumblebee bumblebee, int distMinimaCombinacion){
		Coordenada coordOptimus;
		Coordenada coordRatchet;
		Coordenada coordBumblebee;
		try{
			coordOptimus = this.obtenerCoordenadaDeElemento(optimus);
			coordRatchet = this.obtenerCoordenadaDeElemento(ratchet);
			coordBumblebee = this.obtenerCoordenadaDeElemento(bumblebee);
		}
		catch(ElementoNoExisteException exception){
			throw new NoCombinableException();
		}
		try{
			this.validarDistancias(coordOptimus, coordRatchet, coordBumblebee, distMinimaCombinacion);
		}
		catch (DistanciaInvalidaException exception){
			throw new NoCombinableException();
		}
		this.colocarEnTablero(superion, coordOptimus);
		this.eliminarAccionableDeTablero(coordRatchet);
		this.eliminarAccionableDeTablero(coordBumblebee);
	}
	/* Coloca en el tablero un Menasor a partir de los decepticons si se encuentran a la distancia correcta para 
	 * realizar esta accion. Elimina del tablero a los algoformers individuales.
	 * Parametros: -menasor: decepticon combinado a colocar.
	 * 			   -megatron: megatron que compone al combinado.
	 * 			   -bonecrusher: bonecrusher que compone al combinado.
	 * 			   -frenzy: frenzy que compone al combinado.
	 * 			   -distMinimaCombinacion: distancia minima a la que tienen que estar los 3 autobots individuales para
	 * 									   poder combinarse.
	 * Lanza: NoCombinableException si no estan a la distancia correcta y por lo tanto no se pueden combinar.*/
	public void combinarAlgoformers(Menasor menasor, Megatron megatron, Bonecrusher bonecrusher, Frenzy frenzy, int distMinimaCombinacion){
		Coordenada coordMegatron;
		Coordenada coordBonecrusher;
		Coordenada coordFrenzy;
		try{
			coordMegatron = this.obtenerCoordenadaDeElemento(megatron);
			coordBonecrusher = this.obtenerCoordenadaDeElemento(bonecrusher);
			coordFrenzy = this.obtenerCoordenadaDeElemento(frenzy);
		}
		catch(ElementoNoExisteException exception){
			throw new NoCombinableException();
		}
		
		try{
			this.validarDistancias(coordMegatron, coordBonecrusher, coordFrenzy, distMinimaCombinacion);
		}
		catch (DistanciaInvalidaException exception){
			throw new NoCombinableException();
		}
		this.colocarEnTablero(menasor, coordMegatron);
		this.eliminarAccionableDeTablero(coordBonecrusher);
		this.eliminarAccionableDeTablero(coordFrenzy);
	}
	
	/* Elimina a superion del tablero y vuelve a colocar a los algoformers que lo componen en las posiciones
	 * mas cercanas a la ultima posicion del superion posibles.
	 * Parametros: -superion: superion a descombinar.*/
	public void descombinarAlgoformers(Superion superion){
		Optimus optimus = superion.getOptimus();
		Bumblebee bumblebee = superion.getBumblebee();
		Ratchet ratchet = superion.getRatchet();

		Coordenada coordSuperion = this.obtenerCoordenadaDeElemento(superion);

		this.colocarEnTablero(optimus, coordSuperion);
		this.colocarAccionableEnPosicionValidaDesde(ratchet,coordSuperion);
		this.colocarAccionableEnPosicionValidaDesde(bumblebee, coordSuperion);
	}
	/* Elimina a menasor del tablero y vuelve a colocar a los algoformers que lo componen en las posiciones
	 * mas cercanas a la ultima posicion del menasor posibles.
	 * Parametros: -menasor: menasor a descombinar.*/
	public void descombinarAlgoformers(Menasor menasor){
		Megatron megatron = menasor.getMegatron();
		Bonecrusher bonecrusher = menasor.getBonecrusher();
		Frenzy frenzy = menasor.getFrenzy();

		Coordenada coordMenasor = this.obtenerCoordenadaDeElemento(menasor);

		this.colocarEnTablero(megatron, coordMenasor);
		this.colocarAccionableEnPosicionValidaDesde(bonecrusher, coordMenasor);
		this.colocarAccionableEnPosicionValidaDesde(frenzy, coordMenasor);
	}
	/* Colocar a un accionable en la posicion mas cercana posible a una posicion de referencia.
	 * Parametros: -accionable: accionable a mover.
	 * 			   -coordReferencia: coordenada que indica la posicion desde la que se intenta colocar al accionable.*/
	public void colocarAccionableEnPosicionValidaDesde(Accionable accionable, Coordenada coordReferencia){
		boolean sePudoUbicar = false;
		int radioDeVecindad = 1;
		while(!sePudoUbicar){
		@SuppressWarnings("static-access")
		ArrayList<Coordenada> coordenadasVecinos = coordReferencia.neighborsInRange(coordReferencia, radioDeVecindad);
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
	/* Genera el camino de costo minimo para ir de una coordenada a otra.
	 * Parametros: -coordenadaInicial: coordenada desde donde se inicia el camino.
	 * 			   -coordenadaFinal: coordenada hasta la que llega el camino.*/
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

	@Override
	public void actualizar() {
		this.eliminarAccionableDeTablero(this.obtenerCoordenadaDeElemento(this.observado));
		
	}

	@Override
	public void observarA(Observable observable){
		this.observado = observable;
		observable.agregarObservador(this);
	}

}
