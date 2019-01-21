package Lecture14.RecursionInMazeGame;

/*Question : In Maze start 0,0 to 2,2; motion H(right) or V (down)
 * psv printMazePath(int sourceRow, int sourceCol,int destRow, int destCol,String pathSoFar) */

public class MazePath {
    //Proactive Approach
    private static void printMazePath(int sourceRow, int sourceCol, int destRow, int destCol, String pathSoFar) {

        if (sourceRow == destRow && sourceCol == destCol) {
            System.out.println(pathSoFar);
            return;
        }
        //Vertical call
        if (sourceRow + 1 <= destRow)
            printMazePath(sourceRow + 1, sourceCol, destRow, destCol, pathSoFar + "V");
        //Horizontal call
        if (sourceCol + 1 <= destCol)
            printMazePath(sourceRow, sourceCol + 1, destRow, destCol, pathSoFar + "H");

    }

    //Reactive Approach
    private static void printMazePath_reactive(int sourceRow, int sourceCol, int destRow, int destCol, String pathSoFar) {
        if (sourceRow == destRow && sourceCol == destCol) {
            System.out.println(pathSoFar);
            return;
        }
        if (sourceRow >= destRow || sourceCol >= destCol) {
            return;
        }
        printMazePath(sourceRow + 1, sourceCol, destRow, destCol, pathSoFar + "V");
        printMazePath(sourceRow, sourceCol + 1, destRow, destCol, pathSoFar + "H");


    }

    public static void main(String str[]) {

        //printMazePath(0, 0, 2, 2, "");
        printMazePath_reactive(0, 0, 2, 2, "");

    }

}
