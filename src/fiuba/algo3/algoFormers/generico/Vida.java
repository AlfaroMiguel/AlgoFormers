package fiuba.algo3.algoFormers.generico;

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
	}

	public void multiplicarVida(double factor) {
		this.cantVida = (int)(Math.ceil(this.cantVida*factor));
	}

	public boolean seTermino() {
		return this.cantVida <= 0;
	}
}
