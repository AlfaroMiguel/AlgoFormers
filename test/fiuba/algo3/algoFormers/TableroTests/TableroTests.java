package fiuba.algo3.algoFormers.TableroTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.excepciones.ElementoNoExisteException;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;

public class TableroTests {
	

	@Test
	public void test01ElTableroSeCreaVacio(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada1 = new Coordenada(0,0);
		Coordenada coordenada2 = new Coordenada(3,2);
		Coordenada coordenada3 = new Coordenada(1,9);
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(coordenada1));
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(coordenada2));
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(coordenada3));
	}

	@Test
	public void test02ElTableroUbicaHabitablesEnElMapa(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada = new Coordenada(3,2);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenada);
		Assert.assertFalse("El tablero NO agrega Habitables a posiciones", tablero.estaVacio(coordenada));
	}
	@Test
	public void test03ElTableroEncuentraLasCoordenadasCorrectamente(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada = new Coordenada(1,0);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenada);
		Assert.assertTrue("El tablero NO encuentra las coordenadas correctamente", tablero.obtenerCoordenadaDeHabitable(optimus).equals(coordenada));
	}

	@Test (expected = ElementoNoExisteException.class)
	public void test04ElTableroNoEncuentraElementosQueNoContiene(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		tablero.obtenerCoordenadaDeHabitable(optimus);
	}
	@Test (expected = MovimientoInvalidoException.class)
	public void test05ElTableroLanzaUnaExcepcionEnCasoDeUnMovimientoInvalido(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 2;
		tablero.mover(optimus,coordenadaFinal,paso);
	}
	@Test
	public void test06ElTableroDesplazaUnHabitableDelMapa(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 3;
		tablero.mover(optimus,coordenadaFinal,paso);
		assertTrue("El tablero NO vacia el espacio del cual se movio el habitable",tablero.estaVacio(coordenadaInic));
		assertFalse("El tablero NO pone en el lugar de destino al habitable que se movio",tablero.estaVacio(coordenadaFinal));
	}
	@Test(expected = MovimientoInvalidoException.class)
	public void test07ElTableroUbicaHabitablesEnElMapaEnPosicionInvalida(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada = new Coordenada(100000,10);
		Optimus optimus = new Optimus();
		tablero.put(optimus,coordenada);
	}
	@Test
	public void test08ElTableroCreaSuperionConVidaCorrectaADistanciaCorrecta(){
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		Ratchet ratchet = new Ratchet();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,3);
		Coordenada coordBumblebee = new Coordenada(1,4);
		tablero.put(optimus, coordOptimus);
		tablero.put(bumblebee, coordBumblebee);
		tablero.put(ratchet, coordRatchet);
		tablero.combinarAlgoformers(optimus, ratchet, bumblebee, 1);
		assertEquals(tablero.obtenerHabitableEnCoordenada(coordOptimus).getClass(), Superion.class);
//		assertEquals(tablero.obtenerHabitableEnCoordenada(coordOptimus), ) PROBAR VIDA
	}
	
}
