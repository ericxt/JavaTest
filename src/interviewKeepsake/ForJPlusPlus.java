package interviewKeepsake;

public class ForJPlusPlus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 0;
		for (int i = 0; i < 100; i++) {
			j = j++;	// same with {temp = j; j = j + 1; j = temp;}
		}
		System.out.println(j);
		
		int k = 0;
		k = k++;
		k = k++ + k++ + k++ + ++k;
		System.out.println(k);

	}

}
