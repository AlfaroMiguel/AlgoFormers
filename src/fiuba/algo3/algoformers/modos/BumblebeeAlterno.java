package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

public class BumblebeeAlterno implements Modo {
	
	private static BumblebeeAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BumblebeeAlterno(){
		this.ataque = 20;
		this.distAtaque = 3;
		this.velocidad = 5;
	}
	
	public static BumblebeeAlterno getInstance(){
		if (instancia == null){
			return new BumblebeeAlterno();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeHumanoide.getInstance());
	}
}
