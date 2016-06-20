package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.generico.Algoformer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeAlgoformer extends Button implements RepresentacionDeAlgoformer {
	
	private Algoformer algoformer;

	@Override
	public void update() {
		this.setImagenDeAlgoformer();
		
	}

	@Override
	public void llevadoASegundoPlano() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void traidoAPrimerPlano() {
		// TODO Auto-generated method stub
		
	}
	public void setImagenDeAlgoformer(){
		Image imagen = ClaseImagenes.getImage(this.algoformer);
		this.setGraphic(new ImageView(imagen));
	}
	public void setAlgoformer(Algoformer algoformer) {
		this.algoformer = algoformer;
		this.algoformer.agregarRepresentacionDeAlgoformer(this);
		this.setText(this.algoformer.getNombre());
		
	}
	
}
