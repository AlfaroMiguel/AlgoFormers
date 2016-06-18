package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.controlador.KeyEventHandler;
import fiuba.algo3.algoFormers.juego.Juego;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ContenedorJuego extends HBox{
	
	VBox layout;
	Controlador controlador;
	
	public ContenedorJuego(Juego juego, Controlador controlador){
		
		super();
		int alto = 30;
		int ancho = 20;
//		Juego juego =juego;
		Vista vista = new Vista(juego);
		juego.agregarVista(vista);
//		Controlador controlador =  new Controlador(juego);
		this.controlador = controlador;
		Group grid = crearTablero(alto, ancho, vista, controlador);
		vista.inicializarTablero(alto,ancho);
		Parent contenedor = crearContenedor(grid);
		VBox layout = new VBox(contenedor);
		VBox.setVgrow(layout, Priority.ALWAYS);
		this.layout = layout;
	}
	
	public VBox getLayout(){

//		Scene scene = new Scene(layout);
//		
//		KeyEventHandler handler = new KeyEventHandler(controlador);
//		scene.setOnKeyPressed(handler);
//		
//		return scene;
		return layout;

	}
	public static Group crearTablero(int alto, int ancho,Vista vista, Controlador controlador) {
		return vista.crearTablero(ancho, alto,controlador);
	}


	private Parent crearContenedor(Group grid) {
	    
		final double SCALE_DELTA = 1.1;
	    final double SCALE_MAX = 1.75;
	    final double SCALE_MIN = 0.5;
	    final StackPane zoomPane = new StackPane();
	    zoomPane.setStyle("-fx-background-color: #000000;");

	    zoomPane.getChildren().add(grid);

	    final ScrollPane scroller = new ScrollPane();
	    scroller.setVbarPolicy(ScrollBarPolicy.NEVER);
	    scroller.setHbarPolicy(ScrollBarPolicy.NEVER);

	    final Group scrollContent = new Group(zoomPane);
	    scroller.setContent(scrollContent);


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
