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

    public static ArrayList<String> coinChangeResusive(int denoms[], int amt) {

        if (amt == 0) {
            ArrayList<String> bresult = new ArrayList();
            bresult.add("");
            return bresult;

        }
        if (amt < 0) {
            ArrayList<String> bresult = new ArrayList();
            return bresult;

        }

        ArrayList<String> mresult = new ArrayList();
        for (int i = 0; i < denoms.length; i++) {
            ArrayList<String> rresult = coinChangeResusive(denoms, amt - denoms[i]);

            for (String s : rresult) {
                mresult.add(s + denoms[i]);
            }


        }
//        System.out.println(mresult);
        return mresult;

    }

    public static ArrayList<String> coinChangeResusiveMemo(int denoms[], int amt, ArrayList<String> QB[]) {

        if (amt == 0) {
            ArrayList<String> bresult = new ArrayList();
            bresult.add("");
            return bresult;

        }
        if (amt < 0) {
            ArrayList<String> bresult = new ArrayList();
            return bresult;

        }
        if (QB[amt] != null)
            return QB[amt];

        ArrayList<String> mresult = new ArrayList();
        for (int i = 0; i < denoms.length; i++) {
            ArrayList<String> rresult = coinChangeResusiveMemo(denoms, amt - denoms[i], QB);

            for (String s : rresult) {
                mresult.add(s + denoms[i]);
            }


        }
        QB[amt] = mresult;
//        System.out.println(mresult);
        return mresult;

    }

    public static ArrayList<String> coinChangeResusiveMemoLastIndex(int denoms[], int amt, ArrayList<String> QB[][], int li) {

        if (amt == 0) {
            ArrayList<String> bresult = new ArrayList();
            bresult.add("");
            return bresult;

        }
        if (amt < 0) {
            ArrayList<String> bresult = new ArrayList();
            return bresult;

        }
        if (QB[amt][li] != null)//change
            return QB[amt][li];

        ArrayList<String> mresult = new ArrayList();
        for (int i = li; i < denoms.length; i++) {//to stop permutation i=li
            ArrayList<String> rresult = coinChangeResusiveMemoLastIndex(denoms, amt - denoms[i], QB, i);

            for (String s : rresult) {
                mresult.add(s + denoms[i]);
            }


        }
        QB[amt][li] = mresult;//change
//        System.out.println(mresult);
        return mresult;

    }

    public static void coinChangePermutationTab(int arr[], int amt) {
        int strg[] = new int[amt + 1];
        ArrayList<String> path[] = new ArrayList[amt + 1];

        //Arrays.fill(path, new ArrayList());
        for (int i = 0; i < path.length; i++)
            path[i] = new ArrayList<>();
        strg[0] = 1;
        path[0].add("");
        for (int j = 1; j <= amt; j++) {
            for (int i = 0; i < arr.length; i++) {

                if (j >= arr[i]) {
                    strg[j] = strg[j] + strg[j - arr[i]];
                    for (String rstr : path[j - arr[i]]) {
                        //rstr += arr[i];
                        path[j].add(rstr + arr[i]);

                    }
                }

            }

        }
        System.out.println(strg[strg.length - 1]);
        System.out.println(path[path.length - 1]);


    }


    public static ArrayList<String> coinChangeResusiveMemoPermutation(int denoms[], int amt, ArrayList<String> QB[]) {

        if (amt == 0) {
            ArrayList<String> bresult = new ArrayList();
            bresult.add("");
            return bresult;

        }
        if (amt < 0) {
            ArrayList<String> bresult = new ArrayList();
            return bresult;

        }
        if (QB[amt] != null)
            return QB[amt];

        ArrayList<String> mresult = new ArrayList();
        for (int i = 0; i < denoms.length; i++) {
            ArrayList<String> rresult = coinChangeResusiveMemoPermutation(denoms, amt - denoms[i], QB);

            for (String s : rresult) {
                mresult.add(s + denoms[i]);
            }


        }
        QB[amt] = mresult;
        //System.out.println(mresult.size());

        return mresult;

    }


    public static void main(String str[]) {
        int arr[] = {2, 3, 5, 6};
        //coinChange(arr, 10);
        // System.out.println(coinChangeResusive(arr, 10));
        //System.out.println(coinChangeResusiveMemo(arr, 10, new ArrayList[11]));
        //only combination
//        System.out.println(coinChangeResusiveMemoLastIndex(arr, 10, new ArrayList[11][arr.length],0));
        //coinChangePermutationTab(arr, 10);
        System.out.println(coinChangeResusiveMemoPermutation(arr, 10, new ArrayList[11]));
        System.out.println(coinChangeResusiveMemoLastIndex(arr, 10, new ArrayList[11][arr.length], 0));

        //Permuation

    }


}

