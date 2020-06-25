package com.matrix.matrixs;

public class SpiralPrintofMatrix {

    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = { {1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        SpiralPrintofMatrix.spiralPrint(R, C, a);
    }

    static void spiralPrint(int rows, int cols, int a[][]) {
        int mRow = 0, nColumn = 0;

        while (mRow < rows && nColumn < cols) {

            for (int j = nColumn; j < cols; j++) {
                System.out.print(a[mRow][j] + " ");
            }
            mRow++;

            for (int k = mRow; k < rows; k++) {
                System.out.print(a[k][cols - 1] + " ");
            }
            cols--;
            if (mRow < rows) {
                for (int l = cols - 1; l >= nColumn; l--) {
                    System.out.print(a[rows - 1][l] + " ");
                }
                rows--;
            }
            if (nColumn < cols) {
                for (int m = rows - 1; m >= mRow; m--) {
                    System.out.print(a[m][nColumn] + " ");
                }
                nColumn++;
            }
        }
    }

}
