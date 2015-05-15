package javaBasic;

public class EnumTest {
	public enum Color {
		// default value : 0
		RED(1), GREEN(2), YELLOW;
		
		private int value;
		
		private Color() {
			
		}
		
		private Color(int value) {
			this.value = value;
		}
		
		public void printValue() {
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Color c : Color.values()) {
			System.out.println(c.name()+" "+c.ordinal());
			c.printValue();
		}

	}

}
