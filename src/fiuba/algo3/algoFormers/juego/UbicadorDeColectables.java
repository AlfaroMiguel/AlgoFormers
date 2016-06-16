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

public class UbicadorDeColectables {
	
	private int altoTablero;
	private int anchoTablero;
	private static final int CANT_BURBUJA_INM = 2;
	private static final int CANT_DOBLE_CANION = 2;
	private static final int CANT_FLASH = 2;
	
	public UbicadorDeColectables(int alto, int ancho) {
		this.altoTablero = alto;
		this.anchoTablero = ancho;
	}

	public void ubicarColectables(Tablero tablero){
		this.ubicarChispa(altoTablero, anchoTablero, tablero);
		this.ubicarDobleCanion(tablero);
		this.ubicarBurbujaInmaculada(tablero);
		this.ubicarFlash(tablero);
	}
	
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

	private ArrayList<Flash> crearListaFlash() {
		ArrayList<Flash> listaFlash = new ArrayList<Flash>();
		for (int i = 0; i < UbicadorDeColectables.CANT_FLASH; i++){
			Flash flash = new Flash();
			listaFlash.add(flash);
		}
		return listaFlash;
	}

	private void ubicarChispa(int alto,int ancho, Tablero tablero) {
		ChispaSuprema chispaSuprema = ChispaSuprema.getInstance();
//		boolean pudoColocar = false;
//		while (! pudoColocar){
//			try{
//				tablero.colocarEnTablero(chispaSuprema, coordenadaChispa(alto,ancho));
//				pudoColocar = true;
//			}
//			catch(Throwable g){
//				continue;
//			}
//		}
		tablero.colocarEnTablero(chispaSuprema, coordenadaChispa(alto,ancho));
	}

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

	private ArrayList<BurbujaInmaculada> crearListaBurbujaInmaculada() {
		ArrayList<BurbujaInmaculada> listaBurbujaInmaculada = new ArrayList<BurbujaInmaculada>();
		for (int i = 0; i < UbicadorDeColectables.CANT_BURBUJA_INM; i++){
			BurbujaInmaculada burbujaInmaculada = new BurbujaInmaculada();
			listaBurbujaInmaculada.add(burbujaInmaculada);
		}
		return listaBurbujaInmaculada;
	}

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

	private ArrayList<DobleCanion> crearListaDobleCanion() {
		ArrayList<DobleCanion> listaDobleCanion = new ArrayList<DobleCanion>();
		for (int i = 0; i < UbicadorDeColectables.CANT_DOBLE_CANION; i++){
			DobleCanion dobleCanion = new DobleCanion();
			listaDobleCanion.add(dobleCanion);
		}
		return listaDobleCanion;
	}

	private Coordenada coordenadaChispa(int alto, int ancho){
		Random rand = new Random();
		int q = rand.nextInt((ancho - 6) + 3);
		int q_offset = (int)Math.floor(q/2); 
		int r = rand.nextInt((alto - q_offset - alto/2) + 1);
		return new Coordenada(q,r);
	}

	private Coordenada obtenerCoordenadaBonus(int alto, int ancho) {
		Random rand = new Random();
		int q = rand.nextInt((alto - 0) + 1);
		int r = rand.nextInt((ancho - 0) + 1);
		return new Coordenada(q,r);
	}

	public void ubicarColectables(Tablero tablero, Vista vista) {
		// TODO Auto-generated method stub
		
	}
}
