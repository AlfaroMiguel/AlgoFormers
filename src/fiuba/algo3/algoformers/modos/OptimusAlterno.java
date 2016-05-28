package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;
import fiuba.algo3.algoformers.autobots.Autobot;
import fiuba.algo3.algoformers.decepticons.Decepticon;

public class OptimusAlterno implements Modo {
	
	private static OptimusAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private OptimusAlterno(){
		this.ataque = 15;
		this.distAtaque = 4;
		this.velocidad = 5;
	}
	
	public static OptimusAlterno getInstance(){
		if (instancia == null){
			instancia = new OptimusAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusHumanoide.getInstance());
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
