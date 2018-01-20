package codingInterview.bitManupulation;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {
    //link : https://www.interviewbit.com/problems/prime-sum/
    static private ArrayList<Integer> primesum(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, Boolean.TRUE);
        ArrayList<Integer> numL = new ArrayList<>();
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Update all multiples of p
                for (int j = i * 2; j <= n; j += i)
                    isPrime[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                numL.add(i);
                numL.add(n - i);
                return numL;
            }
        }
        //   System.out.println(numL);
        return numL;
//space O(n) time O(n)

    }

    public static void main(String[] args) {
        System.out.println(primesum(1048574));
        System.out.println(primesum(378));
        //System.out.println(primeSum(4));
    }

}

 