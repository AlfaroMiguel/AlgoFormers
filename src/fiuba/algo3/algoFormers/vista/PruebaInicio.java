package fiuba.algo3.algoFormers.vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
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
		Button botonEntrar = new Button();
		botonEntrar.setText("Comenzar");
		botonEntrar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				
			}
		});
		DropShadow shadow = new DropShadow();
		botonEntrar.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            botonEntrar.setEffect(shadow);
		        }
		});
		botonEntrar.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            botonEntrar.setEffect(null);
		        }
		});
		botonEntrar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
		Image imagenFondo = new Image("file:img/tt.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(imagenFondo);
        imageView.setFitHeight(700);
        imageView.setFitWidth(1300);
	    StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(botonEntrar);

        return new Scene(root);
	}
}
