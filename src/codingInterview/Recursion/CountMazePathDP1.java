package codingInterview.Recursion;

import java.util.Arrays;

public class CountMazePathDP1 {
    public static int countMazePath(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc)
            return 1;
        int csf = 0;
        if (sr + 1 <= dr)
            csf = countMazePath(sr + 1, sc, dr, dc);
        if (sc + 1 <= dc)
            csf += countMazePath(sr, sc + 1, dr, dc);
        return csf;

    }

    public static int countMazePathMemo(int sr, int sc, int dr, int dc, int QB[][]) {

        if (sr == dr && sc == dc)
            return 1;
        int csf = 0;
        if (QB[sr][sc] != 0) return QB[sr][sc];
        if (sr + 1 <= dr)
            csf = countMazePathMemo(sr + 1, sc, dr, dc, QB);
        if (sc + 1 <= dc)
            csf += countMazePathMemo(sr, sc + 1, dr, dc, QB);
        QB[sr][sc] = csf;
        return csf;

    }

    public static int countMazePathTabuLation(int dr, int dc) {
        int function[][] = new int[dr + 1][dc + 1];

        function[dr][dc] = 1;
        for (int i = dr; i >= 0; i--)
            for (int j = dc; j >= 0; j--) {
                if (i == dr && j == dc)
                    function[i][j] = 1;//Last Cell
                else if (i == dr)
                    function[i][j] = function[i][j + 1];//Last Row except last cell
                else if (j == dc)
                    function[i][j] = function[i + 1][j];//Last Col except last cell
                else
                    function[i][j] = function[i + 1][j] + function[i][j + 1];


                //function[i][j] = function[i + 1][j] + function[i][j + 1] ;
            }

        return function[0][0];

    }

    public static int countMazePathSilder(int dr, int dc) {
        int silder[] = new int[dc + 1];//Last row
        Arrays.fill(silder, 1);

        for (int i = 0; i < dr; i++) {
            for (int c = silder.length - 2; c >= 0; c--) {
                int nv = silder[c] + silder[c + 1];
                silder[c] = nv;
            }

        }

        return silder[0];

    }


    public static void main(String str[]) {
        int n = 2;
        System.out.println(countMazePathSilder(n, n));
        System.out.println(countMazePathTabuLation(n, n));
        System.out.println(countMazePathMemo(0, 0, n, n, new int[n + 1][n + 1]));
        System.out.println(countMazePath(0, 0, n, n));

        return;
    }


}


