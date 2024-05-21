package com.test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(spiralOrder(mat));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();

    int m = matrix.length;
    int n = matrix[0].length;
    int startRow = 0;
    int startCol = 0;
    int endRow = m - 1;
    int endCol = n - 1;


    while (startRow <= endRow && startCol <= endCol) {
      for (int i = startCol; i <= endCol; i++) {
        ans.add(matrix[startRow][i]);
        System.out.print(matrix[startRow][i]);
      }
      startRow++;

      for (int i = startRow; i <= endRow; i++) {
        ans.add(matrix[i][endCol]);
        System.out.print(matrix[i][endCol]);
      }
      endCol--;

      for (int i = endCol; i >= startCol; i--) {
        if (startRow == endRow) {
          break;
        }
        ans.add(matrix[endRow][i]);
        System.out.print(matrix[endRow][i]);
      }
      endRow--;

      for (int i = endRow; i >= startRow; i--) {
        if (startCol == endCol) {
          break;
        }
        ans.add(matrix[i][startCol]);
        System.out.print(matrix[i][startCol]);
      }
      startCol++;
    }

    return ans;
  }
}
