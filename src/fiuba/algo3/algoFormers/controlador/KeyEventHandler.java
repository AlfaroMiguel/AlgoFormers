package fiuba.algo3.algoFormers.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent>{
	private Controlador controlador;
	
	public KeyEventHandler(Controlador controlador){
		this.controlador = controlador;
	}
	public void handle(KeyEvent event){
		if(event.getCode()== KeyCode.T){
			controlador.transformarSeleccionado();
		}
		if(event.getCode()== KeyCode.C){
			System.out.println("Entra");
			controlador.combinarSeleccionado();
		}
		if(event.getCode()== KeyCode.M){
			System.out.println("cambia el modo");
			controlador.combiarAModoMover();
		}
		if(event.getCode()== KeyCode.A){
			controlador.combiarAModoAtaque();
		}

		//event.consume();
	}
		
}
