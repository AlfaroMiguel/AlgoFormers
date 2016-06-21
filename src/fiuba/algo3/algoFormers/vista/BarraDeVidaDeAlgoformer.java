package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.generico.Algoformer;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class BarraDeVidaDeAlgoformer extends StackPane implements RepresentacionDeAlgoformer {
	
	//Barras de vida de los algoformers 
	private Algoformer algoformer;
	private int vidaDeAlgoformerInicial;
	private ProgressBar barraDeVida;

	//Actualiza la vida de su algoformer
	@Override
	public void actualizar(){	
		int vidaActual = this.algoformer.verVida();
		float porcentaje = (float)vidaActual/vidaDeAlgoformerInicial;
		if (porcentaje <= 0){
			this.barraDeVida.setProgress(1.0);
			this.setStyle("-fx-accent: black;");
		}
		this.barraDeVida.setProgress(porcentaje);	
	}

	@Override
	public void deshabilitar() {
	}

	@Override
	public void habilitar() {
	}

	//Setea un algoformer a una barrita de vida
	public void setAlgoformer(Algoformer algoformer) {
		this.algoformer = algoformer;
		algoformer.agregarRepresentacionDeAlgoformer(this);
		this.vidaDeAlgoformerInicial = algoformer.verVida();
		ProgressBar barraVida = new ProgressBar();
		Text textoBarra = new Text(this.algoformer.getNombre());
		barraVida.setProgress(1);
		this.getChildren().addAll(barraVida, textoBarra);
		this.barraDeVida = barraVida;
		this.setStyle("-fx-accent: red;");
	}

	@Override
	public boolean estaHabilitado() {
		return false;
	}

}
