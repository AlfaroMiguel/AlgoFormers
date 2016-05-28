package fiuba.algo3.algoformers.modos;

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
			return new RatchetHumanoide();
		}
		return instancia;
	}
	
}
