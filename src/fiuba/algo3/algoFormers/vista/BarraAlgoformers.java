package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.generico.Algoformer;
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

public class BarraAlgoformers extends VBox{

	private static BarraAlgoformers instancia;
	BotonDeAlgoformer algoformer1 = new BotonDeAlgoformer();
	BotonDeAlgoformer algoformer2 = new BotonDeAlgoformer();
	BotonDeAlgoformer algoformer3 = new BotonDeAlgoformer();
	BotonDeAlgoformer algoformerCombinado = new BotonDeAlgoformer();
	

	BarraDeVidaDeAlgoformer vidaAlgoformer1  = new BarraDeVidaDeAlgoformer();
	BarraDeVidaDeAlgoformer vidaAlgoformer2  = new BarraDeVidaDeAlgoformer();
	BarraDeVidaDeAlgoformer vidaAlgoformer3  = new BarraDeVidaDeAlgoformer();
	

	String nombreJugador;
	public BarraAlgoformers(String nombreJugador, List<Algoformer> algoformers){

		this.setFillWidth(true);
		this.setMinWidth(200);
		this.nombreJugador = nombreJugador;
		configurarBotones(algoformers);
		agregarAlgoformers();
		agregarTooltips();
		configurarBarrasVida(algoformers);
		agregarBarrasVida();
	}


	public static BarraAlgoformers getInstance(String nombreJugador, List<Algoformer> algoformers){
		if (instancia == null){
			instancia = new BarraAlgoformers(nombreJugador,algoformers);
		}
		return instancia;
	}

	public void agregarAlgoformers(){
		HBox botonesOptimus = cajaModos(algoformer1);
		HBox botonesBumblebee = cajaModos(algoformer2);
		HBox botonesRatchet = cajaModos(algoformer3);
		HBox botonAlgoformerCombinado = cajaModos(algoformerCombinado);
//		HBox barraTitulo = new HBox();
//		Label titulo = new Label("MODO");
//		titulo.setFont(Font.font("Georgia", 20));
//		titulo.setTextFill(Color.CADETBLUE);
//		barraTitulo.setAlignment(Pos.CENTER);
//		barraTitulo.getChildren().add(titulo);
		this.getChildren().addAll(botonesOptimus, botonesBumblebee, botonesRatchet);
	}




	public void configurarBotones(List<Algoformer> algoformers){
		
		algoformer1.setAlgoformer(algoformers.get(0));
		algoformer1.setImagenDeAlgoformer();
		algoformer2.setAlgoformer(algoformers.get(1));
		algoformer2.setImagenDeAlgoformer();
		algoformer3.setAlgoformer(algoformers.get(2));
		algoformer3.setImagenDeAlgoformer();
		algoformerCombinado.setAlgoformer(algoformers.get(3));
		algoformer3.setImagenDeAlgoformer();
		
		
		
		algoformer1.setContentDisplay(ContentDisplay.TOP);
		algoformer2.setContentDisplay(ContentDisplay.TOP);
		algoformer3.setContentDisplay(ContentDisplay.TOP);

		algoformer1.setMinWidth(200);
		algoformer2.setMinWidth(200);
		algoformer3.setMinWidth(200);
	}



	public void agregarTooltips(){

		algoformer1.setTooltip(configurarTooltip(2,3,3));
		algoformer2.setTooltip(configurarTooltip(2,3,3));
		algoformer3.setTooltip(configurarTooltip(2,3,3));
		
	}

	public void configurarBarrasVida(List<Algoformer> algoformers){
		vidaAlgoformer1.setAlgoformer(algoformers.get(0));
		vidaAlgoformer2.setAlgoformer(algoformers.get(1));
		vidaAlgoformer3.setAlgoformer(algoformers.get(2));

	}


	public void agregarBarrasVida(){

		VBox contenedor = new VBox();

		String nombreCapitalizado = Character.toUpperCase(nombreJugador.charAt(0)) + nombreJugador.substring(1);
		Label tituloVida = new Label("Vida Equipo " + nombreCapitalizado);
		tituloVida.setFont(Font.font("Georgia", 20));
		tituloVida.setTextFill(Color.CADETBLUE);
		
		contenedor.setSpacing(10);
		contenedor.getChildren().addAll(tituloVida, vidaAlgoformer1, vidaAlgoformer2, vidaAlgoformer3);

		contenedor.setAlignment(Pos.CENTER);
		this.getChildren().add(contenedor);

	}


	public Tooltip configurarTooltip(int vida, int ataque, int velocidad){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida: " + vida+ "\nAtaque: "+ataque+"\nVelocidad: "+velocidad);
		return tooltip;
	}



	public HBox cajaModos(Button boton){
		HBox cajaModos = new HBox();

		cajaModos.getChildren().addAll(boton);

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
