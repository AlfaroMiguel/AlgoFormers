package fiuba.algo3.algoFormers.vista;

import java.util.List;

import fiuba.algo3.algoFormers.controlador.Controlador;
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
	BarraDeVidaDeAlgoformer vidaAlgoformerCombinado = new BarraDeVidaDeAlgoformer();
	

	String nombreJugador;
	private Controlador controlador;
	
	public BarraAlgoformers(String nombreJugador, List<Algoformer> algoformers, Controlador controlador){

		this.controlador = controlador;
		this.setFillWidth(true);
		this.setMinWidth(200);
		this.nombreJugador = nombreJugador;
		configurarBotones(algoformers);
		agregarAlgoformers();
		agregarTooltips();
		configurarBarrasVida(algoformers);
		agregarBarrasVida();
	}


	public static BarraAlgoformers getInstance(String nombreJugador, List<Algoformer> algoformers,Controlador controlador){
		if (instancia == null){
			instancia = new BarraAlgoformers(nombreJugador,algoformers,controlador);
		}
		return instancia;
	}

	public void agregarAlgoformers(){
		this.getChildren().addAll(algoformer1, algoformer2, algoformer3, algoformerCombinado);
	}




	public void configurarBotones(List<Algoformer> algoformers){
		
		algoformer1.setAlgoformer(algoformers.get(0));
		algoformer1.setImagenDeAlgoformer();
		algoformer1.setOnMouseClicked(e -> this.controlador.fueSeleccionado(algoformers.get(0).posicion));
		
		algoformer2.setAlgoformer(algoformers.get(1));
		algoformer2.setImagenDeAlgoformer();
		algoformer2.setOnMouseClicked(e -> this.controlador.fueSeleccionado(algoformers.get(1).posicion));
		
		algoformer3.setAlgoformer(algoformers.get(2));
		algoformer3.setImagenDeAlgoformer();
		algoformer3.setOnMouseClicked(e -> this.controlador.fueSeleccionado(algoformers.get(2).posicion));
		
		algoformerCombinado.setAlgoformer(algoformers.get(3));
		algoformerCombinado.setImagenDeAlgoformer();
		algoformerCombinado.setOnMouseClicked(e -> this.controlador.fueSeleccionado(algoformers.get(3).posicion));
		algoformerCombinado.deshabilitar();
		
		
		
		algoformer1.setContentDisplay(ContentDisplay.TOP);
		algoformer2.setContentDisplay(ContentDisplay.TOP);
		algoformer3.setContentDisplay(ContentDisplay.TOP);
		algoformerCombinado.setContentDisplay(ContentDisplay.TOP);

		algoformer1.setMinWidth(200);
		algoformer2.setMinWidth(200);
		algoformer3.setMinWidth(200);
		algoformerCombinado.setMinWidth(200);
	}



	public void agregarTooltips(){
		algoformer1.actualizarTooltip();
		algoformer2.actualizarTooltip();
		algoformer3.actualizarTooltip();
		algoformerCombinado.actualizarTooltip();
	}

	public void configurarBarrasVida(List<Algoformer> algoformers){
		vidaAlgoformer1.setAlgoformer(algoformers.get(0));
		vidaAlgoformer2.setAlgoformer(algoformers.get(1));
		vidaAlgoformer3.setAlgoformer(algoformers.get(2));
		vidaAlgoformerCombinado.setAlgoformer(algoformers.get(3));

	}


	public void agregarBarrasVida(){

		VBox contenedor = new VBox();

		String nombreCapitalizado = Character.toUpperCase(nombreJugador.charAt(0)) + nombreJugador.substring(1);
		Label tituloVida = new Label("Equipo " + nombreCapitalizado);
		tituloVida.setFont(Font.font("Georgia", 20));
		tituloVida.setTextFill(Color.CADETBLUE);
		
		contenedor.setSpacing(10);
		contenedor.getChildren().addAll(tituloVida, vidaAlgoformer1, vidaAlgoformer2, vidaAlgoformer3,vidaAlgoformerCombinado);

		contenedor.setAlignment(Pos.CENTER);
		this.getChildren().add(contenedor);

	}

}
