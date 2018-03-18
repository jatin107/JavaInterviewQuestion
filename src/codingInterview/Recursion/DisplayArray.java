package codingInterview.Recursion;

public class DisplayArray {
//Non Primitive--instance is heap


    public static void display(int a[],int i)
    {
        if(i==a.length)return;
        System.out.println(a[i]);
        display(a,i+1);

    }
    public static void displayInReverse(int a[],int i)
    {
        if(i==a.length)return;

        displayInReverse(a,i+1);
        System.out.println(a[i]);

    }

    public static int  displayMax(int a[],int i)
    {
        if(i==a.length)
            return a[i-1];
        int max=displayMax(a,i+1);
        if(a[i]<max)
            return max;
        else return a[i];

    }

    public static int  displayMin(int a[],int i)
    {
        if(i==a.length-1)
            return a[i];
        int min=displayMax(a,i+1);
        if(a[i]>min)
            return min;
        else return a[i];

    }

    public static boolean  find(int a[],int i,int f)
    {
        if(i==a.length)
            return false;
        if(a[i]==f)
            return true;
        else
        return find(a,i+1,f);


    }

    public static void main(String str[])
    {

        int a[]={2,3,4,5,-1};

        //display(a,0);//virtual index
        //displayInReverse(a,0);
        //System.out.println( displayMax(a,0));
        //System.out.println( displayMin(a,0));
        System.out.println( find(a,0,10));



    }

}
