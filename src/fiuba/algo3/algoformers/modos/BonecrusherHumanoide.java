package fiuba.algo3.algoformers.modos;

public class BonecrusherHumanoide implements Modo {
	
	private static BonecrusherHumanoide instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BonecrusherHumanoide(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 1;
	}
	
	public static BonecrusherHumanoide getInstance(){
		if (instancia == null){
			return new BonecrusherHumanoide();
		}
		return instancia;
	}
}
