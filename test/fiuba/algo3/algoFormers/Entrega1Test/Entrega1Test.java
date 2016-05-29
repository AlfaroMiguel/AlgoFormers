package fiuba.algo3.algoFormers.Entrega1Test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.Juego.Juego;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.modos.OptimusAlterno;
import fiuba.algo3.algoFormers.modos.OptimusHumanoide;

public class Entrega1Test {

	@Test
	public void test01UbicarHumanoideYMoverADireccionValida(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 3;
		tablero.mover(optimus,coordenadaFinal,paso);
		assertTrue(tablero.estaVacio(coordenadaInic));
		assertEquals(tablero.ver(coordenadaFinal), optimus);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test02UbicarHumanoideYMoverADireccionInvalida(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,9);
		int paso = 3;
		tablero.mover(optimus,coordenadaFinal,paso);
	}
	
	
	@Test
	public void test03UbicarHumanoideYTransformarEnAmbasDirecciones(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		OptimusAlterno optimusAlterno = OptimusAlterno.getInstance();
		OptimusHumanoide optimusHumanoide = OptimusHumanoide.getInstance();
		tablero.put(optimus,coordenadaInic);
		assertEquals(optimus.verModo(), optimusHumanoide);
		optimus.cambiarModo();
		assertEquals(optimus.verModo(), optimusAlterno);
		optimus.cambiarModo();
		assertEquals(optimus.verModo(), optimusHumanoide);
	}
	
	@Test
	public void test04UbicarAlternoYMoverAPosicionValida(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,9);
		int paso = 5;
		tablero.mover(optimus,coordenadaFinal,paso);
		assertTrue(tablero.estaVacio(coordenadaInic));
		assertEquals(tablero.ver(coordenadaFinal), optimus);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test05UbicarAlternoYMoverAPosicionInvalida(){
		Optimus optimus = new Optimus();
		optimus.cambiarModo();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,2);
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,9);
		int paso = 5;
		tablero.mover(optimus,coordenadaFinal,paso);
	}
	
//	@Test
//	public void test06PruebIntegracion(){
//		Juego juego = new Juego();
//		assertTrue(juego.seUbicoALosPersonajes());
//		Boolean encontroLaChispa = false;
//		for(int i=9;i<12;i++){
//			for(int j=9;j<12;j++){
//				if(juego.estaLaChispa(i,j)){
//					encontro = true;
//				}
//			}
//		}
//		assertTrue(encontroLaChispa);
//	}
	
}
