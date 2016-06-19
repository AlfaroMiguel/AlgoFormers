package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BarraAcciones extends HBox {
	
	Button botonMover = new Button();
	Button botonAtacar = new Button();
	private Controlador controlador;
	Button botonTransformar = new Button();
	Button botonCombinar = new Button();
	Button botonTerminarTurno = new Button();
	Button botonDescombinar = new Button();
	Label texto = new Label("Elija una opcion: ");
	
	public BarraAcciones(Controlador controlador){
		this.controlador = controlador;
		this.setSpacing(10);
		configurarNodos();
		agregarNodos();
		configurarTamaño();
	}
	
	public void agregarNodos(){
		this.getChildren().addAll(texto, botonMover, botonAtacar, botonTransformar, botonCombinar, botonDescombinar, botonTerminarTurno);
	}
	
	public void configurarNodos(){
		botonMover.setText("Mover");
		botonMover.setOnMouseClicked(e->controlador.cambiarAModoMover());
		botonMover.setStyle("-fx-base: #000000;");
		botonMover.setTextFill(Color.WHITE);
		botonAtacar.setText("Atacar Enemigo");
		botonAtacar.setOnMouseClicked(e->controlador.cambiarAModoAtaque());
		botonAtacar.setStyle("-fx-base: #000000;");
		botonAtacar.setTextFill(Color.WHITE);
		botonTransformar.setText("Cambiar Modo");
		botonTransformar.setOnMouseClicked(e-> controlador.transformarSeleccionado());
		botonTransformar.setStyle("-fx-base: #000000;");
		botonTransformar.setTextFill(Color.WHITE);
		botonCombinar.setText("Combinar");
		botonCombinar.setOnMouseClicked(e-> controlador.combinarSeleccionado());
		botonCombinar.setStyle("-fx-base: #000000;");
		botonCombinar.setTextFill(Color.WHITE);
		botonDescombinar.setText("Descombinar");
		botonDescombinar.setOnMouseClicked(e-> controlador.descombinarSeleccionado());
		botonDescombinar.setStyle("-fx-base: #000000;");
		botonDescombinar.setTextFill(Color.WHITE);
		botonTerminarTurno.setText("Terminar Turno");
		botonTerminarTurno.setOnMouseClicked(e-> controlador.terminarTurno());
		botonTerminarTurno.setStyle("-fx-base: #000000;");
		botonTerminarTurno.setTextFill(Color.WHITE);
	}
	
	public void configurarTamaño(){
		this.setPrefHeight(70);
		this.setFillHeight(true);
		this.setAlignment(Pos.CENTER);
		
		botonMover.setPrefHeight(40);
		botonAtacar.setPrefHeight(40);
		botonTransformar.setPrefHeight(40);
		botonCombinar.setPrefHeight(40);
		botonDescombinar.setPrefHeight(40);
		botonTerminarTurno.setPrefHeight(40);
	}
	
	public void ubicarNodos(){
		botonMover.setLayoutX(10);
	}
}
