package fiuba.algo3.algoFormers.generico;

/* Clase que representa un factor por el que se multiplica el ataque de un adversario
 * para permitir que valga su verdadero valor o 0 y no cause daño. */
public class Escudo {
	
	/* Atributos */
	/* Indica el valor del factor. Se inicializa en 1 para no afectar el ataque inicialmente.
	 * Solo puede valer 1 (activado) o 0 (desactivado).*/
	int poder = 1;
	
	/* Metodos de la clase */
	/* Activa el poder del escudo */
	public void colocarEscudo(){
		this.poder = 0;
	}
	/* Desactiva el poder del escudo */
	public void sacarEscudo() {
		this.poder = 1;
	}
	/* Devuelve el valor del factor de poder del escudo */
	public int getEscudo(){
		return this.poder;
	}
}
