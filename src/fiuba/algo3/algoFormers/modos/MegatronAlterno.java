package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.generico.Algoformer;

public class MegatronAlterno extends ModoAereoAlterno {
	
	private static MegatronAlterno instancia;
	
	private MegatronAlterno(){
		this.ataque = 55;
		this.distAtaque = 2;
		this.velocidad = 8;
	}
	
	public static MegatronAlterno getInstance(){
		if (instancia == null){
			instancia = new MegatronAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(MegatronHumanoide.getInstance());
	}
	
}
