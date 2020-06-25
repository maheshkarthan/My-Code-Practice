package zTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxKingMoves {

    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int cases = 0; cases < testCases; cases++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            char[][] formedMatrix = new char[matrixSize][matrixSize];
            String matrinInputValues = null;
            for (int m = 0; m < matrixSize; m++) {
                matrinInputValues = scanner.nextLine();
                StringTokenizer tok = new StringTokenizer(matrinInputValues, " ");
                for (int n = 0; n < matrixSize; n++) {
                    formedMatrix[m][n] = tok.nextToken().charAt(0);
                }
            }
            //System.out.print(Arrays.toString(formedMatrix));
            /*int count = 0;
            int addValue = 0;
            for (int row = matrixSize-1; row > 0; row--) {
                for (int col = matrixSize-1; col > 0; col--) {
                    char val = formedMatrix[row][col];
                    if ((row -1 > 0 && formedMatrix[row-1][col] != 'x') || (col - 1 > 0 && formedMatrix[row][col-1] != 'x')) {
                        if (row -1 > 0 && Integer.parseInt(""+formedMatrix[row-1][col]) > Integer.parseInt(""+formedMatrix[row][col-1])) {
                            addValue = Integer.parseInt(""+formedMatrix[row-1][col]);
                            row = row - 1;
                        } else if () {
                            addValue = Integer.parseInt(""+formedMatrix[row][col-1]);
                            col = col - 1;
                        }
                        if (formedMatrix[row-1][col] == formedMatrix[row][col-1]) {
                            count ++;
                        } else {
                            count --;
                        }
                    }
                }
            }*/
         // construct a matrix to keep track of visited cells
            int[][] visited= new int[matrixSize][matrixSize];
            M = matrixSize;
            N = matrixSize;
            int maxValue = findLongestPath(formedMatrix, visited, matrixSize-1, matrixSize-1, 0, 0, 0, 0);
                    System.out.println(maxValue/2+" "+(aa-1)/(matrixSize*1000));
        }
    }
    
 // M x N matrix
    private static int M;
    private static int N;

    // check if it is possible to go to position (x, y) from
    // current position. The function returns false if the cell
    // has value 0 or it is already visited.
    private static boolean isSafe(char mat[][], int visited[][], int x, int y)
    {
        if (mat[x][y] == 'x' || visited[x][y] != 0)
            return false;

        return true;
    }

    // if not a valid position, return false
    private static boolean isValid(int x, int y)
    {
        if (x < M && y < N && x >= 0 && y >= 0)
            return true;

        return false;
    }
    static int aa =0;
    
    // Find Longest Possible Route in a Matrix mat from source
    // cell (0, 0) to destination cell (x, y)
    // 'max_dist' stores length of longest path from source to
    // destination found so far and 'dist' maintains length of path from
    // source cell to the current cell (i, j)
    public static int findLongestPath(char mat[][], int visited[][], int i,
                                int j, int x, int y, int max_dist, int dist)
    {
        if(mat[i][j] == 'x') {
            return 0;
        }
        // if destination is found, update max_dist
        if (i == x && j == y)
        {
            return Math.max(dist, max_dist);
        }

        // set (i, j) cell as visited
        visited[i][j] = 1;

        // go to bottom cell
     /*   if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
            max_dist = findLongestPath(mat, visited, i + 1, j, x, y,
                                        max_dist, dist + 1);
        }

        // go to right cell
        if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
            max_dist = findLongestPath(mat, visited, i, j + 1, x, y,
                                        max_dist, dist + 1);
        }*/

        // go to top cell
        if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
            max_dist = findLongestPath(mat, visited, i - 1, j, x, y,
                                        max_dist, dist + 1);
            aa = aa+ mat[i][j];
        }

        // go to left cell
        if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
            max_dist = findLongestPath(mat, visited, i, j - 1, x, y,
                                        max_dist, dist + 1);
            aa = aa+ mat[i][j];
        }
        
     // go to left diagonal cell
        if (isValid(i - 1, j - 1) && isSafe(mat, visited, i - 1, j - 1)) {
            max_dist = findLongestPath(mat, visited, i - 1, j - 1, x, y,
                                        max_dist, dist + 1);
            aa = aa+ mat[i][j];
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;

        return max_dist;
    }
}
