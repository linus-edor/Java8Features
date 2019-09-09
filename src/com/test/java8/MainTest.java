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

	static Main main;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		main = new Main();
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
		assertArrayEquals(new int[] { 1, 2 }, main.streamsLimit(2));
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, main.streamsLimit(4));
	}

	@Test
	public final void testStreamFilter() {
		assertArrayEquals(new Integer[] { 5, 4, 6, 8, 6, 10 }, main.streamFilter());
	}

	@Test
	public final void testStreamFlatMap() {
		assertArrayEquals(new String[] { "One", "flew", "over", "the", "cuckoo's", "nest", "To", "kill", "a",
				"muckingbird", "Gone", "with", "the", "wind" }, main.streamFlatMap());
	}

	@Test
	public final void testStreamMap() {
		assertArrayEquals(new Integer[] { 1, 9, 25, 9, 16 }, main.streamMap());
	}

	@Test
	public void testAddresses() {
		assertEquals(
				"doe_john@example.com; parker_peter@example.com; watsonparker_mary@example.com; doe_john2@example.com; doe_john3@example.com; doe_jane@example.com; parker_peter2@example.com",
				main.addresses(
						"John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker",
						"example"));
	}

	@Test
	public void testAddressesJ8() {
		assertEquals(
				"doe_john@example.com; parker_peter@example.com; watsonparker_mary@example.com; doe_john2@example.com; doe_john3@example.com; doe_jane@example.com; parker_peter2@example.com",
				main.addressesJ8(
						"John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker",
						"example"));
	}

	@Test
	public void testSquareDigits() {
		assertEquals(4104, main.squareDigits(2102));
		assertNotEquals(4204, main.squareDigits(2102));
		assertEquals(2549814, main.squareDigits(5792));
	}

}
