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

    }


}



