package Lecture1.GettingStarted;

public class AllFabonaci {

	public static void main(String[] args) {

		int n = 9, i = 1;
		;
		int a = 0, b = 1, c = 0;
		while (i <= n) {
			System.out.println(a);
			c = a + b;
			a = b;
			b = c;
			i++;
		}

	}

}
