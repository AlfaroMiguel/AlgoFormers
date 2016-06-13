package fiuba.algo3.algoFormers.generico;

public class Escudo {
	
	//con 0 esta activado, con 1 desactivado
	int poder = 1;
	
	public Escudo(){}
	
	public void colocarEscudo(){
		this.poder = 0;
	}
	
	public int getEscudo(){
		return this.poder;
	}

	public void sacarEscudo() {
		this.poder = 1;
	}
}
