package fiuba.algo3.algoFormers.vista;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BarraAcciones extends HBox {
	
	Button botonMover = new Button();
	Button botonAtacar = new Button();
	
	public BarraAcciones(){
		
		this.setSpacing(10);
		configurarNodos();
		agregarNodos();
	}
	
	public void agregarNodos(){
		this.getChildren().addAll(botonMover, botonAtacar);
	}
	
	public void configurarNodos(){
		botonMover.setText("mover algoformer seleccionado");
		botonAtacar.setText("atacar algoformer enemigo");
	}
	
	public void ubicarNodos(){
		botonMover.setLayoutX(10);
		botonAtacar.setLayoutX(40);
	}
}
