package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.vista.Aplicacion;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SilenciadorEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		Aplicacion.silenciarMusica();
	}

}
