public class TheCelebrityProblem {
  public static void main(String[] args) {
    int[][] arr = { { 0, 0, 1, 0 },
        { 0, 0, 1, 0 },
        { 0, 0, 0, 0 },
        { 0, 0, 1, 0 } };
    System.out.println(celebrity(arr));
  }

  static int celebrity(int mat[][]) {
    int n = mat.length;
    int top = 0, down = n - 1;
    while (top < down) {
      if (mat[top][down] == 1) {
        top++;
      } else {
        down--;
      }
    }

    int knows = 0, knownBy = 0;
    for (int i = 0; i < n; i++) {
      if (mat[i][top] == 1 && i != top) {
        knownBy++;
      }
    }

    for (int j = 0; j < n; j++) {
      if (mat[top][j] == 1 & j != top) {
        knows++;
      }
    }

    if (knows == 0 && knownBy == n - 1)
      return top;
    return -1;
  }
}

class Solution {
  static int[] onesCountByRow(int[][] mat, int n) {
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 1 && i != j) {
          count++;
        }
      }
      res[i] = count;
    }
    return res;
  }

  static int[] onesCountByCol(int[][] mat, int n) {
    int[] res = new int[n];
    for (int j = 0; j < n; j++) {
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (mat[i][j] == 1 && i != j) {
          count++;
        }
      }
      res[j] = count;
    }
    return res;
  }

  public int celebrity(int mat[][]) {
    int n = mat.length;
    int[] rows = onesCountByRow(mat, n);
    int[] cols = onesCountByCol(mat, n);
    int celebrity = -1;
    for (int i = 0; i < n; i++) {
      if (rows[i] == 0 && cols[i] == n - 1) {
        if (celebrity != -1) {
          return -1;
        }
        celebrity = i;
      }
    }
    return celebrity;
  }
}