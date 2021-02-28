package fruit;

public class Orange extends Fruit {
	private int valeur;
	private int pepins = 0;
	private final String TYPE = "Orange";
	
	public Orange( String pays, int cout) { 
		super(pays);  
		valeur=cout; 
	}
	
	public Orange( String pays, int cout, int n) throws MauvaiseQualiteOrangeException { 
		super( pays); 
		valeur=cout; 
		pepins=n;
		if ( Float.compare( getValeur()*200, (float)valeur) < 0 ) {
			throw new MauvaiseQualiteOrangeException();
		}
	}
	
	public float getValeur() { 
		return (valeur - pepins *5 ) / 100.0f; 
	}
	
	@Override
	public String getType() { 
		return "gf"; 
	}
}
