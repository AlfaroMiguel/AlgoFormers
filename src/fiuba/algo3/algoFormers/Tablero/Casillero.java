package fiuba.algo3.algoFormers.Tablero;
import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;

public class Casillero {
	private SuperficieAire aire;
	private SuperficieTierra tierra;
	public Casillero(){
	}
	public void agregarSuperficie(SuperficieTierra tierra){
		this.tierra = tierra;
	}
	public void agregarSuperficie(SuperficieAire aire){
		this.aire = aire;
	}
	public void producirEfecto(HabitableDelMapa afectado){
		this.aire.producirEfecto(afectado);
		this.tierra.producirEfecto(afectado);
	}
	public void ubicarEnSuperficie(HabitableDelMapa habitable){
		this.aire.ubicar(habitable);
		this.tierra.ubicar(habitable);
	}
	public void revertirEfecto(HabitableDelMapa desafectado){
		this.aire.revertirEfecto(desafectado);
		this.tierra.revertirEfecto(desafectado);
	}
	public void calcularMovimiento(HabitableDelMapa transeunte){
		this.aire.simularRecorrido(transeunte);
		this.tierra.simularRecorrido(transeunte);
	}
}
