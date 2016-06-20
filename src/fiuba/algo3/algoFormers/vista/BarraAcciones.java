package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.controlador.SilenciadorEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BarraAcciones extends HBox {
	
	Button botonMover = new Button();
	Button botonAtacar = new Button();
	Button botonTransformar = new Button();
	Button botonCombinar = new Button();
	Button botonTerminarTurno = new Button();
	Button botonDescombinar = new Button();
	Button silenciarMusica = new Button();
	//Label texto = new Label("Elija una opcion: ");
	private Controlador controlador;
	
	public BarraAcciones(Controlador controlador){
		this.controlador = controlador;
		this.setSpacing(10);
		configurarNodos();
		agregarNodos();
		configurarTamanio();
	}
	
	public void agregarNodos(){
		this.getChildren().addAll(/*texto,*/ botonMover, botonAtacar, botonTransformar, botonCombinar, botonDescombinar, botonTerminarTurno, silenciarMusica);
	}
	
	public void configurarNodos(){
		botonMover.setText("Mover");
		botonMover.setOnMouseClicked(e->controlador.cambiarAModoMover());
		botonMover.setStyle("-fx-base: #000000;");
		botonMover.setTextFill(Color.WHITE);
		botonAtacar.setText("Atacar");
		botonAtacar.setOnMouseClicked(e->controlador.cambiarAModoAtaque());
		botonAtacar.setStyle("-fx-base: #000000;");
		botonAtacar.setTextFill(Color.WHITE);
		botonTransformar.setText("Transformarse");
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
		Image mute = new Image("file:img/mute.png", 30,30,true,true);
		silenciarMusica.setGraphic(new ImageView(mute));
		silenciarMusica.setOnMouseClicked(new SilenciadorEventHandler());
	}
	
	public void configurarTamanio(){
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
	
}
