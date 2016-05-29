package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.modos.Modo;
import fiuba.algo3.algoFormers.Habitables.*;
import fiuba.algo3.algoFormers.Juego.Autobots;
import fiuba.algo3.algoFormers.Juego.Decepticons;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;


public abstract class Algoformer implements HabitableDelMapa {
	
	protected Modo modo;
	protected int vida;
	public Tablero tablero;
	
	public abstract void atacar(Tablero tablero, HabitableDelMapa atacado);
	public abstract void serAtacado(Autobot atacante, int ataque);
	public abstract void serAtacado(Decepticon atacante, int ataque);
	public abstract void serSeleccionado(Autobots equipoAutobot);
	public abstract void serSeleccionado(Decepticons equipoDecepticon);
	
	public Algoformer(){
	}
	
	public void setTablero(Tablero tablero){
		this.tablero = tablero;
	}
	
	public void moverse(Coordenada coordenada, Tablero tablero){
		this.modo.moverse(this, coordenada, tablero);
	}
	
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

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	
//	//todavia no se como manejar esto
//	public void componerse(){
//	}

}
