package fiuba.algo3.algoFormers.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import fiuba.algo3.algoFormers.vista.TableroVista;
import fiuba.algo3.algoFormers.vista.BarraOpciones;
public class ContenedorGeneral extends BorderPane {

    BarraDeMenu barraMenu;
    Canvas canvasArena;
    VBox contenedorArena;


    public ContenedorGeneral(BarraDeMenu menuBar) {
        this.barraMenu = menuBar;
        this.setTop(barraMenu);
        this.setCenter(TableroVista.layout());
        this.setBottom(BarraOpciones.crearBoxOpciones());
    }


    public BarraDeMenu getBarraMenu() {
        return barraMenu;
    }

}