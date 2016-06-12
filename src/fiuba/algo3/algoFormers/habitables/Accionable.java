package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;

public interface Accionable{


	public void colisionar();
	public boolean ocupaLugar();
	
	public void serAtacado(Autobot atacante, int ataque);
	public void serAtacado(Decepticon atacante, int ataque);
	
	public void serSeleccionado(EquipoAutobots equipoAutobots);
	public void serSeleccionado(EquipoDecepticons equipoDecepticons);
	
	public void reaccionarASuperficie(SuperficieAire superficieAire);
	public void reaccionarASuperficie(SuperficieTierra superficieTierra);
	
	
	public void serDesafectado(SuperficieAire superficieAire);
	public void serDesafectado(SuperficieTierra superficieTierra);
	
	public int simularEfecto(SuperficieAire superficieAire);
	public int simularEfecto(SuperficieTierra superficieTierra);

	public void recolectar(Collectable colectable);

}
