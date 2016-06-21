package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.controlador.KeyEventHandler;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.juego.Juego;
import javafx.scene.layout.BorderPane;

public class ContenedorPrincipal extends BorderPane{

	public ContenedorPrincipal(String jugadorAutobots, String jugadorDecepticons){
		Juego juego = new Juego(30,20);
		Controlador controlador = new Controlador(juego);

		ContenedorJuego contenedor = new ContenedorJuego(juego, controlador,jugadorAutobots,jugadorDecepticons);
		this.setCenter(contenedor.getLayout());
		
		contenedor.setFocusTraversable(true);
		contenedor.requestFocus();

		List<Algoformer> autobots = juego.obtenerAutobots();
		BarraAlgoformers barraAutobots = new BarraAlgoformers(jugadorAutobots,autobots,controlador);
		this.setLeft(barraAutobots);

		List<Algoformer> decepticons = juego.obtenerDecepticons();
		BarraAlgoformers barraDecepticons = new BarraAlgoformers(jugadorDecepticons,decepticons,controlador);
		this.setRight(barraDecepticons);
		
		KeyEventHandler keyHandler = new KeyEventHandler(controlador);
		this.setOnKeyPressed(keyHandler);

		BarraAcciones barraAcciones = new BarraAcciones(controlador);
		this.setBottom(barraAcciones);

	}
}

