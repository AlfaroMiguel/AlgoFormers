package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.efectos.VolverInutil;

/* Clase que se encarga de crear un algoformer combinado de tipo autobot y uno de tipo 
 * decepticon.*/
public class CreadorDeAlgoformersCombinados {
	
	/* Metodos de la clase */
	/* Devuelve un algoformer combinado de tipo autobot.
	 * Parametros: optimus: instancia de optimus que compone al combinado.
	 * 			   bumblebee: instancia de bumblebee que compone al combinado.
	 * 			   ratchet: instancia de ratchet que compone al combinado.*/
	public static Superion crearAlgoformerCombinado(Optimus optimus,Bumblebee bumblebee,Ratchet ratchet){
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		Afectador inutilizador = new AfectadorPorTurnos(1, new VolverInutil());
		inutilizador.afectarAlgoformer(superion);
		return superion;
	}
	/* Devuelve un algoformer combinado de tipo decpticon.
	 * Parametros: megatron: instancia de megatron que compone al combinado.
	 * 			   bonecrusher: instancia de bonecrusher que compone al combinado.
	 * 			   frenzy: instancia de frenzy que compone al combinado.*/
	public static Menasor crearAlgoformerCombinado(Megatron megatron,Frenzy frenzy,Bonecrusher bonecrusher){
		Menasor menasor= new Menasor(megatron,bonecrusher,frenzy);
		Afectador inutilizador = new AfectadorPorTurnos(1, new VolverInutil());
		inutilizador.afectarAlgoformer(menasor);
		return menasor;
	}
}
