	package fiuba.algo3.algoFormers.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


//	KeyEventHanlder
// 	Se encarga de interpretar la entrada
//  por teclado del usuario y
//	pasarsela al controlador
//

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
			controlador.combinarSeleccionado();
		}
		if(event.getCode()== KeyCode.M){
			controlador.cambiarAModoMover();
		}
		if(event.getCode()== KeyCode.A){
			controlador.cambiarAModoAtaque();
		}
		if(event.getCode()== KeyCode.ENTER){
			controlador.terminarTurno();
		}
		event.consume();
	}
		
}
