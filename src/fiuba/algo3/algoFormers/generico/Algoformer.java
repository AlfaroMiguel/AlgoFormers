package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NotColisionableException;
import fiuba.algo3.algoFormers.modos.Modo;
import fiuba.algo3.algoFormers.Habitables.*;
import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;


public abstract class Algoformer implements HabitableDelMapa {
	
	protected Modo modo;
	protected int vida;
	public Tablero tablero;
	
	public abstract void atacar(Tablero tablero, HabitableDelMapa atacado);
	public abstract void serAtacado(Autobot atacante, int ataque);
	public abstract void serAtacado(Decepticon atacante, int ataque);
	public abstract void serSeleccionado(EquipoAutobots equipoAutobot);
	public abstract void serSeleccionado(EquipoDecepticons equipoDecepticon);
	
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
		//throw new NotColisionableException();
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	public void reaccionarASuperficie(SuperficieTierra superficie){
		//this.modo.reaccionar(superficie);
	}
	public void reaccionarASuperficie(SuperficieAire superficieTierra){
		//this.modo.reaccionar(superficie);
	}
	public void serAfectado(SuperficieAire superficieAire){
		
	}
	public void serDesafectado(SuperficieTierra superficieTierra){
		
	}
	public void serAfectado(SuperficieTierra superficieTierra){
		
	}
	public void serDesafectado(SuperficieAire superficieAire){
		
	}
//	//todavia no se como manejar esto
//	public void componerse(){
//	}

}
