package fiuba.algo3.algoFormers.generico;

public class Agilidad {
	float estado = 1;
	
	public Agilidad(){
	}
	
	public void inmovilizar(){
		this.estado = 0;
	}
	
	public void multiplicarVelocidad(double factor){
		this.estado *= factor; 
	}
	
	public double getAgilidad(){
		return this.estado;
	}
}
