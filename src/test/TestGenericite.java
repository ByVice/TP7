package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TestGenericite {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	void test1() {
		ArrayList l1 = new ArrayList();
		l1.add( Integer.valueOf(1));
		l1.add( new Float(2.5));
		l1.add( "bonjour");
		assertEquals( 1, l1.get(0));
		assertEquals( 2.5f, l1.get(1));
		assertEquals( "bonjour", l1.get(2));
		float somme = 0.0f;
		for ( int i = 0; i < l1.size(); i++ ) 
			if ( l1.get(i) instanceof Number )
			 	somme += ((Number)l1.get(i)).floatValue();
		assertEquals(3.5f, somme);
		assertEquals(3.5f, 
				l1.stream().filter( x -> x instanceof Number).reduce(0f, 
						(x,y) -> ((Number)x).floatValue() + ((Number)y).floatValue() ));
	}
	
	@Test 
	void test2() {
		ArrayList<Number> l2 = new ArrayList<>();
		l2.add( Integer.valueOf(1));
		l2.add( new Float(2.5));
		float somme = 0.0f;
		for ( int i = 0; i < l2.size(); i++ ) 
			somme += l2.get(i).floatValue();
		assertEquals(3.5f, somme);
		assertEquals(3.5f, l2.stream().reduce(0f, 
				(x,y) -> x.floatValue() + y.floatValue() ));
	}
}