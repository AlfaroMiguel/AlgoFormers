package fiuba.algo3.algoFormers.generico;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.excepciones.NoColisionableException;
import fiuba.algo3.algoFormers.habitables.Accionable;
import fiuba.algo3.algoFormers.habitables.ChispaSuprema;
import fiuba.algo3.algoFormers.habitables.Recolectable;
import fiuba.algo3.algoFormers.modos.Modo;
import fiuba.algo3.algoFormers.superficie.SuperficieAire;
import fiuba.algo3.algoFormers.superficie.SuperficieTierra;
import fiuba.algo3.algoFormers.tablero.Coordenada;
import fiuba.algo3.algoFormers.tablero.Tablero;
import fiuba.algo3.algoFormers.vista.Vista;
import javafx.scene.image.Image;

/* Clase que representa un algoformer generico */
public abstract class Algoformer implements Accionable{
	
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
	/* Lista de observadores para el patron observer */
	private List<Observador> observadores = new ArrayList<Observador>(); 
	private boolean estaMuerto = false; 
	public Coordenada posicion;
	/* Metodos abstractos */
	/* Ataca a otro accionable. 
	 * Parametros: atacado: accionable a atacar.*/
	public abstract void atacar(Tablero tablero, Accionable atacado);
	
	/*
	VISTAS
	*/
	public static List<Vista> vistas = new ArrayList<Vista>();
	/* Metodos de la clase. */
	/* Convierte su velocidad en 0 para no poder moverse.*/
	public void inmovilizar(){
		this.agilidad.multiplicarVelocidad(0);	
	}
	
	public void setCoordenada(Coordenada posicion){
		this.posicion = posicion;
		this.actualizarVista();
	}
	public Coordenada getCoordenada(){
		return this.posicion;
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
	public int simularPasoPor(SuperficieTierra superficieTierra){
		return this.modo.simularPasoDe(superficieTierra);
	}
	public int simularPasoPor(SuperficieAire superficieAire){
		return this.modo.simularPasoDe(superficieAire);
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
	
	
	public ListaDeAfectadores obtenerAfectadoresEnAtacable() {
		return this.afectadores;
	}
	
	public int verAtaque(){
		return (int)((this.modo.verAtaque()*this.potencia.getPotencia()));
	}
	public int verPaso(){
		return (int)((this.modo.verPaso()*this.agilidad.getAgilidad()));
	}
	public int verRango(){
		return (int)((this.modo.verRangoAtaque()));
	}
	
	public void colocarEscudo() {
		this.escudo.colocarEscudo();
	}
	
	public void sacarEscudo() {
		this.escudo.sacarEscudo();
	}
	
	
	public boolean estaMuerto(){
		return estaMuerto;
	}
	
	public void actualizarEstadoDeVida(){
		if (this.vida.seTermino()){
			estaMuerto = true;
			this.notificarObservadores();
		}
	}
	
	/* Metodos abstractos redefinidos. */
	@Override
	public void colisionar() {
		throw new NoColisionableException();
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
	

	@Override
	public void agregarObservador(Observador observador) {
		if (!this.observadores.contains(observador)){
			this.observadores.add(observador);
		}
	}

	@Override
	public void eliminarObservador(Observador observador) {
		this.observadores.remove(observador);
	}

	@Override
	public void notificarObservadores() {
		for (Observador observador: observadores){
			observador.actualizar();
		}
	}

	public void capturarChispa(ChispaSuprema chispaSuprema) {
		chispaSuprema.serCapturada();
	}

	public int simularPasoDe(SuperficieAire superficieAire) {
		return this.modo.simularPasoDe(superficieAire);
	}
	public int simularPasoDe(SuperficieTierra superficieTierra) {
		return this.modo.simularPasoDe(superficieTierra);
	}
	@Override
	public void efectoPorMicroMovimiento(SuperficieAire superficie) {
		this.modo.producirEfectoPorMicroMovimiento(superficie,this);
		
	}

	@Override
	public void efectoPorMicroMovimiento(SuperficieTierra superficie) {
		this.modo.producirEfectoPorMicroMovimiento(superficie,this);
		
	}

	public Image getImage() {
		return this.modo.getImage();
	}
	public void agregarVista(Vista vista){
		this.vistas.add(vista);
	}
	public void actualizarVista(){
		for(Vista vista: vistas){
			System.out.println("ActualizoVistas");
			vista.update(this, this.posicion);
		}
	}
	public void actualizarVista(int ataque){
		for(Vista vista: vistas){
			vista.update(this, this.posicion, ataque);
		}
	}
}
