package interviewKeepsake;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[101];
		for (int i = 1; i < 101; i++) {
			a[i] = 1;
		}
		
		for (int i = 2; i < 101; i++) {
			if (a[i] != 0) {
				for (int j = i + i; j < 101; j = j + i) {
					if (j % i == 0) {
						a[j] = 0;
					}
				}
			}
		}
		
		for (int i = 2; i < 101; i++) {
			if (a[i] == 1) {
				System.out.println(i);
			}
		}

	}

}
