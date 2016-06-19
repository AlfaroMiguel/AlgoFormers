package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;

public class Vista {
	private HexGrid hexGrid;
	private Juego juego;
	private ScrollPane grupo;
	private int alto;
	private int ancho;
	public Vista(Juego juego){
		this.hexGrid = new HexGrid();
		this.juego = juego;
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

	public void update(Tablero tablero, Coordenada coordenadaInicial, Coordenada coordenadaFinal,Algoformer algoformerActual) {
		List camino = this.juego.buscarCamino(coordenadaInicial, coordenadaFinal);
		int paso = (int) Math.ceil(algoformerActual.verPaso());
		
		Boolean puedePagar = GeneradorDeCaminos.puedePagarCamino(camino, tablero.superficies, algoformerActual, paso);
		camino.add(coordenadaFinal);
		if (puedePagar) this.hexGrid.pintarCaminoCorrecto(camino);
		else this.hexGrid.pintarCaminoIncorrecto(camino);
	}

	public void update(Tablero tablero, Coordenada coordenada, int rango) {
		List coordenadasEnRango = tablero.coordenadasEnRango(rango,coordenada);
		this.hexGrid.pintarRangoAtaque(coordenadasEnRango);
	}

	public void update(Algoformer algoformer, Coordenada posicion, int ataque) {
		this.hexGrid.bajarVida(posicion,ataque);
	}

	public void centrarEnCoordenada(Coordenada coordenada){
		//TODO centrar
		double a = this.grupo.getHmax();
		double x = coordenada.q;
		double v = this.grupo.getLayoutBounds().getWidth();
		
		this.grupo.setHvalue(x*this.grupo.getHmax()/this.ancho);
		
		double y = coordenada.r - coordenada.q;
		
//		this.grupo.setVvalue(y*this.grupo.getVmax()/this.alto);
		
		//this.grupo.translateXProperty().set(this.grupo.getBoundsInLocal().getMaxX()*(x/a));
	}
	public void agregarGrupo(ScrollPane grupo) {
		this.grupo = grupo;
	}

}
