package javaBasic;

class Insect {
	private int size;
	private String color;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void move() {
		System.out.println("Move");
	}
	
	public void attack() {
		move();
		System.out.println("Attack");
	}

}

class Bee extends  Insect {
	public void move() {
		System.out.println("Fly");
	}
	
	public void attack() {
		move();
		super.attack();
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Insect ins = new Bee();
		ins.attack();

	}

}
