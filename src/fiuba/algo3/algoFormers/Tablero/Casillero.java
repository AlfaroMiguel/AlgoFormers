package fiuba.algo3.algoFormers.Tablero;
import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;

public class Casillero {
	private SuperficieAire aire;
	private SuperficieTierra tierra;
	public Casillero(SuperficieAire aire,SuperficieTierra tierra){
		this.aire = aire;
		this.tierra = tierra;
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
