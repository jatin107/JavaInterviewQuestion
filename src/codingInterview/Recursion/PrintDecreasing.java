package codingInterview.Recursion;

public class PrintDecreasing {

    public static void PD(int n)
    {
        if(n==0) return;
        System.out.println(n);
        PD(n-1);

    }

    public static void main(String str[])
    {
        PD(10);

    }

}
