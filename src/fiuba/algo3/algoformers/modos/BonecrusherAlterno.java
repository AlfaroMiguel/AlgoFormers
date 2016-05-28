package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Algoformer;

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
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherHumanoide.getInstance());
	}
	
}
