//
// Instrucciones de compilación:
// javac -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar MinTest.java
//

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

public class RomanNumeralTest
{

	private RomanNumeral number;

	@Before      // Set up - Called before every test method.
	public void setUp()
	{
		number = new RomanNumeral();
	}

	// Test para String nulo
	// Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class)
	public void testForNullString()
	{
		number.convierte("");
	}

	// Test para String ilegal
	// Caminos recorridos: (1,3,4,5,14)
	@Test (expected = IllegalArgumentException.class)
	public void testForNoRoman()
	{
		number.convierte("HJK");
	}

	// Test para String ilegal (pero parecido a romano)
	// @Test (expected = IllegalArgumentException.class)
	// public void testForIllegalRoman()
	// {
	// 	number.convierte("XIIII");
	// }

	// Test para String romano
	// Caminos recorridos: (1,3,4,5,11,4,5,12,4,5,13,4,5,13,4,6)
	@Test
	public void testForRoman()
	{
		assertTrue("Ese numero no es romano", 17 == number.convierte("XVII")); // Se imprimirá este msg si test falla
	}


	// Caminos recorridos: (1,3,4,5,7,4,5,7,4,6)
	@Test
	public void testPrueba1()
	{
		assertTrue("Ese numero no es romano", 2000 == number.convierte("MM")); // Se imprimirá este msg si test falla
	}


	// Caminos recorridos: (1,3,4,5,7,4,5,14)
	@Test (expected = IllegalArgumentException.class)
	public void testPrueba2()
	{
		number.convierte("HM");
	}

}
