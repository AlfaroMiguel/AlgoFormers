package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.Group;

public class Vista {
	private HexGrid hexGrid;
	private Juego juego;
	public Vista(Juego juego){
		this.hexGrid = new HexGrid();
		this.juego = juego;
	}

	public void inicializarTablero(int alto, int ancho) {
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
		int paso = (int) Math.ceil(algoformerActual.verModo().verPaso());
		camino.add(coordenadaFinal);
		Boolean puedePagar = GeneradorDeCaminos.puedePagarCamino(camino, tablero.superficies, algoformerActual, paso);
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

}
