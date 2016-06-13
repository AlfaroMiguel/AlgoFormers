package fiuba.algo3.algoFormers.TableroTests;

import java.util.*;
import org.junit.*;

import fiuba.algo3.algoFormers.tablero.*;
public class PriorityQueueTest {
	@Test
	public void test01PriorityQueueConElementosEnOrden(){
		PriorityQueue<Tupla> cola = new PriorityQueue<Tupla>();
		Tupla tupla1 = new Tupla(new Coordenada(1,3),1);
		Tupla tupla2 = new Tupla(new Coordenada(2,3),2);
		Tupla tupla3 = new Tupla(new Coordenada(3,3),3);
		Tupla tupla4 = new Tupla(new Coordenada(4,3),4);
		cola.add(tupla1);
		cola.add(tupla2);
		cola.add(tupla3);
		cola.add(tupla4);
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(1,3));
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(2,3));
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(3,3));
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(4,3));
		
	}
	@Test
	public void test02PriorityQueueConElementosEnDesorden(){
		PriorityQueue<Tupla> cola = new PriorityQueue<Tupla>();
		Tupla tupla1 = new Tupla(new Coordenada(1,3),3);
		Tupla tupla2 = new Tupla(new Coordenada(2,3),2);
		Tupla tupla3 = new Tupla(new Coordenada(3,3),1);
		Tupla tupla4 = new Tupla(new Coordenada(4,3),4);
		cola.add(tupla1);
		cola.add(tupla2);
		cola.add(tupla3);
		cola.add(tupla4);
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(3,3));
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(2,3));
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(1,3));
		Assert.assertEquals(cola.remove().getCoordenada(), new Coordenada(4,3));
		
	}
}
