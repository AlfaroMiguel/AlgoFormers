package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.HBox;

public class BarraAutobotsDividida  extends BarraAlgoformers{
	
	public BarraAutobotsDividida(){
		
	}
	
	private HBox botonesOptimus(){
		HBox cajaOptimus = new HBox();
		
		Button botonOptimusHumanoide = new Button();
		Button botonOptimusAlterno = new Button();
		
		agregarImagen("file:img/algoformers/humanoide/optimus.png", botonOptimusHumanoide);
		agregarImagen("file:img/algoformers/alterno/optimus.png", botonOptimusAlterno);
		
		botonOptimusHumanoide.setText("OPTIMUS");
		botonOptimusAlterno.setText("OPTIMUS");
		
		botonOptimusHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonOptimusAlterno.setContentDisplay(ContentDisplay.TOP);
		
		botonOptimusHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonOptimusAlterno.setTooltip(configurarTooltip(2,3,3));
		
		cajaOptimus.getChildren().addAll(botonOptimusHumanoide,botonOptimusAlterno);
		
		return cajaOptimus;
	}
}
