package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Algoformer;

public class OptimusHumanoide implements Modo {
	
	private static OptimusHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private OptimusHumanoide(){
		this.ataque = 50;
		this.distAtaque = 2;
		this.velocidad = 2;
	}
	
	public static OptimusHumanoide getInstance(){
		if (instancia == null){
			instancia = new OptimusHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusAlterno.getInstance());
	}
}
