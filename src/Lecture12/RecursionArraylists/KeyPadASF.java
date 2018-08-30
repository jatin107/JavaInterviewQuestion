package Lecture12.RecursionArraylists;

import java.util.ArrayList;

public class KeyPadASF {

	static String[] code = { ".", "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uvwx", "yz" };

	public static void getKPC(String str, String asf) {

		if (str.length() == 0) {

			System.out.println(asf);
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		String choice = code[ch - '0'];
		for (char codess : choice.toCharArray())
			getKPC(ros, asf + codess);

	}

	public static void main(String[] args) {

		getKPC("179", "");
	}

}
