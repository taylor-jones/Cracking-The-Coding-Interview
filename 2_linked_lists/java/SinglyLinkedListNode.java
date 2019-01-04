public class SinglyLinkedListNode<T> {
  // member variables
  private T value;
  private SinglyLinkedListNode<T> next = null;

  // constructor
  public SinglyLinkedListNode(T value) {
    this.value = value;
  }

  // member functions
  public void setNext(SinglyLinkedListNode<T> next) {
    this.next = next;
  }

  public SinglyLinkedListNode<T> getNext() {
    return this.next;
  }

  public T getValue() {
    return this.value;
  }
}