package fiuba.algo3.algoFormers.efectosTest;

import org.junit.*;
import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoNubes;
import fiuba.algo3.algoFormers.generico.*;
import fiuba.algo3.algoFormers.Tablero.*;
import fiuba.algo3.algoFormers.excepciones.*;

public class SuperficiesTest {
	@Test(expected = MovimientoInvalidoException.class)
	public void test01AlPonerAlgoformerModoAereoEnUnaSuperficieDeAndromedaSeInmoviliza(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			ratchet.cambiarModo();
			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaInicial);
			tablero.colocarEnTablero(ratchet, coordenadaInicial);
			ratchet.moverse(new Coordenada(3,4),tablero);		
	}
	@Test(expected = MovimientoInvalidoException.class)
	public void test02AlPonerAlgoformerModoAereoEnUnaSuperficieDeAndromedaSeInmovilizaAunDespuesDeCambiarDeModo(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			ratchet.cambiarModo();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaInicial);
			tablero.colocarEnTablero(ratchet, coordenadaInicial);
			ratchet.cambiarModo();
			ratchet.moverse(new Coordenada(3,4),tablero);		
	}
	@Test
	public void test03AlPonerAlgoformerModoHumanoideEnUnaSuperficieDeAndromedaNoSeInmoviliza(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaInicial);
			tablero.colocarEnTablero(ratchet, coordenadaInicial);
			ratchet.moverse(new Coordenada(3,4),tablero);
			Assert.assertEquals(tablero.obtenerHabitableEnCoordenada(new Coordenada(3,4)), ratchet);
	}
	@Test (expected = MovimientoInvalidoException.class)
	public void test04AlPonerAlgoformerModoAereoEnUnaSuperficieDeAndromedaSeInmovilizaAunDespuesDeCambiarDeModo(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			ratchet.cambiarModo();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaInicial);
			tablero.colocarEnTablero(ratchet, coordenadaInicial);
			ratchet.cambiarModo();
			ratchet.moverse(new Coordenada(3,4),tablero);		
	}
}
