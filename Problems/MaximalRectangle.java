import java.util.*;

public class MaximalRectangle {
  static void lse(int[] lse, int[] h, int n) {
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && h[st.peek()] >= h[i])
        st.pop();
      if (st.isEmpty())
        lse[i] = 0;
      else
        lse[i] = st.peek() + 1;
      st.push(i);
    }
  }

  static void rse(int[] rse, int[] h, int n) {
    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && h[st.peek()] >= h[i])
        st.pop();
      if (st.isEmpty())
        rse[i] = n - 1;
      else
        rse[i] = st.peek() - 1;
      st.push(i);
    }
  }

  public int maximalRectangle(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        if (grid[i][j] == '0')
          continue;
        dp[i][j] = 1;
        if (i - 1 >= 0)
          dp[i][j] += dp[i - 1][j];
      }
    }
    int[][] lse = new int[m][n];
    int[][] rse = new int[m][n];
    for (int i = 0; i < m; i++) {
      lse(lse[i], dp[i], n);
      rse(rse[i], dp[i], n);
    }

    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int area = (rse[i][j] - lse[i][j] + 1) * dp[i][j];
        res = Math.max(res, area);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    char[][] grid = {
        { '1', '0', '1', '0', '0' },
        { '1', '0', '1', '1', '1' },
        { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' }
    };

    MaximalRectangle mr = new MaximalRectangle();
    int result = mr.maximalRectangle(grid);
    System.out.println("The area of the largest rectangle is: " + result);
  }
}
