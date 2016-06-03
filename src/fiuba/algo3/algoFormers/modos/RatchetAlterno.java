package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.generico.Algoformer;

public class RatchetAlterno extends ModoAereo {

	private static RatchetAlterno instancia;
	
	private RatchetAlterno(){
		this.ataque = 35;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static RatchetAlterno getInstance(){
		if (instancia == null){
			instancia = new RatchetAlterno();
		}
		return instancia;
	}
	
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(RatchetHumanoide.getInstance());
	}
}
