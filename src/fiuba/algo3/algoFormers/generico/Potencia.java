package fiuba.algo3.algoFormers.generico;

/*Clase que representa un factor por el que se multiplica el ataque
 * en cada movimiento. */
public class Potencia {
	
	/* Atributos */
	/* Indica el valor del factor. Se inicializa en 1 para no afectar el ataque */ 
	double potencia = 1;
	
	/* Metodos de la clase */
	/* Multiplica la potencia por un factor para multiplicar 
	 * el ataque por el mismo. 
	 * Parametros: factor: factor por el que se quiere multiplicar. */
	public void multiplicarAtaque(double factor){
		this.potencia *= factor;
	}
	/* Devuelve el valor actual de la potencia */
	public double getPotencia(){
		return this.potencia;
	}
	
}
