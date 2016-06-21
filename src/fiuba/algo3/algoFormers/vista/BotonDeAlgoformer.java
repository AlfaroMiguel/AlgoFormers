package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.generico.Algoformer;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeAlgoformer extends Button implements RepresentacionDeAlgoformer {
	
	//Boton que contiene una imagen del algoformer en el modo actual y su nombre
	private Algoformer algoformer;
	private boolean habilitado;

	public boolean estaHabilitado(){
		return habilitado;
	}
	
	@Override
	public void actualizar() {
		this.setImagenDeAlgoformer();
		this.actualizarTooltip();
		if (this.algoformer.verVida()  == 0){
			deshabilitar();
		}
	}
	
	//El algoformer fue sacado del mapa y se habilita el boton
	@Override
	public void deshabilitar() {
		this.setDisable(true);
		habilitado = false;
	}
	
	//El algoformer fue puesto en el mapa y se habilita el boton
	@Override
	public void habilitar(){
		this.setDisable(false);
		habilitado = true;
	}
	//Setea la imagen de algoformer
	public void setImagenDeAlgoformer(){
		Image imagen = ClaseImagenes.getImage(this.algoformer);
		this.setGraphic(new ImageView(imagen));
	}
	
	public void actualizarTooltip(){
		Tooltip tooltip = new Tooltip();
		tooltip.setText("Vida: " + this.algoformer.verVida()+ "\nAtaque: "+this.algoformer.verAtaque()+"\nVelocidad: "+this.algoformer.verPaso());
		this.setTooltip(tooltip);
	}
	//Se le asigna un algoformer al boton
	public void setAlgoformer(Algoformer algoformer) {
		this.algoformer = algoformer;
		this.algoformer.agregarRepresentacionDeAlgoformer(this);
		this.setText(this.algoformer.getNombre());
		
	}
}
