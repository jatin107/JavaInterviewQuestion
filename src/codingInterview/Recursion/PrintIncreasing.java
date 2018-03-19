package codingInterview.Recursion;

public class PrintIncreasing {

    public static void PI(int n)
    {
        if(n==0) return;
        PI(n-1);
        System.out.println(n);


    }

    public static void main(String str[])
    {
        PI(10);

    }

}
