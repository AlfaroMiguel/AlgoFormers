package fiuba.algo3.algoFormers.generico;

public class Agilidad {
	float estado = 1;
	public Agilidad(){
	}
	public void inmovilizar(){
		this.estado = 0;
	}
	public void multiplicarVelocidad(double i){
		this.estado*=i; 
	}
	public double getAgilidad(){
		return this.estado;
	}
}
