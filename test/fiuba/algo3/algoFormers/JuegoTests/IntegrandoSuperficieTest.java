package fiuba.algo3.algoFormers.JuegoTests;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.juego.*;

import org.junit.*;
public class IntegrandoSuperficieTest {
	@Test(expected = MovimientoInvalidoException.class)
	public void test01CambiarAModoAereoEnUnaSuperficieDeAndromeda(){
		Tablero tablero = new Tablero(20,20);
		Equipo equipoAutobots = new EquipoAutobots();
		Jugador jugador= new Jugador(equipoAutobots, tablero);
		jugador.ubicarPersonajes();
		Coordenada inicialRatchet = new Coordenada(3,0);
		jugador.seleccionarAlgoformer(inicialRatchet);
		tablero.colocarSuperficieEnTablero(new SuperficieAndromeda(), new Coordenada(3,1));
		jugador.mover(new Coordenada(3,1));
		jugador.terminarTurno();
		jugador.transformarAlgoformer();
		jugador.terminarTurno();
		jugador.mover(inicialRatchet);
	}
//	@Test(expected = MovimientoInvalidoException.class)
//	public void test02CambiarAModoTerrestreEnUnaSuperficieDePantano(){
//		Tablero tablero = new Tablero(20,20);
//		Equipo equipoAutobots = new EquipoAutobots();
//		Jugador jugador= new Jugador(equipoAutobots, tablero);
//		jugador.ubicarPersonajes();
//		Coordenada inicialRatchet = new Coordenada(2,1);
//		jugador.seleccionarAlgoformer(inicialRatchet);
//		tablero.colocarSuperficieEnTablero(new SuperficiePantano(), new Coordenada(3,1));
//		jugador.transformarAlgoformer();
//		jugador.mover(new Coordenada(3,1));
//		jugador.terminarTurno();
//		jugador.transformarAlgoformer();
//		jugador.terminarTurno();
//		jugador.mover(inicialRatchet);
//	}
	@Test
	public void test03CambiarAModoAereoEnUnaSuperficiePsionica(){
		Tablero tablero = new Tablero(20,20);
		Equipo equipoAutobots = new EquipoAutobots();
		Jugador jugador= new Jugador(equipoAutobots, tablero);
		jugador.ubicarPersonajes();
		Coordenada inicialRatchet = new Coordenada(3,0);
		jugador.seleccionarAlgoformer(inicialRatchet);
		tablero.colocarSuperficieEnTablero(new SuperficiePsionica(), new Coordenada(3,1));
		Megatron megatron = new Megatron();
		tablero.colocarEnTablero(megatron, new Coordenada(5,1));
		jugador.mover(new Coordenada(3,1));
		jugador.terminarTurno();
		jugador.transformarAlgoformer();
		jugador.terminarTurno();
		int vidaInicial = megatron.verVida();
		jugador.atacar(new Coordenada(5,1));
		jugador.terminarTurno();
		Assert.assertEquals(megatron.verVida(), vidaInicial-(int)(35*0.4));
	}
//	@Test
//	public void test04CambiarAModoTerrestreEnUnaSuperficieDeEspinas(){
//		Tablero tablero = new Tablero(20,20);
//		Equipo equipoAutobots = new EquipoAutobots();
//		Jugador jugador= new Jugador(equipoAutobots, tablero);
//		jugador.ubicarPersonajes();
//		Coordenada inicialRatchet = new Coordenada(2,1);
//		jugador.seleccionarAlgoformer(inicialRatchet);
//		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), new Coordenada(3,1));
//		jugador.transformarAlgoformer();
//		jugador.terminarTurno();
//		jugador.mover(new Coordenada(3,1));
//		jugador.terminarTurno();
//		int vidaInicial = jugador.verAlgoformerActual().verVida();
//		jugador.transformarAlgoformer();
//		jugador.terminarTurno();
//		//Sumo un 1 porque se redondea raro, no me voy a calentar por eso
//		Assert.assertEquals(jugador.verAlgoformerActual().verVida(), (int)(vidaInicial*0.95)+1);
//		
//	}
	@Test
	public void test05EntroEnModoTerrestreAEspinasYCambioAAereoSeRetiraElEfecto(){
		Tablero tablero = new Tablero(20,20);
		Equipo equipoAutobots = new EquipoAutobots();
		Jugador jugador= new Jugador(equipoAutobots, tablero);
		jugador.ubicarPersonajes();
		Coordenada inicialRatchet = new Coordenada(3,0);
		jugador.seleccionarAlgoformer(inicialRatchet);
		tablero.colocarSuperficieEnTablero(new SuperficieEspinas(), new Coordenada(3,1));
		jugador.mover(new Coordenada(3,1));
		jugador.terminarTurno();
		int vidaAnteriorAlCambio = jugador.verAlgoformerActual().verVida();
		jugador.transformarAlgoformer();
		jugador.terminarTurno();
		Assert.assertEquals(jugador.verAlgoformerActual().verVida(),vidaAnteriorAlCambio);
		
	}
}
