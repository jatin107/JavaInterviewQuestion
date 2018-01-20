package codingInterview.Games;

/*package whatever //do not write package name here */

import java.util.Scanner;

//Problem Statement link https://practice.geeksforgeeks.org/problems/finger-game/0
//Solution
class CountTheFinger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            //System.out.println(v);
            switch (v % 8) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                case 0:
                    System.out.println("2");
                    break;
                case 3:
                case 7:
                    System.out.println("3");
                    break;
                case 4:
                case 6:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;

            }
        }
//Space O(1) Time O(1)
        sc.close();
    }

}