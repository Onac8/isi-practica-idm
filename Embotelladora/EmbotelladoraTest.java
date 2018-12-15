//
// Instrucciones de compilación:
// javac -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar MinTest.java
//

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

public class EmbotelladoraTest
{

	private Embotelladora embotelladora;

	@Before      // Set up - Called before every test method.
	public void setUp()
	{
		embotelladora = new Embotelladora();
	}

	//Test con botellas pequenas negativas
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class) // Este test decora la anotación @Test con la clase de la excepción esperada.
	public void testForNegativePequenas()
	{
		embotelladora.calculaBotellasPequenas(-10,10,10);
	}

	//Test con botellas grandes negativas
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class)
	public void testForNegativeGrandes()
	{
		embotelladora.calculaBotellasPequenas(10,-10,10);
	}

	//Test con litros totales < 0
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class)
	public void testForNegativeTotal()
	{
		embotelladora.calculaBotellasPequenas(10,10,-10);
	}

	//Test con pequenas=grandes=0
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class)
	public void testForZeroBotellas()
	{
		embotelladora.calculaBotellasPequenas(0,0,10);
	}

	//Test con litros totales = 0
	//Caminos recorridos: (1,2)
	@Test (expected = IllegalArgumentException.class)
	public void testForZeroTotal()
	{
		embotelladora.calculaBotellasPequenas(1,2,0);
	}


	//Caminos recorridos: (1,3,5,8,10)
	@Test
	public void testForSoloPequeñas()
	{
		assertTrue("testForSoloPequeñas_Error", 5 == embotelladora.calculaBotellasPequenas(5,0,5));
	}


	//Caminos recorridos: (1,3,4,5)
	@Test
	public void testForSoloGrandes()
	{
		assertTrue("testForSoloGrandes_Error", 0 == embotelladora.calculaBotellasPequenas(0,2,10));
	}


	//Caminos recorridos: (1,3,5,9,13,14)
	@Test
	public void testForAmbasBotellas()
	{
		assertTrue("testForAmbasBotellas_Error", 4 == embotelladora.calculaBotellasPequenas(5,2,14));
	}


	//Caminos recorridos: (1,3,5,9,13,14)
	@Test
	public void testForIgualCantidad()
	{
		assertTrue("testForIgualCantidad_Error", 2 == embotelladora.calculaBotellasPequenas(2,2,12));
	}


	//Caminos recorridos: (1,3,5,9,13,14)
	@Test
	public void testForMasPequenas()
	{
		assertTrue("testForMasPequenas_Error", 2 == embotelladora.calculaBotellasPequenas(8,4,22));
	}


	//Caminos recorridos: (1,3,5,9,13,14)
	@Test
	public void testForAbastecemosJustas()
	{
		assertTrue("testForAbastecemosJustas_Error", 6 == embotelladora.calculaBotellasPequenas(6,2,16));
	}


	//Caminos recorridos: (1,3,5,9,13,15)
	@Test
	public void testForNoAbastecemos()
	{
		assertTrue("testForNoAbastecemos_Error", -1 == embotelladora.calculaBotellasPequenas(1,2,14));
	}


	//Caminos recorridos: (1,3,5,9,13,14)
	@Test
	public void testForAbastacemosSobra()
	{
		assertTrue("testForAbastacemosSobra_Error", 2 == embotelladora.calculaBotellasPequenas(10,1,7));
	}

	///////////
	// ADDED //
	//////////

	//Caminos recorridos: (1,3,4,6)
	@Test
	public void testPrueba1()
	{
		assertTrue("testPrueba1", 0 == embotelladora.calculaBotellasPequenas(0,4,20));
	}


	//Caminos recorridos: (1,3,4,7)
	@Test
	public void testPrueba2()
	{
		assertTrue("testPrueba2", -1 == embotelladora.calculaBotellasPequenas(0,4,30));
	}


	//Caminos recorridos: (1,3,5,8,11)
	@Test
	public void testPrueba3()
	{
		assertTrue("testPrueba3", -1 == embotelladora.calculaBotellasPequenas(2,0,3));
	}


	//Caminos recorridos: (1,3,5,9,12)
	@Test
	public void testPrueba4()
	{
		assertTrue("testPrueba4", 0 == embotelladora.calculaBotellasPequenas(7,3,13));
	}
}
