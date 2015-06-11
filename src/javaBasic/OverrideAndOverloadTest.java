package javaBasic;

class Animal {
	public void bark() {
		System.out.println("animal bark");
	}
}

class LandAnimal extends Animal {
	public void bark() {
		System.out.println("land animal bark");
	}
}

public class OverrideAndOverloadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// dynamic polymorphism
		Animal a = new LandAnimal();
		
		a.bark();

	}

}
