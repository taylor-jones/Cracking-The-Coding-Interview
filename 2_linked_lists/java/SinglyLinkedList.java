/**
 * Singly-linked list implementation
 */


import java.util.HashSet;

public class SinglyLinkedList {
  private SinglyLinkedListNode head;
  private SinglyLinkedListNode tail;
  private int size;
  private boolean verbose;


  /**
   * Default constructor
   */
  public SinglyLinkedList() {
    this.head = this.tail = null;
    this.size = 0;
    this.verbose = false;
  }

  /**
   * Overrides default constructor to allow for specifying
   * whether or not to show additional information when adding
   * or removing list nodes.
   * @param verbose
   */
  public SinglyLinkedList(boolean verbose) {
    this.head = this.tail = null;
    this.size = 0;
    this.verbose = verbose;
  }

  /**
   * Adds a node at the beginning of the linked list, then updates
   * the head to maintain a pointer to the node at the beginning
   * of this list.
   * 
   * @param node
   */
  public void addAtHead(SinglyLinkedListNode node) {
    if (verbose) System.out.print("Adding " + node.getValue() + " at HEAD ... ");

    node.setNext(this.head);
    this.head = node;

    if (this.tail == null) {
      this.tail = node;
    }

    this.size += 1;
    if (verbose) this.showState(true);
  }


  /**
   * Overloaded version of addAtHead that allows for providing
   * a value for which a node will be created and added to the
   * beginning of the list.
   * 
   * @param value
   */
  public void addAtHead(int value) {
    this.addAtHead(new SinglyLinkedListNode(value));
  }


  /**
   * Adds a node at the end of the linked list, then updates
   * the tail to maintain a pointer to the end of the list.
   * 
   * @param node
   */
  public void addAtTail(SinglyLinkedListNode node) {
    if (verbose) System.out.print("Adding " + node.getValue() + " at TAIL ... ");

    if (this.tail != null) {
      this.tail.setNext(node);
      this.tail = node;
    } else {
      this.head = this.tail = node;
    }

    this.size += 1;
    if (verbose) this.showState(true);
  }


  /**
   * Overloaded version of addAtTail that allows for providing
   * a value for which a node will be created and added to the
   * end of the list.
   * 
   * @param value
   */
  public void addAtTail(int value) {
    this.addAtTail(new SinglyLinkedListNode(value));
  }


  /**
   * Removes the node at the beginning of the list and returns the value within that node.
   * @return int - the value within the head node.
   */
  public int removeAtHead() {
    if (this.isEmpty()) {
      if (verbose) System.out.print("The list is empty. There's nothing to remove. ");
      return 0;
    }

    int removed = this.head.getValue();
    if (verbose) System.out.print("Removing " + removed + " from HEAD ... ");
    this.head = this.head.getNext();
    this.size -= 1;

    if (this.size <= 1) {
      this.tail = this.head;
    }

    if (verbose) this.showState(true);
    return removed;
  }


  /**
   * Removes the node at the end of the list and returns the value within that node.
   * @return int - the value in the tail node.
   */
  public int removeAtTail() {
    if (this.isEmpty()) {
      if (verbose) System.out.print("The list is empty. There's nothing to remove. ");
      return 0;
    }

    int removed = this.tail.getValue();
    if (verbose) System.out.print("Removing " + removed + " from TAIL ... ");
    
    if (this.head == this.tail) {
      this.head = this.tail = null;
    } else {
      SinglyLinkedListNode temp = this.head;
      while (temp.getNext().getNext() != null) {
        temp = temp.getNext();
      }

      // re-assign the tail and remove the previous tail
      this.tail = temp;
      this.tail.setNext(null);
    }

    this.size -= 1;
    if (verbose) this.showState(true);
    return removed;
  }


