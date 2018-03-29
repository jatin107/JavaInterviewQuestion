package codingInterview.Recursion;

public class LongestIncreasingSubSequanceDP3 {
    //LIC--LongestIncreasingSubSequance ending with last number


    public static void main(String str[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        //LIS(arr);
        System.out.println(LISEntry(arr));

    }

    public static void LIS(int arr[]) {
        int[] lis = new int[arr.length];
        String[] plis = new String[arr.length];

        lis[0] = 1;
        plis[0] = arr[0] + "";
        lis[0] = 1;
        plis[0] = arr[0] + "";
        int oomax = 0;
        String maxPath = "";

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] < arr[i] && lis[j] > lis[i]) {
                    lis[i] = lis[j];
                    plis[i] = plis[j];

                }
            }
            lis[i] = lis[i] + 1;
            plis[i] = plis[i] + " " + arr[i];
            if (lis[i] > oomax) {
                oomax = lis[i];
                maxPath = plis[i];


            }

        }
        System.out.println(oomax + "@" + maxPath);


    }

    public static int LISEntry(int arr[]) {
        int QB[] = new int[arr.length];
        int omax = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = LISEndingPoint(arr, i, QB);
            if (omax < max)

                omax = max;
        }
        return omax;


    }


    public static int LISEndingPoint(int arr[], int point, int QB[]) {

        if (point == 0) return 1;
        if (QB[point] != 0) return QB[point];

        int lisEndingatpoint = 0;
        for (int i = 0; i < point; i++)

        {
            if (arr[i] < arr[point]) {
                int lisEndingatpointi = LISEndingPoint(arr, i, QB);
                if (lisEndingatpoint < lisEndingatpointi) lisEndingatpoint = lisEndingatpointi;
            }

        }
        lisEndingatpoint += 1;
        QB[point] = lisEndingatpoint;
        return lisEndingatpoint;
    }
}
