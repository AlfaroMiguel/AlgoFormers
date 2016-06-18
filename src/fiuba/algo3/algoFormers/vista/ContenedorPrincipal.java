package fiuba.algo3.algoFormers.vista;

import javafx.scene.layout.BorderPane;

public class ContenedorPrincipal extends BorderPane{
	
	public ContenedorPrincipal(){
		
		ContenedorJuego contenedor = new ContenedorJuego();
		this.setCenter(contenedor.getLayout());
		
		BarraAcciones barraAcciones = new BarraAcciones();
		this.setBottom(barraAcciones);
		
		BarraAutobots barraAutobots = new BarraAutobots();
		this.setLeft(barraAutobots);
		
		BarraDecepticons barraDecepticons = new BarraDecepticons();
		this.setRight(barraDecepticons);
	}
}
