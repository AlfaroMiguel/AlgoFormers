package fiuba.algo3.algoformers.modos;

public class BonecrusherAlterno implements Modo {
	
	private static BonecrusherAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private BonecrusherAlterno(){
		this.ataque = 30;
		this.distAtaque = 3;
		this.velocidad = 8;
	}
	
	public static BonecrusherAlterno getInstance(){
		if (instancia == null){
			return new BonecrusherAlterno();
		}
		return instancia;
	}
	
}
