package Lecture1.GettingStarted;

public class GCDNumber {

	public static int gcd(int a, int b) {

		if (a == 0 || b == 0)
			return 0;
		if (a == b)
			return a;
		return b > a ? gcd(b - a, a) : gcd(a - b, b);

	}

	public static void main(String[] args) {

		int i = 18;
		int j = 62;
		System.out.println("++>" + gcd(i, j));
		int rem = j % i;
		while (rem != 0)

		{
			j = i;
			i = rem;
			rem = j % i;

		}
		System.out.println(i);
	}

}
