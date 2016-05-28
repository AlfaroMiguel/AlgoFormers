package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.decepticons.Decepticon;

public class RatchetAlterno implements Modo {

	private static RatchetAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private RatchetAlterno(){
		this.ataque = 35;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static RatchetAlterno getInstance(){
		if (instancia == null){
			instancia = new RatchetAlterno();
		}
		return instancia;
	}
	
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(RatchetHumanoide.getInstance());
	}

	@Override
	public void atacar(Autobot atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}

	@Override
	public void atacar(Decepticon atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
}
