package com.java8.lambdas;

import java.util.Comparator;

public class Animal {

	private String name;
	private String animalClass;
	private String animalOrder;

	public Animal(String name) {
		this.name = name;
	}
	public Animal(String name, String animalClass) {
		this.name = name;
		this.animalClass = animalClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalClass() {
		return animalClass;
	}

	public void setAnimalClass(String animalClass) {
		this.animalClass = animalClass;
	}

	public String getAnimalOrder() {
		return animalOrder;
	}

	public void setAnimalOrder(String animalOrder) {
		this.animalOrder = animalOrder;
	}

//Sort by animal name 
//	static class NameComparator implements Comparator<Animal> {
//
//		@Override
//		public int compare(Animal o1, Animal o2) {
//			return o1.name.compareTo(o2.name);
//		}
//
//	}

}
