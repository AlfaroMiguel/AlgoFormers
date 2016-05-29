package fiuba.algo3.algoFormers.algoFormersTests.TableroTests;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoFormers.Habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;

public class TableroTests {
	@Test
	public void test01ElTableroSeCreaVacio(){
		Tablero tablero = new Tablero(10,10);
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(3,3));
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(2,5));
		Assert.assertTrue("El tablero NO se crea vacio en todas las posicines", tablero.estaVacio(1,9));
	}

	@Test
	public void test02ElTableroUbicaHabitablesEnElMapa(){
		Tablero tablero = new Tablero(10,10);
		Coordenada coordenada = new Coordenada(3,2);
		ChispaSuprema chispa = ChispaSuprema.getInstance();
		tablero.put(chispa,coordenada);
		Assert.assertTrue("El tablero NO agrega Habitables a posiciones", tablero.estaVacio(3,4));
	}

}
