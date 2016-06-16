package fiuba.algo3.algoFormers.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
//import javafx.scene.control.Alert.AlertType;


public class BarraDeMenu extends MenuBar {

    Menu menuArchivo;
    Menu menuOpciones;
    Menu menuAyuda;
    MenuItem opcionPantallaCompleta;

    public BarraDeMenu() {

        this.menuArchivo = new Menu("Archivo");
        this.menuOpciones = new Menu("Opciones");
        this.menuAyuda = new Menu("Ayuda");
        agregarOpcionesAMenus();
    }


    private void agregarOpcionesAMenus() {

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        this.menuArchivo.getItems().add(opcionSalir);
        this.menuAyuda.getItems().add(opcionAcercaDe);

        opcionAcercaDe.setOnAction(new OpcionAcercaDeEventHandler());
        
        this.getMenus().addAll(menuArchivo, menuOpciones, menuAyuda);
    }


    private class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Acerca De...");
//            alert.setHeaderText("Algoformers");
//            alert.setContentText("Trabajo Practico Algoritmos 3\n" +
//                                "2016 - Primer Cuatrimestre\n" +
//                                "Grupo:\n" +
//                                "\tAlfaro, Miguel\n" +
//                                "\tMendez, Agustina\n" +
//                                "\tPeirano, Guido\n" +
//                                "\tValdivia, Rodrigo");
//            alert.show();
        }
    }

}
