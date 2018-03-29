package codingInterview.Recursion;

public class RodeCutingDP3 {
    //Find Max Sale proice


    public static void rct(int arr[]) {
        int strg[] = new int[arr.length];
        String path[] = new String[arr.length];

        strg[0] = 0;
        strg[1] = arr[1];
        path[0] = "_";
        path[1] = "1";

        for (int i = 2; i < arr.length; i++) {
            strg[i] = arr[i];
            path[i] = "" + i;
            int left = 1;
            int right = i - 1;
            for (; left <= right; left++, right--) {
                if (strg[left] + strg[right] > strg[i]) {
                    strg[i] = arr[left] + arr[right];
                    path[i] = path[left] + path[right];

                }

            }


        }
        System.out.println(strg[arr.length - 1] + "@" + path[arr.length - 1]);


    }

    public static int rctRecursive(int arr[], int rl, int QB[]) {
        //System.out.println(rl);
        int msp = arr[rl];

        if (rl == 0) return 0;
        if (QB[rl] != 0) return QB[rl];
        int left = 1;
        int right = rl - 1;
        while (left <= right) {
            int msp1 = rctRecursive(arr, left, QB);
            int mspr = rctRecursive(arr, right, QB);
            if (msp1 + mspr > msp) {
                msp = msp1 + mspr;

            }
            left++;
            right--;


        }


        QB[rl] = msp;
        return msp;
    }

    public static void main(String str[]) {
        int arr[] = {0, 3, 5, 6, 15, 10, 25, 12, 24};
        rct(arr);
        System.out.println(rctRecursive(arr, arr.length - 1, new int[arr.length]));
//        String sArr[] = {0, 3, 5, 6, 15, 10, 25 12, 24};

        /*BigInteger a = new BigInteger("32");
        BigInteger b = new BigInteger("23").subtract(new BigInteger("1"));
        BigInteger c = a.and(b);
        System.out.println(c.equals(new BigInteger("0")));*/
        //LIS(arr);
//        System.out.println(LISEntry(arr));

    }


}

