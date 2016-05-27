package pruebasdiseño.strat;

public class ShoppingCart {
	
	public void pay(PaymentMode paymentMode){
		int amount = 10;
		paymentMode.pay(amount);
	}
}
