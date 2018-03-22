package codingInterview.Recursion;

public class PermutationQueeninBox {

    //4 Box 2 Queen nP2 12 =4!2! =n!/n-r!

    //4C2 2!=4P2
    //n Box r Queen ---nPr=nCr*r!

    //Photograph_Proposer
    //n,r(total no of Queen),Queen Place so far,
    //Eular path
    static int c = 0;

    public static void permutation(boolean boxes[], int tq, int qpsf, String asf) {

        if (tq == qpsf) {
            System.out.println(++c + "." + asf);
            return;
        }

        for (int i = 0; i < boxes.length; i++) {

            if (boxes[i] == false) {
                boxes[i] = true;
                permutation(boxes, tq, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + i + ",");
                boxes[i] = false;

            }
            //remove remove
        }

    }

    public static void combination(boolean boxes[], int tq, int qpsf, String asf, int lpq) {

        if (tq == qpsf) {
            System.out.println(++c + "." + asf);
            return;
        }

        for (int i = 1 + lpq; i < boxes.length; i++) {

            if (boxes[i] == false) {
                boxes[i] = true;
                combination(boxes, tq, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + i + ",", i);
                boxes[i] = false;

            }
            //remove remove
        }

    }

    public static void coinChangeCombination(int denoms[], int amt, int lpi, String asf) {

        if (amt == 0) {
            System.out.println(++c + "." + asf);
            return;
        }

        for (int inst = lpi; inst < denoms.length; inst++) {

            if (amt >= denoms[inst])
                coinChangeCombination(denoms, amt - denoms[inst], inst, asf + denoms[inst]);

            //remove remove
        }
        return;

    }

    public static void coinChangeCombinationPermutation(int denoms[], int amt, int lpi, String asf) {

        if (amt == 0) {
            System.out.println(++c + "." + asf);
            return;
        }

        for (int inst = 0; inst < denoms.length; inst++) {

            if (amt >= denoms[inst])
                coinChangeCombinationPermutation(denoms, amt - denoms[inst], inst, asf + denoms[inst]);

            //remove remove
        }
        return;

    }

    public static void main(String[] args) {

        boolean boxes[] = new boolean[4];
        //permutation(boxes, 6, 0, "");
        //combination(boxes, 2, 0, "",-1);
        // coinChangeCombination(new int[]{2, 3, 5, 6}, 10, 0, "");
        coinChangeCombinationPermutation(new int[]{2, 3, 5, 6}, 10, 0, "");

    }

}