package fruit;

import java.util.ArrayList;
import java.util.Iterator;

public class Panier<T> {
	@SuppressWarnings("rawtypes")
	private ArrayList<T> contenu = new ArrayList<T>();
	private int id;
	private static int nombreDePaniers = 0;
	
	public Panier() { 
		nombreDePaniers++; 
		id = nombreDePaniers; 
	}
	
	@SuppressWarnings("unchecked")
	public void add( T o) { 
		contenu.add(o); 
	}
	
	public void filtreOrigine(String pays) { 
		@SuppressWarnings("rawtypes")
		Iterator i = contenu.iterator();
		while ( i.hasNext()) {
			Fruit f = (Fruit) i.next();
			if (f.getOrigine().equals( pays)) {
				i.remove(); 
			}
		}
	}
	
	public float getValeur() { 
		float somme= 0.0f;
		for (int i = 0; i<contenu.size(); i++) {
			somme += ((Fruit)contenu.get(i)).getValeur(); 
		}
		return somme;
	}	
	
    @SuppressWarnings("unchecked")
	@Override 
    public String toString() { 
    	StringBuilder s = new StringBuilder("Panier " + id + " [\n");
    	contenu.stream().forEach(x -> s.append( x.toString()  +"\n"));
    	return s.append( "]\n").toString(); 
    }	
}
