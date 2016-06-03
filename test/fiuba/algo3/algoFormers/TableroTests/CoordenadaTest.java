package fiuba.algo3.algoFormers.TableroTests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

//import fiuba.algo3.algoformers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.*;

public class CoordenadaTest {

	@Test
	public void test01LasCoordenadasSeComparaDeFormaCorrecta(){
		Coordenada coordenada1 = new Coordenada(1,3);
		Coordenada coordenada2 = new Coordenada(1,3);
		Assert.assertEquals("Las coordenadas NO se comparan correctamente", coordenada1,coordenada2 );
	}
	/*@Test
	public void test02LasCoordenadasSeSumanCorrectamente(){
		Coordenada coordenada1 = new Coordenada(2,4);
		Coordenada coordenada2 = new Coordenada(1,3);
		coordenada1.add(coordenada2);
		Coordenada coordenada3 = new Coordenada(3,7);
		Assert.assertEquals("Las coordenadas NO se comparan correctamente", coordenada1,coordenada3 );
	}*/
	@Test
	public void test03LaDistanciaDeLasCoordenadasSeCalculanCorrectamente(){
		Coordenada coordenada1 = new Coordenada(1,4);
		Coordenada coordenada2 = new Coordenada(1,3);
		double largo = 1;
		Assert.assertTrue("La distancia entre las coordenadas NO se calcula correctamente",coordenada1.distancia(coordenada2)==largo);
	}

}
