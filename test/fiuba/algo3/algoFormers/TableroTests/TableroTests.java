package fiuba.algo3.algoFormers.TableroTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import javafx.scene.text.Text;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.Megatron;
//import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.excepciones.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;

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
		tablero.colocarEnTablero(optimus,coordenada);
		Assert.assertFalse("El tablero NO agrega Habitables a posiciones", tablero.estaVacio(coordenada));
	}
	
	@Test
	public void test03ElTableroEncuentraLasCoordenadasCorrectamente(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada = new Coordenada(1,0);
		Optimus optimus = new Optimus();
		tablero.colocarEnTablero(optimus,coordenada);
		Assert.assertTrue("El tablero NO encuentra las coordenadas correctamente", tablero.obtenerCoordenadaDeElemento(optimus).equals(coordenada));
	}

	@Test (expected = ElementoNoExisteException.class)
	public void test04ElTableroNoEncuentraElementosQueNoContiene(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		tablero.obtenerCoordenadaDeElemento(optimus);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test05ElTableroLanzaUnaExcepcionEnCasoDeUnMovimientoInvalido(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.colocarEnTablero(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 2;
		tablero.mover(optimus,coordenadaFinal,paso);
	}
	
	@Test
	public void test06ElTableroDesplazaUnHabitableDelMapa(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenadaInic = new Coordenada(3,4);
		Optimus optimus = new Optimus();
		tablero.colocarEnTablero(optimus,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 3;
		tablero.mover(optimus,coordenadaFinal,paso);
		assertTrue("El tablero NO vacia el espacio del cual se movio el habitable",tablero.estaVacio(coordenadaInic));
		assertFalse("El tablero NO pone en el lugar de destino al habitable que se movio",tablero.estaVacio(coordenadaFinal));
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test07ElTableroNoUbicaHabitablesEnElMapaEnPosicionInvalida(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada = new Coordenada(100000,10);
		Optimus optimus = new Optimus();
		tablero.colocarEnTablero(optimus,coordenada);
	}
	
	@Test
	public void test08ElTableroCreaSuperionADistanciaCorrecta(){
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		Ratchet ratchet = new Ratchet();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(1,3);
		Coordenada coordBumblebee = new Coordenada(1,4);
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		Superion superion = new Superion(optimus, ratchet, bumblebee);
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
		assertEquals(tablero.obtenerAccionableEnCoordenada(coordOptimus), superion);
		assertTrue(tablero.estaVacio(coordBumblebee));
		assertTrue(tablero.estaVacio(coordRatchet));
	}

	@Test (expected = NoCombinableException.class)
	public void test09ElTableroNoCreaSuperionADistanciaIncorrecta(){
		Optimus optimus = new Optimus();
		Bumblebee bumblebee = new Bumblebee();
		Ratchet ratchet = new Ratchet();
		Tablero tablero = new Tablero(10,10);
		Coordenada coordOptimus = new Coordenada(1,2);
		Coordenada coordRatchet = new Coordenada(2,3);
		Coordenada coordBumblebee = new Coordenada(1,5);
		tablero.colocarEnTablero(optimus, coordOptimus);
		tablero.colocarEnTablero(bumblebee, coordBumblebee);
		tablero.colocarEnTablero(ratchet, coordRatchet);
		Superion superion = new Superion(optimus, ratchet, bumblebee);
		tablero.combinarAlgoformers(superion, optimus, ratchet, bumblebee, 1);
	}
	
	@Test
	public void test10AlgoformerMuereYDesapareceDelTablero(){
		Tablero tablero = new Tablero(10,10);
		
		//vida ratchet = 150
		Ratchet ratchet = new Ratchet();
		//ataque megatron alterno = 55
		Megatron megatron = new Megatron();
		megatron.cambiarModo();
		
		Coordenada coordRatchet = new Coordenada(2,2);
		Coordenada coordMegatron = new Coordenada(2,3);
		
		tablero.colocarEnTablero(ratchet, coordRatchet);
		tablero.colocarEnTablero(megatron, coordMegatron);
		
		tablero.coordinarAtaque(megatron, 1, ratchet, 55);
		assertEquals(ratchet.verVida(), 95);
		
		tablero.coordinarAtaque(megatron, 1, ratchet, 55);
		assertEquals(ratchet.verVida(), 40);
		
		try{
			tablero.coordinarAtaque(megatron, 1, ratchet, 55);
		}
		catch(SinVidaException exception){
		}
		assertFalse(tablero.obtenerAccionableEnCoordenada(coordRatchet) == ratchet);	
	}
//
//	@Test
//	public void test10ColocarHabitableEnPosicionValida(){
//		Tablero tablero = new Tablero(6,6);
//		Optimus optimus = new Optimus();
//		Bumblebee bumblebee = new Bumblebee();
//		Ratchet ratchet = new Ratchet();
//		Megatron megatron = new Megatron();
//		Coordenada coordOptimus = new Coordenada(3,2);
//		Coordenada coordBumblebee = new Coordenada(4,4);
//		Coordenada coordRatchet = new Coordenada(3,4);
//		tablero.colocarEnTablero(optimus, coordOptimus);
//		tablero.colocarEnTablero(bumblebee, coordBumblebee);
//		tablero.colocarEnTablero(ratchet, coordRatchet);
//		tablero.colocarHabitableEnPosicionValidaDesde(megatron, new Coordenada(3,3));
//		assertSame(tablero.obtenerHabitableEnCoordenada(coordOptimus), optimus);
//		assertSame(tablero.obtenerHabitableEnCoordenada(coordBumblebee), bumblebee);
//		assertSame(tablero.obtenerHabitableEnCoordenada(coordRatchet), ratchet);
//	}
	// FALTA PROBAR QUE SE PONGA BIEN LA VIDA DEL SUPERION Y PROBAR TODO LO MISMO CON MENASOR
	
}
