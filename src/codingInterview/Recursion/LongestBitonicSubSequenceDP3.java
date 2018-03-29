package codingInterview.Recursion;

public class LongestBitonicSubSequenceDP3 {
    //LIC--LongestIncreasingSubSequance ending with last number


    public static void main(String str[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        LIPS(arr);

    }

    public static void LIPS(int arr[]) {
        int[] lis = new int[arr.length];
        String[] plis = new String[arr.length];
        lis[0] = 1;
        plis[0] = arr[0] + "";
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] < arr[i]) {
                    if (lis[j] > lis[i]) {
                        lis[i] = lis[j];
                        plis[i] = plis[j];
                    }
                }
            }
            lis[i] = lis[i] + 1;
            plis[i] = plis[i] + " " + arr[i];


        }
        int[] lds = new int[arr.length];
        String[] plds = new String[arr.length];
        lds[arr.length - 1] = 1;
        plds[arr.length - 1] = arr[arr.length - 1] + "";
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j] < arr[i]) {
                    if (lds[j] > lds[i]) {
                        lds[i] = lds[j];
                        plds[i] = plds[j];
                    }
                }
            }
            lds[i] = lds[i] + 1;
            plds[i] = arr[i] + " " + plds[i];


        }
        int omax = 0;
        String opath = "";
        for (int i = 0; i < arr.length; i++) {

            if (lds[i] + lis[i] > omax) {
                omax = lis[i] + lds[i] - 1;
                opath = plis[i] + " * " + plds[i];
            }

        }
        System.out.println(omax);
        System.out.println(opath);

        return;
    }

}
