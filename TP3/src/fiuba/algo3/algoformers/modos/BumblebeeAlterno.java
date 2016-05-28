package fiuba.algo3.algoformers.modos;

public class BumblebeeAlterno implements Modo {
	
	private static BumblebeeAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BumblebeeAlterno(){
		this.ataque = 20;
		this.distAtaque = 3;
		this.velocidad = 5;
	}
	
	public static BumblebeeAlterno getInstance(){
		if (instancia == null){
			return new BumblebeeAlterno();
		}
		return instancia;
	}
}
