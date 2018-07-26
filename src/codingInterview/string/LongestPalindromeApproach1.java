package codingInterview.string;

/**
 * @author Mr. X 9:52
 * 
 *
 */
public class LongestPalindromeApproach1 {

	static boolean isPalindome(char ch[], int s, int e) {// O(n)

		while (s < e && e >= 0)
			if (ch[s++] == ch[e--])
				continue;
			else
				return false;
		return true;

	}

	static String makeString(char ch[]) {// O(n)

		int e = 0, s = 0;

		for (int i = 0; i < ch.length; i++)
			for (int j = ch.length; j >=i+1 ; j--) {
				if (j - i > e - s && isPalindome(ch, i, j - 1)) {
					e = j;
					s = i;

				}
			}

		return new String(ch).substring(s, e);

	}

	public static void main(String[] args) {
		// String str = "banana";
		driver("anana");
		 driver("banana");
		driver("aaaabaaa");

	}

	public static void driver(String s) {
		System.out.println(makeString(s.toCharArray()));
		// System.out.println(s + ":" + isPalindome(s.toCharArray(), 0, s.length() -
		// 1));
	}

}
