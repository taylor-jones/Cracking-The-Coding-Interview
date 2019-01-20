public class SinglyLinkedListNode {
  // member variables
  private int value;
  private SinglyLinkedListNode next;

  // constructor
  public SinglyLinkedListNode(int value) {
    this.value = value;
    this.setNext(null);
  }

  // member functions
  public void setNext(SinglyLinkedListNode next) {
    this.next = next;
  }

  public SinglyLinkedListNode getNext() {
    return this.next;
  }

  public int getValue() {
    return this.value;
  }
}