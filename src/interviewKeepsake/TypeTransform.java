package interviewKeepsake;

public class TypeTransform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		short myshort = 96S;
//		float z = 1.0;	// default is double
		int t = "abc".length();
		char c = 48;	// responding to ascii code
//		System.out.println(c);
		
		float f1 = 1.2f;
		Float f2 = new Float(f1);
		double doubleValue = f2.doubleValue();
		System.out.println(doubleValue);
		System.out.println((double)f1);
		System.out.println(f1);
		System.out.println(f2);
		
		char ch = '1';
		Character character = new Character(ch);
		System.out.println(Character.getNumericValue(ch));
		System.out.println(ch);
		
		short s = 1;
		s += 1; // can not written as s = s + 1;
		
		int a = 5;
		System.out.println("value is " + ((a > 5) ? 10.9 : 9));	// 9 transformed to 9.0
		
		char x = 'x';
		int i = 10;
		System.out.println(false ? i : x);
		System.out.println(false ? 10 : x);
		
	}

}
