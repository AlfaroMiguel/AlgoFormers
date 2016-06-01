package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class FrenzyAlterno implements Modo {
	
	private static FrenzyAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private FrenzyAlterno(){
		this.ataque = 25;
		this.distAtaque = 2;
		this.velocidad = 6;
	}
	
	public static FrenzyAlterno getInstance(){
		if (instancia == null){
			instancia = new FrenzyAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyHumanoide.getInstance());
	}

	@Override
	public void atacar(Tablero tablero, Autobot atacante, HabitableDelMapa atacado) {
		tablero.coordinateAttack(atacante, this.distAtaque, atacado, this.ataque);
	}

	@Override
	public void atacar(Tablero tablero, Decepticon atacante, HabitableDelMapa atacado) {
		tablero.coordinateAttack(atacante, this.distAtaque, atacado, this.ataque);
	}
	
	@Override
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero) {
		tablero.mover(algoformer, coordenada, this.velocidad);
	}
}
