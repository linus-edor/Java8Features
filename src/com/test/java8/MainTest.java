/**
 * 
 */
package com.test.java8;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testStreamsLimit() {
		assertArrayEquals(new int[]{1,2}, new Main().streamsLimit(2));
		assertArrayEquals(new int[]{1,2,3,4}, new Main().streamsLimit(4));
	}	
	
	@Test
	public void testAddresses() {
		assertEquals(
				"doe_john@example.com; parker_peter@example.com; watsonparker_mary@example.com; doe_john2@example.com; doe_john3@example.com; doe_jane@example.com; parker_peter2@example.com",
				new Main().addresses(
						"John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker",
						"example"));
	}
	
	@Test
	public void testSquareDigits(){
		assertEquals(4104, new Main().squareDigits(2102));
		assertNotEquals(4204, new Main().squareDigits(2102));
		assertEquals(2549814, new Main().squareDigits(5792));
	}

}
