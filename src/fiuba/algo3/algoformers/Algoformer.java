package fiuba.algo3.algoFormers;

import fiuba.algo3.algoFormers.modos.Modo;

public class Algoformer {
	
	protected Modo modo;
	protected int vida;

	public Algoformer(){
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

	public void serAtacado(Algoformer atacante, int ataque) {
		this.serAtacado(atacante, ataque);
	}
	
	public Modo verModo(){
		return this.modo;
	}
	
	public int verVida(){
		return this.vida;
	}
	
//	//todavia no se como manejar esto
//	public void componerse(){
//	}

}
