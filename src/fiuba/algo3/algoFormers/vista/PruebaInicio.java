package fiuba.algo3.algoFormers.vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PruebaInicio extends Application {

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
		primaryStage.show();
    }

	

	public Scene pantallaInicio(){

        Pane root = new Pane();
        
		Button botonComenzar = new Button();
        Button botonEnter1 = new Button();
        Button botonEnter2 = new Button();
        
        TextField textoJugador1 = new TextField();
        TextField textoJugador2 = new TextField();
        
		botonComenzar.setText("Comenzar");
		botonEnter1.setText("Ingresar");
		botonEnter2.setText("Ingresar");
		
		textoJugador1.setPromptText("nombre jugador 1");
		textoJugador2.setPromptText("nombre jugador 2");
        

		Image imagenFondo = new Image("file:img/fondo/algoformersFondo.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(imagenFondo);
        
        botonComenzar.setStyle("-fx-font: 22 arial; -fx-base: #a8b772;");		
		
		botonComenzar.setLayoutX(600);
        botonComenzar.setLayoutY(350);
        botonEnter1.setLayoutX(620);
        botonEnter1.setLayoutY(400);
        botonEnter2.setLayoutX(620);
        botonEnter2.setLayoutY(400);
        
        textoJugador1.setMaxSize(300, 10);
        textoJugador1.setLayoutX(570);
        textoJugador1.setLayoutY(350);
        textoJugador2.setMaxSize(300, 10);
        textoJugador2.setLayoutX(570);
        textoJugador2.setLayoutY(350);

        imageView.setFitHeight(700);
        imageView.setFitWidth(1300);
        
        root.getChildren().add(imageView);
        root.getChildren().add(botonEnter1);
        root.getChildren().add(textoJugador1);
        
		botonComenzar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				
			} 
		});
		
		botonEnter1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				if (! textoJugador1.getText().trim().equals("")){
					root.getChildren().remove(textoJugador1);
					root.getChildren().remove(botonEnter1);
					root.getChildren().add(textoJugador2);
					root.getChildren().add(botonEnter2);
					botonEnter2.requestFocus();
				}
			} 
		}); 
		
		botonEnter2.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				if (! textoJugador2.getText().trim().equals("")){
					root.getChildren().remove(textoJugador2);
					root.getChildren().remove(botonEnter2);
					root.getChildren().add(botonComenzar);
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
	    
        return new Scene(root);
	}
}
