/**
 * 2.2 - Design a stack in which, in addition to a pop and push, has a function min
 *  which returns the minimum element in O(1) time.
 * 
 * Solution: An additional stack is maintained which keeps a stack of the min values.
 *  Anytime a value is pushed to the main stack, it's value is compared to the top
 *  of the minStack. If the value is less than the head, the value is pushed to the
 *  minStack. Similarly, whenever a value is popped from the main stack, it's value
 *  is compared to the top of the minStack. If the two are equal, then the top of 
 *  the minStack is popped, leaving the next closest min at the top of the minStack.
 */
public class StackWithMin extends Stack<Integer> {
  Stack<Integer> minStack;

  public StackWithMin() {
    this.minStack = new Stack<Integer>();
  }

  public StackWithMin(boolean verbose) {
    this.verbose = verbose;
    this.minStack = new Stack<Integer>();
  }

  public void push(int value) {
    if (value <= min()) {
      minStack.push(value);
    }
    super.push(value);
  }

  public Integer pop() {
    int value = super.pop();
    if (value == min()) {
      minStack.pop();
    }
    return value;
  }

  public int min() {
    return this.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
  }

  public void print() {
    StackNode trace = this.top;

    if (trace != null) {
      System.out.print("MIN: " + minStack.top.data + "\tVALUES: ");
    }

    while (trace != null) {
      System.out.print(trace.data);
      if (trace.next != null) {
        System.out.print(" -> ");
      }
      trace = trace.next;
    }
    System.out.print('\n');
  }



  /**
   * Example Usage
   */
  public static void main(String[] args) {
    StackWithMin stack = new StackWithMin(true);
    stack.push(5);
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(2);
  }
}
