package fiuba.algo3.algoFormers.generico;

/* Clase que representa un factor por el que se multiplica la velocidad
 * en cada movimiento. */
public class Agilidad {
	
	/* Atributos */
	/* Indica el valor del factor. Se inicializa en 1 para no afectar a la velocidad. */
	float agilidad = 1;
	
	/* Metodos de la clase */
	/* Coloca la agilidad en 0 para volver 0 a cualquier velocidad. */
	public void inmovilizar(){
		this.agilidad = 0;
	}
	/* Multiplica la agilidad por un factor para multiplicar 
	 * la velocidad por el mismo. 
	 * Parametros: factor: factor por el que se quiere multiplicar. */
	public void multiplicarVelocidad(double factor){
		this.agilidad *= factor; 
	}
	/* Devuelve el valor actual de la agilidad. */
	public double getAgilidad(){
		return this.agilidad;
	}
}
