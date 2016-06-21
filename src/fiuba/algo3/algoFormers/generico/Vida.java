package fiuba.algo3.algoFormers.generico;

/* Clase que representa la vida de un accionable */
public class Vida {
	
	/* Atributos */
	/* Representa la cantidad de vida en un momento dado.*/
	private int cantVida;

	/* Constructor */
	/* Crea a la vida con una cantidad determinada.
	 * Parametros: cantVida: cantidad de vida inicial. */
	public Vida(int cantVida){
		this.cantVida = cantVida;
	}
	
	/* Metodos de la clase */
	/* Devuelve la cantidad de vida actual */
	public int verVida(){
		return this.cantVida;
	}
	/* Resta cantidad vida dependiendo del daño que se le haga. 
	 * Si se hace mas daño que la cantidad de vida actual, esta queda en 0.
	 * Parametros: danio: entero que representa
	 * 					  el factor de daño que se le causa a la vida. */
	public void sacarVida(int danio){
		int vidaNueva = cantVida - danio;
		if (vidaNueva <= 0) 
			cantVida = 0;
		else 
			cantVida = vidaNueva;
	}
	/* Multiplica la cantidad vida por un factor redondenado el resultado para arriba.
	 * Parametros: factor: entero por el que se multiplica la vida. */
	public void multiplicarVida(double factor) {
		this.cantVida = (int)(Math.ceil(this.cantVida*factor));
	}
	/* Devuelve true si no queda mas cantidad de vida y false en caso contrario. */
	public boolean seTermino() {
		return this.cantVida == 0;
	}
}
