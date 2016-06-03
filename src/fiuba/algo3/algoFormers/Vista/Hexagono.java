package fiuba.algo3.algoFormers.Vista;

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
        this.setOnMouseEntered(e -> open());
        this.setOnMouseExited(e-> close());
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
	
}