package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.generico.Algoformer;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeAlgoformer extends Button implements RepresentacionDeAlgoformer {
	
	private Algoformer algoformer;

	@Override
	public void update() {
		this.setImagenDeAlgoformer();
		
	}

	@Override
	public void deshabilitar() {
		this.setDisable(true);
		
	}

	@Override
	public void habilitar() {
		this.setDisable(false);
	}
	
	public void setImagenDeAlgoformer(){
		Image imagen = ClaseImagenes.getImage(this.algoformer);
		this.setGraphic(new ImageView(imagen));
	}
	public Tooltip configurarTooltip(){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida: " + this.algoformer.verVida()+ "\nAtaque: "+this.algoformer.verAtaque()+"\nVelocidad: "+this.algoformer.verPaso());
		return tooltip;
	}
	public void setAlgoformer(Algoformer algoformer) {
		this.algoformer = algoformer;
		this.algoformer.agregarRepresentacionDeAlgoformer(this);
		this.setText(this.algoformer.getNombre());
		
	}
}
