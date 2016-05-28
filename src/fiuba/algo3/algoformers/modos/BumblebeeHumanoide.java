package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Algoformer;

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
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(BumblebeeAlterno.getInstance());
	}
}
