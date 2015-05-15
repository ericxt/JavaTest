package javaBasic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommonStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "this is a string.";
		String[] split = str.split(" ");
		// alse str.split("\\s+")
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}

		/**
		 * about substring()
		 */
		// create a new string
		String substring = str.substring(0, str.length()) + "";

		// str.substring(0, str.length()) : use the existing string
		String substring2 = str.substring(0, str.length());

		// while substring(0, not str.length()), create a new string
		String substring3 = str.substring(0, str.length() - 1);

		System.out.println(substring == str);
		System.out.println(substring2 == str);
		System.out.println(substring3 == str);

		String date = "sep 04, 2013";
		try {
			Date parseDate = new SimpleDateFormat("MMMM d, yy", Locale.ENGLISH)
					.parse(date);
			System.out.println(parseDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
