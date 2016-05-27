package fiuba.algo3.algoformers;

import java.util.HashMap;
import java.util.Map;

public class Autobot extends Algoformer {
	
	private static Map<String,Autobot> instancias = new HashMap<String,Autobot>();
	
	private Autobot(){
		super();
	}
	
	public static Autobot getInstance(String nombre) {
		if (! instancias.containsKey(nombre)){
			instancias.put(nombre, new Autobot());
		}
		return instancias.get(nombre);
	}
	
}
