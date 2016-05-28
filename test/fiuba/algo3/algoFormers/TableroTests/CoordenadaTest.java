package TableroTests;

import Tablero.Coordenada;
import org.junit.Assert;
import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void test01LasCoordenadasSeComparaDeFormaCorrecta(){
		Coordenada coordenada1 = new Coordenada(1,3);
		Coordenada coordenada2 = new Coordenada(1,3);
		Assert.assertEquals("Las coordenadas NO se comparan correctamente", coordenada1,coordenada2 );
	}
	@Test
	public void test02LasCoordenadasSeSumanCorrectamente(){
		Coordenada coordenada1 = new Coordenada(2,4);
		Coordenada coordenada2 = new Coordenada(1,3);
		coordenada1.add(coordenada2);
		Coordenada coordenada3 = new Coordenada(3,7);
		Assert.assertEquals("Las coordenadas NO se comparan correctamente", coordenada1,coordenada3 );
	}
}
