package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.juego.Juego;
import javafx.scene.layout.BorderPane;

public class ContenedorPrincipal extends BorderPane{
	
	public ContenedorPrincipal(String jugadorAutobots, String jugadorDecepticons){
		Juego juego = new Juego(30,20);
		Controlador controlador = new Controlador(juego);
		
		ContenedorJuego contenedor = new ContenedorJuego(juego, controlador);
		this.setCenter(contenedor.getLayout());
		
		BarraAutobots barraAutobots = BarraAutobots.getInstance(jugadorAutobots);
		BarraSuperion barraSuperion = new BarraSuperion(jugadorAutobots);
		this.setLeft(barraAutobots);
		
		BarraDecepticons barraDecepticons = BarraDecepticons.getInstance(jugadorDecepticons);
		BarraMenasor barraMenasor = new BarraMenasor(jugadorDecepticons);
		this.setRight(barraDecepticons);
		
		BarraAcciones barraAcciones = new BarraAcciones(controlador);
		this.setBottom(barraAcciones);
		
	}
}
