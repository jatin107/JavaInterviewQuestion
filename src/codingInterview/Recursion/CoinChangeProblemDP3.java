package codingInterview.Recursion;

import java.util.ArrayList;

public class CoinChangeProblemDP3 {
    //Find Max Sale proice
    public static void coinChange(int arr[], int amt) {
        int strg[] = new int[amt + 1];
        ArrayList<String> path[] = new ArrayList[amt + 1];

        //Arrays.fill(path, new ArrayList());
        for (int i = 0; i < path.length; i++)
            path[i] = new ArrayList<>();
        strg[0] = 1;
        path[0].add("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= amt; j++) {
                strg[j] = strg[j] + strg[j - arr[i]];
                for (String rstr : path[j - arr[i]]) {
                    //rstr += arr[i];
                    path[j].add(rstr + arr[i]);

                }

            }

        }
        System.out.println(strg[strg.length - 1]);
        System.out.println(path[path.length - 1]);


    }

    public static void main(String str[]) {
        int arr[] = {2, 3, 5, 6};
        coinChange(arr, 10);
    }


}

