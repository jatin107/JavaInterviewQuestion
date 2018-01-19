package codingInterview.arrays;

import java.util.Arrays;

public class CheckPermutation {


    static boolean checkPermutation1(String s, String t) {
        if (s.length() != t.length())
            return false;

        int letterCounts[] = new int[128];// character set are ASCII

        char sCArray[] = s.toCharArray();
        for (char c : sCArray)
            letterCounts[c]++;

        for (int i = 0; i < t.length(); i++) {
            letterCounts[t.charAt(i)]--;
            if (letterCounts[t.charAt(i)] < 0)
                return false;
        }

        return true;
        //space: O(1) time: O(n)
    }

    static boolean checkPermutation2(String s, String t) {

        if (s.length() != t.length())
            return false;

        return sort(s).equals(sort(t));

        //space: O(1) time: O(NlogN)
    }

    static String sort(String str1) {
        char[] ch = str1.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
        //space: O(1) time: O(NlogN)

    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        System.out.println("tintin " + checkPermutation1("tintin", "nittin"));
        System.out.println("tintin " + checkPermutation2("tintin", "nittin"));

    }


}
