package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.Recolectable;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Hexagono extends StackPane {
	private int x;
	private int y;
	private Coordenada coordenada;
	private Text text = new Text();
	private Polyline hexagon;
	private ImagePattern tierra;
	private ImageView habitable = new ImageView();
	private ImageView recolectable = new ImageView();
	private ImageView aire = new ImageView();
	public boolean pinto = false;
	public Controlador controlador;

	public Hexagono (int x, int y, double l){
		this.x= x;
		this.y= y;
		this.coordenada = new Coordenada(x,y);
		this.hexagon = new Polyline(l*1.0, 0.0,
									l/2.0 , l*Math.sqrt(3.0)/2,
									-l/2.0 , l*Math.sqrt(3.0)/2,
									-l*1.0, 0.0,
									-l/2.0 , -l*Math.sqrt(3.0)/2,
									l/2.0 , -l*Math.sqrt(3.0)/2,
									l*1.0, 0.0
									);
		//Separo los casilleros con lineas
		hexagon.setStroke(Color.IVORY);
		hexagon.setStrokeWidth(1.3);
		//De ahora en mas las lineas van adentro de las lineas que separan (las blancas)
		hexagon.strokeTypeProperty().setValue(StrokeType.INSIDE);

		
		this.getChildren().addAll(hexagon,text,habitable,recolectable,aire);

		text.setFont(Font.font(18));
//        text.setText(String.valueOf(x) +"," + String.valueOf(y));
        
//        this.setOnMouseExited(e-> close());
//        this.setOnMouseClicked(e -> this.atacado(50));
//        this.setOnMouseEntered(e -> open());

        //this.setOnMouseExited(e-> close());
        //Esto es nuevo 13/06/2016
        this.setOnMouseClicked(e -> seleccionado());
        //this.setOnMouseEntered(e -> open());
	}
	public void setControlador(Controlador controlador){
		//Esto es nuevo 13/6/2016
		this.controlador = controlador;
	}
	public void seleccionado() {
		this.hexagon.setStroke(Color.YELLOW);
		this.hexagon.setStrokeWidth(2);
		//Esto es nuevo 13/06/2016
		this.controlador.fueSeleccionado(this.coordenada);
	}

	public void pintarCaminoCorrecto() {
		this.hexagon.setStroke(Color.CADETBLUE);
		this.hexagon.setStrokeWidth(2);
	}
	public void pintarCaminoIncorrecto() {
		this.hexagon.setStroke(Color.GREY);
		this.hexagon.setStrokeWidth(2);
	}
	public void pintarRegionAtaque() {
		this.hexagon.setStroke(Color.DARKRED);
		this.hexagon.setStrokeWidth(2);
	}	
	public void despintar() {
		hexagon.strokeTypeProperty().setValue(StrokeType.CENTERED);
		hexagon.setStroke(Color.IVORY);
		hexagon.setStrokeWidth(1.3);
		hexagon.strokeTypeProperty().setValue(StrokeType.INSIDE);
	}
	public void atacado(int vida){
		this.text.setFill(Color.DARKRED);
		this.text.setText("-"+ String.valueOf(vida));
		this.text.toFront();
		
//		this.text.setText("");
	}	
	public void sacarAlgoFormer(){
		//Supongo que no es lo mas lindo mañana buscare como se hace bien
		this.habitable.setImage(null);
	}
	public void sacarRecolectable(){
		//Supongo que no es lo mas lindo mañana buscare como se hace bien
		this.recolectable.setImage(null);
	}
	
	public void ponerSuperficie(SuperficieAire superficieAire) {
		Image imagen = ClaseImagenes.getImage(superficieAire);
		this.aire.setImage(imagen);
		this.aire.setOpacity(0.4);
		this.aire.toFront();
	}
	public void ponerSuperficie(SuperficieTierra superficieTierra) {
		Image imagen = ClaseImagenes.getImage(superficieTierra);
		this.tierra = new ImagePattern(imagen);
		this.hexagon.setFill(tierra);
	}
	public void ponerAccionable(Accionable accionable) {
		Image imagen = ClaseImagenes.getImage(accionable);
		this.habitable.setImage(imagen);
		this.aire.toFront();
	}
	public void ponerRecolectable(Recolectable recolectable) {
		Image imagen = ClaseImagenes.getImage(recolectable);
		this.recolectable.setImage(imagen);
	}
}