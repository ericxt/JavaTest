package codingInterview;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "the sky is so blue";
		String reverseStr = reverseWords(str);
		System.out.println(reverseStr);

	}

	private static String reverseWords(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.length() == 0) {
			return null;
		}
		String[] splitArray = str.split(" ");
		int length = splitArray.length;
		int left = 0;
		int right = length - 1;
		// there is no need to reverse the array
		// while (left < right) {
		// String tmp = splitArray[left];
		// splitArray[left] = splitArray[right];
		// splitArray[right] = tmp;
		//
		// left++;
		// right--;
		// }
		StringBuilder builder = new StringBuilder();
		// for (int i = 0; i < length; i++) {
		// if (i != length - 1) {
		// builder.append(splitArray[i] + " ");
		// } else {
		// builder.append(splitArray[i]);
		// }
		// }

		// append the array string from right to left
		for (int i = length - 1; i >= 0; i--) {
			if (i != 0) {
				builder.append(splitArray[i] + " ");
			} else {
				builder.append(splitArray[i]);
			}
		}

		return builder.toString();
	}
}
