package fiuba.algo3.algoFormers.Vista;



import java.util.HashMap;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficieNubes;
import fiuba.algo3.algoFormers.Superficies.SuperficieRocosa;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Casillero;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacion extends Application {

	public static void main(String[] args) {
	    Application.launch(args);
	    }
	
	@Override
	public void start(Stage stage){
		
//		Group grid = HexGrid.crearTablero(10,10);
//		Layout layout = new Layout(grid);
		
		Juego juego = new Juego();
		Group grid = HexGrid.GrupoDeTablero(20,20);
		Parent contenedor = crearContenedor(grid);
		VBox layout = new VBox(contenedor);
		VBox.setVgrow(layout, Priority.ALWAYS);
		
//		HexGrid.pintarCamino(juego.buscarCamino(new Coordenada(4,1), new Coordenada(5,5)));
		
		Scene scene = new Scene(layout);
	    stage.setScene(scene);
	    stage.setTitle("AlgoFormers");
	    stage.show();
	}
	
	public static void ponerSuperficieTierra(Coordenada coordenada, SuperficieTierra superficieTierra) {
		HexGrid.ponerSuperficieTierra(coordenada,superficieTierra);	
	}

	public static void ponerSuperficieAire(Coordenada coordenada, SuperficieAire superficieAire) {
		HexGrid.ponerSuperficieAire(coordenada,superficieAire);	
	}
	
	public static void ponerPersonaje(HabitableDelMapa habitable, Coordenada coordenada) {
		HexGrid.ponerPersonaje(habitable,coordenada);
	}


	public static void crearTablero(int alto, int ancho) {
		HexGrid.crearTablero(ancho, alto);
	}


	private Parent crearContenedor(Group grid) {
	    final double SCALE_DELTA = 1.1;
	    final double SCALE_MAX = 1.25;
	    final double SCALE_MIN = 0.25;
	    final StackPane zoomPane = new StackPane();

	    zoomPane.getChildren().add(grid);

	    final ScrollPane scroller = new ScrollPane();
	    scroller.setVbarPolicy(ScrollBarPolicy.NEVER);
	    scroller.setHbarPolicy(ScrollBarPolicy.NEVER);
	    
	    final Group scrollContent = new Group(zoomPane);
	    scroller.setContent(scrollContent);
	    scroller.prefHeight(500);
	    scroller.prefWidth(500);
	    

	    scroller.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
	      @Override
	      public void changed(ObservableValue<? extends Bounds> observable,
	          Bounds oldValue, Bounds newValue) {
	        zoomPane.setMinSize(newValue.getWidth(), newValue.getHeight());
	      }
	    });
	    //Todo esto agarra y hace zoom cuando se scrolea con la escala dada
	    zoomPane.setOnScroll(new EventHandler<ScrollEvent>() {
	      @Override
	      public void handle(ScrollEvent event) {
	        event.consume();

	        if (event.getDeltaY() == 0) {
	          return;
	        }
	        
	        double scaleFactor = (event.getDeltaY() > 0) ? SCALE_DELTA
	            : 1 / SCALE_DELTA;
	        double escala = grid.getScaleX()* scaleFactor;
	        
	        if(escala < SCALE_MIN) escala = SCALE_MIN;
	        else if (escala > SCALE_MAX) escala = SCALE_MAX;
	        
	        grid.setScaleX(escala);
	        grid.setScaleY(escala);
	        
	      }
	    });
	    
	 // Mover el tablero con teclas

	    
	 // Mover el tablero arrastrandolo
	    
	    final ObjectProperty<Point2D> lastMouseCoordinates = new SimpleObjectProperty<Point2D>();
	    scrollContent.setOnMousePressed(new EventHandler<MouseEvent>() {
	      @Override
	      public void handle(MouseEvent event) {
	        lastMouseCoordinates.set(new Point2D(event.getX(), event.getY()));
	      }
	    });

	    scrollContent.setOnMouseDragged(new EventHandler<MouseEvent>() {
	      @Override
	      public void handle(MouseEvent event) {
	        double deltaX = event.getX() - lastMouseCoordinates.get().getX();
	        double extraWidth = scrollContent.getLayoutBounds().getWidth() - scroller.getViewportBounds().getWidth();
	        double deltaH = deltaX * (scroller.getHmax() - scroller.getHmin()) / extraWidth;
	        double desiredH = scroller.getHvalue() - deltaH;
	        scroller.setHvalue(Math.max(0, Math.min(scroller.getHmax(), desiredH)));

	        double deltaY = event.getY() - lastMouseCoordinates.get().getY();
	        double extraHeight = scrollContent.getLayoutBounds().getHeight() - scroller.getViewportBounds().getHeight();
	        double deltaV = deltaY * (scroller.getHmax() - scroller.getHmin()) / extraHeight;
	        double desiredV = scroller.getVvalue() - deltaV;
	        scroller.setVvalue(Math.max(0, Math.min(scroller.getVmax(), desiredV)));
	      }
	    });

	    return scroller;
	}

}
