package codingInterview.Recursion;

public class MinSizeSquare1DP2 {


    static int countMemo = 0;
    static int omax = 0;
    static int ormax = -1;
    static int ocmax = -1;

    public static void maxSquareSubMatrixTabulation(int mat[][]) {
        int strg[][] = new int[mat.length][mat[0].length];
        int dr = strg.length - 1;
        int dc = strg[0].length - 1;
        int max = 0;
        int orMax = -1;
        int ocMax = -1;
        for (int r = dr; r >= 0; r--)
            for (int c = dc; c >= 0; c--) {
                int rp1 = r + 1;
                int cp1 = c + 1;
                if (r == dr && c == dc) {
                    strg[r][c] = mat[r][c];
                } else if (r == dr) {
                    strg[r][c] = mat[r][c];

                } else if (c == dc) {
                    strg[r][c] = mat[r][c];
                } else {
                    if (mat[r][c] == 0)
                        strg[r][c] = 0;
                    else {
                        strg[r][c] = 1 + Math.min(Math.min(strg[r][cp1], strg[rp1][c]), strg[rp1][cp1]);
//Math.min(Math.min(strg[rp1][c], strg[rp1][cp1]), strg[r][cp1]);
                    }


                }
                if (strg[r][c] >= max) {
                    max = strg[r][c];
                    orMax = r;
                    ocMax = c;
                }


            }
        System.out.println(max + "@[" + orMax + "," + ocMax + "]");

    }

    public static int maxSquareSubMatrixMemo(int mat[][], int sr, int sc) {

        int dr = mat.length - 1;
        int dc = mat[0].length - 1;

        if (sr == dr || sc == dc) return mat[dr][dc];
        if (mat[sr][sc] == 0) return mat[sr][sc];
        else {
            int max = 1 + Math.min(Math.min(
                    maxSquareSubMatrixMemo(mat, sr, sc + 1),
                    maxSquareSubMatrixMemo(mat, sr + 1, sc)),
                    maxSquareSubMatrixMemo(mat, sr + 1, sc + 1));
            if (omax < max) {
                omax = max;
                ormax = sr;
                ocmax = sc;
            }
            return max;
        }


    }

    public static int maxSquareSubMatrixMemoQB(int mat[][], int sr, int sc, int QB[][]) {

        int dr = mat.length - 1;
        int dc = mat[0].length - 1;

        if (sr == dr || sc == dc) return mat[dr][dc];
        if (mat[sr][sc] == 0) return mat[sr][sc];
        if (QB[sr][sc] != 0) return QB[sr][sc];
        else {
            int max = 1 + Math.min(Math.min(
                    maxSquareSubMatrixMemo(mat, sr, sc + 1),
                    maxSquareSubMatrixMemo(mat, sr + 1, sc)),
                    maxSquareSubMatrixMemo(mat, sr + 1, sc + 1));
            if (omax < max) {
                omax = max;
                ormax = sr;
                ocmax = sc;
            }
            QB[sr][sc] = 0;
            return max;
        }


    }


    public static void main(String strp[]) {
        int n = 2;
        long s = System.currentTimeMillis();
        int mat[][] = {
                {
                        1, 0, 1, 0, 0, 1
                },
                {
                        1, 0, 1, 1, 1, 1
                },
                {
                        1, 1, 1, 1, 1, 1
                },
                {
                        1, 1, 1, 1, 0, 0
                }
                ,
                {
                        1, 1, 1, 1, 1, 1
                },
                {
                        0, 0, 1, 1, 1, 0
                }
        };
        //  System.out.println(minCostPath(0, 0, mat.length - 1, mat[0].length - 1, mat));
        //System.out.println(minCostPathMem(0, 0, mat.length - 1, mat[0].length - 1, mat, new int[mat.length][mat.length]));
        maxSquareSubMatrixTabulation(mat);
        maxSquareSubMatrixMemo(mat, 0, 0);
        maxSquareSubMatrixMemoQB(mat, 0, 0, new int[mat.length][mat[0].length]);
        System.out.println(omax + "@" + ormax + "," + ocmax);
        omax = 0;
        maxSquareSubMatrixMemoQB(mat, 0, 0, new int[mat.length][mat[0].length]);
        System.out.println(omax + "@" + ormax + "," + ocmax);


        long e = System.currentTimeMillis();
        //System.out.println(e - s);
        return;
    }


}


