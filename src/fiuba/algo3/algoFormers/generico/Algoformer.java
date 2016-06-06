package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.modos.Modo;
import fiuba.algo3.algoFormers.Habitables.*;
import fiuba.algo3.algoFormers.Juego.EquipoAutobots;
import fiuba.algo3.algoFormers.Juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.Superficies.SuperficieAire;
import fiuba.algo3.algoFormers.Superficies.SuperficiePantano;
import fiuba.algo3.algoFormers.Superficies.SuperficieTierra;
import fiuba.algo3.algoFormers.Tablero.Coordenada;
import fiuba.algo3.algoFormers.Tablero.Tablero;
import fiuba.algo3.algoFormers.afectadores.Afectador;


public abstract class Algoformer implements HabitableDelMapa {
	
	protected Modo modo;
	protected Vida vida;
	protected ListaDeAfectadores afectadores = new ListaDeAfectadores();
	protected Agilidad agilidad= new Agilidad() ;
	protected Potencia potencia = new Potencia();
	public abstract void atacar(Tablero tablero, HabitableDelMapa atacado);
	public abstract void serAtacado(Autobot atacante, int ataque);
	public abstract void serAtacado(Decepticon atacante, int ataque);
	public abstract void serSeleccionado(EquipoAutobots equipoAutobot);
	public abstract void serSeleccionado(EquipoDecepticons equipoDecepticon);
	
	
	public Algoformer(){
	}
	public void inmovilizar(){
		this.agilidad.multiplicarVelocidad(0);
		
	}
	public void moverse(Coordenada coordenada, Tablero tablero){
		this.modo.moverse(this, coordenada, tablero,this.agilidad);
	}
	
	public void cambiarModo(){
		this.modo.cambiar(this);
	}
	
	public void establecerModo(Modo modoNuevo){
		this.modo = modoNuevo;
	}
	
	public Modo verModo(){
		return this.modo;
	}
	
	public int verVida(){
		return this.vida.verVida();
	}

	@Override
	public void colisionar() {
		//throw new NoColisionableException();
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	public void reaccionarASuperficie(SuperficieTierra superficieTierra){
		this.modo.reaccionarASuperficie(superficieTierra, this);
	}
	public void reaccionarASuperficie(SuperficieAire superficieAire){
		this.modo.reaccionarASuperficie(superficieAire, this);
	}
	public int simularEfecto(SuperficieAire superficieAire){
		return this.modo.simularEfecto(superficieAire, this);
	}
	public int simularEfecto(SuperficieTierra superficieTierra){
		return this.modo.simularEfecto(superficieTierra, this);
	}
//	public void serAfectado(SuperficieAire superficieAire){
//	}
//	public void serDesafectado(SuperficieTierra superficieTierra){
//		
//	}
//	public void serAfectado(SuperficieTierra superficieTierra){
//		
//	}
//	public void serDesafectado(SuperficieAire superficieAire){
//		
//	}
	public void serAfectado(SuperficieAire superficieAire){
	}
	public void serDesafectado(SuperficieTierra superficieTierra){	
	}
	public void terminaTurno(){
		this.agilidad = new Agilidad();
		this.potencia= new Potencia();
		this.afectadores.afectarAlgoformer(this);
		afectadores.pasarTurno();
		
		
	}
	public void multiplicarVelocidad(double factor) {
		this.agilidad.multiplicarVelocidad(factor);
		
	}
	public void multiplicarVida(double factor) {
		this.vida.multiplicarVida(factor);
	}
	public void agregarEfecto(Afectador afectador) {
		this.afectadores.agregarAfectador(afectador);
		
	}
	public void multiplicarAtaque(double factor) {
		this.potencia.multiplicarAtaque(factor);
		
	}
	public void reposicionarse(Tablero tablero) {
		this.modo.reposicionarse(tablero,this);
	}
	public int simularPasoDe(SuperficiePantano superficiePantano) {
		return this.modo.simularPasoDe(superficiePantano);
	}

}
