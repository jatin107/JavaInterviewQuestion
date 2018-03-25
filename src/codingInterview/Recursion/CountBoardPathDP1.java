package codingInterview.Recursion;

public class CountBoardPathDP1 {

    public static int countBoardPath(int s, int d, String asf) {
        int cstod = 0;
        if (s > d) return 0;
        if (s == d) return 1;//Don't throw the dice

        for (int dice = 1; dice <= 6; dice++) {
            int intermediate = s + dice;

            int c = countBoardPath(intermediate, d, asf + dice);
            cstod += c;

        }
        return cstod;

    }
//T(n)=T(n-1)...<=k+6T(n-1)
// T(n)=  k+6k+6^2k...=k(6^n-1)/6-1=6^n

    public static int countBoardPathMemo(int s, int d, int QuesBank[]) {
        int cstod = 0;
        if (s > d) return 0;
        if (s == d) return 1;//Don't throw the dice

        if (QuesBank[s] != 0) return QuesBank[s];
        for (int dice = 1; dice <= 6; dice++) {
            int intermediate = s + dice;

            int c = countBoardPathMemo(intermediate, d, QuesBank);
            cstod += c;

        }

        QuesBank[s] = cstod;
        return cstod;

    }

    public static int countBoardPathTabular(int s, int d) {
        //f(x)=CBP(x,d)

        int Array[] = new int[d + 1];
        Array[d] = 1;


        for (int k = d - 1; k >= 0; k--) {
            for (int dice = 1; dice <= 6; dice++) {
                if (k + dice <= d)
                    Array[k] += Array[k + dice];
            }

        }


        return Array[0];

    }

    public static int countBoardPathSlider(int s, int d) {
        int Array[] = new int[6];
        Array[0] = 1;//0==d
//S12345= concide with F11..15 if d=10
        int temp = 0;

        for (int k = d; k >= 1; k--) {
            temp = Array[5] + Array[4] + Array[3] + Array[2] + Array[1] + Array[0];
            Array[5] = Array[4];
            Array[4] = Array[3];
            Array[3] = Array[2];
            Array[2] = Array[1];
            Array[1] = Array[0];
            Array[0] = temp;

        }


        return Array[0];

    }


    public static void main(String str[]) {
        int n = 10;
        System.out.println(countBoardPathSlider(0, n));
        System.out.println(countBoardPathMemo(0, n, new int[n + 1]));//fast.
        System.out.println(countBoardPathTabular(0, n));//working fine.

        return;
    }


}


