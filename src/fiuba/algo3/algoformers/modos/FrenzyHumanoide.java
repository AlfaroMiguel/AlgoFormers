package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoFormers.Algoformer;

public class FrenzyHumanoide implements Modo {
	
	private static FrenzyHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private FrenzyHumanoide(){
		this.ataque = 10;
		this.distAtaque = 5;
		this.velocidad = 2;
	}
	
	public static FrenzyHumanoide getInstance(){
		if (instancia == null){
			instancia = new FrenzyHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyAlterno.getInstance());
	}
}
