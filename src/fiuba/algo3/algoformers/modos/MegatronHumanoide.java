package fiuba.algo3.algoformers.modos;

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
			return new MegatronHumanoide();
		}
		return instancia;
	}
	
}
