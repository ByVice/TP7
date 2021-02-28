package fruit;

public abstract class Fruit {
	private String origine;
	
	public Fruit( String pays) { 
		origine = pays;
	}
	
	public String getOrigine() {
		return origine; 
	}
	
	public abstract float getValeur();
	
	public abstract String getType();
	
	@Override
	public boolean equals( Object o) { 
		if (o == this) {
			return true;
		}
		if  (! (o instanceof Fruit))  {
			return false;
		}
		return ((Fruit)o).getOrigine().equals(getOrigine())
				&& ( Float.compare( ((Fruit)o).getValeur(),getValeur()) == 0 );
	}
	
	@Override
	public int hashCode() {
		return origine.hashCode();
	}	

	@Override
	public String toString() { 
		return getType() +" "+ getOrigine()+ " " + getValeur() + "€"; 
	}
}
