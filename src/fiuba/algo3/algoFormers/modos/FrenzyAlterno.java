package fiuba.algo3.algoFormers.modos;


import fiuba.algo3.algoFormers.generico.Algoformer;

public class FrenzyAlterno extends ModoTerrestre {
	
	private static FrenzyAlterno instancia;
	
	private FrenzyAlterno(){
		this.ataque = 25;
		this.distAtaque = 2;
		this.velocidad = 6;
	}
	
	public static FrenzyAlterno getInstance(){
		if (instancia == null){
			instancia = new FrenzyAlterno();
		}
		return instancia;
	}
	
	@Override
	public void cambiar(Algoformer algoformer) {
		algoformer.establecerModo(FrenzyHumanoide.getInstance());
	}
}
