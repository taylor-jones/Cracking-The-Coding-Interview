/**
 * Singly-linked list implementation
 */


import java.util.HashSet;

public class SinglyLinkedList<T> {
  public SinglyLinkedListNode<T> head;
  public SinglyLinkedListNode<T> tail;
  public int size;

  // constructor
  public SinglyLinkedList() {
    this.head = this.tail = null;
    this.size = 0;
  }


  /**
   * Adds a node at the beginning of the linked list, then updates
   * the head to maintain a pointer to the node at the beginning
   * of this list.
   * 
   * @param node
   */
  public void addAtHead(SinglyLinkedListNode<T> node) {
    System.out.print("Adding " + node.getValue() + " at HEAD ... ");

    node.setNext(this.head);
    this.head = node;

    if (this.tail == null) {
      this.tail = node;
    }

    this.size += 1;
    this.showState();
  }


  /**
   * Overloaded version of addAtHead that allows for providing
   * a value for which a node will be created and added to the
   * beginning of the list.
   * 
   * @param value
   */
  public void addAtHead(T value) {
    this.addAtHead(new SinglyLinkedListNode<T>(value));
  }


  /**
   * Adds a node at the end of the linked list, then updates
   * the tail to maintain a pointer to the end of the list.
   * 
   * @param node
   */
  public void addAtTail(SinglyLinkedListNode<T> node) {
    System.out.print("Adding " + node.getValue() + " at TAIL ... ");

    if (this.tail != null) {
      this.tail.setNext(node);
      this.tail = node;
    } else {
      this.head = this.tail = node;
    }

    this.size += 1;
    this.showState();
  }


  /**
   * Overloaded version of addAtTail that allows for providing
   * a value for which a node will be created and added to the
   * end of the list.
   * 
   * @param value
   */
  public void addAtTail(T value) {
    this.addAtTail(new SinglyLinkedListNode<T>(value));
  }


  /**
   * Removes the node at the beginning of the list and returns the value within that node.
   * @return T - the value within the head node.
   */
  public T removeAtHead() {
    if (this.isEmpty()) {
      System.out.println("The list is empty. There's nothing to remove.");
      return null;
    }

    T removed = this.head.getValue();
    System.out.print("Removing " + removed + " from HEAD ... ");
    this.head = this.head.getNext();
    this.size -= 1;

    if (this.size <= 1) {
      this.tail = this.head;
    }

    this.showState();
    return removed;
  }


  /**
   * Removes the node at the end of the list and returns the value within that node.
   * @return T - the value in the tail node.
   */
  public T removeAtTail() {
    if (this.isEmpty()) {
      System.out.println("The list is empty. There's nothing to remove.");
      return null;
    }

    T removed = this.tail.getValue();
    System.out.print("Removing " + removed + " from TAIL ... ");
    
    if (this.head == this.tail) {
      this.head = this.tail = null;
    } else {
      SinglyLinkedListNode<T> temp = this.head;
      while (temp.getNext().getNext() != null) {
        temp = temp.getNext();
      }

      // re-assign the tail and remove the previous tail
      this.tail = temp;
      this.tail.setNext(null);
    }

    this.size -= 1;
    this.showState();
    return removed;
  }


  /**
   * Checks if a specified value exists in the linked list.
   * @param value - T - the value to check for.
   * @return boolean - True if there is a node in the list with the argued
   *  value, false if not.
   */
  public boolean has(T value) {
    if (!this.isEmpty()) {
      SinglyLinkedListNode temp = this.head;
      while (temp != null) {
        if (temp.getValue() == value) {
          System.out.println(value + " is in the list.");
          return true;
        }

        temp = temp.getNext();
      }
    }

    System.out.println(value + " is not in the list.");
    return false;
  }


  /**
   * Simple helper function that indicates whether the list
   * contains any list items.
   * 
   * @return bool - true if this list has 0 list items, false if
   *  the list has more than 0 items.
   */
  public boolean isEmpty() {
    return this.size <= 0;
  }



  /**
   * Updates the head, tail, and size of the current list with
   * some other list, effectively replacing the current list
   * with the new list.
   * @param newList - SinglyLinkedList - the replacement list.
   */
  private void replaceWith(SinglyLinkedList<T> newList) {
    this.head = newList.head;
    this.tail = newList.tail;
    this.size = newList.size;
  }


  /**
   * Prints the size and contents of the linked list.
   */
  public void print() {
    System.out.print("List Size: " + this.size + "   Values: ");
    SinglyLinkedListNode trace = head;

    while (trace != null) {
      System.out.print(trace.getValue());

      if (trace.getNext() != null) {
        System.out.print(" -> ");
      }

      trace = trace.getNext();
    }

    System.out.print('\n');
  }


  public void showState() {
    System.out.print("Size: " + this.size);

    if (this.head == null) {
      System.out.print("  Head: null");
    } else {
      System.out.print("  Head:" + this.head.getValue());
    }

    if (this.tail == null) {
      System.out.print("  Tail: null");
    } else {
      System.out.print("  Tail:" + this.tail.getValue());
    }

    System.out.print("\n");
  }



