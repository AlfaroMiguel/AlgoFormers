package fiuba.algo3.algoFormers.controlador;

import fiuba.algo3.algoFormers.excepciones.ElementoNoExisteException;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.juego.Juego;
import fiuba.algo3.algoFormers.tablero.Coordenada;

public class Controlador {
	public Juego juego;
	public ModoControlador modo;
	
	public Controlador(Juego juego){
		this.juego = juego;
		this.modo = new ModoSeleccionar();
	}
	
	public void fueSeleccionado(Coordenada coordenada){
		juego.nuevaSeleccion();
		juego.moverTablero(coordenada);
		try{
			this.modo.fueSeleccionado(this.juego, coordenada);
		}
		catch(MovimientoInvalidoException exception){/*Va a modo seleccionar*/}
		catch(ElementoNoExisteException exception){}
		catch(NullPointerException exception){}
		this.modo = new ModoSeleccionar();	
	}
	public void cambiarAModoMover(){
		System.out.println("cambio a mover");
		this.modo = new ModoMover();
	}
	
	public void transformarSeleccionado() {
		this.juego.transformarSeleccionado();
		this.modo = new ModoSeleccionar();
	}
	
	public void entro(Coordenada coordenada) {
		this.modo.entro(this.juego, coordenada);
	}

	public void combinarSeleccionado() {
		this.juego.combinarAlgoFormers();
		this.modo = new ModoSeleccionar();
		
	}
	
	public void descombinarSeleccionado(){
		this.juego.descombinarAlgoFormers();
		this.modo = new ModoSeleccionar();
	}

	public void cambiarAModoAtaque() {
		this.modo = new ModoAtacar(this.juego);
	}

	public void terminarTurno() {
		this.juego.cambiarTurno();
	}
}
