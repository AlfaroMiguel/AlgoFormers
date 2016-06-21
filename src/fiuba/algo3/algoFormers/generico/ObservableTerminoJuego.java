package fiuba.algo3.algoFormers.generico;

/* Interfaz que agrupa a las clases que son observadas para terminar el juego. */
public interface ObservableTerminoJuego {
	
	/* Metodos abstractos */
	/* Agrega un observador para que este pueda estar al tanto de los cambios.
	 * Parametros: observador: observador que se quiere agregar. */
	public void agregarObservador(ObservadorTerminoJuego observador);
	/* Elimina un observador. Este no esta mas al tanto de los cambios.
	 * Parametros: observador: observador que se quiere eliminar.*/ 
	public void eliminarObservador(ObservadorTerminoJuego observador);
	/* Notifica a los observadores sobre los cambios. */
	public void notificarObservadores();
	
}
