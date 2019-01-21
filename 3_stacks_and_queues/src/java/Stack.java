import java.util.EmptyStackException;

/************************************************
 * Base Stack implementation
 ************************************************/

public class Stack<T> {
  protected static class StackNode<T> {
    protected T data;
    protected StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }

  protected StackNode<T> top;
  protected boolean verbose;

  public Stack() {
    this.top = null;
    this.verbose = false;
  }

  public Stack(boolean verbose) {
    this.top = null;
    this.verbose = verbose;
  }

  public T pop() {
    if (top == null) throw new EmptyStackException();
    T item = top.data;
    top = top.next;
    if (verbose) print();
    return item;
  }

  public void push(T item) {
    StackNode<T> t = new StackNode(item);
    t.next = top;
    top = t;
    if (verbose) {
      this.print();
    }
  }

  public T peek() {
    if (top == null) throw new EmptyStackException();
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void print() {
    StackNode trace = this.top;
    if (trace != null) {
      System.out.print("VALUES: ");

      while (trace != null) {
        System.out.print(trace.data);
        if (trace.next != null) {
          System.out.print(" -> ");
        }
        trace = trace.next;
      }
      System.out.print('\n');
    }
  }
}