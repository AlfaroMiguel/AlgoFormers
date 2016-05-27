package fiuba.algo3.algoformers;

public class Algoformer {
	
	private Modo modo;
	private Forma forma;
	
	public Algoformer(){
		this.modo = new Humanoide();
		this.forma = new FormaSimple();
	}
	
	public void cambiarModo(Modo modoNuevo){
		this.modo = modoNuevo;
	}
	
	public void cambiarForma(Forma formaNueva){
		this.forma = formaNueva;
	}
	
	public void atacar(Algoformer otro){
		this.atacar(otro);
	}
}
