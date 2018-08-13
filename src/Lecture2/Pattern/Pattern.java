package Lecture2.Pattern;

import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

public class Pattern {

	public static void pattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void pattern2(int n) {
		int k = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(k++ + " ");
			System.out.println();
		}
	}

	public static void pattern3(int n) {
		int a = 0;
		int b = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(a + " ");
				int c = a + b;
				a = b;
				b = c;
			}
			System.out.println();
		}

	}

	public static void pattern4(int n) {
		int a = 0;
		int b = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(a + " ");
				int c = a + b;
				a = b;
				b = c;
			}
			System.out.println();
		}

	}

	public static void pattern5(int n) {
		int row = 0;
		while (row < n) {
			int col = 0;
			int val = 1;// NC0=1
			while (col <= row) {
				System.out.print(val + " ");
				int nCkp1 = val * (row - col) / (col + 1);
				val = nCkp1;
				col++;
			}
			System.out.println();
			row++;
		}

	}

	public static void pattern6X(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (i == j || i + j == n - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

	public static void pattern7(int n) {
		int str = n / 2 + 1;
		int spc = 1;
		// n=5
		// 3 1 3
		// 2 2 2
		// 1 3 1
		// 2 2 2
		// 3 1 3

		for (int i = 0; i < n; i++) {

			for (int p = 0; p < str; p++)
				System.out.print("* ");
			for (int p = 0; p < spc; p++)
				System.out.print("  ");
			for (int p = 0; p < str; p++)
				System.out.print("* ");
			if (i < n / 2) {
				str--;
				spc += 2;
			} else

			{
				spc -= 2;
				str++;
			}
			System.out.println();

		}

	}

	public static void pattern8(int n) {
		int spc = n / 2 + 1;
		int str = 1;
		for (int i = 0; i < n; i++) {

			for (int p = 0; p < spc; p++)
				System.out.print("  ");
			for (int p = 0; p < str; p++)
				System.out.print("* ");
			if (i < n / 2) {
				str += 2;
				spc--;
			} else

			{
				spc++;
				str -= 2;
			}
			System.out.println();

		}

	}

	public static void pattern9(int n) {
		int spc = n / 2 + 1;
		int str = 1;
		int val = 1, rval = 1;
		for (int i = 0; i < n; i++) {

			for (int p = 0; p < spc; p++)
				System.out.print("  ");
			for (int p = 0; p < str; p++) {
				if (p < str / 2)
					System.out.print(rval++ + " ");
				else
					System.out.print(rval-- + " ");

			}

			if (i < n / 2) {
				str += 2;
				spc--;
				rval = ++val;
			} else

			{

				spc++;
				rval = --val;
				str -= 2;
			}
			System.out.println();

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a  number.");
		int n = sc.nextInt();
		// pattern(n);
		// pattern2(n);
//		pattern5(n);
//		pattern7(n);
		// pattern8(n);
		pattern9(n);

	}

}
