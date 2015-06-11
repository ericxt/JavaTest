package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "adhjkghewq\r\n43798\n\n5y34\r\nht24\nt93h9\n42t9\n34tyht924hg24htg";

		/**
		 * extract numbers from a string by using Pattern, Matcher class
		 */
		LinkedList<Integer> intList = new LinkedList<Integer>();
		// \\d+ : match strings like "123" to 123
		// \\d : match strings like "123" to 1, 2, 3
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			intList.add(Integer.parseInt(matcher.group()));
		}
		System.out.println(intList);

		/**
		 * split strings by newline
		 */
		// contains empty line
		String[] containEmptyLine = str.split("\r?\n");
		// no empty line
		String[] noEmptyLine = str.split("[\r\n]+");
		// system independent, but contains empty lines
		String[] systemIndependent = str.split(System
				.getProperty("line.separator"));

		ArrayList<String> containEmptyLineList = new ArrayList<String>(
				Arrays.asList(containEmptyLine));
		ArrayList<String> noEmptyLineList = new ArrayList<String>(
				Arrays.asList(noEmptyLine));
		ArrayList<String> independentList = new ArrayList<String>(
				Arrays.asList(systemIndependent));

		System.out.println(containEmptyLineList);
		System.out.println(noEmptyLineList);
		System.out.println(independentList);

		/**
		 * match anbn with regex
		 */
		Pattern p = Pattern.compile("(?x)(?:a(?=a*(\\1?+b)))+\\1");
		System.out.println(p.matcher("aaabbb").matches());
		System.out.println(p.matcher("aaabbbb").matches());
		System.out.println(p.matcher("aaaabbb").matches());
		System.out.println(p.matcher("caaabbb").matches());

		/**
		 * replace spaces
		 */
		String spaceLine = "  aa  bak asd  adskl ";
		System.out.println(spaceLine);
		System.out.println(spaceLine.replaceAll("[\\s]+", " "));

		/**
		 * split string with commas, but ignore commas in quotes
		 */

		String commasLine = "hgak,adhjkg,akdhga\"adk,adklg\"dk,adjlj";
		List<String> commasSeparatedList = splitCommas(commasLine);
		System.out.println(commasSeparatedList);

		/**
		 * lookahead and lookbehind
		 */
		String lookahead = "programreek";
		// programcreek works
		// Pattern p_lookahead = Pattern.compile(".*program(?=creek).*");
		// programriver works
		Pattern p_negative = Pattern.compile(".*program(?!creek).*");
		Matcher m_lookahead = p_negative.matcher(lookahead);
		if (m_lookahead.matches()) {
			System.out.println(m_lookahead.group() + ">>>"
					+ m_lookahead.groupCount());
		}

		/**
		 * backreference
		 */
		String backrefStr = "1231234";
		Pattern backrefPatt = Pattern.compile("(\\d\\d\\d)\\1\\d");
		Matcher backrefMat = backrefPatt.matcher(backrefStr);
		if (backrefMat.matches()) {
			System.out.println(backrefMat.group() + ">>>" + backrefMat.start()
					+ ":" + backrefMat.end());
		}

	}

	private static List<String> splitCommas(String commasLine) {
		// TODO Auto-generated method stub
		int start = 0;
		boolean inQuote = false;
		List<String> toks = new ArrayList<String>();
		for (int end = 0; end < commasLine.length(); end++) {
			char c = commasLine.charAt(end);
			switch (c) {
			case ',':
				if (!inQuote) {
					toks.add(commasLine.substring(start, end));
					start = end + 1;
				}
				break;

			case '\"':
				inQuote = !inQuote;
				break;

			default:
				break;
			}
		}

		if (start < commasLine.length()) {
			toks.add(commasLine.substring(start, commasLine.length()));
		}
		return toks;
	}

}
