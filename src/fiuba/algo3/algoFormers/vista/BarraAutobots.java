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

public class BarraAutobots extends VBox{
	
	private static BarraAutobots instancia;
	Button botonOptimusHumanoide = new Button();
	Button botonOptimusAlterno = new Button();
	Button botonBumblebeeHumanoide = new Button();
	Button botonBumblebeeAlterno = new Button();
	Button botonRatchetHumanoide = new Button();
	Button botonRatchetAlterno = new Button();
	
	StackPane barraVidaOptimus;
	StackPane barraVidaBumblebee;
	StackPane barraVidaRatchet;
	
	private BarraAutobots(){
		
		this.setFillWidth(true);
		this.setMinWidth(200);
		agregarImagenes();
		configurarBotones();
		agregarAlgoformers();
		agregarTooltips();
		configurarBarrasVida();
		agregarBarrasVida();
	}
	

	public static BarraAutobots getInstance(){
		if (instancia == null){
			instancia = new BarraAutobots();
		}
		return instancia;
	}
	
	public void agregarAlgoformers(){
		HBox botonesOptimus = cajaModos(botonOptimusHumanoide, botonOptimusAlterno);
		HBox botonesBumblebee = cajaModos(botonBumblebeeHumanoide, botonBumblebeeAlterno);
		HBox botonesRatchet = cajaModos(botonRatchetHumanoide, botonRatchetAlterno);
		HBox barraTitulo = new HBox();
		Label titulo = new Label("MODO");
		titulo.setFont(Font.font("Georgia", 20));
		titulo.setTextFill(Color.CADETBLUE);
		barraTitulo.setAlignment(Pos.CENTER);
		barraTitulo.getChildren().add(titulo);
		this.getChildren().addAll(barraTitulo, barraModos(),botonesOptimus, botonesBumblebee, botonesRatchet);
	}

	
	public void agregarImagen(String ruta, Button boton){
		Image imagen = new Image(ruta);
		boton.setGraphic(new ImageView(imagen));
	}
	
	public void agregarImagenes(){
		agregarImagen("file:img/algoformers/humanoide/optimus.png", botonOptimusHumanoide);
		agregarImagen("file:img/algoformers/alterno/optimus.png", botonOptimusAlterno);
		agregarImagen("file:img/algoformers/humanoide/bumblebee.png", botonBumblebeeHumanoide);
		agregarImagen("file:img/algoformers/alterno/bumblebee.png", botonBumblebeeAlterno);
		agregarImagen("file:img/algoformers/humanoide/ratchet.png", botonRatchetHumanoide);	
		agregarImagen("file:img/algoformers/alterno/ratchet.png", botonRatchetAlterno);
	}
	
	public void configurarBotones(){
		botonOptimusHumanoide.setText("OPTIMUS");
		botonOptimusAlterno.setText("OPTIMUS");
		botonBumblebeeHumanoide.setText("BUMBLEBEE");
		botonBumblebeeAlterno.setText("BUMBLEBEE");
		botonRatchetHumanoide.setText("RATCHET");
		botonRatchetAlterno.setText("RATCHET");
		
		botonOptimusHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonOptimusAlterno.setContentDisplay(ContentDisplay.TOP);
		botonBumblebeeHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonBumblebeeAlterno.setContentDisplay(ContentDisplay.TOP);
		botonRatchetHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonRatchetAlterno.setContentDisplay(ContentDisplay.TOP);
		
		botonOptimusHumanoide.setMinWidth(100);
		botonBumblebeeHumanoide.setMinWidth(100);
		botonRatchetHumanoide.setMinWidth(100);
		botonOptimusAlterno.setMinWidth(100);
		botonBumblebeeAlterno.setMinWidth(100);
		botonRatchetAlterno.setMinWidth(100);
	}
	
	
	public void agregarTooltips(){
		
		botonOptimusHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonOptimusAlterno.setTooltip(configurarTooltip(2,3,3));
		botonBumblebeeHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonBumblebeeAlterno.setTooltip(configurarTooltip(2,3,3));
		botonRatchetHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonRatchetAlterno.setTooltip(configurarTooltip(2,3,3));
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

	
	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida: " + vida+ "\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
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
