
package codingInterview.bitManupulation;

import java.util.Scanner;
//Problem Statement link https://practice.geeksforgeeks.org/problems/power-of-2/0

class PowerOfTwo {

    static boolean isPowerOfTwo(long a) {
        if (a == 0) return false;
        return (a & (a - 1)) == 0;
        //space: O(1) time: O(1)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long v = sc.nextLong();
            if (isPowerOfTwo(v))
                System.out.println("YES");
            else

                System.out.println("NO");

        }
        //Space O(1) Time O(1)
        sc.close();

    }
}
