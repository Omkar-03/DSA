package Arrays2D;

public class Matrices {

    public static void spiral(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int startrow = 0, startcol = 0, endrow = n - 1, endcol = m - 1;

        while (startrow <= endrow && startcol <= endcol) {
            // top
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }

            // right
            for (int i = startrow + 1; i <= endrow; i++) {
                System.out.print(matrix[i][endcol] + " ");
            }

            // bottom
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[endrow][j] + " ");
            }

            // left
            for (int i = endrow - 1; i >= startrow + 1; i--) {
                if (startcol == endcol) {
                    break;
                }
                System.out.print(matrix[i][startcol] + " ");
            }

            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
    }

    public static void diagonal_sum(int matrix[][]) {
        int sum = 0;

        // Brute Force Time Complexity = O(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix.length; j++) {
        // if (i == j) {
        // sum += matrix[i][j];
        // } else if ((i + j) == matrix.length - 1) {
        // sum += matrix[i][j];
        // }
        // }
        // }

        // Time Complexity = O(n)
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - i - 1) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        System.out.println("The sum of diagonal of matrix is " + sum);
    }

    public static void print(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void search(int matrix[][], int key) { // Time complexity = O(n+m)
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (key == matrix[row][col]) {
                System.out.println("Element found at cell " + "(" + row + "," + col + ")");
                break;
            } else if (key < matrix[row][col]) {
                col--;
            } else if (key > matrix[row][col]) {
                row++;
            }
        }
        System.out.println("Element not found !!!");

        // int row = matrix.length - 1, col = 0;
        // while (row >= 0 && col < matrix[0].length) {
        // if (key == matrix[row][col]) {
        // System.out.println("Element found at cell " + "(" + row + "," + col + ")");
        // break;
        // } else if (key < matrix[row][col]) {
        // row--;
        // } else (key > matrix[row][col]) {
        // col++;
        // }
        // }
        // System.out.println("Element not found !!!");
    }

    public static void transpose(int matrix[][]) {
        int trans[][] = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix_1[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
                14, 15, 16 } };
        // int matrix_1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, {
        // 13, 14, 15 } };

        // print(matrix_1);
        // spiral(matrix_1);

        int matrix_2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
                14, 15, 16 } };
        // print(matrix_2);
        // diagonal_sum(matrix_2);

        int matrix_3[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, // sorted matrix
                33, 39, 50 } };
        // print(matrix_3);
        // search(matrix_3, 34); // Staircase search

        int matrix[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 }, { 2, 3, 4 } };
        transpose(matrix);
    }
}