package fiuba.algo3.algoformers.modos;

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
			return new BumblebeeHumanoide();
		}
		return instancia;
	}
}
