package pruebasdiseño.pxy;

public class ProxyUso {
	
	public static void main(String[] args){
		Image image = new ProxyImage("aa");
		
		image.display();
		
		image.display();
	}
}
