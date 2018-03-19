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
            my.add((int)s.charAt(0) + fs);

        }

        return my;

    }


    public static void main(String strp[])

    {
        //System.out.println(gss("ab"));
        System.out.println(gsswAscii("ab"));
        return;
    }

}
