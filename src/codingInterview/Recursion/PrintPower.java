package codingInterview.Recursion;

public class PrintPower {

    public static int  power(int n,int i)
    {
        if(i==0)return 1;

        return n*power(n,i-1);


    }

    public static void main(String str[])
    {
       System.out.println(power(2,3));

    }

}
