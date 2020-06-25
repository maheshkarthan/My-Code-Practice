package com.matrix.matrixs;

public class AntiClockwiseMatrixRotate {
    public static void main(String args[]) {

        int matrix[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int N = 3; // mxn value
        antiClockwiseMatrixRotateMethod(N, matrix);
        displayMatrix(N, matrix);
    }

    private static void antiClockwiseMatrixRotateMethod(int N, int[][] matrix) {
        // Consider all squares one by one for 3X3 we have 2 squares
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N - x - 1; y++) {
                // store current cell in temp variable
                int temp = matrix[x][y];

                // move values from rightTop to leftTop
                matrix[x][y] = matrix[y][N - 1 - x];

                // move values from bottom to right
                matrix[y][N - 1 - x] = matrix[N - 1 - x][N - 1 - y];

                // move values from left to bottom
                matrix[N - 1 - x][N - 1 - y] = matrix[N - 1 - y][x];

                // assign temp to left
                matrix[N - 1 - y][x] = temp;
            }
        }
    }

    static void displayMatrix(int N, int matrix[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + matrix[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
