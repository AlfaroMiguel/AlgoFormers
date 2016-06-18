package fiuba.algo3.algoFormers.vista;


import fiuba.algo3.algoFormers.controlador.Controlador;
import fiuba.algo3.algoFormers.controlador.KeyEventHandler;
import fiuba.algo3.algoFormers.controlador.TextoEventHandler;
import fiuba.algo3.algoFormers.juego.Juego;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Aplicacion extends Application {
	
	private Stage stage;
	public static void main(String[] args) {
	    Application.launch(args);
	    }
	
	@Override
	public void start(Stage primaryStage){
		stage = primaryStage;
		Scene scene = pantallaInicio();
		primaryStage.setTitle("Algoformers");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
	
	public Scene layout(){

		int alto = 30;
		int ancho = 20;
		Juego juego = new Juego(alto, ancho);
		Vista vista = new Vista(juego);
		juego.agregarVista(vista);
		Controlador controlador =  new Controlador(juego);
		Group grid = crearTablero(alto, ancho, vista,controlador);
		vista.inicializarTablero(alto,ancho);
		Parent contenedor = crearContenedor(grid);
		VBox layout = new VBox(contenedor);
		VBox.setVgrow(layout, Priority.ALWAYS);

		Scene scene = new Scene(layout);
		
		KeyEventHandler handler = new KeyEventHandler(controlador);
		scene.setOnKeyPressed(handler);
		
		return scene;
	}
	
	public Scene pantallaInicio(){
		Pane root = new Pane();
        
		Button botonComenzar = new Button();
        Button botonEnter1 = new Button();
        Button botonEnter2 = new Button();
        
        TextField textoJugador1 = new TextField();
        TextField textoJugador2 = new TextField();
        
        Label errorIngreso = new Label("Debe ingresar un nombre");
        Label errorNombresIguales = new Label("Debe ingresar nombres distintos");
        
		botonComenzar.setText("Comenzar");
		botonEnter1.setText("Ingresar");
		botonEnter2.setText("Ingresar");
		
		textoJugador1.setPromptText("nombre jugador autobots");
		textoJugador2.setPromptText("nombre jugador decepticons");

		Image imagenFondo = new Image("file:img/fondo/algoformersFondo.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(imagenFondo);
        
        botonComenzar.setStyle("-fx-font: 22 arial; -fx-base: #a8b772;");	
        
        errorIngreso.setFont(Font.font("arial",15));
        errorIngreso.setTextFill(Color.CRIMSON);
        errorNombresIguales.setFont(Font.font("arial",15));
        errorNombresIguales.setTextFill(Color.CRIMSON);
        
        textoJugador1.setMinSize(210, 10);
        textoJugador2.setMinSize(210, 10);
       
        imageView.setFitHeight(800);
        imageView.setFitWidth(1400);
        
        this.ubicarNodo(botonComenzar, 600, 350);
        this.ubicarNodo(botonEnter1, 640, 400);
        this.ubicarNodo(botonEnter2, 640, 400);
        this.ubicarNodo(textoJugador1, 570, 350);
        this.ubicarNodo(textoJugador2, 570, 350);
        this.ubicarNodo(errorIngreso, 558, 330);
        this.ubicarNodo(errorNombresIguales, 550, 330);
        
        root.getChildren().addAll(imageView, botonEnter1, textoJugador1);
        
		botonComenzar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				stage.setScene(layout());
				stage.setFullScreen(true);
			} 
		});
		
		botonEnter1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				if (! textoJugador1.getText().trim().equals("")){
					if (root.getChildren().contains(errorIngreso)){
						root.getChildren().remove(errorIngreso);
					}
					root.getChildren().remove(textoJugador1);
					root.getChildren().remove(botonEnter1);
					root.getChildren().add(textoJugador2);
					root.getChildren().add(botonEnter2);
					botonEnter2.requestFocus();
				}
				else{
					if (! root.getChildren().contains(errorIngreso)){
						root.getChildren().add(errorIngreso);
					}
				}
			} 
		}); 
		
		botonEnter2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				if (! textoEstaVacio(textoJugador2) && ! textosSonIguales(textoJugador1, textoJugador2)){
					if (root.getChildren().contains(errorIngreso)){
						root.getChildren().remove(errorIngreso);
					}
					if (root.getChildren().contains(errorNombresIguales)){
						root.getChildren().remove(errorNombresIguales);
					}
					root.getChildren().remove(textoJugador2);
					root.getChildren().remove(botonEnter2);
					root.getChildren().add(botonComenzar);
					botonComenzar.requestFocus();
				}
				else if (textosSonIguales(textoJugador1, textoJugador2)){
					if (root.getChildren().contains(errorIngreso)){
						root.getChildren().remove(errorIngreso);
					}
					if (! root.getChildren().contains(errorNombresIguales)){
						root.getChildren().add(errorNombresIguales);
					}
				}
				else{
					if (root.getChildren().contains(errorNombresIguales)){
						root.getChildren().remove(errorNombresIguales);
					}
					if (! root.getChildren().contains(errorIngreso)){
						root.getChildren().add(errorIngreso);
					}
				}
			} 
		});
		
		DropShadow shadow = new DropShadow();
		botonComenzar.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            botonComenzar.setEffect(shadow);
		        }
		});
		botonComenzar.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            botonComenzar.setEffect(null);
		        }
		});
	    
		TextoEventHandler texto1EventHandler = new TextoEventHandler(botonEnter1);
        textoJugador1.setOnKeyPressed(texto1EventHandler);
        
        TextoEventHandler texto2EventHandler = new TextoEventHandler(botonEnter2);
        textoJugador2.setOnKeyPressed(texto2EventHandler);
        
        TextoEventHandler botonEnter1EventHandler = new TextoEventHandler(botonEnter1);
        botonEnter1.setOnKeyPressed(botonEnter1EventHandler);
        
        TextoEventHandler botonEnter2EventHandler = new TextoEventHandler(botonEnter2);
        botonEnter2.setOnKeyPressed(botonEnter2EventHandler);
        
        TextoEventHandler botonComenzarEventHandler = new TextoEventHandler(botonComenzar);
        botonComenzar.setOnKeyPressed(botonComenzarEventHandler);
        
        return new Scene(root);

	}
	
	private static boolean textoEstaVacio(TextField texto){
		return texto.getText().trim().equals("");
	}
	
	private static boolean textosSonIguales(TextField texto1, TextField texto2){
		return texto1.getText().equalsIgnoreCase(texto2.getText());
	}
	private void ubicarNodo(Node nodo, int x, int y){		
		nodo.setLayoutX(x);
        nodo.setLayoutY(y);
	}
	
	public static Group crearTablero(int alto, int ancho,Vista vista, Controlador controlador) {
		return vista.crearTablero(ancho, alto,controlador);
	}


	private Parent crearContenedor(Group grid) {
	    final double SCALE_DELTA = 1.1;
	    final double SCALE_MAX = 1.75;
	    final double SCALE_MIN = 0.5;
	    final StackPane zoomPane = new StackPane();

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
