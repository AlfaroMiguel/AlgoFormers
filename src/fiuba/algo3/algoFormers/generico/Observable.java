package fiuba.algo3.algoFormers.generico;

public interface Observable {
	
	public void agregarObservador(Observador observador);
	public void eliminarObservador(Observador observador);
	public void notificarObservadores();
	
}
