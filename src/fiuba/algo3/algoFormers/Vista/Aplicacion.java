package fiuba.algo3.algoFormers.Vista;



import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	public static void main(String[] args) {
	    Application.launch(args);
	    }
	
	@Override
	public void start(Stage stage){
		
		Group grid = HexGrid.crearTablero();
//		Layout layout = new Layout(grid);
		VBox layout = new VBox(grid);
		
		Juego juego = new Juego();
		
		HexGrid.pintarCamino(juego.buscarCamino(new Coordenada(4,1), new Coordenada(5,5)));
		Scene scene = new Scene(layout);
	    stage.setScene(scene);
	    stage.setTitle("HexGrid");
	    stage.show();
	}


}
