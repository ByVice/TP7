package fruit;

public class Banane extends Fruit {
	private static final int VALEUR = 20;
	private static final String TYPE = "Banane";
	
	public Banane( String pays) { 
		super(pays); 
	}
	
	public float getValeur() { 
		return VALEUR / 100.0f; 
	}
		
	@Override
	public String getType() { 
		return TYPE; 
	}
}
