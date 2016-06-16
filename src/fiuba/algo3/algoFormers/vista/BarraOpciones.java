package fiuba.algo3.algoFormers.vista;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BarraOpciones {
	
	public static HBox crearBoxOpciones(){
		HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);

	    Button botonMover = new Button("Mover a posicion");
	    botonMover.setPrefSize(150, 20);
	   
	    Button botonAtacar = new Button("Atacar algoformer enemigo");
	    botonAtacar.setPrefSize(200, 20);
	    
	    Label etiquetaOpciones = new Label("Elija la accion a realizar:");
	    
	    Text textoError = new Text();
	    textoError.setText("aca se podrian detallar los errores");
	    textoError.setFill(Color.CRIMSON);
	    textoError.setFont(Font.font("verdana", 12));
	    
	    hbox.getChildren().addAll(etiquetaOpciones,botonMover, botonAtacar,textoError);
	    return hbox;
	}
}
