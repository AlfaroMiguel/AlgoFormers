package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BarraAlgoformers extends VBox{
	
	public void agregarImagen(String ruta, Button boton){
		Image imagen = new Image(ruta,2,5,true,false);
		boton.setGraphic(new ImageView(imagen));
	}
	
	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida" + vida+ "\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
		return tooltip;
	}
	
	public StackPane configurarBarraVida(int vidaInicial, int vida, String texto){
		StackPane contenedor = new StackPane();
		ProgressBar barraVida = new ProgressBar();
		Text textoBarra = new Text(texto);
		float porcentaje = (float)vida/vidaInicial;
		barraVida.setProgress(porcentaje);
		contenedor.getChildren().addAll(barraVida, textoBarra);
		return contenedor;
	}
	
	public HBox cajaModos(Button botonHumanoide, Button botonAlterno){
		HBox cajaModos = new HBox();
		
		cajaModos.getChildren().addAll(botonHumanoide,botonAlterno);
		
		return cajaModos;
	}
	
	public HBox barraModos(){
		HBox barraModos = new HBox(20);
		Label humanoide = new Label("Humanoide");
		humanoide.setFont(Font.font("Georgia", 20));
		humanoide.setTextFill(Color.CADETBLUE);
		Label alterno = new Label("Alterno");
		alterno.setFont(Font.font("Georgia", 20));
		alterno.setTextFill(Color.CADETBLUE);		
		barraModos.getChildren().addAll(humanoide, alterno);
		return barraModos;
	}
}
