//
// Instrucciones de compilación:
// javac -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar MinTest.java
//

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

public class DescuentoBlackFridayTest
{

	private DescuentoBlackFriday price;

	@Before      // Set up - Called before every test method.
	public void setUp()
	{
		price = new DescuentoBlackFriday();
	}

	//Test con precio original negativo
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class) // Este test decora la anotación @Test con la clase de la excepción esperada.
	public void testForNegativePrice()
	{
		price.PrecioFinal(-1.0);
	}

	//Test con precio original cero
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class)
	public void testForZeroPrice()
	{
		price.PrecioFinal(0.0);
	}

	// Test con precio original válido y día válido
	// Caminos recorridos: (1,3,4)
	@Test
	public void testForValidPrice()
	{
		price.day = 23;
		price.month = 11;
		assertTrue("testForValidPrice_Error", 70.0 == price.PrecioFinal(100.0)); // Se imprimirá este msg si test falla
	}

	// Test con precio original válido y día no Black Friday
	// Caminos recorridos: (1,3,5)
	@Test
	public void testForValidPriceDesc()
	{
		price.day = 24;
		price.month = 11;
		assertTrue("testForValidPrice_Error", 100.0 == price.PrecioFinal(100.0)); // Se imprimirá este msg si test falla
	}

}
