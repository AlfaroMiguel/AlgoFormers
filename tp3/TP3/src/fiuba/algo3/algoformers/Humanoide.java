package fiuba.algo3.algoformers;

import java.util.HashMap;
import java.util.Map;

public class Humanoide implements Modo {
	
	private static Map<String,Humanoide> instancias = new HashMap<String,Humanoide>();
	
	private Humanoide(){
	}
	
	public static Humanoide getInstance(String nombre){
		if (! instancias.containsKey(nombre)){
			instancias.put(nombre, new Humanoide());
		}
		return instancias.get(nombre);
	}
}
