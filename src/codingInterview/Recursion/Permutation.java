package codingInterview.Recursion;

public class Permutation {

    static int c = 0;

    public static void printPermutaion(String Ques, String ans) {
        if (Ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int k = 0; k < Ques.length(); k++) {
            char ch = Ques.charAt(k);
            String Quesnew = Ques.substring(0, k) + Ques.substring(k + 1);
            printPermutaion(Quesnew, ans + Ques.charAt(k));

        }

        return;
    }

    public static void printPermutaionStringBuilder(StringBuilder Ques, StringBuilder ans) {
        if (Ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int k = 0; k < Ques.length(); k++) {
            char ch = Ques.charAt(k);

            //StringBuilder Quesnew = new StringBuilder(Ques.substring(0, k) + (Ques.substring(k + 1)));
            ans = ans.append("" + Ques.charAt(k));
            Ques.deleteCharAt(k);
            printPermutaionStringBuilder(Ques, ans);
            ans = ans.deleteCharAt(ans.length() - 1);
            Ques.insert(k, ch);

        }

        return;
    }


    public static void printPermutaionString2(String Ques, String ans) {
        if (Ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = Ques.charAt(0);
        String Quesnew = Ques.substring(1);
        for (int k = 0; k <= ans.length(); k++) {


            String Ansnew = ans.substring(0, k) + ch + ans.substring(k);
            printPermutaionString2(Quesnew, Ansnew);


        }

        return;
    }

    public static void printPermutaionStringBuilder2(StringBuilder Ques, StringBuilder ans) {
        if (Ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = Ques.charAt(0);
        Ques = Ques.deleteCharAt(0);
        for (int k = 0; k <= ans.length(); k++) {


            ans = ans.insert(k, ch);
            printPermutaionStringBuilder2(Ques, ans);
            ans = ans.deleteCharAt(k);


        }
        Ques.insert(0, ch);

        return;
    }


    public static void main(String strp[]) {
        //printPermutaion("abc", "");
        //printPermutaionStringBuilder(new StringBuilder("abc"), new StringBuilder());
        //printPermutaionString2("abc", "");
        printPermutaionStringBuilder2(new StringBuilder("abc"), new StringBuilder());
    }

}

