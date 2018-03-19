package codingInterview.Recursion;

public class DisplayArray {
//Non Primitive--instance is heap


    public static void display(int a[], int i) {
        if (i == a.length) return;
        System.out.println(a[i]);
        display(a, i + 1);

    }

    public static void displayInReverse(int a[], int i) {
        if (i == a.length) return;

        displayInReverse(a, i + 1);
        System.out.println(a[i]);

    }

    public static int displayMax(int a[], int i) {
        if (i == a.length)
            return a[i - 1];
        int max = displayMax(a, i + 1);
        if (a[i] < max)
            return max;
        else return a[i];

    }

    public static int displayMin(int a[], int i) {
        if (i == a.length - 1)
            return a[i];
        int min = displayMax(a, i + 1);
        if (a[i] > min)
            return min;
        else return a[i];

    }

    public static boolean find(int a[], int i, int f) {
        if (i == a.length)
            return false;
        if (a[i] == f)
            return true;
        else
            return find(a, i + 1, f);


    }

    public static int findFirstIndex(int a[], int i, int f) {
        if (i == a.length)
            return -1;
        if (a[i] == f)
            return i;
        else
            return findFirstIndex(a, i + 1, f);


    }

    public static int findLastIndex(int a[], int i, int f) {

        if (i == a.length)
            return -1;
        if (a[i] == f) {
            int last = findLastIndex(a, i + 1, f);
            return last == -1 ? i : last;
        } else
            return findLastIndex(a, i + 1, f);


    }

    public static int[] findAllIndex(int a[], int i, int f, int c) {
//count c
        if (i == a.length) {
            return new int[c];

        }
        if (a[i] == f) {
            int index[] = findAllIndex(a, i + 1, f, c + 1);
            index[c] = i;
            return index;
        } else
            return findAllIndex(a, i + 1, f, c);


    }

    public static int[] bubleSort(int a[], int s, int e) {
//count c
        if (e == 0) {
            return a;
        }
        if (s == e) {
            return bubleSort(a, 0, e - 1);
        }


        if ( a[s] > a[s + 1]) {
            int temp = 0;
            temp = a[s];
            a[s] = a[s + 1];
            a[s + 1] = temp;
            return bubleSort(a, s + 1, e);

        } else
            return bubleSort(a, s + 1, e);


    }

    public static void main(String str[]) {

        int a[] = {9, 2, 3, 4, 5, -1, 2, 9, 9};

        //display(a,0);//virtual index
        //displayInReverse(a,0);
        //System.out.println( displayMax(a,0));
        //System.out.println( displayMin(a,0));
        //System.out.println( find(a,0,10));
        // System.out.println( findFirstIndex(a,0,3));
        //System.out.println(findLastIndex(a, 0, 10));
        //Emotion control
        //1. dhar and  2/gamand
        //int A[]=findAllIndex(a, 0, 9, 0);
        int A[] = bubleSort(a, 0, a.length - 1);

        for (int b : A) {
            System.out.println(b);
        }


    }

}
