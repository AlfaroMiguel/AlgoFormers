package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.juego.Juego;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class ContenedorPrincipal extends BorderPane{
	
	public ContenedorPrincipal(){
		Juego juego = new Juego(30,20);
		Controlador controlador = new Controlador(juego);
		
		ContenedorJuego contenedor = new ContenedorJuego(juego, controlador);
//		ScrollPane sp = new ScrollPane(contenedor.getLayout());
//		sp.setMinViewportHeight(100);
//		sp.setMinViewportWidth(10);
		this.setCenter(contenedor.getLayout());
		
		BarraAcciones barraAcciones = new BarraAcciones(controlador);
		this.setBottom(barraAcciones);
		
		BarraAutobots barraAutobots = new BarraAutobots();
		this.setLeft(barraAutobots);
		
		BarraDecepticons barraDecepticons = new BarraDecepticons();
		this.setRight(barraDecepticons);
	}
}
