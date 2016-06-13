package fiuba.algo3.algoFormers.efectosTest;

import org.junit.*;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.*;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.efectos.Efecto;
import fiuba.algo3.algoFormers.efectos.EfectoNubes;
import fiuba.algo3.algoFormers.generico.*;
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
			//Los efectos se aplican al final de cada turno
			ratchet.terminaTurno();
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
			//Los efectos se aplican al final de cada turno
			ratchet.terminaTurno();
			ratchet.moverse(new Coordenada(3,4),tablero);		
	}
	
//	@Test
//	public void test03AlPonerAlgoformerModoHumanoideEnUnaSuperficieDeAndromedaNoSeInmoviliza(){
//			Tablero tablero = new Tablero(10,10);
//			Ratchet ratchet = new Ratchet();
//			Coordenada coordenadaInicial = new Coordenada(3,3);
//			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaInicial);
//			tablero.colocarEnTablero(ratchet, coordenadaInicial);
//			//Los efectos se aplican al final de cada turno
//			ratchet.terminaTurno();
//			ratchet.moverse(new Coordenada(3,4),tablero);
//			Assert.assertEquals(tablero.obtenerHabitableEnCoordenada(new Coordenada(3,4)), ratchet);
//	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test04AlPonerAlgoformerModoAereoEnUnaSuperficieDeAndromedaSeInmovilizaAunDespuesDeCambiarDeModo(){
			Tablero tablero = new Tablero(10,10);
			Ratchet ratchet = new Ratchet();
			ratchet.cambiarModo();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), coordenadaInicial);
			tablero.colocarEnTablero(ratchet, coordenadaInicial);
			ratchet.terminaTurno();
			//Los efectos se aplican al final de cada turno
			ratchet.cambiarModo();
			ratchet.moverse(new Coordenada(3,4),tablero);		
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test05AlPonerAlgoformerModoTerrestreEnUnaSuperficiePantanoNoPuedeAtravesar(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaInicial);
			tablero.colocarEnTablero(optimus, coordenadaInicial);
	}
	
	@Test (expected = MovimientoInvalidoException.class)
	public void test06AlPonerAlgoformerModoTerrestreEnUnaSuperficiePantanoReduceSuMovimientoAunDespuesDeCambiarDeModo(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficiePantano(), coordenadaInicial);
			tablero.colocarEnTablero(optimus, coordenadaInicial);
			optimus.cambiarModo();
			//Los efectos se aplican al final de cada turno
			optimus.terminaTurno();
			optimus.moverse(new Coordenada(3,6),tablero);		
	}
	
	@Test
	public void test07AlPonerAlgoformerModoTerrestreEnUnaSuperficieEspinasReduceSuVida(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), coordenadaInicial);
			tablero.colocarEnTablero(optimus, coordenadaInicial);
			int vidaInicial = optimus.verVida();
			//Los efectos se aplican al final de cada turno
			optimus.terminaTurno();
			Assert.assertEquals(optimus.verVida(), (int)(vidaInicial*0.95));		
	}
	
	@Test
	public void test08AlPonerAlgoformerModoTerrestreEnUnaSuperficiePsionicaNoReduceSuAtaque(){
			Tablero tablero = new Tablero(10,10);
			Optimus optimus = new Optimus();
			Megatron megatron = new Megatron();
			Coordenada coordenadaInicial = new Coordenada(3,3);
			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaInicial);
			tablero.colocarEnTablero(optimus, coordenadaInicial);
			tablero.colocarEnTablero(megatron, new Coordenada(3,4));
			int vidaInicial = megatron.verVida();
			//Los efectos se aplican al final de cada turno
			optimus.terminaTurno();
			optimus.atacar(tablero, megatron);
			Assert.assertEquals(megatron.verVida(), vidaInicial- 50);
			
	}
	
//	@Test
//	public void test09AlPonerAlgoformerModoAereoEnUnaSuperficiePsionicaReduceSuAtaque(){
//			Tablero tablero = new Tablero(10,10);
//			Optimus optimus = new Optimus();
//			Megatron megatron = new Megatron();
//			megatron.cambiarModo();
//			Coordenada coordenadaInicial = new Coordenada(3,3);
//			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaInicial);
//			tablero.colocarEnTablero(megatron, coordenadaInicial);
//			tablero.colocarEnTablero(optimus, new Coordenada(3,4));
//			int vidaInicial = optimus.verVida();
//			//Los efectos se aplican al final de cada turno
//			megatron.terminaTurno();
//			megatron.atacar(tablero, optimus);
//			Assert.assertEquals(optimus.verVida(), vidaInicial- (int)(55*0.4));
//			
//	}
//	
//	@Test
//	public void test10AlPonerAlgoformerModoAereoEnUnaSuperficiePsionicaReduceSuAtaqueDespuesDeCambiarModo(){
//			Tablero tablero = new Tablero(10,10);
//			Optimus optimus = new Optimus();
//			Megatron megatron = new Megatron();
//			megatron.cambiarModo();
//			Coordenada coordenadaInicial = new Coordenada(3,3);
//			tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), coordenadaInicial);
//			tablero.colocarEnTablero(megatron, coordenadaInicial);
//			tablero.colocarEnTablero(optimus, new Coordenada(3,4));
//			int vidaInicial = optimus.verVida();
//			//Los efectos se aplican al final de cada turno
//			megatron.terminaTurno();
//			megatron.cambiarModo();
//			megatron.atacar(tablero, optimus);
//			Assert.assertEquals(optimus.verVida(), vidaInicial- (int)(10*0.4));
//			
//	}
}
