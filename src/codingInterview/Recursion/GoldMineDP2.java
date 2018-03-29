package codingInterview.Recursion;

public class GoldMineDP2 {

    private static void digMine(int mine[][]) {

        int smine[][] = new int[mine.length][mine[0].length];
        String sminePath[][] = new String[mine.length][mine[0].length];

        int max = Integer.MIN_VALUE;
        int mr = -1;
        int mc = -1;
        for (int c = mine[0].length - 1; c >= 0; c--) {
            for (int r = 0; r < mine.length; r++) {
                int rp1 = r + 1;
                int rm1 = r - 1;
                int cp1 = c + 1;
                if (c == mine[0].length - 1) {
                    smine[r][c] = mine[r][c];
                    sminePath[r][c] = r + "," + c + "|";
                } else if (r == 0) {
                    if (smine[r][cp1] > smine[rp1][cp1]) {
                        smine[r][c] = mine[r][c] + smine[r][cp1];
                        sminePath[r][c] = r + "," + c + "|" + sminePath[r][cp1];
                    } else {
                        smine[r][c] = mine[r][c] + smine[rp1][cp1];
                        sminePath[r][c] = r + "," + "|" + c + sminePath[rp1][cp1];
                    }


                } else if (r == mine.length - 1) {
                    if (smine[r][cp1] > smine[rm1][cp1]) {
                        smine[r][c] = mine[r][c] + smine[r][cp1];
                        sminePath[r][c] = r + "," + c + "|" + sminePath[r][cp1];
                    } else {
                        smine[r][c] = mine[r][c] + smine[rm1][cp1];
                        sminePath[r][c] = r + "," + c + "|" + sminePath[rm1][cp1];
                    }
                } else {
                    if (smine[r][cp1] > smine[rm1][cp1] && smine[r][cp1] > smine[rp1][cp1]) {
                        smine[r][c] = mine[r][c] + smine[r][cp1];
                        sminePath[r][c] = r + "," + c + "|" + sminePath[r][cp1];
                    } else if (smine[rm1][cp1] > smine[r][cp1] && smine[rm1][cp1] > smine[rp1][cp1]) {
                        {
                            smine[r][c] = mine[r][c] + smine[rm1][cp1];
                            sminePath[r][c] = r + "," + c + "|" + sminePath[rm1][cp1];
                        }
                    } else {
                        smine[r][c] = mine[r][c] + smine[rp1][cp1];
                        sminePath[r][c] = r + "," + c + "|" + sminePath[rp1][cp1];
                    }

                }
                if (max < smine[r][c]) {
                    max = smine[r][c];
                    mr = r;
                    mc = c;

                }


            }

        }

        System.out.println(max + "@" + sminePath[mr][mc]);
        return;
    }

    private static int digMineRecusive(int mine[][], int r, int c) {

        if (c == mine[0].length - 1) return mine[r][c];
        int max = Integer.MIN_VALUE;
        int tr = 0, mr = 0, br = 0;
        if (r > 0)
            br = digMineRecusive(mine, r - 1, c + 1);
        if (r < mine.length - 1)
            tr = digMineRecusive(mine, r + 1, c + 1);
        mr = digMineRecusive(mine, r, c + 1);

        return Math.max(Math.max(tr, mr), br) + mine[r][c];

    }

    private static int digMineMemo(int mine[][], int r, int c, int QB[][]) {

        if (c == mine[0].length - 1) return mine[r][c];
        if (QB[r][c] != 0) return QB[r][c];
        int max = Integer.MIN_VALUE;
        int tr = 0, mr = 0, br = 0;
        if (r > 0)
            br = digMineMemo(mine, r - 1, c + 1, QB);
        if (r < mine.length - 1)
            tr = digMineMemo(mine, r + 1, c + 1, QB);
        mr = digMineMemo(mine, r, c + 1, QB);
        QB[r][c] = Math.max(Math.max(tr, mr), br) + mine[r][c];
        return QB[r][c];

    }


    public static void main(String strp[]) {
        int mat[][] = {
                {
                        2, 6, 0, 5
                },
                {
                        0, 7, 5, 2
                },
                {
                        3, 0, 3, 7
                },
                {
                        8, 0, 2, 3
                }
        };
        digMine(mat);
        int oMax = 0;
        int QB[][] = new int[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            //int rMax = digMineMemo(mat, r, 0);
            int rMax = digMineMemo(mat, r, 0, QB);
            System.out.println(rMax);
            if (rMax > oMax)
                oMax = rMax;
        }
        System.out.println("--->" + oMax);

    }


}



