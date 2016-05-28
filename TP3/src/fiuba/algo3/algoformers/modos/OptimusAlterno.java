package fiuba.algo3.algoformers.modos;

public class OptimusAlterno implements Modo {
	
	private static OptimusAlterno instancia;
	private int distAtaque;
	private int ataque;
	private int velocidad;
	
	private OptimusAlterno(){
		this.ataque = 15;
		this.distAtaque = 4;
		this.velocidad = 5;
	}
	
	public static OptimusAlterno getInstance(){
		if (instancia == null){
			return new OptimusAlterno();
		}
		return instancia;
	}
}
