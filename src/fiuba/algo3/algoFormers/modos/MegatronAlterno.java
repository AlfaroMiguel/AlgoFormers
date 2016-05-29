package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Algoformer;

public class MegatronAlterno implements Modo {
	
	private static MegatronAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private MegatronAlterno(){
		this.ataque = 55;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static MegatronAlterno getInstance(){
		if (instancia == null){
			instancia = new MegatronAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronHumanoide.getInstance());
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
