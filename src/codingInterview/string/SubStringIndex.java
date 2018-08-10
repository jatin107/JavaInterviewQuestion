package codingInterview.string;

public class SubStringIndex {

	public int strStr(final String A, final String B) {
		int j = 0;
		
		if (B.length() == 1 && A.length() == 1)
			return A.equals(B) == true ? 0 : -1;

		for (int i = 0; i <= A.length() - B.length(); i++) {
			for (j = 0; j < B.length(); j++) {
				if (A.charAt(i + j) != B.charAt(j))
					break;
			}
			if (j == B.length())
				return i;

		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
