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
	private static final int CANT_BURBUJA_INM = 5;
	private static final int CANT_DOBLE_CANION = 5;
	private static final int CANT_FLASH = 5;
	
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
		Coordenada coordenadaDeChispa = obtenerCoordenadaDeChispa();
		tablero.colocarEnTablero(chispaSuprema, coordenadaDeChispa);
	}

	private Coordenada obtenerCoordenadaDeChispa() {
		double y =  Math.random();
		double x = Math.random();
		if(x<0.1){
		for(int i =4; i<8;i++){
			return new Coordenada(4+(int)(y*3),24);
		}
		}else if(x<0.2){
		for(int i =5; i<10;i++){
			return new Coordenada(5+(int)(y*4),23);
		}
		}else if(x<0.4){
		for(int i =5; i<12;i++){
			return new Coordenada(5+(int)(y*6),22);
		}
		}else if(x<0.6){
		for(int i =5; i<14;i++){
			return new Coordenada(5+(int)(y*8),21);
		}
		}else if(x<0.7){
		for(int i =6; i<13;i++){
			return new Coordenada(6+(int)(y*6),20);
		}
		}else if(x<0.8){
		for(int i =7; i<14;i++){
			return new Coordenada(7+(int)(y*6),19);
		}
		}else if(x<0.9){
		for(int i =9; i<14;i++){
			return new Coordenada(9+(int)(y*4),18);
		}
		}
		for(int i = 11; i<14;i++){
			return new Coordenada(11+(int)(y*2),17);
		}
		return null;
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
