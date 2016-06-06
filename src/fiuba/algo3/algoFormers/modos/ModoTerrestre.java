package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;
import fiuba.algo3.algoFormers.Superficies.*;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Agilidad;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.Potencia;

public abstract class ModoTerrestre implements Modo {
	
	protected int distAtaque;
	protected int ataque;
	protected int velocidad;
	
	public int verAtaque(){
		return this.ataque;
	}
	
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
	public void cambiar(Algoformer algoformer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reposicionarse(Tablero tablero, Algoformer algoformer) {
		tablero.reposicionar(algoformer);
	}

	@Override
	public int simularEfecto(SuperficieAire superficieAire, Algoformer algoformer) {
		return 0;
	}

	@Override
	public int simularEfecto(SuperficieTierra superficieTierra, Algoformer algoformer) {
		return superficieTierra.simularPasoDe(algoformer);
	}

	@Override
	public abstract int simularPasoDe(SuperficiePantano superficiePantano);
	public void serDesafectado(SuperficieTierra superficieTierra, Algoformer algoformer){
		superficieTierra.desafectar(algoformer);
	}
	public void serDesafectado(SuperficieAire superficieAire, Algoformer algoformer){
		//Nada
	}
	
}
