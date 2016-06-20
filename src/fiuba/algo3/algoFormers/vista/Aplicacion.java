package fiuba.algo3.algoFormers.vista;


import java.io.File;

import fiuba.algo3.algoFormers.controlador.SilenciadorEventHandler;
import fiuba.algo3.algoFormers.controlador.TextoEventHandler;
import javafx.scene.media.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Aplicacion extends Application {
	static MediaPlayer mediaPlayer;
	private static Stage stage;
	static boolean musicaPausada = false;
	String nombreJugadorAutobots;
	String nombreJugadorDecepticons;
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage){
		stage = primaryStage;
		reproducirMusica();
		Scene scene = pantallaInicio();
		primaryStage.setTitle("Algoformers");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("");
		primaryStage.show();
	}
	
	public static void reproducirMusica(){
		String path = new File("snd/transformers.mp3").getAbsolutePath();
		Media musicFile = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(musicFile);
		mediaPlayer.setAutoPlay(true);
	}

	public Scene pantallaInicio(){
		Pane root = new Pane();

		Button botonComenzar = new Button();
        Button botonEnter1 = new Button();
        Button botonEnter2 = new Button();
        Button silenciarMusica = new Button();
        
        RestrictiveTextField textoJugadorAutobots = new RestrictiveTextField();
        RestrictiveTextField textoJugadorDecepticons = new RestrictiveTextField();

        textoJugadorAutobots.setMaxLength(10);
        textoJugadorDecepticons.setMaxLength(10);

        Label errorIngreso = new Label("Debe ingresar un nombre");
        Label errorNombresIguales = new Label("Debe ingresar nombres distintos");

		botonComenzar.setText("Nueva Partida");
		botonComenzar.setTextFill(Color.WHITE);
		botonEnter1.setText("Ingresar Nombre");
		botonEnter1.setTextFill(Color.WHITE);
		botonEnter2.setText("Ingresar Nombre");
		botonEnter2.setTextFill(Color.WHITE);
		
		Image mute = new Image("file:img/mute.png", 30,30,true,true);
		silenciarMusica.setGraphic(new ImageView(mute));
		
		textoJugadorAutobots.setPromptText("nombre jugador autobots");
		textoJugadorDecepticons.setPromptText("nombre jugador decepticons");

		Image imagenFondo = new Image("file:img/fondo/algoformersFondo.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(imagenFondo);

        botonComenzar.setStyle("-fx-font: 22 arial; -fx-base: #000000;");
        botonEnter1.setStyle("-fx-base: #000000;");
        botonEnter2.setStyle("-fx-base: #000000;");

        errorIngreso.setFont(Font.font("arial",15));
        errorIngreso.setTextFill(Color.CRIMSON);
        errorNombresIguales.setFont(Font.font("arial",15));
        errorNombresIguales.setTextFill(Color.CRIMSON);

        textoJugadorAutobots.setMinSize(210, 10);
        textoJugadorDecepticons.setMinSize(210, 10);

        imageView.setFitHeight(800);
        imageView.setFitWidth(1400);

        Label autobots = new Label("Jugador Autobots: ");
        autobots.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        autobots.setTextFill(Color.WHITE);
        Label decepticons = new Label("Jugador Decepticons: ");
        decepticons.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        decepticons.setTextFill(Color.WHITE);
        this.ubicarNodo(botonComenzar, 600, 350);
        this.ubicarNodo(botonEnter1, 640, 200);
        this.ubicarNodo(botonEnter2, 640, 200);
        this.ubicarNodo(textoJugadorAutobots, 670, 150);
        this.ubicarNodo(textoJugadorDecepticons, 670, 150);
        this.ubicarNodo(errorIngreso, 588, 178);
        this.ubicarNodo(errorNombresIguales, 570, 178);
        this.ubicarNodo(autobots, 500, 153);
        this.ubicarNodo(decepticons, 475, 153);
//        this.ubicarNodo(silenciarMusica, 900, 600);
        


        root.getChildren().addAll(imageView, textoJugadorAutobots, botonEnter1, autobots, silenciarMusica);
        
        silenciarMusica.setOnMouseClicked(new SilenciadorEventHandler());
        
		botonComenzar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				ContenedorPrincipal contenedor = new ContenedorPrincipal(nombreJugadorAutobots, nombreJugadorDecepticons);
				stage.setScene(new Scene(contenedor));
				stage.setFullScreen(true);
				stage.setFullScreenExitHint("");
			}
		});

		botonEnter1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento){
				if (! textoJugadorAutobots.getText().trim().equals("")){
					if (root.getChildren().contains(errorIngreso)){
						root.getChildren().remove(errorIngreso);
					}
					nombreJugadorAutobots = textoJugadorAutobots.getText();
					root.getChildren().remove(textoJugadorAutobots);
					root.getChildren().remove(botonEnter1);
					root.getChildren().remove(autobots);
					root.getChildren().add(textoJugadorDecepticons);
					root.getChildren().add(botonEnter2);
					root.getChildren().add(decepticons);
					textoJugadorDecepticons.requestFocus();
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
				if (! textoEstaVacio(textoJugadorDecepticons) && ! textosSonIguales(textoJugadorAutobots, textoJugadorDecepticons)){
					if (root.getChildren().contains(errorIngreso)){
						root.getChildren().remove(errorIngreso);
					}
					if (root.getChildren().contains(errorNombresIguales)){
						root.getChildren().remove(errorNombresIguales);
					}
					nombreJugadorDecepticons = textoJugadorDecepticons.getText();
					root.getChildren().remove(textoJugadorDecepticons);
					root.getChildren().remove(botonEnter2);
					root.getChildren().remove(decepticons);
					root.getChildren().add(botonComenzar);
					botonComenzar.requestFocus();
				}
				else if (textosSonIguales(textoJugadorAutobots, textoJugadorDecepticons)){
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
        textoJugadorAutobots.setOnKeyPressed(texto1EventHandler);

        TextoEventHandler texto2EventHandler = new TextoEventHandler(botonEnter2);
        textoJugadorDecepticons.setOnKeyPressed(texto2EventHandler);

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
	
	public static void ganoAlguien(String ganador){
        Stage popUp = new Stage();
        popUp.initModality(Modality.WINDOW_MODAL);
        //Botones y texto
        Label label = new Label();
        label.setText(ganador + " GANASTE!");
        Button botonCerrar = new Button();
        botonCerrar.setText("Cerrar");
        botonCerrar.setOnAction(e -> cerrarPrograma());
        Button botonSeguir = new Button();
        botonSeguir.setText("Seguir jugando");
        botonSeguir.setOnAction(e -> popUp.close());
        //Contenedor
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,botonCerrar,botonSeguir);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(5);
        popUp.setFullScreen(false);
        popUp.initOwner(stage);
        HBox cont = new HBox(layout);
        cont.setSpacing(5);
         
        Scene scene = new Scene(cont);
        popUp.setScene(scene);
        popUp.showAndWait();
	}
	private static void cerrarPrograma(){
		stage.close();
	}
	
	public static void silenciarMusica(){
		if (musicaPausada){
			mediaPlayer.play();
			musicaPausada = false;
		}
		else{
			mediaPlayer.pause();
			musicaPausada = true;
		}
	}

}
