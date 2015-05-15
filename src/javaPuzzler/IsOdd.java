package javaPuzzler;

import java.io.IOException;

public class IsOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int read = 0;
		while (read != -1) {
			try {
				read = System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(isOdd(read));
		}

	}

	private static boolean isOdd(int read) {
		// TODO Auto-generated method stub
		return read % 2 == 1;
	}

}
