package fiuba.algo3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoformers.Alterno;
import fiuba.algo3.algoformers.Autobot;
import fiuba.algo3.algoformers.Decepticon;
import fiuba.algo3.algoformers.Modo;

public class algoformersTest {

	@Test
	public void crearAutobotsConMultitonTest() {
		Autobot optimus = Autobot.getInstance("optimus");
		Autobot bumblebee = Autobot.getInstance("bumblebee");
		Autobot optimus2 = Autobot.getInstance("optimus");
		Autobot bumblebee2 = Autobot.getInstance("bumblebee");
		assertEquals(optimus, optimus2);
		assertEquals(bumblebee, bumblebee2);
	}
	
	@Test
	public void crearDecepticonsConMultitonTest(){
		Decepticon megatron = Decepticon.getInstance("megatron");
		Decepticon frenzy = Decepticon.getInstance("frenzy");
		Decepticon megatron2 = Decepticon.getInstance("megatron");
		Decepticon frenzy2 = Decepticon.getInstance("frenzy");
		assertEquals(megatron, megatron2);
		assertEquals(frenzy, frenzy2);
	}
	
	@Test
	public void cambiarModoAutobotTerrestre(){
		Autobot optimus = Autobot.getInstance("optimus");
		Modo alterno = new Alterno();
		optimus.cambiarModo(alterno);
	}
	
	

}
