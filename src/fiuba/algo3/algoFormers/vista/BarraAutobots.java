package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BarraAutobots extends HBox {
	
	Button botonOptimus = new Button();
	Button botonRatchet = new Button();
	Button botonBumblebee = new Button();
	
	public BarraAutobots(){
		
		agregarImagenes();
		agregarTexto();
		agregarAlgoformers();
	}
	
	public void agregarAlgoformers(){
		this.getChildren().addAll(botonOptimus);
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
	
	public void agregarTexto(){
		botonOptimus.setText("OPTIMUS");
		botonBumblebee.setText("BUMBLEBEE");
		botonRatchet.setText("RATCHET");
	}
}
