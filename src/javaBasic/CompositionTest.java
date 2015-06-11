package javaBasic;

class Insects {
	private int size;
	private String color;
	
	public Insects(int size, String color) {
		this.size = size;
		this.color = color;
	}

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

}

interface Attack {
	public void move();
	public void attack();
}

class AttackImpl implements Attack {
	private String move;
	private String attack;
	
	public AttackImpl(String move, String attack) {
		// TODO Auto-generated constructor stub
		this.move = move;
		this.attack = attack;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(move);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		move();
		System.out.println(attack);
	}
	
}

class Bees extends Insects implements Attack {
	private Attack attack;

	public Bees(int size, String color, Attack attack) {
		super(size, color);
		this.attack  = attack;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		attack.move();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		attack.attack();
	}
	
}

public class CompositionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bees bee1 = new Bees(10, "red", new AttackImpl("fly", "sting"));
		bee1.attack();
		
		Bees bee2 = new Bees(20, "balck", new AttackImpl("fly", "move"));
		bee2.attack();

	}

}
