package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.Tablero.Coordenada;

public interface HabitableDelMapa {

	public void colisionar();
	public boolean ocupaLugar();
	
	public void serAtacado(Autobot atacante, int ataque);
	public void serAtacado(Decepticon atacante, int ataque);
	
	public void serSeleccionado(EquipoAutobots equipoAutobots);
	public void serSeleccionado(EquipoDecepticons equipoDecepticons);
	
	public void reaccionarASuperficie(SuperficiePantano superficiePantano);
	public void reaccionarASuperficie(SuperficieRocosa superficieRocosa);
	public void reaccionarASuperficie(SuperficieEspinas superficieEspinas);
	public void reaccionarASuperficie(SuperficieNubes superficieNubes);
	public void reaccionarASuperficie(SuperficieAndromeda superficieAndromeda);
	public void reaccionarASuperficie(SuperficiePsionica superficiePsionica);
	
	public void serDesafectado(SuperficieAire superficieAire);
	public void serDesafectado(SuperficieTierra superficieTierra);
	
	public int simularEfecto(SuperficieAire superficieAire);
	public int simularEfecto(SuperficieTierra superficieTierra);
	public void ponerHabitable(Coordenada coordenada);
	
	
}
