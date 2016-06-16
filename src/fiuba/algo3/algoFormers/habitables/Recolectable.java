package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ObservableTerminoJuego;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import javafx.scene.image.Image;

public interface Recolectable extends ObservableTerminoJuego{
	
	public void colisionar();
	public boolean ocupaLugar();
	public void producirEfecto(Algoformer algoformer);
	public void desafectar(Algoformer algoformer);
	public boolean fueConsumido();
	public boolean equals(BonusVacio otro);
	public Image getImage();
}
