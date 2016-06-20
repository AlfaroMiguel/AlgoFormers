package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

public class Vista {
	private HexGrid hexGrid;
	private Juego juego;
	private ScrollPane grupo;
	private int alto;
	private int ancho;
	private String nombreJugadorAutobots;
	private String nombreJugadorDecepticons;
	
	public Vista(Juego juego, String jugadorAutobots, String jugadorDecepticons){
		this.hexGrid = new HexGrid();
		this.juego = juego;
		this.nombreJugadorAutobots = jugadorAutobots;
		this.nombreJugadorDecepticons = jugadorDecepticons;
	}

	public void inicializarTablero(int alto, int ancho) {
		this.ancho = ancho;
		this.alto = alto;
		this.hexGrid.inicializarTablero(alto,ancho,juego);	
	}

	public Group crearTablero(int ancho, int alto, Controlador controlador) {
		return this.hexGrid.crearTablero(ancho,alto,controlador);
	}

	public void update(Tablero tablero, Coordenada coordenada,boolean esAlgoformer) {
		if(esAlgoformer)
			this.hexGrid.borrarAlgoformer(coordenada);
		else
			this.hexGrid.borrarRecolectable(coordenada);

	}

	public void update(Algoformer algoformer, Coordenada posicion) {
		this.hexGrid.ponerAccionable(posicion, algoformer);

	}

	public void update(Tablero tablero) {
		this.hexGrid.limpiarSeleccion();
	}

	//Muestro el camino que se quiere hacer
	public void update(Tablero tablero, Coordenada coordenadaInicial, Coordenada coordenadaFinal,Algoformer algoformerActual) {
		List<Coordenada> camino = this.juego.buscarCamino(coordenadaInicial, coordenadaFinal);
		int paso = (int) Math.ceil(algoformerActual.verPaso());

		Boolean puedePagar = GeneradorDeCaminos.puedePagarCamino(camino, tablero.superficies, algoformerActual, paso);
		camino.add(coordenadaFinal);
		if (puedePagar) this.hexGrid.pintarCaminoCorrecto(camino);
		else this.hexGrid.pintarCaminoIncorrecto(camino);
	}

	//Muestro a donde se puede atacar
	public void update(Tablero tablero, Coordenada coordenada, int rango) {
		List<Coordenada> coordenadasEnRango = tablero.coordenadasEnRango(rango,coordenada);
		this.hexGrid.pintarRangoAtaque(coordenadasEnRango);
	}

	//Le bajo la vida al personaje
	public void update(Algoformer algoformer, Coordenada posicion, int ataque) {
		this.hexGrid.bajarVida(posicion,ataque);
	}

	public void centrarEnCoordenada(Coordenada coordenada){
		double ancho = this.grupo.getHmax();
		int x = coordenada.q;
		double alto = this.grupo.getVmax();
		int y = coordenada.q/2 + coordenada.r;

		this.grupo.setHvalue(x*ancho/this.ancho);
		this.grupo.setVvalue((this.alto-y)*alto/this.alto);

		this.hexGrid.seleccionarCoordenada(coordenada);
	}

	public void agregarGrupo(ScrollPane grupo) {
		this.grupo = grupo;
	}


	public void reproducirAtaque() {
		AudioClip disparo = new AudioClip("file:snd/disparo.mp3");
		disparo.play();
	}

	public void actualizar(Algoformer algoformer) {
		this.centrarEnCoordenada(algoformer.posicion);

	}

	public void seleccionarPrimerPersonaje() {
		//Intento de seleccionar al principio
		this.centrarEnCoordenada(this.juego.obtenerJugadorActual().verAlgoformerActual().posicion);
	}

	public void ganoPartida() {
		String ganador = juego.obtenerJugadorActual().equipo.obtenerNombre(this.nombreJugadorAutobots,this.nombreJugadorDecepticons);
		Aplicacion.ganoAlguien(ganador);
	}

}
