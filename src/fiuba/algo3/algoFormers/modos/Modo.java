package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.Habitables.Accionable;
import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.*;

public interface Modo{
	
	public void atacar(Tablero tablero, Autobot atacante, Accionable atacado,Potencia potencia);
	public void atacar(Tablero tablero, Decepticon atacante, Accionable atacado,Potencia potencia);
	public void cambiar(Algoformer algoformer);
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero, Agilidad agilidad);
	public void reposicionarse(Tablero tablero,Algoformer algoformer);
	public int simularEfecto(SuperficieAire superficieAire, Algoformer algoformer);
	public int simularEfecto(SuperficieTierra superficieTierra, Algoformer algoformer);
	public int simularPasoDe(SuperficiePantano superficiePantano);
	public void reaccionarASuperficie(SuperficieAire superficieAire, Algoformer algoformer);
	public void reaccionarASuperficie(SuperficieTierra superficieTierra, Algoformer algoformer);
	public void serDesafectado(SuperficieTierra superficieTierra, Algoformer algoformer);
	public void serDesafectado(SuperficieAire superficieAire, Algoformer algoformer);
	public int verAtaque();
	
}
