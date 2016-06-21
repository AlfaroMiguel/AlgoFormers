package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.vista.Aplicacion;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SilenciadorEventHandler implements EventHandler<MouseEvent> {

	// Al hacer click sobre el boton de silenciar
	// se pausara la musica
	@Override
	public void handle(MouseEvent event) {
		Aplicacion.silenciarMusica();
	}

}
