package codingInterview.Recursion;

public class NQueen {
    //Classical Question
    //Place Queen such that No Queen kill each Other
    //1. Generate combination
    //2.check the combination is valid or not?
    //Reactive vs Proactive
    //Slow vs fast

    static int c = 0;

    public static void nQueen(boolean chess[][], int qpsf, String asf, int lpq) {
        if (qpsf == chess.length) {
//    System.out.println(++c + "." + asf);
            if (isBoardValid(chess) == true)
                System.out.println(++c + "." + asf);
            return;
        }

        for (int i = 1 + lpq; i < chess.length * chess.length; i++) {

            int r = i / chess.length;
            int c = i % chess.length;
            if (chess[r][c] == false) {
                chess[r][c] = true;
                nQueen(chess, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + i + " , ", i);
                chess[r][c] = false;

            }

        }
        return;

    }

    public static void nQueenProactive(boolean chess[][], int qpsf, String asf, int lpq) {
        if (qpsf == chess.length) {
//    System.out.println(++c + "." + asf);
            //if (isBoardValid(chess) == true)
            System.out.println(++c + "." + asf);
            return;
        }

        for (int i = 1 + lpq; i < chess.length * chess.length; i++) {

            int r = i / chess.length;
            int c = i % chess.length;
            if (chess[r][c] == false) {
                if (isQueesSave(chess, r, c) == true) {
                    chess[r][c] = true;
                    nQueenProactive(chess, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + i + " , ", i);
                    chess[r][c] = false;
                }

            }

        }
        return;

    }

    public static void nQueenPSubSequence(boolean chess[][], int box, int qpsf, String asf) {
        if (qpsf == chess.length) {
            //    System.out.println(++c + "." + asf);
            //if (isBoardValid(chess) == true)
            System.out.println(++c + "." + asf);
            return;
        }
        if (box >= chess.length * chess.length)
            return;
        nQueenPSubSequence(chess, box + 1, qpsf, asf);
        int r = box / chess.length;
        int c = box % chess.length;
        if (isQueesSave(chess, r, c) == true) {
            chess[r][c] = true;
            nQueenPSubSequence(chess, box + 1, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + box + " ,");
            chess[r][c] = false;
        }
        return;

    }

    public static boolean isBoardValid(boolean chess[][]) {
        for (int r = 0; r < chess.length; r++) {
            for (int c = 0; c < chess[r].length; c++) {
                if (chess[r][c] == true) {
                    if (isQueesSave(chess, r, c) == false)
                        return false;
                }

            }

        }
        return true;
    }

    public static boolean isQueesSave(boolean chess[][], int r, int c) {
        int dirs[][] = {
                {0, -1},//North
                {1, -1},//NE
                {1, 0},//East
                {1, 1},//SE
                {0, 1},//S
                {-1, 1},//SW
                {-1, 0},//W
                {-1, -1},//NW
        };
        for (int di = 0; di < dirs.length; di++) {
            for (int dist = 1; true; dist++) {
                int eqcol = c + dist * dirs[di][0];//col r
                int eqrow = r + dist * dirs[di][1];//row c
                if (eqcol < 0 || eqrow < 0 || eqcol >= chess[0].length || eqrow >= chess.length)
                    break;
                if (chess[eqrow][eqcol] == true)
                    return false;

            }

        }
        return true;
    }

    public static void main(String[] args) {

        boolean chess[][] = new boolean[4][4];
        //permutation(boxes, 6, 0, "");
        long st = System.currentTimeMillis();
        //nQueen(chess, 0, "", -1);
        long end = System.currentTimeMillis();
        //nQueenProactive(chess, 0, "", -1);
        long end2 = System.currentTimeMillis();
        nQueenPSubSequence(chess, 0, 0, "");
        long end3 = System.currentTimeMillis();
        System.out.println("1" + (end - st));
        System.out.println("2" + (end2 - end));
        System.out.println("2" + (end3 - end2));
        // coinChangeCombination(new int[]{2, 3, 5, 6}, 10, 0, "");


    }

}