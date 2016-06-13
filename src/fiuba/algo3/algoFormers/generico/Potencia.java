package fiuba.algo3.algoFormers.generico;

public class Potencia {
	double potencia = 1;
	public Potencia(){}
	
	public void multiplicarAtaque(double i){
		this.potencia*=i;
	}
	public double getPotencia(){
		return this.potencia;
	}
	
}
