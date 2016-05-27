package pruebasdiseño.strat;

public class PayPalMode implements PaymentMode {
	
	public PayPalMode(){
		
	}
	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with paypal");
	}

}
