import java.util.*;

public class SortStack {
  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    for (int i = 1; i < 10; i++) {
      st.push(i);
    }
    printStack(st);
    sortStack(st);
    // printStack(st);
  }

  static void sortStack(Stack<Integer> st) {
    Stack<Integer> store = new Stack<>();
    while (!st.isEmpty()) {
      store.push(st.pop());
    }
    Stack<Integer> temp = new Stack<>();
    while (!store.isEmpty()) {
      int val = store.pop();
      if (st.isEmpty()) {
        st.push(val);
        System.out.println(val);
      } else {
        while (!st.isEmpty() && st.peek() > val) {
          temp.push(st.pop());
        }
        st.push(val);
        System.out.println(val);
        while (!temp.isEmpty()) {
          st.push(temp.pop());
        }
      }
    }
  }

  static void printStack(Stack<Integer> st) {
    ArrayList<Integer> arr = new ArrayList<>();
    while (!st.isEmpty()) {
      int val = st.pop();
      System.out.print(val + "->");
      arr.add(val);
    }
    for (int i = arr.size() - 1; i >= 0; i--) {
      st.push(arr.get(i));
    }
    System.out.println();
  }
}