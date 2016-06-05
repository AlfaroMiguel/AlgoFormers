package fiuba.algo3.algoFormers.Vista;



import java.util.HashMap;

import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Casillero;
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
		
//		Group grid = HexGrid.crearTablero(20,20);
//		Layout layout = new Layout(grid);
		
		
		Juego juego = new Juego();
		Group grid = HexGrid.GrupoDeTablero(20,20);
		VBox layout = new VBox(grid);
		
		HexGrid.pintarCamino(juego.buscarCamino(new Coordenada(4,1), new Coordenada(5,5)));
		
		Scene scene = new Scene(layout);
	    stage.setScene(scene);
	    stage.setTitle("HexGrid");
	    stage.show();
	}

	public static void ponerSuperficieTerrestre(Coordenada coordenada, SuperficieTierra superficieTierra) {
		HexGrid.ponerSuperficieTierra(coordenada,superficieTierra);	
	}

	public static void ponerSuperficieAerea(Coordenada coordenada, SuperficieAire superficieAire) {
		HexGrid.ponerSuperficieAire(coordenada,superficieAire);	

	}

}
