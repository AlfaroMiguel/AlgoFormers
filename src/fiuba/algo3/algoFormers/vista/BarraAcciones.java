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
	Button botonTerminarTurno = new Button();
	
	public BarraAcciones(Controlador controlador){
		this.controlador = controlador;
		this.setSpacing(10);
		configurarNodos();
		agregarNodos();
	}
	
	public void agregarNodos(){
		this.getChildren().addAll(botonMover, botonAtacar, botonTransformar, botonCombinar,botonTerminarTurno);
	}
	
	public void configurarNodos(){
		botonMover.setText("mover algoformer seleccionado");
		botonMover.setOnMouseClicked(e->controlador.cambiarAModoMover());
		botonAtacar.setText("atacar algoformer enemigo");
		botonAtacar.setOnMouseClicked(e->controlador.cambiarAModoAtaque());
		botonTransformar.setText("cambiar modo");
		botonTransformar.setOnMouseClicked(e-> controlador.transformarSeleccionado());
		botonCombinar.setText("combinar algoformers");
		botonCombinar.setOnMouseClicked(e-> controlador.combinarSeleccionado());
		botonTerminarTurno.setText("Terminar Turno");
		botonTerminarTurno.setOnMouseClicked(e-> controlador.terminarTurno());
	}
	
	public void ubicarNodos(){
		botonMover.setLayoutX(10);
		botonAtacar.setLayoutX(40);
	}
}
