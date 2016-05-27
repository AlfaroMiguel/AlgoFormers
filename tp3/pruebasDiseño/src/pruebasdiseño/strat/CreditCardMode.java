package pruebasdiseño.strat;

public class CreditCardMode implements PaymentMode {
	
	public CreditCardMode(){
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit/debit card");	
	}
	
}
