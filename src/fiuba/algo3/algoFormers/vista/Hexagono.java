package fiuba.algo3.algoFormers.vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Hexagono extends StackPane {
	private int x;
	private int y;
	
	private Text text = new Text();
	private Polyline hexagon;
	public boolean pinto=false;
	
	public Hexagono (int x, int y, double l){
		this.x= x;
		this.y= y;
		
		this.hexagon = new Polyline(l*1.0, 0.0,
									l/2.0 , l*Math.sqrt(3.0)/2,
									-l/2.0 , l*Math.sqrt(3.0)/2,
									-l*1.0, 0.0,
									-l/2.0 , -l*Math.sqrt(3.0)/2,
									l/2.0 , -l*Math.sqrt(3.0)/2,
									l*1.0, 0.0
									);
		
		hexagon.setFill(Color.GREEN);
		hexagon.setStroke(Color.WHITE);
		
		this.getChildren().addAll(hexagon,text);

		text.setFont(Font.font(18));
        text.setText(String.valueOf(x) +"," + String.valueOf(y));
        
//        this.setOnMouseExited(e-> close());
//        this.setOnMouseClicked(e -> seleccionado());
//        this.setOnMouseEntered(e -> open());
	}

	public void seleccionado() {
		this.hexagon.setFocusTraversable(true);
		this.hexagon.setFill(Color.DEEPPINK);
	}

	public void paint() {
		this.hexagon.setFill(Color.LIGHTBLUE);
	}

	private void close() {
		this.hexagon.setFill(Color.GREEN);

	}

	private void open() {
		this.hexagon.setFill(Color.IVORY);
	}

	public void ponerRocosa() {
		this.hexagon.setFill(Color.DARKGRAY);
		//text.setText("Rocosa");
	}

	public void ponerPantano() {
		this.hexagon.setFill(Color.GREEN);
		text.setText("Pantano");
	}

	public void ponerEspinas() {
		this.hexagon.setFill(Color.CHOCOLATE);
		text.setText("Espinas");
	}

	public void ponerAndromeda() {
		
	}

	public void ponerNubes() {
		//No hace nada
	}

	public void ponerPsionica() {
		
	}

	public void ponerOptimusHumanoide() {
		text.setText("Optimus");
	}

	public void ponerBumblebeeHumanoide() {
		text.setText("Bumblebee");
	}

	public void ponerFrenzyHumanoide() {
		text.setText("Frenzy");
	}
	
}