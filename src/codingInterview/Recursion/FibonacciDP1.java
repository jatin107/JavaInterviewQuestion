package codingInterview.Recursion;

public class FibonacciDP1 {
    //Fibinacci
    // 0 1 1 2 3 5
    //T(n)=T(n-1)+T(n-2)
    //T(n)<=2 T(n)
    //T(n)<=k+2k+3K=2^n
    //OverLapping SubProblem

    //f-->Fb
    //x{0,1} -->f(x)=x
    //x>=2 = f(x-1)+f(x-2)

    public static int fabTabulation(int n) {
        int fT[] = new int[n + 1];
        fT[0] = 0;
        fT[1] = 1;

        for (int x = 2; x <= n; x++) {
            fT[x] = fT[x - 1] + fT[x - 2];
        }
        return fT[n];
    }

    public static int fabMemo(int n, int rfab[]) {
        if (n == 0 || n == 1)
            return n;

        if (rfab[n] == 0)

            return rfab[n] = fabMemo(n - 1, rfab) + fabMemo(n - 2, rfab);
        return rfab[n];

    }

    public static int fabProblem(int n) {
        if (n == 0 || n == 1)
            return n;

        return fabProblem(n - 1) + fabProblem(n - 2);


    }

    public static int fabSlider(int n) {
        int slider[] = new int[2];

        slider[0] = 0;
        slider[1] = 1;
        int temp = 0;
        for (int x = 1; x <= n; x++) {
            temp = slider[0] + slider[1];
            slider[0] = slider[1];
            slider[1] = temp;
        }
        return slider[0];


    }


    public static void main(String strp[]) {
        int n = 10000;
        long s = System.currentTimeMillis();
        //System.out.println(fabProblem(n));
        //System.out.println(fabMemo(n, new int[n + 1]));
        System.out.println(fabSlider(n));
        long e = System.currentTimeMillis();
        System.out.println(fabTabulation(n));//faster then Memozization
        long e1 = System.currentTimeMillis();
        System.out.println(e - s);
        System.out.println(e1 - e);
        return;
    }


}


