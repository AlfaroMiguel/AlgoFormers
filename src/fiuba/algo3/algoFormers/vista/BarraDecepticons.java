package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.modos.BonecrusherAlterno;
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

public class BarraDecepticons extends VBox {
	
	private static BarraDecepticons instancia;
	
	Button botonMegatronHumanoide = new Button();
	Button botonMegatronAlterno = new Button();
	Button botonBonecrusherHumanoide = new Button();
	Button botonBonecrusherAlterno = new Button();
	Button botonFrenzyHumanoide = new Button();
	Button botonFrenzyAlterno = new Button();
	
	StackPane barraVidaMegatron;
	StackPane barraVidaBonecrusher;
	StackPane barraVidaFrenzy;
	
	private BarraDecepticons(){
		
		this.setFillWidth(true);
		this.setMinWidth(200);
		agregarImagenes();
		configurarBotones();
		agregarAlgoformers();
		agregarTooltips();
		configurarBarrasVida();
		agregarBarrasVida();
	}
	
	public static BarraDecepticons getInstance(){
		if (instancia == null){
			instancia = new BarraDecepticons();
		}
		return instancia;
	}
	public void agregarAlgoformers(){
		HBox botonesMegatron = cajaModos(botonMegatronHumanoide, botonMegatronAlterno);
		HBox botonesBonecrusher = cajaModos(botonBonecrusherHumanoide, botonBonecrusherAlterno);
		HBox botonesFrenzy = cajaModos(botonFrenzyHumanoide, botonFrenzyAlterno);
		HBox barraTitulo = new HBox();
		Label titulo = new Label("MODO");
		titulo.setFont(Font.font("Georgia", 20));
		titulo.setTextFill(Color.CADETBLUE);
		barraTitulo.setAlignment(Pos.CENTER);
		barraTitulo.getChildren().add(titulo);
		this.getChildren().addAll(barraTitulo, barraModos(),botonesMegatron, botonesBonecrusher, botonesFrenzy);
	}
	
	public void agregarImagen(String ruta, Button boton){
		Image imagen = new Image(ruta);
		boton.setGraphic(new ImageView(imagen));
	}
	
	public void agregarImagenes(){
		agregarImagen("file:img/algoformers/humanoide/megatron.png", botonMegatronHumanoide);
		agregarImagen("file:img/algoformers/alterno/megatron.png", botonMegatronAlterno);
		agregarImagen("file:img/algoformers/humanoide/bonecrusher.png", botonBonecrusherHumanoide);
		agregarImagen("file:img/algoformers/alterno/bonecrusher.png", botonBonecrusherAlterno);
		agregarImagen("file:img/algoformers/humanoide/frenzy.png", botonFrenzyHumanoide);	
		agregarImagen("file:img/algoformers/alterno/frenzy.png", botonFrenzyAlterno);
	}
	
	public void configurarBotones(){
		botonMegatronHumanoide.setText("MEGATRON");
		botonMegatronAlterno.setText("MEGATRON");
		botonBonecrusherHumanoide.setText("BONECRUSHER");
		botonBonecrusherAlterno.setText("BONECRUSHER");
		botonFrenzyHumanoide.setText("FRENZY");
		botonFrenzyAlterno.setText("FRENZY");
		
		botonMegatronHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonMegatronAlterno.setContentDisplay(ContentDisplay.TOP);
		botonBonecrusherHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonBonecrusherAlterno.setContentDisplay(ContentDisplay.TOP);
		botonFrenzyHumanoide.setContentDisplay(ContentDisplay.TOP);
		botonFrenzyAlterno.setContentDisplay(ContentDisplay.TOP);
		
		botonMegatronHumanoide.setMinWidth(100);
		botonMegatronAlterno.setMinWidth(100);
		botonBonecrusherHumanoide.setMinWidth(100);
		botonBonecrusherAlterno.setMinWidth(100);
		botonFrenzyHumanoide.setMinWidth(100);
		botonFrenzyAlterno.setMinWidth(100);
	}
	
	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida: "+ vida+"\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
		return tooltip;
	}
	
	public void agregarTooltips(){
		
		botonMegatronHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonMegatronAlterno.setTooltip(configurarTooltip(2,3,3));
		botonBonecrusherHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonBonecrusherAlterno.setTooltip(configurarTooltip(2,3,3));
		botonFrenzyHumanoide.setTooltip(configurarTooltip(2,3,3));
		botonFrenzyAlterno.setTooltip(configurarTooltip(2,3,3));
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
		barraVidaMegatron = configurarBarraVida(500, 350, "megatron");
		barraVidaBonecrusher = configurarBarraVida(350, 350, "bonecrusher");
		barraVidaFrenzy = configurarBarraVida(150, 150, "frenzy");
		
		barraVidaMegatron.setStyle("-fx-accent: red;");
		barraVidaBonecrusher.setStyle("-fx-accent: red;");
		barraVidaFrenzy.setStyle("-fx-accent: red;");
		
	}
	

	public void agregarBarrasVida(){
		
		VBox contenedor = new VBox();
		
		Label tituloVida = new Label("Vida Equipo");
		tituloVida.setFont(Font.font("Georgia", 20));
		tituloVida.setTextFill(Color.CADETBLUE);
		
		contenedor.setSpacing(10);
		contenedor.getChildren().addAll(tituloVida, barraVidaMegatron, barraVidaBonecrusher, barraVidaFrenzy);
		
		contenedor.setAlignment(Pos.CENTER);
		tituloVida.relocate(10, 0);
		this.getChildren().add(contenedor);
		
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
