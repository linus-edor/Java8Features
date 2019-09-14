package com.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambdas {


	public static void main(String args[]) {

		// An array of animals
		Animal[] animalArr = { new Animal("Lion"), new Animal("Crocodile"), new Animal("Tiger"),
				new Animal("Elephant") };

		System.out.println("Before Sort: " + Arrays.stream(animalArr).map(animal -> {
			return animal.getName();
		}).collect(Collectors.joining(",")));

		// Sort the list of animals by name
		animalArr = sortAnimalListByName(animalArr);

		// Print the sorted list
		System.out.println("After Sort: " + Arrays.stream(animalArr).map(animal -> {
			return animal.getName();
		}).collect(Collectors.joining(",")));
		
		
		//Lambdas with predicates 
		Animal[] animalArr1 = {
				new Animal("Lion", "mammalia"),
				new Animal("Fowl", "Ave"),
				new Animal("Bird", "Ave"),
				new Animal("Tiger", "mammalia"),
				new Animal("Elephant", "mammalia")};
		List<Animal> mammals = getAllMamals(animalArr1);
		
		mammals.stream().map(el -> {
			return el.getName() + "->" + el.getAnimalClass();
		}).forEach(el -> {
			System.out.println(el);
		});

	}

	public String helloWorld() {
		HelloWorld helloWorld = (String name) -> {
			return "Hello " + name;
		}; // lambda expression implementing the HelloWorld interface.
		return helloWorld.hello("Linus");
	}

	//Use the Callable interface to initialize a lambda expression
	public Callable[] animals;
	public void initializeLambdas() {
		animals = new Callable[] { () -> {
			String name = "Lion";
			return name;
		}, () -> "Crocodile" };
	};

	// sort the list of animals by name
	public static Animal[] sortAnimalListByName(Animal[] animals) {

		// Pass Comparator as a lambda expression
		Arrays.sort(animals, (Animal o1, Animal o2) -> {
			return o1.getName().compareTo(o2.getName());
		});

		return animals;
	}
	
	// use predicate as a lambda expression
	public static List<Animal> getAllMamals(Animal[] animals) {
		return (List<Animal>) Stream.of(animals).filter(new Predicate<Animal>() {

			@Override
			public boolean test(Animal a) {
				return a.getAnimalClass().equalsIgnoreCase("mammalia");
			}

		}).collect(Collectors.toList());
	}
	
	// Lambda predicate example; this function method could replace the predicate in getAllMammals
	private Predicate<Animal> isMamal() {
		return p -> p.getAnimalClass().equalsIgnoreCase("mammalia");
	}

}
