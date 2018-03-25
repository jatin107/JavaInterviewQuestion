package codingInterview.Recursion;

import java.util.ArrayList;

public class SubSet {

    static int c = 0;

    public static void printSubSet(int Arr[], int sum, int vt, int setsum, String set) {
        if (vt == Arr.length) {
            if (sum == setsum)
                System.out.println(set);
            return;
        }
        printSubSet(Arr, sum, vt + 1, setsum + Arr[vt], set + " " + Arr[vt]);
        printSubSet(Arr, sum, vt + 1, setsum, set);

    }

    public static void printSubSetArraylist(int Arr[], int sum, int vt, int setsum, ArrayList<Integer> set) {
        if (vt == Arr.length) {
            if (sum == setsum)
                System.out.println(set);
            return;
        }
        set.add(Arr[vt]);
        printSubSetArraylist(Arr, sum, vt + 1, setsum + Arr[vt], set);
        set.remove(set.size() - 1);
        printSubSetArraylist(Arr, sum, vt + 1, setsum, set);

    }

    public static void printSubSetSumArraylist(int Arr[], int set1sum, int vt, int set2sum, ArrayList<Integer> set1, ArrayList<Integer> set2) {
        if (vt == Arr.length) {
            if (set1sum == set2sum)
                System.out.println(++c + "" + set1 + ":" + set2);
            return;
        }
        set1.add(Arr[vt]);
        printSubSetSumArraylist(Arr, set1sum + Arr[vt], vt + 1, set2sum, set1, set2);
        set1.remove(set1.size() - 1);
        set2.add(Arr[vt]);
        printSubSetSumArraylist(Arr, set1sum, vt + 1, set2sum + Arr[vt], set1, set2);
        set2.remove(set2.size() - 1);

    }

    public static void printEquiSetString(int Arr[], int set1sum, int vt, int set2sum, String set1, String set2) {
        if (vt == Arr.length) {
            if (set1sum == set2sum)
                System.out.println(set1 + ":" + set2sum);
            return;
        }
        printEquiSetString(Arr, set1sum + Arr[vt], vt + 1, set2sum, set1 + " " + Arr[vt], set2);

        printEquiSetString(Arr, set1sum, vt + 1, set2sum + Arr[vt], set1, set2 + " " + Arr[vt]);

    }


    public static void main(String strp[]) {
        //System.out.println(gss("ab"));
        int Arr[] = {10, 20, 30, 40, 50, 60, 70};
        //printSubSet(Arr, 70, 0, 0, "");
        ArrayList<Integer> al = new ArrayList<Integer>();
        //printSubSetArraylist(Arr, 70, 0, 0, new ArrayList<Integer>());
        //printSubSetSumArraylist(Arr, 0, 0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
        printEquiSetString(Arr, 0, 0, 0, "", "");
    }

}
