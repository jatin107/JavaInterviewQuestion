package Lecture1.GettingStarted;

public class ReverseNumber {

	public static void main(String[] args) {

		int i = 56789;
		while (i != 0) {
			System.out.print(i % 10);

			i /= 10;
		}

	}

}
