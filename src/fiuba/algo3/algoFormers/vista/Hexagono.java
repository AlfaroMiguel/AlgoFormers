package fiuba.algo3.algoFormers.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private ImageView algoFormer = new ImageView();
	private ImageView aire = new ImageView();
	public boolean pinto = false;
	
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
		
		hexagon.setStroke(Color.IVORY);
		hexagon.setStrokeWidth(0.2);
		
		this.getChildren().addAll(hexagon,text,algoFormer);

		text.setFont(Font.font(18));
        text.setText(String.valueOf(x) +"," + String.valueOf(y));
        
//        this.setOnMouseExited(e-> close());
//        this.setOnMouseClicked(e -> this.atacado(50));
//        this.setOnMouseEntered(e -> open());
	}

	public void seleccionado() {
		this.hexagon.setFocusTraversable(true);
		this.hexagon.setFill(Color.DEEPPINK);
	}

	public void paint() {
		this.hexagon.setStroke(Color.LIGHTBLUE);
	}

	private void close() {
		this.hexagon.setFill(Color.GREEN);

	}

	private void open() {
		this.hexagon.setFill(Color.IVORY);
	}

	public void atacado(int vida){
		this.text.setFill(Color.DARKRED);
		this.text.setText("-"+ String.valueOf(vida));
		this.text.toFront();
		
//		this.text.setText("");
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

	public void ponerOptimusAlterno() {
		text.setText("Optimus");
	}

	public void ponerBumblebeeAlterno() {
		this.ponerAlgoFormer("file:img/alterno/Bumblebee.png");
	}

	public void ponerFrenzyAlterno() {
		this.ponerAlgoFormer("file:img/alterno/Frenzy.png");
	}

	public void ponerBonecrusherAlterno() {
		this.ponerAlgoFormer("file:img/alterno/Bonecrusher.png");
	}

	public void ponerMegatronAlterno() {
		this.ponerAlgoFormer("file:img/alterno/Megatron.png");
	}

	public void ponerRatchetAlterno() {
		this.ponerAlgoFormer("file:img/alterno/Ratchet.png");
	}

	public void ponerOptimusHumanoide() {
		text.setText("Optimus");
	}

	public void ponerBumblebeeHumanoide() {
		//Para probar
		this.ponerBumblebeeAlterno();
	}

	public void ponerFrenzyHumanoide() {
		//Para probar
		this.ponerFrenzyAlterno();
	}

	public void ponerBonecrusherHumanoide() {
		//Para probar
		this.ponerBonecrusherAlterno();
	}

	public void ponerMegatronHumanoide() {
		//Para probar
		this.ponerMegatronAlterno();
	}

	public void ponerRatchetHumanoide() {
		//Para probar
		this.ponerRatchetAlterno();
	}
	
	private void ponerAlgoFormer(String path) {
		Image imagen = new Image(path,40,60,true,true,false);
		this.algoFormer.setImage(imagen);
		this.aire.toFront();
	}
	public void ponerChispa() {
		text.setText("Chispa");		
	}
	
}