package codingInterview.Recursion;

public class MinCostPathDP2 {


    static int countMemo = 0;

    public static int minCostPath(int sr, int sc, int dr, int dc, int cost[][]) {
        //E=F
        if (sr == dr && sc == dc) return cost[sr][sc];
        int cost1 = Integer.MAX_VALUE, cost2 = Integer.MAX_VALUE;
        if (sr < dr)
            cost1 = minCostPath(sr + 1, sc, dr, dc, cost);
        if (sc < dc)
            cost2 = minCostPath(sr, sc + 1, dr, dc, cost);
        if (cost1 < cost2)
            return cost1 + cost[sr][sc];//min cost s to d
        else
            return cost2 + cost[sr][sc];//min cost s to d

    }

    public static int minCostPathMem(int sr, int sc, int dr, int dc, int cost[][], int memo[][]) {

        if (sr == dr && sc == dc) return cost[sr][sc];

        int cost1 = Integer.MAX_VALUE, cost2 = Integer.MAX_VALUE;

        if (memo[sr][sc] != 0) return memo[sr][sc];
        System.out.println("Hello" + ++countMemo);
        if (sr < dr)
            cost1 = minCostPathMem(sr + 1, sc, dr, dc, cost, memo);
        if (sc < dc)
            cost2 = minCostPathMem(sr, sc + 1, dr, dc, cost, memo);
        if (cost1 < cost2)
            return memo[sr][sc] = cost1 + cost[sr][sc];//min cost s to d
        else
            return memo[sr][sc] = cost2 + cost[sr][sc];//min cost s to d

    }

    public static void minCostPathMemPath(int cost[][]) {
        int dr = cost.length - 1;
        int dc = cost[0].length - 1;
        int mcost[][] = new int[dr + 1][dc + 1];
        String Spath[][] = new String[dr + 1][dc + 1];
        int m = Integer.MAX_VALUE, n = Integer.MAX_VALUE;
        for (int r = dr; r >= 0; r--)
            for (int c = dc; c >= 0; c--) {
                int rp1 = r + 1;
                int cp1 = c + 1;
                if (r == dr && c == dc) {
                    mcost[r][c] = cost[r][c];
                    Spath[r][c] = ".";
                } else if (r == dr) {
                    mcost[r][c] = cost[r][c] + mcost[r][cp1];
                    Spath[r][c] = "H" + Spath[r][cp1];

                } else if (c == dc) {
                    mcost[r][c] = cost[r][c] + mcost[rp1][c];
                    Spath[r][c] = "V" + Spath[rp1][c];

                } else {
                    if (mcost[rp1][c] < mcost[r][cp1]) {
                        mcost[r][c] = cost[r][c] + mcost[rp1][c];
                        Spath[r][c] = "H" + Spath[r][cp1];

                    } else {
                        mcost[r][c] = cost[r][c] + mcost[r][cp1];
                        Spath[r][c] = "V" + Spath[rp1][c];
                    }
                    //mcost[r][c] = Math.min(m, n);


                }


            }
        System.out.println(Spath[0][0]);
        System.out.println(mcost[0][0]);

    }


    public static void main(String strp[]) {
        int n = 2;
        long s = System.currentTimeMillis();
        int mat[][] = {
                {
                        2, 3, 0, 4
                },
                {
                        0, 6, 5, 2
                },
                {
                        8, 0, 3, 7
                },
                {
                        2, 0, 4, 2
                }
        };
        //  System.out.println(minCostPath(0, 0, mat.length - 1, mat[0].length - 1, mat));
        //System.out.println(minCostPathMem(0, 0, mat.length - 1, mat[0].length - 1, mat, new int[mat.length][mat.length]));
        minCostPathMemPath(mat);


        long e = System.currentTimeMillis();
        //System.out.println(e - s);
        return;
    }


}


