package Lecture1.GettingStarted;

public class AllPrime {

	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
//O(n^1/2)
		return true;
	}

	public static boolean allPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (isPrime(i))
				System.out.println(i);
		}
//O(n^1/2)
		return true;
	}

	public static void main(String[] args) {
		System.out.println(allPrime(50));
	}

}
