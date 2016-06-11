package fiuba.algo3.algoFormers.efectosTest;

import fiuba.algo3.algoFormers.generico.*;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.Megatron;
import fiuba.algo3.algoFormers.efectos.*;
import fiuba.algo3.algoFormers.Tablero.*;

import org.junit.*;
public class efectosTest {
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test01EfectoAndromedaInmovilizaAlgoformer(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoAndromeda = new EfectoAndromeda();
		efectoAndromeda.afectarAlgoformer(optimus);
		Coordenada coordenada = new Coordenada(3,3);
		Coordenada coordenadaDestino = new Coordenada(3,4);
		tablero.colocarEnTablero(optimus, coordenada);
		optimus.moverse(coordenadaDestino, tablero);
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test02EfectoAndromedaInmovilizaAlgoformerAPesarDeCambioDeModo(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoAndromeda = new EfectoAndromeda();
		efectoAndromeda.afectarAlgoformer(optimus);
		optimus.cambiarModo();
		Coordenada coordenada = new Coordenada(3,3);
		Coordenada coordenadaDestino = new Coordenada(3,4);
		tablero.colocarEnTablero(optimus, coordenada);
		optimus.moverse(coordenadaDestino, tablero);
	}
	
	@Test
	public void test03EfectoEspinasDaniaAlgoformer(){
		Optimus optimus = new Optimus();
		int vidaInicial = optimus.verVida();
		Efecto efectoEspina = new EfectoEspinas();
		efectoEspina.afectarAlgoformer(optimus);
		Assert.assertEquals(optimus.verVida(),(int)(0.95*vidaInicial));
	}
	
	@Test
	public void test04EfectoNubesNoAfectaAlgoformer(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoNubes = new EfectoNubes();
		efectoNubes.afectarAlgoformer(optimus);
		Coordenada coordenada = new Coordenada(3,3);
		//Se mueve en toda su capacidad
		Coordenada coordenadaDestino = new Coordenada(4,4);
		tablero.colocarEnTablero(optimus, coordenada);
		optimus.moverse(coordenadaDestino, tablero);
		Megatron megatron = new Megatron();
		int vidaInicialMegatron = megatron.verVida();
		tablero.colocarEnTablero(megatron, coordenada);
		//AtacaEn todo su Rango
		optimus.atacar(tablero, megatron);
		Assert.assertEquals(vidaInicialMegatron - 50, megatron.verVida());
	}
	
	@Test(expected = MovimientoInvalidoException.class)
	public void test05EfectoPantanoReduceElMovimientoDelAlgoformerALaMitadYMuevoDeFormaIncorrecta(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoPantano = new EfectoPantano();
		efectoPantano.afectarAlgoformer(optimus);
		Coordenada coordenada = new Coordenada(3,3);
		Coordenada coordenadaDestino = new Coordenada(4,4);
		tablero.colocarEnTablero(optimus, coordenada);
		optimus.moverse(coordenadaDestino, tablero);
	}
	
	@Test
	public void test06EfectoPantanoReduceElMovimientoDelAlgoformerALaMitadYMuevoDeFormaCorrecta(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoPantano = new EfectoPantano();
		efectoPantano.afectarAlgoformer(optimus);
		Coordenada coordenada = new Coordenada(3,3);
		Coordenada coordenadaDestino = new Coordenada(3,4);
		tablero.colocarEnTablero(optimus, coordenada);
		optimus.moverse(coordenadaDestino, tablero);
		Assert.assertEquals(tablero.obtenerAccionableEnCoordenada(coordenadaDestino),optimus);
	}
	
	@Test
	public void test07EfectoPsionicoReduceElAtaqueAlgoformerACuartentaPoricento(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoPsionico = new EfectoPsionico();
		efectoPsionico.afectarAlgoformer(optimus);
		Coordenada coordenada = new Coordenada(3,3);
		Coordenada coordenadaMegatron = new Coordenada(4,4);
		tablero.colocarEnTablero(optimus, coordenada);
		Megatron megatron = new Megatron();
		int vidaInicialMegatron = megatron.verVida();
		tablero.colocarEnTablero(megatron, coordenadaMegatron);
		optimus.atacar(tablero, megatron);
		Assert.assertEquals(vidaInicialMegatron -(int)(50*.4),megatron.verVida());
	}
	
	@Test
	public void test08EfectoRocosasNoAfectaAlgoformer(){
		Tablero tablero = new Tablero(10,10);
		Optimus optimus = new Optimus();
		Efecto efectoRocosas = new EfectoRocas();
		efectoRocosas.afectarAlgoformer(optimus);
		Coordenada coordenada = new Coordenada(3,3);
		//Se mueve en toda su capacidad
		Coordenada coordenadaDestino = new Coordenada(4,4);
		tablero.colocarEnTablero(optimus, coordenada);
		optimus.moverse(coordenadaDestino, tablero);
		Megatron megatron = new Megatron();
		int vidaInicialMegatron = megatron.verVida();
		tablero.colocarEnTablero(megatron, coordenada);
		//AtacaEn todo su Rango
		optimus.atacar(tablero, megatron);
		Assert.assertEquals(vidaInicialMegatron - 50, megatron.verVida());
	}
}
