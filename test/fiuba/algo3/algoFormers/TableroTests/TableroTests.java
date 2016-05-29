package fiuba.algo3.algoformers.tests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoformers.Tablero.*;
import fiuba.algo3.algoformers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoformers.Habitables.ChispaSuprema;

public class TableroTests {
	Tablero tablero = new Tablero(10,10);

	@Test
	public void test01ElTableroSeCreaVacio(){
		Coordenada coordenada1 = new Coordenada(0,0);
		Coordenada coordenada2 = new Coordenada(3,2);
		Coordenada coordenada3 = new Coordenada(1,9);
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(coordenada1));
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(coordenada2));
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(coordenada3));
	}

	@Test
	public void test02ElTableroUbicaHabitablesEnElMapa(){
		Coordenada coordenada = new Coordenada(3,2);
		ChispaSuprema chispa = ChispaSuprema.getInstance();
		tablero.put(chispa,coordenada);
		Assert.assertTrue("El tablero NO agrega Habitables a posiciones", tablero.estaVacio(coordenada));
	}
	@Test
	public void test03ElTableroEncuentraLasCoordenadasCorrectamente(){
		Coordenada coordenada = new Coordenada(1,0);
		ChispaSuprema chispa = ChispaSuprema.getInstance();
		tablero.put(chispa,coordenada);
		Assert.assertTrue("El tablero NO encuentra las coordenadas coorectamente", tablero.getKeyValue(chispa).equals(coordenada));
	}

	@Test (expected = ElementoNoExisteException.class)
	public void test04ElTableroNoEncuentraElementosQueNoContiene(){
		ChispaSuprema chispa = ChispaSuprema.getInstance();
		tablero.getKeyValue(chispa);
	}
	@Test (expected = MovimientoInvalidoException.class)
	public void test05ElTableroDesplazaUnHabitableDelMapa(){
		Coordenada coordenadaInic = new Coordenada(3,4);
		ChispaSuprema chispa = ChispaSuprema.getInstance();
		tablero.put(chispa,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 2;
		tablero.move(chispa,coordenadaFinal,paso);
	}
	@Test
	public void test06ElTableroDesplazaUnHabitableDelMapa(){
		Coordenada coordenadaInic = new Coordenada(3,4);
		ChispaSuprema chispa = ChispaSuprema.getInstance();
		tablero.put(chispa,coordenadaInic);
		Coordenada coordenadaFinal = new Coordenada(3,7);
		int paso = 3;
		tablero.move(chispa,coordenadaFinal,paso);
		Assert.assertTrue("El tablero NO vacia el espacio del cual se movio el habitable",tablero.estaVacio(coordenadaInic));
		Assert.assertFalse("El tablero NO pone en el lugar de destino al habitable que se movio",tablero.estaVacio(coordenadaFinal));
	}

}
