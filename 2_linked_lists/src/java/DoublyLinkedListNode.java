/**
 * Simple doubly-linked list implementation
 */

public class LinkedListNode {
  //
  // member variables
  //
  public LinkedListNode prev;
  public LinkedListNode next;
  public LinkedListNode tail;
  public int data;

  //
  // constructors
  //
  public LinkedListNode(int data, LinkedListNode prev, LinkedListNode next) {
    this.data = data;

  }

  public LinkedListNode(int data) {
    this.data = data;
  }

  public LinkedListNode() { }


  //
  // methods
  //

  /**
   * Sets the next node in the list, relative to the current node.
   * @param node
   */
  public void setNext(LinkedListNode node) {
    this.next = node;
    if (this == tail) {
      tail = node;
    }

    if (node != null && node.prev != this) {
      node.setPrev(this);
    }
  }


  /**
   * Sets the previous node in the list, relative to the current node.
   * @param node
   */
  public void setPrev(LinkedListNode node) {
    this.prev = node;
    if (node != null && node.next != this) {
      node.setNext(this);
    }
  }


  public LinkedListNode clone() {
    LinkedListNode nextClone = null;
    if (next != null) {
      nextClone = next.clone();
    }

    return new LinkedListNode(this.data, nextClone, null);
  }

}

