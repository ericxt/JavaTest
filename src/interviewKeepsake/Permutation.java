package interviewKeepsake;

public class Permutation {
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s = "12234";
		
		permutations(s, "");
		System.out.println(count);

	}

	private static void permutations(String s, String p) {
		// TODO Auto-generated method stub
		if (s.length() < 1) {
			System.out.println(p);
			count++;
		} else {
			int[] index = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				index[i] = s.indexOf(s.charAt(i));
//				System.out.println(index[i] + ", " + s.charAt(i));
			}
			
			for (int i = 0; i < s.length(); i++) {
				if (i == index[i]) {
					permutations(s.substring(1), p + s.substring(0, 1));
				}
				s = s.substring(1) + s.substring(0, 1);
//				System.out.println(s);
			}
		}
		
	}

}
