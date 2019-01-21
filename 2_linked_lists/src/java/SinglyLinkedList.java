/**
 * Singly-linked list implementation
 */


import java.util.HashSet;
import java.util.HashMap;

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
    this.verbose = newList.verbose;
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

    HashSet<Integer> set = new HashSet<>();
    SinglyLinkedListNode curr = this.head;
    SinglyLinkedListNode prev = null;
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
    }

    while (temp.getNext() != null) {
      if (temp.getNext() == node) {
        temp.setNext(temp.getNext().getNext());
        this.size -= 1;
        System.out.println("Deleted node with value " + node.getValue());
        return;
      }

      temp = temp.getNext();
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
    int sum = this.getReversedListNumber(this) + this.getReversedListNumber(list);
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
   * Example:   Input: (7 -> 1 -> 6) Output: 617.
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
   * Example:   Input: (7 -> 1 -> 6) Output: 716.
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
  * Runtime: O(1)
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


  /********************************************************
   * 2.7 - Intersection
   * Description: Given two (singly) linked lists, determine 
   *  if the two lists intersect. Return the inter­secting node. 
   *  Note that the intersection is defined based on reference, 
   *  not value. That is, if the kth node of the first linked list
   *  is the exact same node (by reference) as the jth node of 
   *  the second linked list, then they are intersecting
   * 
   * Solution: Create two trace nodes, starting one at each of the
   *  head nodes of the the lists. With either list has items, add
   *  the item to a HashMap, where the key is the node and the value
   *  is the # of times the node has been enountered. Then, check 
   *  if there's more than one of those items in the map. If so, 
   *  it's in both lists, making it the intersection.
   * 
   * Runtime: O(n)
   * 
   * @param list SinglyLinkedList to compare to this list.
   * @return SinglyLinkedListNode that represents the intersection
   *  of the two lists, or a null SinglyLinkedListNode if no
   *  intersection is found.
   */
  public SinglyLinkedListNode intersection(SinglyLinkedList list) {
    HashMap<SinglyLinkedListNode, Integer>map = new HashMap<>();
    SinglyLinkedListNode result = null;
    SinglyLinkedListNode trace1 = this.head;
    SinglyLinkedListNode trace2 = list.head;

    while (trace1 != null || trace2 != null) {
      if (trace1 != null) {
        map.merge(trace1, 1, (a, b) -> a == null ? 0 : a + b);
        if (map.get(trace1) > 1) result = trace1;
      }
      
      if (trace2 != null) {
        map.merge(trace2, 1, (a, b) -> a == null ? 0 : a + b);
        if (map.get(trace2) > 1) result = trace2;
      }

      if (result != null) {
        System.out.println("Intersection found at node with value: " + result.getValue());
        return result;
      }

      trace1 = trace1.getNext();
      trace2 = trace2.getNext();
    }

    System.out.println("No intersection exists.");
    return result;
  }


  /**
   * 2.8 - Loop Detection
   * Description: Given a circular linked list, implement an algorithm 
   *  that returns the node at the beginning of the loop.
   * Circular linked list (in this context): A (corrupt) linked list 
   *  in which a node's next pointer points to an earlier node, 
   * so as to make a loop in the linked list.
   * 
   * Solution: Use a HashSet to track encountered nodes. If any node is
   *  in the list more than once, it's the ciruclar looping node.
   * 
   * Runtime: O(n)
   * 
   * Example
   *  Input: A -> B -> C -> D -> E -> C[thesameCasearlier]
   *  Output: C
   * 
   * @param list
   * @return SinglyLinkedListNode - representing the circular link
   */
  public SinglyLinkedListNode detectLoop(SinglyLinkedList list) {
    HashSet<SinglyLinkedListNode>set = new HashSet<>();
    SinglyLinkedListNode trace = list.head;

    while (trace.getNext() != null) {
      if (set.contains(trace)) {
        System.out.println("Circular link node found with value: " + trace.getValue());
        return trace;
      }

      set.add(trace);
      trace = trace.getNext();
    }

    System.out.println("No circular link node found");
    return trace;
  }



  /********************************************************
   * Testing list functionality / Examples
   *********************************************************/
  public static void main(String[] args) {
    
    // 
    // Testing base functionality and populating lists.
    // 
    System.out.println("\n*** Testing base Singly-Linked List functionality...");
    SinglyLinkedList list = new SinglyLinkedList(true);
    list.addAtHead(1);
    list.addAtHead(1);
    list.addAtHead(2);
    list.addAtHead(2);
    list.addAtHead(2);
    list.addAtTail(8);
    list.addAtTail(9);
    list.addAtTail(3);

    list.removeAtHead();
    list.removeAtTail();
    list.removeAtTail();

    System.out.println(list.has(2));
    System.out.println(list.has(3));


    // 
    // Testing 2.1 - Remove Dups
    // 
    System.out.println("\n\n*** Testing : 2.1 - Remove Dups");
    list.removeDups();


    // 
    // Testing 2.2 - Return Kth to Last
    // 
    System.out.println("\n\n*** Testing : 2.2 - Return Kth to Last");

    // V1
    System.out.println("* Version 1 - List Size Known");
    System.out.println("0th from last: " + list.nthFromLast(0));
    System.out.println("1st from last: " + list.nthFromLast(1));
    System.out.println("2nd from last: " + list.nthFromLast(2));
    System.out.println("3rd from last: " + list.nthFromLast(3));
    System.out.println("4th from last: " + list.nthFromLast(4));

    // V2
    System.out.println("\n* Version 2 - List Size Unknown");
    System.out.println("0th from last: " + list.nthFromLast2(0));
    System.out.println("1st from last: " + list.nthFromLast2(1));
    System.out.println("2nd from last: " + list.nthFromLast2(2));
    System.out.println("3rd from last: " + list.nthFromLast2(3));
    System.out.println("4th from last: " + list.nthFromLast2(4));


    // 
    // Testing 2.3 - Delete Middle Node
    // 
    System.out.println("\n\n*** Testing : 2.3 - Delete Middle Node");
    SinglyLinkedListNode fiveNode = new SinglyLinkedListNode(5);
    SinglyLinkedListNode nineNode = new SinglyLinkedListNode(9);  // never added
    list.addAtHead(fiveNode);
    list.addAtHead(7);
    list.addAtTail(3);
    list.deleteNode(fiveNode);
    list.print();
    list.deleteNode(nineNode);
    list.print();


    // 
    // Testing 2.4 - Partition
    // 
    System.out.println("\n\n*** Testing : 2.4 - Partition");
    list.addAtHead(4);
    list.addAtHead(3);
    list.addAtHead(2);
    list.addAtHead(1);
    list.addAtTail(5);
    list.addAtTail(1);
    list.addAtTail(2);
    list.addAtTail(3);
    list.addAtTail(4);
    list.partition(3);
    list.print();


    // 
    // Testing 2.5 - Sum Lists
    // 
    System.out.println("\n\n*** Testing : 2.5 - Sum Lists");
    SinglyLinkedList list1 = new SinglyLinkedList(true);
    SinglyLinkedList list2 = new SinglyLinkedList(true);
    list1.addAtTail(7);
    list1.addAtTail(1);
    list1.addAtTail(6);
    list2.addAtTail(5);
    list2.addAtTail(9);
    list2.addAtTail(2);

    SinglyLinkedList summedList = list1.sumWith(list2);
    summedList.print();


    // 
    // Testing 2.6 - Palindrome
    // 
    System.out.println("\n\n*** Testing : 2.6 - Palindrome");
    list1.replaceWith(new SinglyLinkedList());
    list1.addAtHead(1);
    list1.addAtHead(2);
    list1.addAtHead(3);
    list1.addAtHead(2);
    list1.addAtHead(1);
    System.out.print("List1: ");
    list1.print();
    
    list2.replaceWith(new SinglyLinkedList());
    list2.addAtHead(1);
    list2.addAtHead(2);
    list2.addAtHead(3);
    list2.addAtHead(4);
    list2.addAtHead(5);
    System.out.print("List2: ");
    list2.print();

    System.out.println("Is list1 a palindrome? " + list1.isPalindrome());
    System.out.println("Is list2 a palindrome? " + list2.isPalindrome());


    // 
    // Testing 2.7 - Intersection
    // 
    System.out.println("\n\n*** Testing : 2.7 - Intersection");
    list1.replaceWith(new SinglyLinkedList());
    list2.replaceWith(new SinglyLinkedList());

    list1.addAtHead(7);
    list1.addAtHead(nineNode);
    list1.addAtHead(8);

    list2.addAtHead(1);
    list2.addAtHead(2);
    list2.addAtHead(3);
    list1.intersection(list2);
    
    list2.addAtTail(nineNode);
    list1.intersection(list2);


    // 
    // Testing 2.8 - Loop Detection
    // 
    System.out.println("\n\n*** Testing : 2.8 - Loop detection");
    list1.replaceWith(new SinglyLinkedList());
    list1.addAtHead(3);
    list1.addAtHead(4);
    list1.addAtHead(fiveNode);
    list1.addAtHead(6);
    list1.addAtHead(7);
    list1.detectLoop(list1);
    
    list1.addAtTail(fiveNode);
    list1.detectLoop(list1);

  }

}

