package fiuba.algo3.algoformers.Tablero;
import java.util.*;

import fiuba.algo3.algoformers.Habitables.Vacio;
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
		try{
		this.habitables.get(coordenada).ocupaLugar();
		return true;
		}catch(Throwable g){
			return false;
		}
	}
	public void put(HabitableDelMapa habitable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).colisionar();
			//habitable.recibir(this.habitables.get(coordenada));
			this.habitables.put(coordenada,habitable);
		}
		catch(Throwable g){
		}
	}
	public void put(Collectable collectable,Coordenada coordenada){
		try{
			this.habitables.get(coordenada).ocupaLugar();
			this.habitables.put(coordenada, collectable);

	}catch(Throwable g){

		}

	}
	public void move(HabitableDelMapa habitable, Coordenada coordenadaFinal, int paso) {
		Coordenada coordInic = this.getKeyValue(habitable);
		if(coordInic.distancia(coordenadaFinal)>paso)
			throw new MovimientoInvalidoException();
		this.put(new Vacio(),coordInic);
		this.put(habitable,coordenadaFinal);

	}

	public Coordenada getKeyValue(HabitableDelMapa value){
        for(Map.Entry<Coordenada, HabitableDelMapa> entry : this.habitables.entrySet()) {
            if(value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        throw new ElementoNoExisteException();

	}

}
