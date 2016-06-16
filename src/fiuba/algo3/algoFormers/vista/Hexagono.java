package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
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

		
		this.getChildren().addAll(hexagon,text,habitable,aire);

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
		//this.hexagon.setFocusTraversable(true);
		this.hexagon.setStroke(Color.YELLOW);
		this.hexagon.setStrokeWidth(2);
		//Esto es nuevo 13/06/2016
		this.controlador.fueSeleccionado(this.coordenada);
	}

	public void paint() {
		this.hexagon.setStroke(Color.LIGHTBLUE);
	}

	public void atacado(int vida){
		this.text.setFill(Color.DARKRED);
		this.text.setText("-"+ String.valueOf(vida));
		this.text.toFront();
		
//		this.text.setText("");
	}
	public void ponerRocosa() {
		this.ponerTierra("file:img/superficies/roca.png");
	}

	public void ponerPantano() {
		this.ponerTierra("file:img/superficies/pantano.png");
	}

	public void ponerEspinas() {
		this.ponerTierra("file:img/superficies/espina.png");
	}

	public void ponerAndromeda() {
		this.ponerAire("file:img/superficies/nebulosa.png");
	}

	public void ponerNubes() {
		//No hace nada
	}

	public void ponerPsionica() {
		this.ponerAire("file:img/superficies/tormenta.png");
	}
//	
//	private void ponerTierra(String path) {
//		Image imagen = new Image(path,100,50*(1+Math.cos(Math.PI/3)),true,true,false);
//		this.tierra.setImage(imagen);
//		this.tierra.toBack();
//	}
	private void ponerTierra(String path) {
		Image imagen = new Image(path);
		this.tierra = new ImagePattern(imagen);
		this.hexagon.setFill(tierra);
	}
	private void ponerAire(String path) {
	Image imagen = new Image(path,60,60,true,true,false);
	this.aire.setImage(imagen);
	this.aire.setOpacity(0.8);
	this.aire.toFront();
}

	public void ponerOptimusAlterno() {
		this.ponerAlgoFormer("file:img/algoformers/alterno/optimus.png");
	}

	public void ponerBumblebeeAlterno() {
		this.ponerAlgoFormer("file:img/algoformers/alterno/bumblebee.png");
	}

	public void ponerFrenzyAlterno() {
		this.ponerAlgoFormer("file:img/algoformers/alterno/frenzy.png");
	}

	public void ponerBonecrusherAlterno() {
		this.ponerAlgoFormer("file:img/algoformers/alterno/bonecrusher.png");
	}

	public void ponerMegatronAlterno() {
		this.ponerAlgoFormer("file:img/algoformers/alterno/megatron.png");
	}

	public void ponerRatchetAlterno() {
		this.ponerAlgoFormer("file:img/algoformers/alterno/ratchet.png");
	}

	public void ponerOptimusHumanoide() {
		this.ponerAlgoFormer("file:img/algoformers/humanoide/optimus.png");
	}

	public void ponerBumblebeeHumanoide() {
		this.ponerAlgoFormer("file:img/algoformers/humanoide/bumblebee.png");
	}

	public void ponerFrenzyHumanoide() {
		this.ponerAlgoFormer("file:img/algoformers/humanoide/frenzy.png");
	}

	public void ponerBonecrusherHumanoide() {
		this.ponerAlgoFormer("file:img/algoformers/humanoide/bonecrusher.png");
	}

	public void ponerMegatronHumanoide() {
		this.ponerAlgoFormer("file:img/algoformers/humanoide/megatron.png");
	}

	public void ponerRatchetHumanoide() {
		this.ponerAlgoFormer("file:img/algoformers/humanoide/ratchet.png");
	}

	public void ponerSuperion() {
		this.ponerCombinado("file:img/algoformers/superion.png");
	}
	
	public void ponerMenasor() {
		this.ponerCombinado("file:img/algoformers/menasor.png");
	}
	
	private void ponerCombinado(String path) {
		Image imagen = new Image(path,80,100,true,true,false);
		this.habitable.setImage(imagen);
		this.aire.toFront();
	}

	private void ponerAlgoFormer(String path) {
		Image imagen = new Image(path,70,90,true,true,false);
		this.habitable.setImage(imagen);
		this.aire.toFront();
	}
	
	public void sacarAlgoFormer(){
		//Supongo que no es lo mas lindo mañana buscare como se hace bien
		this.habitable.setImage(null);
	}
	
	public void ponerChispa() {

		this.ponerRecolectable("file:img/recolectable/chispa.png");
	}
	public void ponerBurbuja() {
		this.ponerRecolectable("file:img/recolectable/burbuja.png");	
	}
	public void ponerFlash() {
		this.ponerRecolectable("file:img/recolectable/flash.png");
	}
	public void ponerCanion() {
		this.ponerRecolectable("file:img/recolectable/cañon.png");
	}
	
	private void ponerRecolectable(String path) {
		Image imagen = new Image(path,40,40,true,true,false);
		this.habitable.setImage(imagen);

	}

}