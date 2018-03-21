package codingInterview.Recursion;

public class Maze {
    static int counter = 0;

    public static String pmp(int sr, int sc, int dr, int dc, String psf) {//print Board Path

        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return psf;
        }

        if (sr + 1 <= dr)
            pmp(sr + 1, sc, dr, dc, psf + "H");
        if (sc + 1 <= dc)
            pmp(sr, sc + 1, dr, dc, psf + "V");

        return psf;

    }

    public static String pmpHVD(int sr, int sc, int dr, int dc, String psf) {//print Board Path
        //proreactive
        if (sr == dr && sc == dc) {
            System.out.println(++counter + ". " + psf);
            return psf;
        }

        if (sr + 1 <= dr)
            pmpHVD(sr + 1, sc, dr, dc, psf + "H");
        if (sc + 1 <= dc)
            pmpHVD(sr, sc + 1, dr, dc, psf + "V");
        if (sc + 1 <= dc && sc + 1 <= dc)
            pmpHVD(sr + 1, sc + 1, dr, dc, psf + "D");

        return psf;

    }

    public static void pmpQueen(int sr, int sc, int dr, int dc, String psf) {//print Board Path
        //proreactive
        if (sr == dr && sc == dc) {
            System.out.println(++counter + ". " + psf);
            return;
        }


        for (int i = 1; i <= dr - sr; i++)//col
            pmpQueen(sr + i, sc, dr, dc, psf + "V" + i);
        for (int i = 1; i <= dc - sc; i++)//row
            pmpQueen(sr, sc + i, dr, dc, psf + "H" + i);
        for (int i = 1; i <= dc - sc && i <= dr - sr; i++)
            pmpQueen(sr + i, sc + i, dr, dc, psf + "D" + i);

        return;

    }

    public static void floodfill(int sr, int sc, int maze[][], boolean visited[][], String psf) {//print Board Path
        //reactive-Postice

        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(++counter + ". " + psf);
            return;

        }
        if (sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length) return;
        if (maze[sr][sc] == 0) return;
        if (visited[sr][sc] == true) return;
        visited[sr][sc] = true;
        //down
        floodfill(sr + 1, sc, maze, visited, psf + "D");
        //left
        floodfill(sr, sc - 1, maze, visited, psf + "L");
        //top
        floodfill(sr - 1, sc, maze, visited, psf + "T");
        //right
        floodfill(sr, sc + 1, maze, visited, psf + "R");

        visited[sr][sc] = false;
        return;

    }


    public static String pmpreactive(int sr, int sc, int dr, int dc, String psf) {//print Board Path

        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return psf;
        }
        //Speration of concern
        if (sr > dr || sc > dr)
            return "";


        pmpreactive(sr + 1, sc, dr, dc, psf + "H");
        pmpreactive(sr, sc + 1, dr, dc, psf + "V");

        return psf;

    }


    public static void main(String str[]) {

        //System.out.println(pmp(0, 0, 2, 2, ""));
        //System.out.println(pmpreactive(0, 0, 2, 2, ""));
        //System.out.println(pmpHVD(0, 0, 2, 2, ""));
        int maze[][] = {
                {
                        1, 0, 1, 1
                },
                {
                        1, 1, 1, 1
                },
                {
                        1, 0, 1, 1
                },
                {
                        1, 1, 0, 1
                }

        };
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        //pmpQueen(0, 0, 3, 3, "");
        floodfill(0, 0, maze, visited, "");

    }

}


