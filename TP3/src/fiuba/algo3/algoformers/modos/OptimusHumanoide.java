package fiuba.algo3.algoformers.modos;

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
			return new OptimusHumanoide();
		}
		return instancia;
	}
}
