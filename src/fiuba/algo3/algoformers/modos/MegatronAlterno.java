package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

public class MegatronAlterno implements Modo {
	
	private static MegatronAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private MegatronAlterno(){
		this.ataque = 55;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static MegatronAlterno getInstance(){
		if (instancia == null){
			return new MegatronAlterno();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronHumanoide.getInstance());
	}
}
