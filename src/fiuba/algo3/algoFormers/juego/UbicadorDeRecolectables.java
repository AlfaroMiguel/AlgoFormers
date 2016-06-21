package fiuba.algo3.algoFormers.juego;

import java.util.ArrayList;
import java.util.Random;

import fiuba.algo3.algoFormers.habitables.BurbujaInmaculada;
import fiuba.algo3.algoFormers.habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.habitables.DobleCanion;
import fiuba.algo3.algoFormers.habitables.Flash;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.Vista;

/* Clase que se encarga de ubicar los recolectables en el tablero */
public class UbicadorDeRecolectables {
	
	/* Constantes */
	/* Cantidad de recolectables de cada tipo a ubicar */
	private static final int CANT_BURBUJA_INM = 5;
	private static final int CANT_DOBLE_CANION = 5;
	private static final int CANT_FLASH = 5;
	
	/* Atributos */
	/* Alto del tablero del juego */
	private int altoTablero;
	/* Ancho del tablero del juego */
	private int anchoTablero;
	
	/* Constructor */
	/* crea un Ubicador de recolectables.
	 * Parametros: alto: alto del tablero del juego.
	 * 			   ancho: ancho del tablero del juego. */
	public UbicadorDeRecolectables(int alto, int ancho) {
		this.altoTablero = alto;
		this.anchoTablero = ancho;
	}
	
	/* Metodos de la clase */
	/* Ubica cada uno de los recolectables en el tablero.
	 * Parametros: tablero: tablero del juego. */
	public void ubicarRecolectables(Tablero tablero){
		this.ubicarChispa(tablero);
		this.ubicarDobleCanion(tablero);
		this.ubicarBurbujaInmaculada(tablero);
		this.ubicarFlash(tablero);
	}
	
	/* Ubica todos los bonus flash en posiciones aleatorias del tablero.
	 * Parametros: tablero: tablero del juego. */
	private void ubicarFlash(Tablero tablero) {
		ArrayList<Flash> listaFlash = this.crearListaFlash();
		for (Flash flashEnLista: listaFlash){
			boolean pudoColocar = false;
			while (! pudoColocar){
				try{
					tablero.colocarEnTablero(flashEnLista, this.obtenerCoordenadaBonus(altoTablero, anchoTablero));
					pudoColocar = true;
				}
				catch(Throwable MovimientoInvalidoException){
					continue;
				}
			}
		}
	}
	/* Devuelve una lista con la cantidad de bonus flash indicada por la constante. */
	private ArrayList<Flash> crearListaFlash() {
		ArrayList<Flash> listaFlash = new ArrayList<Flash>();
		for (int i = 0; i < UbicadorDeRecolectables.CANT_FLASH; i++){
			Flash flash = new Flash();
			listaFlash.add(flash);
		}
		return listaFlash;
	}
	/* Ubica la chispa en una region especifica del tablero.
	 * Parametros: tablero: tablero del juego.*/
	private void ubicarChispa(Tablero tablero) {
		ChispaSuprema chispaSuprema = ChispaSuprema.getInstance();
		boolean pudoColocar = false;
		while (! pudoColocar){
			try{
				tablero.colocarEnTablero(chispaSuprema, obtenerCoordenadaDeChispa());
				pudoColocar = true;
			}
			catch(Throwable MovimientoInvalidoException){
				continue;
			}
		}
	}
	/* Devuelve una coordenada aleatoria dentro de la region donde
	 * se quiere colocar la chispa. */
	private Coordenada obtenerCoordenadaDeChispa() {
		double y =  Math.random();
		double x = Math.random();
		if(x<0.1)
			return new Coordenada(4+(int)(y*3),24);
		else if(x<0.2)
			return new Coordenada(5+(int)(y*4),23);
		else if(x<0.4)
			return new Coordenada(5+(int)(y*6),22);
		else if(x<0.6)
			return new Coordenada(5+(int)(y*8),21);
		else if(x<0.7)
			return new Coordenada(6+(int)(y*6),20);
		else if(x<0.8)
			return new Coordenada(7+(int)(y*6),19);
		else if(x<0.9)
			return new Coordenada(9+(int)(y*4),18);
		return new Coordenada(11+(int)(y*2),17);
	}
	/* Ubica todos los bonus burbuja inmaculada en posiciones aleatorias del tablero.
	 * Parametros: tablero: tablero del juego. */
	private void ubicarBurbujaInmaculada(Tablero tablero) {
		ArrayList<BurbujaInmaculada> listaBurbujaInmaculada = this.crearListaBurbujaInmaculada();
		for (BurbujaInmaculada burbujaInmaculadaEnLista: listaBurbujaInmaculada){
			boolean pudoColocar = false;
			while (! pudoColocar){
				try{
					tablero.colocarEnTablero(burbujaInmaculadaEnLista, this.obtenerCoordenadaBonus(altoTablero, anchoTablero));
					pudoColocar = true;
				}
				catch(Throwable g){
					continue;
				}
			}
		}
	}
	/* Devuelve una lista con la cantidad de bonus flash indicada por la constante. */
	private ArrayList<BurbujaInmaculada> crearListaBurbujaInmaculada() {
		ArrayList<BurbujaInmaculada> listaBurbujaInmaculada = new ArrayList<BurbujaInmaculada>();
		for (int i = 0; i < UbicadorDeRecolectables.CANT_BURBUJA_INM; i++){
			BurbujaInmaculada burbujaInmaculada = new BurbujaInmaculada();
			listaBurbujaInmaculada.add(burbujaInmaculada);
		}
		return listaBurbujaInmaculada;
	}
	/* Ubica todos los bonus burbuja inmaculada en posiciones aleatorias del tablero.
	 * Parametros: tablero: tablero del juego. */
	private void ubicarDobleCanion(Tablero tablero) {
		ArrayList<DobleCanion> listaDobleCanion = this.crearListaDobleCanion();
		for(DobleCanion dobleCanionEnLista: listaDobleCanion){
			boolean pudoColocar = false;
			while (! pudoColocar){
				try{
					tablero.colocarEnTablero(dobleCanionEnLista, this.obtenerCoordenadaBonus(altoTablero, anchoTablero));
					pudoColocar = true;
				}
				catch(Throwable MovimientoInvalidoException){
					continue;
				}
			}
		}
	}
	/* Devuelve una lista con la cantidad de bonus flash indicada por la constante. */
	private ArrayList<DobleCanion> crearListaDobleCanion() {
		ArrayList<DobleCanion> listaDobleCanion = new ArrayList<DobleCanion>();
		for (int i = 0; i < UbicadorDeRecolectables.CANT_DOBLE_CANION; i++){
			DobleCanion dobleCanion = new DobleCanion();
			listaDobleCanion.add(dobleCanion);
		}
		return listaDobleCanion;
	}
	
	/* Devuelve una coordenada aleatoria dentro del tablero.
	 * Parametros: alto: alto del tablero.
	 * 			   ancho: ancho del tablero. */
	private Coordenada obtenerCoordenadaBonus(int alto, int ancho) {
		Random rand = new Random();
		int q = rand.nextInt((alto - 0) + 1);
		int r = rand.nextInt((ancho - 0) + 1);
		return new Coordenada(q,r);
	}

}
