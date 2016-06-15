package fiuba.algo3.algoFormers.vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		Pane pane = new Pane();
		Button botonEntrar = new Button();
		botonEntrar.setText("Comenzar");
		botonEntrar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				
			}
		});
		pane.getChildren().add(botonEntrar);
		return new Scene(pane);
	}
}
