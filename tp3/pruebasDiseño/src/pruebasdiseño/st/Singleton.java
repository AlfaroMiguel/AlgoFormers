package pruebasdiseño.st;

public class Singleton {
	
	//crea el atributo instancia
	private static Singleton instance = null;
	private String name;
	
	//constructor privado para que no se pueda instanciar
	private Singleton(){
	}
	
	//devuelve la instancia
	public static Singleton getInstance(){
		if (instance == null){
			return new Singleton();
		}
		return instance;
	}
	
	//hacer cosas
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
