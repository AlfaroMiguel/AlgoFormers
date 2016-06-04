package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.*;

public class ModoAereo implements Modo {
	
	protected int distAtaque;
	protected int ataque;
	protected int velocidad;
	
	@Override
	public void atacar(Tablero tablero, Autobot atacante, HabitableDelMapa atacado,Potencia potencia) {
		tablero.coordinateAttack(atacante, this.distAtaque, atacado, (int)(this.ataque*potencia.getPotencia()));
	}

	@Override
	public void atacar(Tablero tablero, Decepticon atacante, HabitableDelMapa atacado,Potencia potencia) {
		tablero.coordinateAttack(atacante, this.distAtaque, atacado, (int)(this.ataque*potencia.getPotencia()));
	}


	@Override
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero,Agilidad agilidad) {
		tablero.mover(algoformer, coordenada, (int)(this.velocidad*agilidad.getAgilidad()));
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieTierra superficieTierra, Algoformer afectado){
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieAire superficieAire, Algoformer afectado){
		superficieAire.afectar(afectado);
	}

	@Override
	public void cambiar(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
	}
}
