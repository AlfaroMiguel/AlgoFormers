package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.excepciones.SinVidaException;

public class Vida {
	
	private int cantVida;

	public Vida(int cantVida){
		this.cantVida = cantVida;
	}
	
	public int verVida(){
		return this.cantVida;
	}
	
	public void sacarVida(int danio){
		this.cantVida = this.cantVida-danio;
		if (this.cantVida <= 0){
			throw new SinVidaException();
		}
	}

	public void multiplicarVida(double factor) {
		this.cantVida = (int)(Math.ceil(this.cantVida*factor));
	}
}
