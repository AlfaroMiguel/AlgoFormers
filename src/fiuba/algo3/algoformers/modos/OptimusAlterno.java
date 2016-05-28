package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

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
			return new OptimusAlterno();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(OptimusHumanoide.getInstance());
	}
}
