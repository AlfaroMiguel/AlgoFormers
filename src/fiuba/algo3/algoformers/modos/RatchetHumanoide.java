package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

public class RatchetHumanoide implements Modo {
	
	private static RatchetHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private RatchetHumanoide(){
		this.ataque = 5;
		this.distAtaque = 5;
		this.velocidad = 1;
	}
	
	public static RatchetHumanoide getInstance(){
		if (instancia == null){
			instancia = new RatchetHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado){
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(RatchetAlterno.getInstance());
	}
}
