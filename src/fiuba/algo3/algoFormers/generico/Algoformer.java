package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.modos.Modo;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.afectadores.Afectador;


public abstract class Algoformer implements Accionable {
	
	protected Modo modo;
	protected Vida vida;
	protected ListaDeAfectadores afectadores = new ListaDeAfectadores();
	protected Agilidad agilidad = new Agilidad();
	protected Potencia potencia = new Potencia();
	protected Escudo escudo = new Escudo();
	public abstract void atacar(Tablero tablero, Accionable atacado);
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
		this.modo.moverse(this, coordenada, tablero, this.agilidad);
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

	
	public int simularEfecto(SuperficieAire superficieAire){
		return this.modo.simularEfecto(superficieAire, this);
	}
	
	public int simularEfecto(SuperficieTierra superficieTierra){
		return this.modo.simularEfecto(superficieTierra, this);
	}
	
	public void reaccionarASuperficie(SuperficieAire superficieAire){
		this.modo.reaccionarASuperficie(superficieAire, this);
	}
	public void reaccionarASuperficie(SuperficieTierra superficieTierra){
		this.modo.reaccionarASuperficie(superficieTierra, this);
	}
	public void serDesafectado(SuperficieTierra superficieTierra){
		this.modo.serDesafectado(superficieTierra,this);
	}
	
	public void serDesafectado(SuperficieAire superficieAire){
		this.modo.serDesafectado(superficieAire,this);
	}
	
	public void terminaTurno(){
		this.agilidad = new Agilidad();
		this.potencia= new Potencia();
		this.escudo = new Escudo();
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
	
	public ListaDeAfectadores obtenerAfectadoresEnAtacable() {
		return this.afectadores;
	}
	
	public int verAtaque(){
		return (int)((this.modo.verAtaque()*this.potencia.getPotencia()));
	}
	
	@Override
	public void recolectar(Collectable colectable){
		colectable.producirEfecto(this);
	}
	
	public void colocarEscudo() {
		this.escudo.colocarEscudo();
	}
	public void sacarEscudo() {
		this.escudo.sacarEscudo();
	}
	
}
