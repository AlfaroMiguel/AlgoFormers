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

public class BarraDecepticons extends VBox {
	
	Button botonMegatron = new Button();
	Button botonBonecrusher = new Button();
	Button botonFrenzy = new Button();
	
	StackPane barraVidaMegatron;
	StackPane barraVidaBonecrusher;
	StackPane barraVidaFrenzy;
	
	public BarraDecepticons(){
		
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
		
		botonMegatron.setMinWidth(200);
		botonBonecrusher.setMinWidth(200);
		botonFrenzy.setMinWidth(200);
	}
	
	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida"+ vida+"\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
		return tooltip;
	}
	public void agregarTooltips(){
		
		botonMegatron.setTooltip(configurarTooltip(2,3,3));
		botonBonecrusher.setTooltip(configurarTooltip(2,3,3));
		botonFrenzy.setTooltip(configurarTooltip(2,3,3));
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
}
