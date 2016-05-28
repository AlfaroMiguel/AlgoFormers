package fiuba.algo3.algoformers.modos;

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
	
}
