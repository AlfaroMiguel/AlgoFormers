package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.modos.Modo;

public abstract class Algoformer{
	
	protected Modo modo;
	protected int vida;
	
	public abstract void atacar(Algoformer atacado);
	public abstract void serAtacado(Autobot atacante, int ataque);
	public abstract void serAtacado(Decepticon atacante, int ataque);
	
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
