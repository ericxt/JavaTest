package codingInterview;

public class CompareVersionNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ver1 = "1.3.3.1";
		String ver2 = "1.3.3.";
		int result = versionCompare(ver1, ver2);
		System.out.println(result);

	}

	private static int versionCompare(String ver1, String ver2) {
		// TODO Auto-generated method stub
		if (ver1 == null || ver2 == null) {
			System.out.println("invalid version numbers");
			return -2;
		}

		String[] ver1Array = ver1.split("\\.");
		String[] ver2Array = ver2.split("\\.");
		// System.out.println(ver1 + ", " + ver1Array.length);
		int i = 0, j = 0;
		for (i = 0, j = 0; i < ver1Array.length && j < ver2Array.length; i++, j++) {
			// System.out.println(ver1Array[i] + ", " + ver2Array[j]);
			if (ver1Array[i].compareTo(ver2Array[j]) < 0) {
				return -1;
			} else if (ver1Array[i].compareTo(ver2Array[j]) > 0) {
				return 1;
			}
		}

		if (i < ver1Array.length) {
			if (Integer.valueOf(ver1Array[i]) > 0) {
				return 1;
			}
		}
		if (j < ver2Array.length) {
			if (Integer.valueOf(ver2Array[j]) > 0) {
				return 1;
			}
		}
		return 0;
	}

}
