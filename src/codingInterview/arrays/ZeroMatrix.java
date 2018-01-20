package codingInterview.arrays;

public class ZeroMatrix {


    private static void printMatrix(int mat[][]) {


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j]);
            System.out.println();

        }
        //space: O(1) time: O(NM)
    }


    private static void zeroMatrix(int mat[][]) {

        boolean row[] = new boolean[mat.length];
        boolean col[] = new boolean[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }


        }
        for (int j = 0; j < row.length; j++)
            if (row[j]) {
                for (int i = 0; i < mat[0].length; i++)
                    mat[j][i] = 0;
            }
        for (int j = 0; j < col.length; j++)
            if (col[j]) {
                for (int i = 0; i < mat.length; i++)
                    mat[i][j] = 0;
            }


        printMatrix(mat);
        //space: O(N) time: O(NM)
    }

    public static void main(String... str) {

//        System.out.println("Hello World!");
        int a[][] = {{1, 2, 3}, {0, 5, 6}, {7, 8, 9}};
        printMatrix(a);
        zeroMatrix(a);


    }


}
