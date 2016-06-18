package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BarraDecepticons extends VBox {
	
	Button botonMegatron = new Button();
	Button botonBonecrusher = new Button();
	Button botonFrenzy = new Button();
	
	public BarraDecepticons(){
		
		agregarImagenes();
		configurarBotones();
		agregarAlgoformers();
	}
	
	public void agregarAlgoformers(){
		this.getChildren().addAll(botonMegatron, botonBonecrusher, botonFrenzy);
	}
	
	public void agregarImagen(String ruta, Button boton){
		Image imagen = new Image(ruta);
		boton.setGraphic(new ImageView(imagen));
	}
	
	public void agregarImagenes(){
		agregarImagen("file:img/algoformers/humanoide/megatron.png", botonMegatron);
		agregarImagen("file:img/algoformers/humanoide/bonecrusher.png", botonBonecrusher);
		agregarImagen("file:img/algoformers/humanoide/frenzy.png", botonFrenzy);	
	}
	
	public void configurarBotones(){
		botonMegatron.setText("MEGATRON");
		botonBonecrusher.setText("BONECRUSHER");
		botonFrenzy.setText("FRENZY");
		
		botonMegatron.setContentDisplay(ContentDisplay.TOP);
		botonBonecrusher.setContentDisplay(ContentDisplay.TOP);
		botonFrenzy.setContentDisplay(ContentDisplay.TOP);
	}
}
