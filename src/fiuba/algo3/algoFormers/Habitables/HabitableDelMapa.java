package fiuba.algo3.algoFormers.Habitables;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;

public interface HabitableDelMapa {

	public void colisionar();
	public boolean ocupaLugar();
	public void serAtacado(Autobot atacante, int ataque);
	public void serAtacado(Decepticon atacante, int ataque);
}
