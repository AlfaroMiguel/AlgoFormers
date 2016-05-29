package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class MegatronHumanoide implements Modo {
	
	private static MegatronHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private MegatronHumanoide(){
		this.ataque = 10;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	public static MegatronHumanoide getInstance(){
		if (instancia == null){
			instancia = new MegatronHumanoide();
		}
		return instancia;
	}

	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronAlterno.getInstance());
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
