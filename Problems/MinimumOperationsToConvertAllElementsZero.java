public
package Problems;

import java.util.Stack;

class MinimumOperationsToConvertAllElementsZero {
  public int minOperations(int[] nums) {
    Stack<Integer> st = new Stack<>();
    int ops = 0;
    for (int num : nums) {
      while (!st.isEmpty() && st.peek() > num) {
        st.pop();
      }

      if (num == 0) {
        continue;
      }

      if (st.isEmpty() || st.peek() < num) {
        st.push(num);
        ops++;
      }
    }
    return ops;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = scanner.nextInt();
    }
    MinimumOperationsToConvertAllElementsZero solution = new MinimumOperationsToConvertAllElementsZero();
    int result = solution.minOperations(nums);
    System.out.println(result);
    scanner.close();
  }
}