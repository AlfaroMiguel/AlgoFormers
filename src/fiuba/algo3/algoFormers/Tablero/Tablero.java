package fiuba.algo3.algoFormers.Tablero;
import java.util.*;

import fiuba.algo3.algoFormers.Habitables.Vacio;
import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.decepticons.Decepticon;
import fiuba.algo3.algoFormers.excepciones.ElementoNoExisteException;
import fiuba.algo3.algoFormers.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.excepciones.OutOfRangeException;
import fiuba.algo3.algoFormers.Habitables.Collectable;
import fiuba.algo3.algoFormers.Habitables.HabitableDelMapa;


public class Tablero {
	HashMap<Coordenada,Casillero> superficies = new HashMap<Coordenada,Casillero>();
	HashMap<Coordenada,HabitableDelMapa> habitables = new HashMap<Coordenada,HabitableDelMapa>();
	
	public Tablero(int height,int width){
		GeneradorDeCoordenadas.generarCasillerosDelTablero(this.superficies,height,width);
		GeneradorDeCoordenadas.generarCoordenadasDelTablero(this.habitables,height,width);
	}
	public boolean estaVacio(Coordenada coordenada) {
		return !(this.habitables.get(coordenada).ocupaLugar());

	}
	public void put(HabitableDelMapa habitable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).colisionar();
			//habitable.recibir(this.habitables.get(coordenada));
			this.habitables.put(coordenada,habitable);
		}
		catch(Throwable g){
			throw new MovimientoInvalidoException();
		}
	}
	public void put(Collectable collectable,Coordenada coordenada){
		if(!this.habitables.get(coordenada).ocupaLugar()){
			this.habitables.put(coordenada, collectable);
			return;
		}
		throw new MovimientoInvalidoException();

	}
	public void mover(HabitableDelMapa habitable, Coordenada coordenadaFinal, int paso) {
		Coordenada coordInic = this.getKeyValue(habitable);
		if(coordInic.distancia(coordenadaFinal)>paso)
			throw new MovimientoInvalidoException();
		this.put(habitable,coordenadaFinal);
		this.habitables.put(coordInic,new Vacio());
	}

	public Coordenada getKeyValue(HabitableDelMapa value){
        for(Map.Entry<Coordenada, HabitableDelMapa> entry : this.habitables.entrySet()) {
            if(value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}
	
	public void coordinateAttack(Autobot atacante, int range, HabitableDelMapa atacado, int ataque) {
		Coordenada coordInic = this.getKeyValue(atacante);
		Coordenada coordFinal = this.getKeyValue(atacado);
		if(coordInic.distancia(coordFinal)>range)
			throw new OutOfRangeException();
		atacado.serAtacado(atacante, ataque);
	}
	
	public void coordinateAttack(Decepticon atacante, int range, HabitableDelMapa atacado, int ataque) {
		Coordenada coordInic = this.getKeyValue(atacante);
		Coordenada coordFinal = this.getKeyValue(atacado);
		if(coordInic.distancia(coordFinal)>range)
			throw new OutOfRangeException();
		atacado.serAtacado(atacante, ataque);
	}
	
	public HabitableDelMapa ver(Coordenada coordenada){
		return habitables.get(coordenada);
	}

}
