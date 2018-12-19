import java.util.HashSet;

public class LinkedList<T> {
  Node head;
  Node tail;
  int size;

  // constructor
  public LinkedList() {
    System.out.println("Creating an empty list.");
    head = null;
    tail = null;
    size = 0;
  }
  public LinkedList(T data) {
    System.out.println("Creating a list with initial Node value: " + data + ".");
    head = new Node(data);
    tail = head;
    size = 1;
  }


  /**
   * Adds a Node at the beginning of the linked-list
   * @param data - the data to assign to the added Node
   */
  public void addAtHead(T data) {
    System.out.println("Adding " + data + " to the head of the list.");
    Node temp = head;
    head = new Node(data);
    head.next = temp;

    if (tail == null) {
      tail = head;
    }

    size += 1;
  }


  /**
   * Adds a Node at the end of the linked-list
   * @param data - the data to assign to the added Node
   */
  public void addAtTail(T data) {
    System.out.println("Adding " + data + " to the tail of the list.");
    if (tail != null) {
      tail.next = new Node(data);
      tail = tail.next;
    } else {
      head = tail = new Node(data);
    }

    size += 1;
  }


  /**
   * Removes the Node at the beginning of the linked-list.
   * @return T - the data in the node at the beginning of the list.
   */
  public T removeAtHead() {
    if (this.isEmpty()) {
      System.out.println("The list is empty. There's nothing to remove.");
      return null;
    }
    
    T removed = head.data;
    System.out.println("Removing " + removed + " from the head of the list.");
    if (head == tail) {
      // there's only one Node in the list
      head = tail = null;
    } else {
      head = head.next;
    }

    size -= 1;
    return removed;
  }


  /**
   * Removes the Node at the end of the linked-list.
   * @return T - the data in the node at the end of the list.
   */
  public T removeAtTail() {
    if (this.isEmpty()) {
      System.out.println("The list is empty. There's nothing to remove.");
      return null;
    }

    T removed = tail.data;
    System.out.println("Removing " + removed + " from the tail of the list.");
    if (head == tail) {
      // there's only one node in the list
      head = tail = null;
    } else {
      Node temp = head;
      while (temp.next.next != null) {
        temp = temp.next;
      }

      // re-assign the tail and remove the previous tail
      tail = temp;
      tail.next = null;
    }

    size -= 1;
    return removed;
  }


  /**
   * Checks if the list contains a Node with the specified data.
   * @param data - the data to look for.
   * @return boolean - true if the data is in the list, false if not.
   */
  public boolean has(T data) {
    if (!this.isEmpty()) {
      Node temp = head;
      while (temp != null) {
        if (temp.data == data) {
          System.out.println(data + " is in the list.");
          return true;
        }

        temp = temp.next;
      }
    }

    System.out.println(data + " is not in the list.");
    return false;
  }


  /**
   * Prints the contents of the Nodes in the list.
   */
  public void print() {
    System.out.print("List Size: " + size + "   Contents: ");

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data);
      
      if (temp.next != null) {
        System.out.print(" -> ");
      }

      temp = temp.next;
    }

    System.out.println('\n');
  }


  /**
   * Checks if the list is empty
   * @return boolean - true if the size is 0, false if > 0.
   */
  public boolean isEmpty() {
    return (size == 0);
  }


  // Node class
  class Node {
    Node next;
    T data;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }



  /********************************************************
   * 2.1 - Remove duplicates from an unsorted Linked List
   * 
   * Solution: Using a hash table, if a Node's data is already in the table, 
   *  then remove it from the LL. Otherwise, add it to the hash table and 
   *  increment the counter. At the end, update the LL size to be the 
   *  value of the counter.
   * 
   * Runtime: O(n)
   ********************************************************/
  public void dedupe() {
    HashSet<T> set = new HashSet<T>();
    Node curr = head;
    Node prev = null;
    int count = 0;

    while (curr != null) {
      if (set.contains(curr.data)) {
        prev.next = curr.next;
      } else {
        set.add(curr.data);
        prev = curr;
        count += 1;
      }

      curr = curr.next;
    }

    // update the LL size to reflect the size after removing duplicates.
    size = count;
  }


  /********************************************************
   * 2.2 - Find the kth from last element in a singly-linked list.
   * 
   * Solution: The kth-from-last element is the size - kth element in the list,
   *  or the element at the (size - k - 1) index. Calcuate the target element number, 
   *  and use a for loop to traverse the list until this element is reached.
   * 
   * Runtime: O(n)
   ********************************************************/
  public T nthFromLast(int k) {
    Node curr = head;
    int target = size - k;

    if (k <= (size - 1)) {
      for (int i = 1; i < target; i++) {
        curr = curr.next;
      }
  
      return curr.data;  
    }

    System.out.println("There aren't that many elements in the list.");
    return null;
  }
  


  /********************************************************
   * 2.2 - Find the kth from last element in a singly-linked list.
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
    Node trail = head;
    Node lead = head;

    if (head == null) {
      System.out.println("The list is empty!");
      return null;
    }

    // move the lead node ahead k nodes into the list
    for (int i = 0; i < k; i++) {
      lead = lead.next;
      if (lead == null) {
        System.out.println("There aren't enough list elements to get the " + k + "th from last.");
        return null;
      }
    }

    // then, move both the lead node and trail node until the end of the list is reached
    while (lead.next != null) {
      trail = trail.next;
      lead = lead.next;
    }

    return trail.data;
  }

}

