package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.juego.Juego;
import javafx.scene.layout.BorderPane;

public class ContenedorPrincipal extends BorderPane{

	public ContenedorPrincipal(String jugadorAutobots, String jugadorDecepticons){
		Juego juego = new Juego(30,20);
		Controlador controlador = new Controlador(juego);

		ContenedorJuego contenedor = new ContenedorJuego(juego, controlador);
		this.setCenter(contenedor.getLayout());
		contenedor.setFocusTraversable(true);

		List<Algoformer> autobots = juego.obtenerAutobots();
		BarraAutobots barraAutobots = BarraAutobots.getInstance(jugadorAutobots,autobots);
		BarraSuperion barraSuperion = new BarraSuperion(jugadorAutobots);
		this.setLeft(barraAutobots);

		//List<Algoformer> decepticons = juego.obtenerDecepticons();
		BarraDecepticons barraDecepticons = BarraDecepticons.getInstance(jugadorDecepticons);
		BarraMenasor barraMenasor = new BarraMenasor(jugadorDecepticons);
		this.setRight(barraDecepticons);

		BarraAcciones barraAcciones = new BarraAcciones(controlador);
		this.setBottom(barraAcciones);

	}
}

