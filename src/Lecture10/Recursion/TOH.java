package Lecture10.Recursion;

public class TOH {

	public static void toh(String src, String desc, String helper, int n) {
		if (n == 0)
			return;

		else {
			toh(src, helper, desc, n - 1);
			System.out.println("Move " + n + "th disc from " + src + " to " + desc);
			toh(helper, desc, src, n - 1);

		}

	}

	public static void main(String[] args) {
		toh("A", "B", "C", 3);

	}

}
