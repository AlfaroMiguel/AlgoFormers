package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class BumblebeeHumanoide implements Modo {
	
	private static BumblebeeHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BumblebeeHumanoide(){
		this.ataque = 40;
		this.distAtaque = 1;
		this.velocidad = 2;
	}
	
	public static BumblebeeHumanoide getInstance(){
		if (instancia == null){
			instancia = new BumblebeeHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeAlterno.getInstance());
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
