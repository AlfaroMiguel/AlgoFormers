package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class BarraAlgoformers {
	
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
}
