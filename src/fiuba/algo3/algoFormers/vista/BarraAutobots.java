package fiuba.algo3.algoFormers.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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

public class BarraAutobots extends VBox {
	
	Button botonOptimus = new Button();
	Button botonBumblebee = new Button();
	Button botonRatchet = new Button();
	
	StackPane barraVidaOptimus;
	StackPane barraVidaBumblebee;
	StackPane barraVidaRatchet;
	
	public BarraAutobots(){
		
		this.setFillWidth(true);
		this.setMinWidth(200);
		agregarImagenes();
		configurarBotones();
		agregarAlgoformers();
		agregarTooltips();
		configurarBarrasVida();
		agregarBarrasVida();
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
		
		botonOptimus.setMinWidth(200);
		botonOptimus.setMaxHeight(10);
		botonBumblebee.setMinWidth(200);
		botonRatchet.setMinWidth(200);
	}
	
	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida" + vida+ "\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
		return tooltip;
	}
	
	public void agregarTooltips(){
		
		botonOptimus.setTooltip(configurarTooltip(2,3,3));
		botonBumblebee.setTooltip(configurarTooltip(2,3,3));
		botonRatchet.setTooltip(configurarTooltip(2,3,3));
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
	
	public void configurarBarrasVida(){
		barraVidaOptimus = configurarBarraVida(500, 350, "optimus");
		barraVidaBumblebee = configurarBarraVida(350, 350, "bumblebee");
		barraVidaRatchet = configurarBarraVida(150, 150, "ratchet");
		
		barraVidaOptimus.setStyle("-fx-accent: red;");
		barraVidaBumblebee.setStyle("-fx-accent: red;");
		barraVidaRatchet.setStyle("-fx-accent: red;");
	}
	

	public void agregarBarrasVida(){
		
		VBox contenedor = new VBox();
		
		Label tituloVida = new Label("Vida Equipo");
		tituloVida.setFont(Font.font("Georgia", 20));
		tituloVida.setTextFill(Color.CADETBLUE);
		
		contenedor.setSpacing(10);
		contenedor.getChildren().addAll(tituloVida, barraVidaOptimus, barraVidaBumblebee, barraVidaRatchet);
		
		contenedor.setAlignment(Pos.CENTER);
		this.getChildren().add(contenedor);
		
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
