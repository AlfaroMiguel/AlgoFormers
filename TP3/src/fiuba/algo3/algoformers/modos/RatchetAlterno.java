package fiuba.algo3.algoformers.modos;

public class RatchetAlterno implements Modo {

	private static RatchetAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private RatchetAlterno(){
		this.ataque = 35;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static RatchetAlterno getInstance(){
		if (instancia == null){
			return new RatchetAlterno();
		}
		return instancia;
	}
}
