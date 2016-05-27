package pruebasdiseño.st;

import java.util.HashMap;

public class Multiton {
	
	private static HashMap<String, Multiton> instances = new HashMap<String, Multiton>();
	private String name;
	
	private Multiton(){	
	}
	
	public static Multiton getInstance(String key){
		if (! instances.containsKey(key)){
			instances.put(key, new Multiton());
		}
		return instances.get(key);
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
