package codingInterview.Recursion;

import java.util.ArrayList;

public class KeyPadCombination {

    static String ms[] = {".", "abc", "def", "ghl", "jkl", "mno", "pqr", "st", "uvwx", "yz"};

    public static void main(String s[]) {
        System.out.println(getAStr("179"));
        //System.out.println(Integer.parseInt("147".charAt(0)+""));
    }

    public static ArrayList<String> getAStr(String s) {
        if (s.length() == 0) {
            ArrayList<String> al = new ArrayList<String>();
            al.add("");
            return al;

        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        int i = ch - '0';
        ArrayList<String> rr = getAStr(ros);
        ArrayList<String> my = new ArrayList<String>();

        for (String ad : rr)
            for (char sch : ms[i].toCharArray()) {
                my.add(sch + ad);
            }


        return my;
    }

}
