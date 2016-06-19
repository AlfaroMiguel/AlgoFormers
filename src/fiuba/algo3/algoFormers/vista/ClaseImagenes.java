package fiuba.algo3.algoFormers.vista;

import fiuba.algo3.algoFormers.habitables.*;
import fiuba.algo3.algoFormers.modos.*;
import fiuba.algo3.algoFormers.superficie.*;
import javafx.scene.image.Image;

public class ClaseImagenes {
	
	public static Image getImage(SuperficieAire superficieAire){
		return superficieAire.ponerSuperficieAire();
	}
	
	public static Image getImage(SuperficieTierra superficieTierra){
		return superficieTierra.ponerSuperficieTierra();
	} 
	
	public static Image getImageSuperficie(SuperficieAndromeda superficie){
		return ponerAire("file:img/superficies/nebulosa.png");
	}
	public static Image getImageSuperficie(SuperficiePantano superficie){
		return ponerAire("file:img/superficies/pantano.png");
	}
	public static Image getImageSuperficie(SuperficieRocosa superficie){
		return ponerAire("file:img/superficies/roca.png");
	}
	public static Image getImageSuperficie(SuperficiePsionica superficie){
		return ponerAire("file:img/superficies/tormenta.png");
	}
	public static Image getImageSuperficie(SuperficieEspinas superficie){
		return ponerAire("file:img/superficies/espinasNuevo.png");
	}
	
	public static Image getImageSuperficie(SuperficieMonte superficieMonte) {
		return ponerAire("file:img/superficies/montania.png");
	}
	
	public static Image getImageSuperficie(SuperficieNubes superficie){
//		return ponerAire();
		return null;
	}
	
	private static Image ponerAire(String path) {
		return new Image(path,60,60,true,true,false);
	}
	
	private static Image ponerTiera(String path) {
		return new Image(path);
	}
	
//	
//					TERMINA IMAGENES SUPERFIECIES
//	
//					EMPIEZA IMAGENES ALGOFORMERS
//	
	
	public static Image getImage(Accionable accionable){
		return accionable.getImage();
	}
	public static Image getImageModo(FrenzyHumanoide frenzyHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/humanoide/frenzy.png");
	}
	public static Image getImageModo(FrenzyAlterno frenzyHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/alterno/frenzy.png");
	}
	public static Image getImageModo(OptimusHumanoide frenzyHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/humanoide/optimus.png");
	}
	public static Image getImageModo(OptimusAlterno frenzyHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/alterno/optimus.png");
	}
	public static Image getImageModo(BumblebeeHumanoide frenzyHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/humanoide/bumblebee.png");
	}
	
	public static Image getImageModo(RatchetAlterno ratchetAlterno) {
		return ponerAlgoFormer("file:img/algoformers/alterno/ratchet.png");
	}
	public static Image getImageModo(MenasorTerrestre menasorTerrestre) {
		return ponerCombinado("file:img/algoformers/menasor.png");
	}
	public static Image getImageModo(RatchetHumanoide ratchetHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/humanoide/ratchet.png");
	}
	public static Image getImageModo(SuperionTerrestre superionTerrestre) {
		return ponerCombinado("file:img/algoformers/superion.png");
	}
	public static Image getImageModo(MegatronHumanoide megatronHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/humanoide/megatron.png");
	}
	public static Image getImageModo(BonecrusherHumanoide bonecrusherHumanoide) {
		return ponerAlgoFormer("file:img/algoformers/humanoide/bonecrusher.png");
	}
	public static Image getImageModo(BonecrusherAlterno bonecrusherAlterno) {
		return ponerAlgoFormer("file:img/algoformers/alterno/bonecrusher.png");
	}
	public static Image getImageModo(BumblebeeAlterno bumblebeeAlterno) {
		return ponerAlgoFormer("file:img/algoformers/alterno/bumblebee.png");
	}
	public static Image getImageModo(MegatronAlterno megatronAlterno) {
		return ponerAlgoFormer("file:img/algoformers/alterno/megatron.png");
	}
	private static Image ponerAlgoFormer(String path) {
	return new Image(path,90,120,true,true,false);
	}
	private static Image ponerCombinado(String path) {
	return new Image(path,80,100,true,true,false);
	}

//	
//					TERMINA IMAGENES ALGOFORMERS
//	
//					EMPIEZA IMAGENES RECOLECTABLES
//		
	
	public static Image getImage(Recolectable recolectable) {
		return recolectable.getImage();
	}
	public static Image getImageRecolectable(DobleCanion dobleCanion) {
		return ponerRecolectable("file:img/recolectable/canion.png");
	}
	public static Image getImageRecolectable(BurbujaInmaculada burbujaInmaculada) {
		return ponerRecolectable("file:img/recolectable/burbuja.png");
	}
	public static Image getImageRecolectable(ChispaSuprema chispaSuprema) {
		return ponerRecolectable("file:img/recolectable/chispa.png");
	}
	public static Image getImageRecolectable(Flash flash) {
		return ponerRecolectable("file:img/recolectable/flash.png");
	}
	private static Image ponerRecolectable(String path) {
		return new Image(path,40,40,true,true,false);
	}

}
