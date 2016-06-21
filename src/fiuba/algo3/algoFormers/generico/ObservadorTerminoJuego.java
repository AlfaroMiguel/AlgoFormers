package fiuba.algo3.algoFormers.generico;

/* Interfaz que agrupa a las clases que observan a otras para modificarse segun
 * los cambios de estas, con el objetivo de terminar el juego. */
public interface ObservadorTerminoJuego {
	
	/* Metodos abstractos */
	/* Aplica los cambios */
	public void actualizar();
	/* Notifica cuando se muere el combinado para terminar el juego*/
	public void actualizarCombinado();
	/* Agrega un observable para poder actualizarse con los cambios de este.
	 * Parametros: observable: observable que se quiere agregar. */
	public void observarA(ObservableTerminoJuego observable);
}
