package fiuba.algo3.algoformers;

import java.util.HashMap;
import java.util.Map;


public class Decepticon extends Algoformer {

	private static Map<String,Decepticon> instancias = new HashMap<String,Decepticon>();
	
	private Decepticon(){
		super();
	}
	public static Decepticon getInstance(String nombre) {
		if (! instancias.containsKey(nombre)){
			instancias.put(nombre, new Decepticon());
		}
		return instancias.get(nombre);
	}

}
