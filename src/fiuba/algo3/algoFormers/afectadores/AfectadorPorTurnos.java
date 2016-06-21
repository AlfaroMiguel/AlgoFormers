package fiuba.algo3.algoFormers.afectadores;

import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoTerminado;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.ListaDeAfectadores;

/*Tipo de afectador que maneja los efectos que dependen de los turnos*/
public class AfectadorPorTurnos extends Afectador {
	
	/*Atributos*/
	/*Cantidad de turnos que debe durar el efecto*/
	int turnos;
	/*Indica si algun algoformer ya fue afectado por este afectador*/
	private boolean activado;
	
	/*Constructor*/
	/*Parametros: -efecto: es el efecto que se le quiere asignar al afectador*/
	public AfectadorPorTurnos(int turnos, Efecto efecto){
		this.turnos = turnos;
		this.efecto = efecto;
		this.activado = false;
	}
	
	/*Metodos de la clase*/
	/*Indica que algun algoformer fue afectado por este afectador*/
	public void activar(){
		this.activado = true;
	}
	/*Devuelve true o false dependiendo de si el afectador fue activado o no*/
	public boolean estaActivado(){
		return this.activado;
	}
	/*Cambia el efecto a terminado para que no afecte mas al algoformer*/
	public void cambiarEfecto(){
		this.efecto = new EfectoTerminado();
	}
	
	/*Metodos abstractos redefinidos*/
	@Override
	public void pasarTurno(){
		this.turnos--;
		if(this.turnos == 0)
			this.cambiarEfecto();
	}
	
	@Override
	public void desafectarAlgoformer(Algoformer algoformer){
	}
	
	@Override
	public void afectarPorPaso(Algoformer algoformer) {
		algoformer.agregarEfecto(this);	
	}

	@Override
	public void afectarAlgoformer(Algoformer algoformer) {
		ListaDeAfectadores afectadores  = algoformer.obtenerAfectadoresEnAtacable();
		afectadores.agregarAfectador(this);	
	}
}
