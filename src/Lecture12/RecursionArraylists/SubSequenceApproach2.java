package Lecture12.RecursionArraylists;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

public class SubSequenceApproach2 {

	public static void subSequence(String ques, String asf) {

		if (ques.length() == 0) {
			System.out.print(asf + ",");
		} else {
			char ch = ques.charAt(0);
			subSequence(ques.substring(1), "" + asf);
			subSequence(ques.substring(1), asf + ch);

		}

	}

	public static void subSequenceWithASCII(String ques, String asf) {

		if (ques.length() == 0) {
			System.out.print(asf + ",");
			return;
		}
		char ch = ques.charAt(0);
		subSequenceWithASCII(ques.substring(1), asf);
		subSequenceWithASCII(ques.substring(1), asf + ch);
		subSequenceWithASCII(ques.substring(1), asf + (int) ch);

	}

	public static void main(String[] args) {
		subSequence("abc", "");

		System.out.println();
		subSequenceWithASCII("ab", "");

	}

}
