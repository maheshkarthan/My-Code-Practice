package zTest;

/* Read input from STDIN. Print your output to STDOUT */

import java.io.*;
import java.util.*;

public class CandidateCode {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] formedMatrix = new char[matrixSize][matrixSize];
        String matrinInputValues[] = new String[matrixSize];
        int m = -1, n = 0;
        R = C = matrixSize;
        // System.out.print(matrixSize);
        for (int i = 0; i < matrixSize; i++) {
            matrinInputValues[i] = scanner.nextLine();
            StringTokenizer tok = new StringTokenizer(matrinInputValues[i], "#");
            m++;
            while (tok.hasMoreTokens()) {
                for (; m < matrixSize; m++) {
                    for (; n < matrixSize; n++) {
                        formedMatrix[m][n] = tok.nextToken().charAt(0);
                        // System.out.print(formedMatrix[m][n]);
                    }
                }
                n = 0;
                m = 0;
            }

        }
        String word = scanner.nextLine();
        patternSearch(formedMatrix, word);
    }

    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    // Searches given word in a given
    // matrix in all 8 directions
    static void patternSearch(char[][] grid, String word) {
        // Consider every point as starting
        // point and search given word
        int count = 0;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                // if (search2D(grid, row, col, word)){
                count += findPath(grid, word, row, col, 0);
                // System.out.println("pattern found at " + row + ", " + col);\
                // }
            }
        }
        System.out.print(count);
    }

    static int R, C;

    public static int findPath(char[][] map, String target, int startX, int startY, int targetIndex) {

        if (startX < 0 || startY < 0 || startX >= map.length || startY >= map[startX].length) {
            return 0;
        }

        char original = map[startX][startY];

        if (original != target.charAt(targetIndex))
            return 0;

        if (targetIndex == target.length() - 1)
            return 1;

        int count = 0;
        map[startX][startY] = '\0'; // avoid return back to visited node

        count += findPath(map, target, startX + 1, startY, targetIndex + 1);
        count += findPath(map, target, startX, startY + 1, targetIndex + 1);
        count += findPath(map, target, startX - 1, startY, targetIndex + 1);
        count += findPath(map, target, startX, startY - 1, targetIndex + 1);

        map[startX][startY] = original;
        return count;
    }
}

/*
5
5
-1 7 8 -5 4 
4
3 2 1 -1    
4
11 12 -2 -1 
4
4 5 4 3 
4
5 10 4 -1
Output
48
13
12
44
10
Explanation
Test Case 1: Maximum sum which can be formed is 12. Element considered 8, 4. Note that Output is printed from the reverse side of the array which is TRUE for all the test cases without the space. So, the output is 48.
Test Case 2: Maximum sum which can be formed is 4. Element considered 3, 1. Output = 13.
Test Case 3: Maximum sum which can be formed is 12 as by taking any other element value of maximum sum decreases.
Test Case 4: Maximum sum which can be formed is 8 by taking 3, 5 or 4, 4. But the output is 4, 4 as 3 is smaller than 4.
Test Case 5: Maximum sum which can be formed is 10. 



1000 500 800 600 900

2700

9008001000
 */