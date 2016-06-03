package fiuba.algo3.Vista;



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
		
		HexGrid.pintarCamino();
		Scene scene = new Scene(layout);
	    stage.setScene(scene);
	    stage.setTitle("HexGrid");
	    stage.show();
	}

}
