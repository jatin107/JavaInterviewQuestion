package codingInterview.Recursion;

public class PalindromicDP2 {

    private static void findPalindrome(String str) {

        boolean strg[][] = new boolean[str.length()][str.length()];
//lope for diagonal
        int count = 0;
        for (int d = 0; d < str.length(); d++) {
            int sp = 0;
            int ep = d;
            while (ep < str.length()) {

                if (d == 0) strg[sp][ep] = true;
                else if (d == 1 && str.charAt(sp) == str.charAt(ep)) strg[sp][ep] = true;
                else if (str.charAt(sp) == str.charAt(ep) && strg[sp + 1][ep - 1]) strg[sp][ep] = true;
                if (strg[sp][ep]) count++;
                ep++;
                sp++;

            }

        }
        System.out.println(count);


    }


    public static void main(String str[]) {

        findPalindrome("abccbc");
    }


}



