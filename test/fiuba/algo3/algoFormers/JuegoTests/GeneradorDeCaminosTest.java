package fiuba.algo3.algoFormers.JuegoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.GeneradorDeCaminos;
import fiuba.algo3.algoFormers.Tablero.Tablero;

public class GeneradorDeCaminosTest {

	@Test
	public void test01SeGeneraUnCaminoRecto() {
		Tablero tablero = new Tablero(15,15);
		List<Coordenada> caminoCorrecto = new ArrayList<Coordenada>(); 
			//caminoCorrecto.add(new Coordenada(1,4));
			caminoCorrecto.add(new Coordenada(4,4));
			caminoCorrecto.add(new Coordenada(3,4));
			caminoCorrecto.add(new Coordenada(2,4));
		List<Coordenada> caminoEncontrado = new ArrayList<Coordenada>();
		caminoEncontrado = tablero.buscarCamino(new Coordenada(1,4), new Coordenada(4,4));
		Assert.assertEquals(caminoCorrecto,caminoEncontrado);
	}

}
