package codingInterview.arrays;

public class RotateMatrix {

    /*
    Algo steps:Layer 1..n/2 logic
    1.temp=Top//save top
    2.Top=left
    3.left=bottom
    4.bottom=right
    5.right=top
    */

    private static void rotateMatrix(int mat[][]) {
        if (mat.length == 0 || mat.length != mat[1].length) {
            System.out.println("Not a Square Matrix");
            return;
        }
        printMatrix(mat);
        int n = mat.length;
        for (int l = 0; l < n / 2; l++) {
            int first = l, last = n - 1 - l;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = mat[first][i];
                mat[first][i] = mat[last - offset][first];
                mat[last - offset][first] = mat[last][last - offset];
                mat[last][last - offset] = mat[i][last];
                mat[i][last] = top;
            }


        }
//space: O(1) time: O(N^2)
        printMatrix(mat);
    }


    private static void printMatrix(int mat[][]) {


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j]);
            System.out.println();

        }
        //space: O(1) time: O(N^2)
    }


    public static void main(String... str) {

//        System.out.println("Hello World!");
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(a);


    }


}
