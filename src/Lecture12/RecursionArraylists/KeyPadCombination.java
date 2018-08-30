package Lecture12.RecursionArraylists;

import java.util.ArrayList;

public class KeyPadCombination {

	static String[] code = { ".", "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uvwx", "yz" };

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;

		}
		char ch = str.charAt(0);
		int chint = (int) ch;
		String ros = str.substring(1);

		ArrayList<String> ral = getKPC(ros);
		ArrayList<String> newal = new ArrayList<>();

		for (String s : ral) {
			for (char codess : code[ch - '0'].toCharArray())
				newal.add(codess + s);
		}

		return newal;

	}

	public static void main(String[] args) {

		System.out.println(getKPC("197"));
	}

}
