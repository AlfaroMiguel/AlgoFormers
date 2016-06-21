package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.excepciones.ElementoNoExisteException;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class Controlador {
	
//	Controlador
//	Interpreta la entrada del usuario y se lo comunica al modelo
//	  
//	 juego: una referencia al modelo del juego para que
//	  	pueda ser modificada
//	  
//	 modo: El modo en que esta el jugador actual, de este depende
//	  		  la accion que vaya a hacer

	public Juego juego;
	public ModoControlador modo;
	
	public Controlador(Juego juego){
		this.juego = juego;
		this.modo = new ModoSeleccionar();
	}
	
//	 Responde a el click del usuario sobre un casillero 
//	 coordenada: casillero seleccionado
	
	public void fueSeleccionado(Coordenada coordenada){
		//Limpia la pantalla y se centra en la coordenada
		juego.nuevaSeleccion();
		juego.moverTablero(coordenada);
		
		// Actualiza el modelo
		try{
			this.modo.fueSeleccionado(this.juego, coordenada);
		}
		catch(MovimientoInvalidoException exception){/*Va a modo seleccionar*/}
		catch(ElementoNoExisteException exception){}
		catch(NullPointerException exception){}
		
		//Pone por defecto al modo seleccionar
		this.modo = new ModoSeleccionar();	
	}
	
//	 Mismo caso que fueSeleccionado, pero para cuando
//	 el mouse pasa por encima de la coordenada
//	 
//	 coordenada: casillero por el cual se pasa
	
	public void entro(Coordenada coordenada) {
		this.modo.entro(this.juego, coordenada);
	}
	
//	 Los siguientes metodos son para cambiar el
//	 modo en el cual se encuentra el controlador
//	 cambiando asi su comportamiento
	
	public void cambiarAModoMover(){
		this.modo = new ModoMover();
	}

	public void cambiarAModoAtaque() {
		this.modo = new ModoAtacar(this.juego);
	}
	
//	 Todos los siguientes metodos son para realizar una accion
//	 que no requiere de un modo
	
	public void transformarSeleccionado() {
		this.juego.transformarSeleccionado();
		this.modo = new ModoSeleccionar();
	}

	public void combinarSeleccionado() {
		this.juego.combinarAlgoFormers();
		this.modo = new ModoSeleccionar();	
	}
	
	public void descombinarSeleccionado(){
		this.juego.descombinarAlgoFormers();
		this.modo = new ModoSeleccionar();
	}

	public void terminarTurno() {
		this.juego.cambiarTurno();
	}
}
