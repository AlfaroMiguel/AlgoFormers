package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BonecrusherAlterno implements Modo {
	
	private static BonecrusherAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BonecrusherAlterno(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 8;
	}
	
	public static BonecrusherAlterno getInstance(){
		if (instancia == null){
			instancia = new BonecrusherAlterno();
		}
		return instancia;
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherHumanoide.getInstance());
	}

	@Override
	public void atacar(Autobot atacante, HabitableDelMapa atacado) {
		atacado.serAtacado(atacante, this.ataque);	
	}

	@Override
	public void atacar(Decepticon atacante, HabitableDelMapa atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}

	@Override
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero) {
		tablero.mover(algoformer, coordenada, this.velocidad);
	}
	
}
