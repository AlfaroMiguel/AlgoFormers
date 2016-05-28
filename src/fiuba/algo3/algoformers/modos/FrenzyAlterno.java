package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

public class FrenzyAlterno implements Modo {
	
	private static FrenzyAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private FrenzyAlterno(){
		this.ataque = 25;
		this.distAtaque = 2;
		this.velocidad = 6;
	}
	
	public static FrenzyAlterno getInstance(){
		if (instancia == null){
			return new FrenzyAlterno();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyHumanoide.getInstance());
	}
}
