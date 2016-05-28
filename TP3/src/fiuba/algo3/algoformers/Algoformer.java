package fiuba.algo3.algoformers;

import fiuba.algo3.algoformers.modos.Modo;

public class Algoformer {
	
	protected Modo modo;
	protected int vida;

	public Algoformer(Modo modo){
		this.modo = modo;
	}
	
	//llama a mover() de tablero
//	public void moverse(Posicion posicion){
//	}
	
	//el modo se encarga de resetear this.modo a traves de establecerModo()
	public void cambiarModo(){
		this.modo.cambiar(this);
	}
	
	public void establecerModo(Modo modoNuevo){
		this.modo = modoNuevo;
	}
	
	//la forma se encarga de componerlo
	public void componerse(){
		this.forma.componer(this);
	}
	
	public void establecerForma(Forma formaNueva){
		this.forma = formaNueva;
	}
}
