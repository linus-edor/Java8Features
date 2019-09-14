package com.java8.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java8.lambdas.Animal;
import com.java8.lambdas.Lambdas;

public class LambdasTest {

	static Lambdas lambdas;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lambdas = new Lambdas();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("Hello Linus", lambdas.helloWorld());

		lambdas.initializeLambdas();
		try {
			assertEquals(lambdas.animals[0].call(), "Lion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Animal[] animalArr = {
				new Animal("Lion"),
				new Animal("Crocodile"),
				new Animal("Tiger"),
				new Animal("Elephant")};
		lambdas.sortAnimalListByName(animalArr);
		assertEquals(animalArr[0].getName(), "Crocodile");
		assertEquals(animalArr[3].getName(), "Tiger");
		
		Animal[] animalArr1 = {
				new Animal("Lion", "mammalia"),
				new Animal("Fowl", "Ave"),
				new Animal("Bird", "Ave"),
				new Animal("Tiger", "mammalia"),
				new Animal("Elephant", "mammalia")};
		assertEquals("Lion,Tiger,Elephant", lambdas.getAllMamals(animalArr1).stream().map(el -> {
			return el.getName();
		}).collect(Collectors.joining(",")));
		
	}
	
}
