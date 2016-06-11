package fiuba.algo3.algoFormers.Juego;

public class JugadorProxy {
	
	private Jugador jugadorReal;
	private int turnoCombinar;
	private static int MAXTURNOCOMBINAR = 2;
	
	public JugadorProxy(Jugador jugadorReal){
		this.jugadorReal = jugadorReal;
		this.turnoCombinar = 0;
	}
	
	public void eliminarBonus(){
		this.descombinarAlgoformers();
		//funciones para eliminar cada uno de los demas bonus
	}
	
	private void descombinarAlgoformers(){
		if (this.turnoCombinar == this.MAXTURNOCOMBINAR){
			this.jugadorReal.descombinarAlgoformers();
		}
		this.turnoCombinar++;
	}
}
