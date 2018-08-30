package Lecture12.RecursionArraylists;

import java.util.ArrayList;

public class SubSequence {

	public static ArrayList<String> subSequence(String str) {

		if (str.length() == 0) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> ral = subSequence(ros);
		ArrayList<String> newal = new ArrayList<>();

		for (String s : ral) {
			newal.add(s);
			newal.add(ch + s);
		}

		return newal;

	}

	public static ArrayList<String> subSequenceWithASCII(String str) {

		if (str.length() == 0) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;

		}
		char ch = str.charAt(0);
		int chint = (int) ch;
		String ros = str.substring(1);

		ArrayList<String> ral = subSequenceWithASCII(ros);
		ArrayList<String> newal = new ArrayList<>();

		for (String s : ral) {
			newal.add(s);
			newal.add(ch + s);
			// newal.add(ch + s);
			newal.add((int) chint + s);
		}

		return newal;

	}

	public static void main(String[] args) {
		System.out.println(subSequence("abc"));
		System.out.println(subSequenceWithASCII("abc"));
	}

}
