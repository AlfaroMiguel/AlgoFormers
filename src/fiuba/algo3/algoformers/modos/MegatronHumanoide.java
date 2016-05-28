package fiuba.algo3.algoformers.modos;

import fiuba.algo3.algoformers.Algoformer;

public class MegatronHumanoide implements Modo {
	
	private static MegatronHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private MegatronHumanoide(){
		this.ataque = 10;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	public static MegatronHumanoide getInstance(){
		if (instancia == null){
			instancia = new MegatronHumanoide();
		}
		return instancia;
	}
	
	@Override
	public void atacar(Algoformer atacante, Algoformer atacado) {
		atacado.serAtacado(atacante, this.ataque);
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronAlterno.getInstance());
	}
}
