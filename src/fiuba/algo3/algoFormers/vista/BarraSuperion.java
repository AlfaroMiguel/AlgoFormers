package fiuba.algo3.algoFormers.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BarraSuperion extends VBox{
	
	Button botonSuperion = new Button();
	
	StackPane barraVidaSuperion;
	
	public BarraSuperion(){
		agregarImagen("file:img/algoformers/superion.png", botonSuperion);
		botonSuperion.setText("SUPERION");
		botonSuperion.setContentDisplay(ContentDisplay.TOP);
		botonSuperion.setMinWidth(200);
		botonSuperion.setTooltip(configurarTooltip(2,2,2));
		barraVidaSuperion = configurarBarraVida(100,100,"superion");
		barraVidaSuperion.setStyle("-fx-accent: red;");
		this.getChildren().add(botonSuperion);
		agregarBarraVida();
	}
	
	public void agregarBarraVida(){
		
		VBox contenedor = new VBox();
		
		Label tituloVida = new Label("Vida Equipo");
		tituloVida.setFont(Font.font("Georgia", 20));
		tituloVida.setTextFill(Color.CADETBLUE);
		
		contenedor.setSpacing(10);
		contenedor.getChildren().addAll(tituloVida, barraVidaSuperion);
		
		contenedor.setAlignment(Pos.CENTER);
		tituloVida.relocate(10, 0);
		this.getChildren().add(contenedor);
		
	}
	
	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida: "+ vida+"\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
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
	
	public void agregarImagen(String ruta, Button boton){
		Image imagen = new Image(ruta);
		boton.setGraphic(new ImageView(imagen));
	}
}
