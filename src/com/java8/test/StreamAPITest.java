/**
 * 
 */
package com.java8.test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java8.streams.StreamAPI;

public class StreamAPITest {

	static StreamAPI main;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		main = new StreamAPI();
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
	public final void testStreamAnyMatch() {
		assertTrue(main.streamAnyMatch("One"));
		assertTrue(main.streamAnyMatch("kill"));
		assertTrue(main.streamAnyMatch("a"));
		assertFalse(main.streamAnyMatch("Than"));
		assertTrue(main.streamAnyMatch("To kill a muckingbird"));
	}

	@Test
	public final void testStreamAllMatch() {
		assertFalse(main.streamAllMatch("One"));
		assertFalse(main.streamAllMatch("kill"));
		assertFalse(main.streamAllMatch("a"));
	}

	@Test
	public final void testStreamNoneMatch() {
		assertFalse(main.streamNoneMatch("One"));
		assertFalse(main.streamNoneMatch("kill"));
		assertFalse(main.streamNoneMatch("a"));
		assertTrue(main.streamNoneMatch("More"));
	}

	@Test
	public final void testStreamCount() {
		assertEquals(14, main.streamCount());
	}

	@Test
	public final void testStreamFindAny() {
		assertNotNull(main.streamFindAny(true));
	}

	// @Test(expected=NullPointerException.class)
	@Test(expected = NoSuchElementException.class)
	public final void testStreamFindAnyWithNSE() {
		main.streamFindAny(false);
	}

	@Test
	public final void testStreamFindFirst() {
		assertNotNull(main.streamFindFirst(true));
	}

	@Test(expected = NullPointerException.class)
	// @Test(expected = NoSuchElementException.class)
	public final void testStreamFindFirstWithNSE() {
		main.streamFindFirst(false);
	}

	@Test
	public final void testStreamMin() {
		// String
		assertEquals("one", main.streamMinString());
		assertNotEquals("three", main.streamMinString());

		// Integer
		assertEquals(4, main.streamMinInt());
	}

	@Test
	public final void testStreamMax() {
		// String
		assertEquals("two", main.streamMaxString());
		assertNotEquals("one", main.streamMaxString());

		// Integer
		assertEquals(89, main.streamMaxInt());
		
		//Boxed stream - int
		assertEquals(19, main.boxedStreamMax(new int[] { 1, 2, 3, 2, 4, 19 }));
	}

	@Test
	public final void testStreamReduce() {
		assertEquals("Gone with the wind + To kill a muckingbird + One flew over the cuckoo's nest",
				main.streamReduce());
	}

	@Test(timeout=5)
	public final void testStreamConcat() {
		assertEquals(
				"One flew over the cuckoo's nest + To kill a muckingbird + Gone with the wind + Lord of the Rings + Planet of the Rats + Phantom Menace",
				main.streamConcat());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
