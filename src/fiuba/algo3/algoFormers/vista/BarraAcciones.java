package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BarraAcciones extends HBox {
	
	Button botonMover = new Button();
	Button botonAtacar = new Button();
	private Controlador controlador;
	Button botonTransformar = new Button();
	Button botonCombinar = new Button();
	
	public BarraAcciones(Controlador controlador){
		this.controlador = controlador;
		this.setSpacing(10);
		configurarNodos();
		agregarNodos();
	}
	
	public void agregarNodos(){
		this.getChildren().addAll(botonMover, botonAtacar, botonTransformar, botonCombinar);
	}
	
	public void configurarNodos(){
		botonMover.setText("mover algoformer seleccionado");
		botonMover.setOnMouseClicked(e->controlador.combiarAModoMover());
		botonAtacar.setText("atacar algoformer enemigo");
		botonAtacar.setOnMouseClicked(e->controlador.combiarAModoAtaque());
		botonTransformar.setText("cambiar modo");
		botonCombinar.setText("combinar algoformers");
	}
	
	public void ubicarNodos(){
		botonMover.setLayoutX(10);
		botonAtacar.setLayoutX(40);
	}
}
