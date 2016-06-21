package fiuba.algo3.algoFormers.habitables;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoSeleccionableException;
import fiuba.algo3.algoFormers.generico.ObservadorTerminoJuego;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.vista.HexGrid;
import javafx.scene.image.Image;

public class Vacio implements Accionable{

	@Override
	 public Image getImage(){
		return null;
	}
	
	public boolean ocupaLugar(){
		return false;
	}
	
	public void colisionar(){
	}

	@Override
	public void serAtacado(Autobot atacante, int ataque) {
	}
	
	@Override
	public void serAtacado(Decepticon atacante, int ataque) {
	}
	
	@Override
	public void serSeleccionado(EquipoAutobots equipo) {
		throw new NoSeleccionableException();
	}

	@Override
	public void serSeleccionado(EquipoDecepticons equipo) {
		throw new NoSeleccionableException();
	}
	
	@Override
	public void serDesafectado(SuperficieAire superficie) {
	}

	@Override
	public void serDesafectado(SuperficieTierra superficie) {
	}

	public int simularPasoPor(SuperficieTierra superficie){
		return 0;
	}
	public int simularPasoPor(SuperficieAire superficie){
		return 0;
	}

	@Override
	public void reaccionarASuperficie(SuperficieAire superficie) {
	}

	@Override
	public void reaccionarASuperficie(SuperficieTierra superficie) {
	}

	@Override
	public void recolectar(Recolectable recolectable) {
	}

	@Override
	public void agregarObservador(ObservadorTerminoJuego observador) {
	}

	@Override
	public void eliminarObservador(ObservadorTerminoJuego observador) {
	}

	@Override
	public void notificarObservadores() {
	}

	@Override
	public void efectoPorMicroMovimiento(SuperficieAire superficie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void efectoPorMicroMovimiento(SuperficieTierra superficie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coordenada getCoordenada() {
		return null;
	}

	@Override
	public void setCoordenada(Coordenada coordenada) {
		// TODO Auto-generated method stub
		
	}
	
}
