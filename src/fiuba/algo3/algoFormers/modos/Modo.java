package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.*;

public interface Modo{
	
	public void atacar(Tablero tablero, Autobot atacante, HabitableDelMapa atacado,Potencia potencia);
	public void atacar(Tablero tablero, Decepticon atacante, HabitableDelMapa atacado,Potencia potencia);
	public void cambiar(Algoformer algoformer);
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero, Agilidad agilidad);
	public void reaccionarASuperficie(SuperficieTierra superficieTierra, Algoformer afectado);
	public void reaccionarASuperficie(SuperficieAire superficieAire, Algoformer afectado);
	public void reposicionarse(Tablero tablero,Algoformer algoformer);
	public int simularEfecto(SuperficieAire superficieAire, Algoformer algoformer);
	public int simularEfecto(SuperficieTierra superficieTierra, Algoformer algoformer);
	public int simularPasoDe(SuperficiePantano superficiePantano);

}
