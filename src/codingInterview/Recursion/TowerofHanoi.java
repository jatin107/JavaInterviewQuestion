package codingInterview.Recursion;

public class TowerofHanoi {

    public static void toh(String  s,String d, String h , int peg)
    {
        if(peg==0)return;

        toh(s,h,d,peg-1);
        System.out.println("Move  "+peg+" peg  from source "+s+" to destination "+d);
        toh(h,d,s,peg-1);

    }

    public static void main(String str[])
    {
        toh("A","B","C",2);

    }

}