  /**
   * Checks if a specified value exists in the linked list.
   * @param value - int - the value to check for.
   * @return boolean - True if there is a node in the list with the argued
   *  value, false if not.
   */
  public boolean has(int value) {
    if (verbose) System.out.print("List has value " + value + ": ");

    if (!this.isEmpty()) {
      SinglyLinkedListNode temp = this.head;
      while (temp != null) {
        if (temp.getValue() == value) {
          return true;
        }

        temp = temp.getNext();
      }
    }

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
  public void replaceWith(SinglyLinkedList newList) {
    this.head = newList.head;
    this.tail = newList.tail;
    this.size = newList.size;
  }


  /**
   * Prints the values of the items in the list.
   */
  public void print() {
    System.out.print("VALUES: ");
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



  /**
   * Displays the current details of the linked list including:
   * - the size
   * - the value of the head node
   * - the value of the tail node
   */
  public void showState(boolean showItems) {
    System.out.print("SIZE: " + this.size);
    SinglyLinkedListNode trace = head;

    if (this.head == null) {
      System.out.print("  HEAD: null");
    } else {
      System.out.print("  HEAD:" + this.head.getValue());
    }

    if (this.tail == null) {
      System.out.print("  TAIL: null");
    } else {
      System.out.print("  TAIL:" + this.tail.getValue());
    }

    if (showItems) {
      System.out.print("  ");  
      this.print();
    } else {
      System.out.print('\n');
    }
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
    System.out.print("> Before: ");
    this.print();

    HashSet set = new HashSet<>();
    SinglyLinkedListNode curr = this.head;
    SinglyLinkedListNode prev = null;
    int prevSize = this.size;
    int count = 0;

    while (curr != null) {
      if (set.contains(curr.getValue())) {
        System.out.print("Dupe Found\t");
        this.print();

        prev.setNext(curr.getNext());
      } else {
        set.add(curr.getValue());
        prev = curr;
        count += 1;
      }

      curr = curr.getNext();
    }

    this.size = count;
    if (this.size == 1) {
      this.head = this.tail;
    }

    System.out.print("> After: ");
    this.print();
  }



  /********************************************************
   * 2.2 - Return Kth to Last
   * Description: Find the kth from last element in a singly-linked list.
   * 
   * Solution: The kth-from-last element is the size - kth element in the list,
   *  or the element at the (size - k - 1) index. Calcuate the target element number, 
   *  and use a for loop to traverse the list until this element is reached.
   * 
   * Note that this function returns a string, which is the resulting value
   *  of the kth-from-last node, if valid. If invalid, a response explaining
   *  the error is returned. This is a bit of a workaround to avoiding
   *  the issue of a NullPointerException in the case where an int return
   *  is expected, but the node didn't exist (which would've returned null).
   * 
   * Runtime: O(n)
   ********************************************************/
  public String nthFromLast(int k) {
    SinglyLinkedListNode curr = head;
    int target = this.size - k;

    if (head == null) {
      return "The list is empty!";
    } else if (target <= 0) {
      return "Not enough items to get " + k + " from last.";
    }

    for (int i = 1; i < target; i++) {
      curr = curr.getNext();
    }

    return Integer.toString(curr.getValue());
  }



  /********************************************************
   * 2.2 - Return Kth to Last
   * Description: Find the kth from last element in a singly-linked list.
   * 
   * Variation: If the linked-list size were unknown...
   * 
   * Solution: Use a lead node to move ahead k elements into the list. 
   *  Then, move both the lead node and trail node until the lead node
   *  reaches the end of the list. At that point, the trail node will
   *  be k elements from the end.
   * 
   * Note that this function returns a string, which is the resulting value
   *  of the kth-from-last node, if valid. If invalid, a response explaining
   *  the error is returned. This is a bit of a workaround to avoiding
   *  the issue of a NullPointerException in the case where an int return
   *  is expected, but the node didn't exist (which would've returned null).
   * 
   * Runtime: O(n)
   * Space: O(1)
   ********************************************************/
  public String nthFromLast2(int k) {
    SinglyLinkedListNode trail = this.head;
    SinglyLinkedListNode lead = this.head;

    // Make sure the list isn't empty
    if (lead == null) return "The list is empty!";

    // move the lead node ahead k nodes into the list
    for (int i = 0; i < k; i++) {
      lead = lead.getNext();
      if (lead == null) return "Not enough items to get " + k + " from last.";
    }

    // then, move both the lead node and trail node until the end of the list is reached
    while (lead.getNext() != null) {
      trail = trail.getNext();
      lead = lead.getNext();
    }

    return Integer.toString(trail.getValue());
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
  public void deleteNode(SinglyLinkedListNode node) {
    SinglyLinkedListNode temp = head;

    if (temp == node) {
      removeAtHead();
      return;
    } else {
      while (temp.getNext() != null) {
        if (temp.getNext() == node) {
          temp.setNext(temp.getNext().getNext());
          this.size -= 1;
          System.out.println("Deleted node with value " + node.getValue());
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
   * @param value - int (int in this case) - the value on which
   *  to partition the list.
   * 
   * Note: All though the list is designed to use generic type T,
   *  this implementation assumes the value is an integer.
   ********************************************************/
  public void partition(int value) {
    System.out.println("Partitioning list on value " + value);
    SinglyLinkedList partitionedList = new SinglyLinkedList();
    SinglyLinkedListNode trace = this.head;
    SinglyLinkedListNode temp = this.head;

    while (trace != null) {
      temp = trace;
      trace = trace.getNext();
      
      if (temp.getValue() < value) {
        partitionedList.addAtHead(temp);
      } else {
        partitionedList.addAtTail(temp);
      }
    }

    this.replaceWith(partitionedList);
  }




 /********************************************************
  * 2.5 - Sum Lists
  * Description: You have two numbers represented by a linked list,
  *  where each node contains a single digit. The digits are stored
  *  in reverse order, such that the 1's digit is at the head of the
  *  list. Write a function that adds the two numbers and returns
  *  the sum as a linked list.
  * 
  * Solution: Get the int value of the reversed list amount for
  *  each list and then add those two values. Then, convert that 
  *  integer to a string and add each of the digits to the head
  *  of the new linked list.
  * 
  * Runtime: O(n)
  *
  * Example: 
  *  Input: (7 -> 1 -> 6) + (5 -> 9 -> 2), which is 617 + 295.
  *  Output: 2 -> 1 -> 9, which is 912.
  ********************************************************/
  public SinglyLinkedList sumWith(SinglyLinkedList list) {
    SinglyLinkedList newList = new SinglyLinkedList();
    int a = this.getReversedListNumber(this);
    int b = this.getReversedListNumber(list);
    int sum = a + b;
    String strSum = Integer.toString(sum);

    for (int i = 0; i < strSum.length(); i++) {
      newList.addAtHead(new SinglyLinkedListNode(Integer.parseInt(strSum.substring(i, i + 1))));
    }
    
    return newList;
  }


  /**
   * Helper function that traverses a linked list of integers
   *  and returns the reversed integer value of the digits.
   * 
   * Example: 
   *  Input: (7 -> 1 -> 6) Output: 617.
   * 
   * @param list - a SinglyLinkedList object
   * @return int
   */
  private int getReversedListNumber(SinglyLinkedList list) {
    SinglyLinkedListNode trace = list.head;
    String temp = "";

    while (trace != null) {
      temp = Integer.toString(trace.getValue()) + temp;
      trace = trace.getNext();
    }

    return Integer.parseInt(temp);
  }



  /**
   * Helper function that traverses a linked list of integers
   *  and returns the integer value of the digits.
   * 
   * Example: 
   *  Input: (7 -> 1 -> 6) Output: 716.
   * 
   * @param list - a SinglyLinkedList object
   * @return int
   */
  private int getListNumber(SinglyLinkedList list) {
    SinglyLinkedListNode trace = list.head;
    String temp = "";

    while (trace != null) {
      temp += Integer.toString(trace.getValue());
      trace = trace.getNext();
    }

    return Integer.parseInt(temp);
  }



  /********************************************************
  * 2.6 - Palindrome
  * Description: Implement a function to check if a linked list
  *  is a palindrome.
  * 
  * Solution: Get the reversed integer value and the non-reversed
  *  integer value. Check if the two values are equal.
  * 
  * Runtime: 
  *
  * Examples:  
  *   Input: (1 -> 2 -> 3 -> 2 -> 1)    Output: true    
  *   Input: (1 -> 2 -> 3 -> 4 -> 5)    Output: false
  ********************************************************/
  public boolean isPalindrome() {
    int intVal = this.getListNumber(this);
    int intValRev = this.getReversedListNumber(this);
    return intVal == intValRev;
  }
}