  /********************************************************
   * 2.1 - Remove Dups
   * Description: Remove duplicates from an unsorted Linked List
   * 
   * Solution: Using a hash table, if a Node's data is already in 
   * the table, then remove it from the LL. Otherwise, add it to the 
   * hash table and increment the counter. At the end, update the LL 
   * size to be the value of the counter.
   * 
   * Runtime: O(n)
   ********************************************************/
  public void removeDups() {
    System.out.print("Removing duplicate values ... ");

    HashSet<T> set = new HashSet<>();
    SinglyLinkedListNode<T> curr = this.head;
    SinglyLinkedListNode<T> prev = null;
    int prevSize = this.size;
    int count = 0;

    while (curr != null) {
      if (set.contains(curr.getValue())) {
        prev.setNext(curr.getNext());
      } else {
        set.add(curr.getValue());
        prev = curr;
        count += 1;
      }

      curr = curr.getNext();
    }

    this.size = count;
    System.out.println("Items Removed: " + (prevSize - this.size));
  }



  /********************************************************
   * 2.2 - Return Kth to Last
   * Description: Find the kth from last element in a singly-linked list.
   * 
   * Solution: The kth-from-last element is the size - kth element in the list,
   *  or the element at the (size - k - 1) index. Calcuate the target element number, 
   *  and use a for loop to traverse the list until this element is reached.
   * 
   * Runtime: O(n)
   ********************************************************/
  public T nthFromLast(int k) {
    SinglyLinkedListNode<T> curr = head;
    int target = this.size - k;

    if (k <= (size - 1)) {
      for (int i = 1; i < target; i++) {
        curr = curr.getNext();
      }
  
      return curr.getValue();
    }

    // There aren't enough elements to get the kth from last
    return null;
  }



  /********************************************************
   * 2.2 - Return Kth to Last
   * Description: Find the kth from last element in a singly-linked list.
   * Variation: If the linked-list size were unknown...
   * Solution: Use a lead node to move ahead k elements into the list. 
   *  Then, move both the lead node and trail node until the lead node
   *  reaches the end of the list. At that point, the trail node will
   *  be k elements from the end.
   * 
   * Runtime: O(n)
   * Space: O(1)
   ********************************************************/
  public T nthFromLast2(int k) {
    SinglyLinkedListNode<T> trail = this.head;
    SinglyLinkedListNode<T> lead = this.head;

    if (lead == null) {
      System.out.println("The list is empty!");
      return null;
    }

    // move the lead node ahead k nodes into the list
    for (int i = 0; i < k; i++) {
      lead = lead.getNext();
      if (lead == null) {
        // There aren't enough elements to get the kth from last
        return null;
      }
    }

    // then, move both the lead node and trail node until the end of the list is reached
    while (lead.getNext() != null) {
      trail = trail.getNext();
      lead = lead.getNext();
    }

    return trail.getValue();
  }



  /********************************************************
   * 2.3 - Delete Middle Node
   * Description: Implement an algorithm to delete a node in the middle
   *  of a singly linked list, given only access to that node.
   * Solution: Traverse the list, starting with the head node. Compare
   *  each list node's next node to the target node. If, at any point,
   *  the target not is found in the list, remove it by updating the
   *  previous node's next pointer to point to the target node's
   *  next node.
   * 
   * Runtime: O(n)
   ********************************************************/
  public void deleteNode(SinglyLinkedListNode<T> node) {
    SinglyLinkedListNode<T> temp = head;

    if (temp == node) {
      removeAtHead();
    } else {
      while (temp.getNext() != null) {
        if (temp.getNext() == node) {
          temp.setNext(temp.getNext().getNext());
          this.size -= 1;
          System.out.println("Deleted given node with value " + node.getValue());
          return;
        }

        temp = temp.getNext();
      }
    }

    System.out.println("Node with value " + node.getValue() + " not found.");
  }



  /********************************************************
   * 2.4 - Partition
   * Description: Write code to partition a linked list around
   *  a value x, such that all nodes less than x come before all
   *  nodes greater than or equal to x. If x is contained within
   *  the list, the values of x only need to be after the elements
   *  less than x. The partition element x can appear anywhere in
   *  the correct partition; it does not need to appear between the
   *  left and right partitions.
   * 
   * Solution: Create a new, empty list. Then, traverse the existing list.
   *  Any node having a value less than the partition value will be added
   *  to the head of the new list, and any node having a value greater than
   *  or equal to the partition value will be added to the tail of the new
   *  list. After the entire list has been traversed, replace the current
   *  list with the new list.
   * 
   * Runtime: O(n) ?
   * 
   * Example:   Input:  3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1  Partition: 5
   *            Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
   * 
   * @param value - T (int in this case) - the value on which
   *  to partition the list.
   * 
   * Note: All though the list is designed to use generic type T,
   *  this implementation assumes the value is an integer.
   ********************************************************/
  public void partition(T value) {
    System.out.println("Partitioning list on value " + value);
    SinglyLinkedList<T>partitionedList = new SinglyLinkedList();
    SinglyLinkedListNode<T> trace = this.head;
    SinglyLinkedListNode<T> temp = this.head;

    while (trace != null) {
      temp = trace;
      trace = trace.getNext();
      
      if ((Integer) temp.getValue() < (Integer) value) {
        partitionedList.addAtHead(temp);
      } else {
        partitionedList.addAtTail(temp);
      }
    }

    this.replaceWith(partitionedList);
  }


}

