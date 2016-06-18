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
		System.out.println("KEY EVENT" + event.getCode());
		if(event.getCode()== KeyCode.T){
			System.out.println("Entra");
			controlador.transformarSeleccionado();
		}
		if(event.getCode()== KeyCode.C){
			System.out.println("Entra");
			controlador.combinarSeleccionado();
		}
		//event.consume();
	}
		
}
