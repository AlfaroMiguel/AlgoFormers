package fiuba.algo3.algoFormers.decepticons;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.autobots.Autobot;
import fiuba.algo3.algoFormers.generico.Vida;
import fiuba.algo3.algoFormers.modos.MenasorTerrestre;
import fiuba.algo3.algoFormers.vista.RepresentacionDeAlgoformer;

/*Clase que representa al algoformer decepticon combinado Megatron*/
public class Menasor extends Decepticon {
	
	public static List<RepresentacionDeAlgoformer> representadoresCombinado = new ArrayList<RepresentacionDeAlgoformer>();
	
	
	/*Atributos*/
	/*Cada uno de los decepticons individuales que contiene*/
	private Megatron megatron;
	private Bonecrusher bonecrusher;
	private Frenzy frenzy;
	
	/*Constructor*/
	/* Parametros: los decepticons con los que se va a componer.
	 * Crea un superion en modo unico con la suma de las vidas de los algoformers
	 * que lo componen en el momento de la composicion*/
	public Menasor(Megatron megatron, Bonecrusher bonecrusher, Frenzy frenzy){
		this.nombre = "Menasor";
		this.megatron = megatron;
		this.bonecrusher = bonecrusher;
		this.frenzy = frenzy;
		this.vida = new Vida(megatron.verVida() + bonecrusher.verVida() + frenzy.verVida());
		this.modo = MenasorTerrestre.getInstance();
	}
	
	/*Metodos de la clase*/
	/*Devuelve el megatron que contiene*/
	public Megatron getMegatron() {
		return this.megatron;
	}
	
	/*Devuelve el bonecrusher que contiene*/
	public Bonecrusher getBonecrusher(){
		return this.bonecrusher;
	}
	
	/*Devuelve el frenzy que contiene*/
	public Frenzy getFrenzy(){
		return this.frenzy;
	}
	
	@Override
	public void agregarRepresentacionDeAlgoformer(RepresentacionDeAlgoformer representador){
		representadoresCombinado.add(representador);
	}
	@Override
	public void notificarRepresentaciones(){
		for(RepresentacionDeAlgoformer representador: representadoresCombinado)
			representador.actualizar();
	}
	@Override
	public void sacadoDelMapa(){
		for(RepresentacionDeAlgoformer representador: representadoresCombinado){
			if (representador.estaHabilitado())
				representador.deshabilitar();
		}
	}
	@Override
	public void puestoEnMapa(){
		for(RepresentacionDeAlgoformer representador: representadoresCombinado){
			if (!representador.estaHabilitado())
				representador.habilitar();
		}
	}
	
}	
	
