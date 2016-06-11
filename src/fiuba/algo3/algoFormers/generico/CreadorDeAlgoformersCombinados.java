package fiuba.algo3.algoFormers.generico;

import fiuba.algo3.algoFormers.afectadores.Afectador;
import fiuba.algo3.algoFormers.afectadores.AfectadorPorTurnos;
import fiuba.algo3.algoFormers.autobots.*;
import fiuba.algo3.algoFormers.decepticons.*;
import fiuba.algo3.algoFormers.efectos.VolverInutil;

public class CreadorDeAlgoformersCombinados {
	public static Superion crearAlgoformerCombinado(Optimus optimus,Bumblebee bumblebee,Ratchet ratchet){
		Superion superion = new Superion(optimus,ratchet,bumblebee);
		Afectador inutilizador = new AfectadorPorTurnos(1, new VolverInutil());
		inutilizador.afectarAlgoformer(superion);
		return superion;
	}
	public static Menasor crearAlgoformerCombinado(Megatron megatron,Frenzy frenzy,Bonecrusher bonecrusher){
		Menasor menasor= new Menasor(megatron,bonecrusher,frenzy);
		Afectador inutilizador = new AfectadorPorTurnos(1, new VolverInutil());
		inutilizador.afectarAlgoformer(menasor);
		return menasor;
	}
}
