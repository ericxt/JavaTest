package moreAboutJava;

class Basket<T> {
	private T element;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}

class Fruit {

}

class Apple extends Fruit {

}

class Orange extends Fruit {

}

public class GenericProblemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basket<Fruit> basket = new Basket<Fruit>();
		basket.setElement(new Apple());
		Fruit element = basket.getElement();
		// run time exception : apple can not be cast to orange
//		Orange element = (Orange)basket.getElement();
		System.out.println(element.getClass());

	}

}
