package fiuba.algo3.algoFormers.JuegoTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoFormers.autobots.Optimus;
import fiuba.algo3.algoFormers.superficie.SuperficiePantano;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;

public class GeneradorDeCaminosTest {

	@Test
	public void test01SeGeneraUnCaminoRecto() {
		Tablero tablero = new Tablero(15,15);
		List<Coordenada> caminoCorrecto = new ArrayList<Coordenada>();
			caminoCorrecto.add(new Coordenada(4,4));
			caminoCorrecto.add(new Coordenada(3,4));
			caminoCorrecto.add(new Coordenada(2,4));
			caminoCorrecto.add(new Coordenada(1,4));
		List<Coordenada> caminoEncontrado = new ArrayList<Coordenada>();
		caminoEncontrado = tablero.buscarCamino(new Coordenada(1,4), new Coordenada(4,4),new Optimus());
		Assert.assertEquals(caminoCorrecto,caminoEncontrado);
	}
	@Test
	public void test02SeGeneraUnCaminoNoRectoParaEvitarSuperficie() {
		Tablero tablero = new Tablero(15,15);
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(),new Coordenada(3,4));
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(),new Coordenada(3,5));
		tablero.colocarSuperficieEnTablero(new SuperficiePantano(),new Coordenada(2,5));
		List<Coordenada> caminoCorrecto = new ArrayList<Coordenada>();
			caminoCorrecto.add(new Coordenada(4,4));
			caminoCorrecto.add(new Coordenada(4,3));
			caminoCorrecto.add(new Coordenada(3,3));
			caminoCorrecto.add(new Coordenada(2,4));
			caminoCorrecto.add(new Coordenada(1,4));
		List<Coordenada> caminoEncontrado = new ArrayList<Coordenada>();
		caminoEncontrado = tablero.buscarCamino(new Coordenada(1,4), new Coordenada(4,4),new Optimus());
		Assert.assertEquals(caminoCorrecto,caminoEncontrado);
	}

}
