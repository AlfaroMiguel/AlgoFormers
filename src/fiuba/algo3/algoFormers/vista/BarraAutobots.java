package fiuba.algo3.algoFormers.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BarraAutobots extends VBox {
	
	Button botonOptimus = new Button();
	Button botonRatchet = new Button();
	Button botonBumblebee = new Button();
	
	public BarraAutobots(){
		
		agregarImagenes();
		configurarBotones();
		agregarAlgoformers();
		this.setAlignment(Pos.TOP_CENTER);
	}
	
	public void agregarAlgoformers(){
		this.getChildren().addAll(botonOptimus, botonBumblebee, botonRatchet);
	}
	
	public void agregarImagen(String ruta, Button boton){
		Image imagen = new Image(ruta);
		boton.setGraphic(new ImageView(imagen));
	}
	
	public void agregarImagenes(){
		agregarImagen("file:img/algoformers/humanoide/optimus.png", botonOptimus);
		agregarImagen("file:img/algoformers/humanoide/bumblebee.png", botonBumblebee);
		agregarImagen("file:img/algoformers/humanoide/ratchet.png", botonRatchet);	
	}
	
	public void configurarBotones(){
		botonOptimus.setText("OPTIMUS");
		botonBumblebee.setText("BUMBLEBEE");
		botonRatchet.setText("RATCHET");
		
		botonOptimus.setContentDisplay(ContentDisplay.TOP);
		botonBumblebee.setContentDisplay(ContentDisplay.TOP);
		botonRatchet.setContentDisplay(ContentDisplay.TOP);
	}
	
	
}
