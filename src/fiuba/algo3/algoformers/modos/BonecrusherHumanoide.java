package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

public class BonecrusherHumanoide implements Modo {
	
	private static BonecrusherHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BonecrusherHumanoide(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	public static BonecrusherHumanoide getInstance(){
		if (instancia == null){
			instancia = new BonecrusherHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BonecrusherAlterno.getInstance());
	}
}
