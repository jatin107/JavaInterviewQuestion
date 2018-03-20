package codingInterview.Recursion;

import java.util.ArrayList;

public class SubSequence {
//SubString abc n=3

// total=n(n+1)/2==a,ab,abc,b,bc,c
//SubSequence abc==___,__c,_b_,_bc,a__,a_c,ab_,abc==2^3

    //Expectation =Faith(subString) +a Faith(subString)
    public static ArrayList<String> gss(String s) {
        if (s.length() == 0) {
            ArrayList a = new ArrayList();
            a.add("");
            return a;
        }
        ArrayList<String> rr = gss(s.substring(1));
        ArrayList<String> my = new ArrayList();
        for (String fs : rr) {
            my.add(fs);
            my.add(s.charAt(0) + fs);

        }

        return my;

    }

    public static void gss1(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = ques.charAt(0);
        gss1(ques.substring(1), asf);
        gss1(ques.substring(1), asf + ch);


        return;

    }

    public static void gss1withascii(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = ques.charAt(0);
        gss1withascii(ques.substring(1), asf);
        gss1withascii(ques.substring(1), asf + ch);
        gss1withascii(ques.substring(1), asf + (int) ch);


        return;

    }

    //    E=F()+AF()
    public static ArrayList<String> gsswAscii(String s) {
        if (s.length() == 0) {
            ArrayList a = new ArrayList();
            a.add("");
            return a;
        }
        ArrayList<String> rr = gsswAscii(s.substring(1));
        ArrayList<String> my = new ArrayList();
        for (String fs : rr) {
            my.add(fs);
            my.add(s.charAt(0) + fs);
            my.add((int) s.charAt(0) + fs);

        }

        return my;

    }


    public static void main(String strp[])

    {
        //System.out.println(gss("ab"));
        gss1withascii("ab", "");
        return;
    }

}
