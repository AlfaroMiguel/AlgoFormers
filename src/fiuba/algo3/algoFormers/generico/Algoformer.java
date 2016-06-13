package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.NoColisionableException;
import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.juego.EquipoAutobots;
import fiuba.algo3.algoFormers.juego.EquipoDecepticons;
import fiuba.algo3.algoFormers.modos.Modo;
import fiuba.algo3.algoFormers.superficie.*;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.afectadores.Afectador;

/* Clase que representa un algoformer generico */
public abstract class Algoformer implements Accionable {
	
	/* Atributos */
	/* Indica el modo actual del algoformer. */
	protected Modo modo;
	/* Indica la vida actual del algoformer. */
	protected Vida vida;
	/* Contiene a los afectadores activos en el algoformer. */
	protected ListaDeAfectadores afectadores = new ListaDeAfectadores();
	/* Represena la agilidad actual del algoformer. */
	protected Agilidad agilidad = new Agilidad();
	/* Representa la potencia actual del algoformer. */
	protected Potencia potencia = new Potencia();
	/* Representa el actudo presente en el algoformer. */
	protected Escudo escudo = new Escudo();
	
	/* Metodos abstractos */
	/* Ataca a otro accionable. 
	 * Parametros: atacado: accionable a atacar.*/
	public abstract void atacar(Tablero tablero, Accionable atacado);
	
	/* Metodos de la clase. */
	/* Convierte su velocidad en 0 para no poder moverse.*/
	public void inmovilizar(){
		this.agilidad.multiplicarVelocidad(0);	
	}
	/* Se mueve a una determinada coordenada.
	 * Parametros: coordenada: coordenada a la que se quiere mover.
	 * 			   tablero: tablero del juego.
	 * Lanza: MovimientoInvalidoException si el movimiento no se puede completar. */
	public void moverse(Coordenada coordenada, Tablero tablero){
		this.modo.moverse(this, coordenada, tablero, this.agilidad);
	}
	/* Cambia de modo humanoide a alterno o alterno a humanoide segun corresponda
	 * por el modo actual. */
	public void cambiarModo(){
		this.modo.cambiar(this);
	}
	/* Cambia el modo del algoformer.
	 * Parametros: modoNuevo: modo al que se quiere cambiar. */
	public void establecerModo(Modo modoNuevo){
		this.modo = modoNuevo;
	}
	/* Devuelve el modo actual del algoformer. */
	public Modo verModo(){
		return this.modo;
	}
	/* Devuelve la vida actual del algoformer.*/
	public int verVida(){
		return this.vida.verVida();
	}
	/**/
	public int simularEfecto(SuperficieAire superficie){
		return this.modo.simularEfecto(superficie, this);
	}
	/**/
	public int simularEfecto(SuperficieTierra superficie){
		return this.modo.simularEfecto(superficie, this);
	}
	/* Termina el turno. Es afectado por los efectos que junto durante el turno.*/
	public void terminaTurno(){
		this.agilidad = new Agilidad();
		this.potencia= new Potencia();
		this.escudo = new Escudo();
		this.afectadores.afectarAlgoformer(this);
		afectadores.pasarTurno();
	}
	/* Multiplica la velocidad por un factor dado.
	 * Parametros: factor: factor por el que se quiere multiplicar.*/
	public void multiplicarVelocidad(double factor) {
		this.agilidad.multiplicarVelocidad(factor);
		
	}
	/* Multiplica la vida por un factor dado.
	 * Parametros: factor: factor por el que se quiere multiplicar.*/
	public void multiplicarVida(double factor) {
		this.vida.multiplicarVida(factor);
	}
	/* Acumula un efecto.
	 * Parametros: afectador: afectador que tiene el efecto a acumular. */
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
	
	public void colocarEscudo() {
		this.escudo.colocarEscudo();
	}
	
	public void sacarEscudo() {
		this.escudo.sacarEscudo();
	}
	
	public void ponerAccionable(Coordenada coordenada) {
		this.modo.ponerAccionable(coordenada);
	}
	
	/* Metodos abstractos redefinidos. */
	@Override
	public void colisionar() {
		//throw new NoColisionableException();
	}

	@Override
	public boolean ocupaLugar() {
		return true;
	}
	
	@Override
	public void recolectar(Recolectable colectable){
		colectable.producirEfecto(this);
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieAire superficie){
		this.modo.reaccionarASuperficie(superficie, this);
	}
	
	@Override
	public void reaccionarASuperficie(SuperficieTierra superficie){
		this.modo.reaccionarASuperficie(superficie, this);
	}
	
	@Override
	public void serDesafectado(SuperficieTierra superficie){
		this.modo.serDesafectado(superficie,this);
	}
	
	@Override
	public void serDesafectado(SuperficieAire superficie){
		this.modo.serDesafectado(superficie,this);
	}
}
