package codingInterview.string;

/**
 * @author Mr. X 9:52
 *
 */
public class LongestPalindromeApproach2 {

	public static String palindrome(String st) {
		char ch[] = st.toCharArray();
		int s = 0, e = 0;

		for (int m = 0; m < ch.length; m++) {
			int l = m, r = m;
			while (l >= 0 && r < ch.length) {
				if (ch[l] == ch[r]) {
					if (r - l > e - s) {
						e = r;
						s = l;
					}
				} else
					break;
				l--;
				r++;

			}
			l = m;
			r = m + 1;
			while (l >= 0 && r < ch.length) {
				if (ch[l] == ch[r]) {
					if (r - l > e - s) {
						e = r;
						s = l;
					}
				} else
					break;
				l--;
				r++;

			}

		}

		return st.substring(s, e + 1);
	}

	public static void main(String[] args) {
		// String str = "banana";
		// driver("anana");
		System.out.println(palindrome("banana"));
		System.out.println(palindrome("aaaabaaa"));

	}

}
