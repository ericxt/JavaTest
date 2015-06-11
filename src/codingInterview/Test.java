package codingInterview;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int[5];
		int i = 0;
		int j = -1;
		while (i < a.length) {
			a[++i] = ++j;
		}
		System.out.println(Arrays.asList(a));

	}

}
