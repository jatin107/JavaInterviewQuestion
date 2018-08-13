package codingInterview.Recursion;

public class PrintDecreasing {

	public static void PD(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		PD(n - 1);

	}

	public static void Pat(int n) {
		if (n == 0)
			return;

		Pat(n - 1);
		System.out.println(n);

		if (n == 4)
			PD(n);

		// Pat(n-1);

	}
	public static void Pat2(int n,int i) {
		if (n == i)
			return;

		System.out.println(i);
		Pat2(n,i+1);
		System.out.println(i);

		

	}



	public static void main(String str[]) {
		// PD(10);
		Pat(4);
		Pat2(4,1);

	}

}
