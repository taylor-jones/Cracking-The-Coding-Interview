/**
 * 3.3 - Stack of Plates
 * 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks and should create 
 * a new stack once the previous one exceeds capacity. SetOfStacks.push() 
 * and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there 
 * were just a single stack).
 * 
 * SetOfStacks
 */
public class SetOfStacks {
  Stack<StackWithCapacity> stacks = new Stack<StackWithCapacity>();
  int stackCapacity;
  int stackCount;

  public SetOfStacks(int stackCapacity) {
    this.stackCapacity = stackCapacity;
    this.stacks.push(new StackWithCapacity(stackCapacity, stackCount));
    stackCount++;
  }
  
  public void push(int value) {
    if (stacks.peek().atCapacity()) {
      this.stacks.push(new StackWithCapacity(stackCapacity, stackCount));
      stackCount++;
    }

    stacks.peek().push(value);
    System.out.print("STACKS:\t" + stackCount + '\t');
    stacks.peek().print();
  }


  public Integer pop() {
    Integer popped = stacks.peek().pop();    
    if (stacks.peek().isEmpty()) {
      stacks.pop();
      stackCount--;
    }

    System.out.print("STACKS:\t" + stackCount + '\t');
    stacks.peek().print();
    return popped;
  }


  public static void main(String[] args) {
    SetOfStacks s = new SetOfStacks(4);
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);
    s.push(6);
    s.push(7);

    s.pop();
    s.pop();
    s.pop();

    s.push(12);
    s.push(9);
    s.push(7);
  }

}



class StackWithCapacity extends Stack<Integer> {
  private int capacity;
  private int size;
  private int index;

  public StackWithCapacity(int capacity, int index) {
    this.capacity = capacity;
    this.size = 0;
    this.index = index;
  }

  public void push(int value) {
    this.size++;
    super.push(value);
  }

  public Integer pop() {
    this.size--;
    return super.pop();
  }

  public boolean atCapacity() {
    return this.capacity == this.size;
  }

  public void print() {
    System.out.print("IDX: " + index + '\t' + "CAP: " + size + "/" + capacity + '\t');
    super.print();
  }
}