package fiuba.algo3.algoformers.Tablero;
import java.util.*;

import fiuba.algo3.algoformers.Habitables.Vacio;
import fiuba.algo3.algoformers.autobots.Optimus;
import fiuba.algo3.algoformers.Habitables.ChispaSuprema;
import fiuba.algo3.algoformers.Habitables.Collectable;
import fiuba.algo3.algoformers.Habitables.HabitableDelMapa;


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
		if(this.habitables.get(coordenada).ocupaLugar()){
			this.habitables.put(coordenada, collectable);
			return;
		}
		throw new MovimientoInvalidoException();

	}
	public void move(HabitableDelMapa habitable, Coordenada coordenadaFinal, int paso) {
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
	public HabitableDelMapa coordinateAttack(HabitableDelMapa attacker, int range, Coordenada coordenadaDestino) {
		Coordenada coordInic = this.getKeyValue(attacker);
		if(coordInic.distancia(coordenadaDestino)>range)
			throw new OutOfRangeException();
		return this.habitables.get(coordenadaDestino);
	}

}
