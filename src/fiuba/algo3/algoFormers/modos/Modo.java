package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import javafx.scene.image.Image;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.*;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.superficie.*;

public interface Modo{
	
	public void atacar(Tablero tablero, Autobot atacante, Accionable atacado,Potencia potencia);
	public void atacar(Tablero tablero, Decepticon atacante, Accionable atacado,Potencia potencia);
	public void cambiar(Algoformer algoformer);
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero, Agilidad agilidad);
	public void reposicionarse(Tablero tablero,Algoformer algoformer);
	public int simularPasoDe(SuperficieTierra superficieTierra);
	public int simularPasoDe(SuperficieAire superficieAire);
	public void reaccionarASuperficie(SuperficieAire superficieAire, Algoformer algoformer);
	public void reaccionarASuperficie(SuperficieTierra superficieTierra, Algoformer algoformer);
	public void serDesafectado(SuperficieTierra superficieTierra, Algoformer algoformer);
	public void serDesafectado(SuperficieAire superficieAire, Algoformer algoformer);
	public int verAtaque();
	public void producirEfectoPorMicroMovimiento(SuperficieAire superficie, Algoformer algoformer);
	public void producirEfectoPorMicroMovimiento(SuperficieTierra superficie, Algoformer algoformer);
	public Image getImage();
	
}
