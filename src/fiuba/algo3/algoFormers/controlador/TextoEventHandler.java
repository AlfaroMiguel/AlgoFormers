package fiuba.algo3.algoFormers.controlador;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextoEventHandler implements EventHandler<KeyEvent>{
	// Esta clase se encarga de hacer que
	// apretar enter sea equivalente a clickear
	// el boton de entrada
	
	private Button botonEnter;
	
	public TextoEventHandler(Button botonEnter){
		this.botonEnter = botonEnter;
	}
	
    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(botonEnter, new ActionEvent());
        }

    }
}
