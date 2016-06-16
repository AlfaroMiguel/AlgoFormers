package fiuba.algo3.algoFormers.generico;

public interface ObservableTerminoJuego {
	
	public void agregarObservador(Observador observador);
	public void eliminarObservador(Observador observador);
	public void notificarObservadores();
	
}
