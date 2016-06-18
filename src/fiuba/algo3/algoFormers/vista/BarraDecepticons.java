package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BarraDecepticons extends HBox {
	
	Button botonMegatron = new Button();
	
	public BarraDecepticons(){
		
		Image megatron = new Image("file:img/algoformers/humanoide/megatron.png");
		botonMegatron.setGraphic(new ImageView(megatron));
		botonMegatron.setText("MEGATRON");
		agregarAlgoformers();
	}
	
	public void agregarAlgoformers(){
		this.getChildren().add(botonMegatron);
	}
}
