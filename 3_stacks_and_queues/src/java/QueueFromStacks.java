/**
 * 3.4 - Queue via Stacks
 * Implement a class which implements a queue using two stacks.
 * 
 * QueueFromStacks
 * 
 */
public class QueueFromStacks<T> {
  private Stack<T> newestFirst;
  private Stack<T> newestLast;
  private int size;

  public QueueFromStacks() {
    newestFirst = new Stack<T>();
    newestLast = new Stack<T>();
  }

  public void add(T value) {
    newestFirst.push(value);
    size += 1;
    System.out.println("ADDED: " + value + "\tSIZE: " + size);
  }

  public T remove() {
    swapStacks();
    size -= 1;
    System.out.println("REMOVED: " + newestLast.peek() + "\tSIZE: " + size);
    return newestLast.pop();
  }

  public T peek() {
    swapStacks();
    return newestLast.peek();
  }

  /**
   * Moves the elements from the stack having newest items first
   *  to the stack having newest items last.
   */
  private void swapStacks() {
    if (newestLast.isEmpty()) {
      while (!newestFirst.isEmpty()) {
        newestLast.push(newestFirst.pop());
      }
    }
  }


  /**
   * Example Usage
   */
  public static void main(String[] args) {
    QueueFromStacks<Integer>q = new QueueFromStacks<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.remove();
    q.remove();
    q.add(99);
    q.add(88);
    q.add(77);
    q.remove();
    q.remove();
    q.remove();
    q.remove();
  }
}
