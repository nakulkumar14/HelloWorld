package com.company.leetcode;

import java.util.Arrays;

public class _733 {
  public static void main(String[] args) {
//    int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
    int image[][] = {{0,0,0},{0,0,0}};
    int sr = 0;
    int sc = 0;
    int newColor = 2;
    Solution solution = new Solution();
    for (int i = 0; i < image.length; i++) {
      System.out.print(Arrays.toString(image[i]));
      System.out.println();
    }
    solution.floodFill(image, sr, sc, newColor);
    System.out.println("Filled");
    for (int i = 0; i < image.length; i++) {
      System.out.print(Arrays.toString(image[i]));
      System.out.println();
    }
  }
}

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    boolean visited[][] = new boolean[image.length][image[0].length];
    int oldColor = image[sr][sc];
    if (oldColor != newColor)
      fillUtil(image, visited, sr, sc, newColor, oldColor);
    return image;
  }

  void fillUtil(int[][] image, boolean visited[][], int i, int j, int newColor, int oldColor) {
    visited[i][j] = true;
    image[i][j] = newColor;
    int r[] = {0,0,-1,1};
    int c[] = {1,-1,0,0};
    for(int k=0;k<4;k++) {
      if(isSafe(image, visited, i+r[k],j+c[k],oldColor))
        fillUtil(image, visited, i+r[k],j+c[k], newColor, oldColor);
    }
  }

  boolean isSafe(int[][] image, boolean visited[][], int i, int j, int oldColor) {
    return i>=0 && i < image.length
        && j>=0 && j < image[0].length
        && image[i][j]==oldColor && !visited[i][j];
  }
}
