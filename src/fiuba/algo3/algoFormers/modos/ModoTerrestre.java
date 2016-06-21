package fiuba.algo3.algoFormers.modos;

import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.generico.Agilidad;
import fiuba.algo3.algoFormers.generico.Algoformer;
import fiuba.algo3.algoFormers.generico.Potencia;
import fiuba.algo3.algoFormers.habitables.Accionable;

/* Clase que representa al modo terrestre */
public abstract class ModoTerrestre implements Modo {
	
	/* Atributos */
	/* Distancia a la que tiene que estar otro accionable para poder atacarlo */
	protected int distAtaque;
	/* Cantidad de vida que le saca a otro accionable cuando lo ataca */
	protected int ataque;
	/* Cantidad maxima de casilleros que se puede desplazar en cada movimiento */
	protected int velocidad;
	
	/* Metodos abstractos redefinidos */
	@Override
	public int verAtaque(){
		return this.ataque;
	}
	
	@Override
	public double verPaso(){
		return this.velocidad;
	}
	
	@Override
	public int verRangoAtaque(){
		return this.distAtaque;
	}
	
	@Override
	public void atacar(Tablero tablero, Autobot atacante, Accionable atacado,Potencia potencia) {
		tablero.coordinarAtaque(atacante, atacado, this.distAtaque, (int)(this.ataque*potencia.getPotencia()));
	}

	@Override
	public void atacar(Tablero tablero, Decepticon atacante, Accionable atacado,Potencia potencia) {
		tablero.coordinarAtaque(atacante, atacado, this.distAtaque, (int)(this.ataque*potencia.getPotencia()));
	}


	@Override
	public void moverse(Algoformer algoformer, Coordenada coordenada, Tablero tablero,Agilidad agilidad) {
		tablero.mover(algoformer, coordenada, (int)(this.velocidad*agilidad.getAgilidad()));
	}

	@Override
	public void cambiar(Algoformer algoformer) {
	}

	@Override
	public void reposicionarse(Tablero tablero, Algoformer algoformer) {
		tablero.reposicionar(algoformer);
	}
	
	@Override
	public abstract int simularPasoDe(SuperficieTierra superficie);
	
	@Override
	public int simularPasoDe(SuperficieAire superficie){
		return 1;
	}
	
	@Override
	public void serDesafectado(SuperficieAire superficie, Algoformer algoformer){
	}
	@Override
	public void reaccionarASuperficie(SuperficieAire superficie, Algoformer afectado){	
	}
	
	@Override
	public void producirEfectoPorMicroMovimiento(SuperficieAire superficie, Algoformer algoformer){
	}
	
	@Override
	public void producirEfectoPorMicroMovimiento(SuperficieTierra superficie, Algoformer algoformer){
		superficie.producirEfectoPorPaso(algoformer,this);
	}
	
}
