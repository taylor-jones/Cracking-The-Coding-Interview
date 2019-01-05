import java.util.HashSet;

/**
 * Example calls to the various linked list method solutions.
 * 
 * Note: Many of the methods also print statements to the console
 * to help indicate exactly what changes are being made to the list.
 */
public class Main {
  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
    SinglyLinkedListNode<Integer> fiveNode = new SinglyLinkedListNode<Integer>(5);  // used for 2.3
    SinglyLinkedListNode<Integer> nineNode = new SinglyLinkedListNode<Integer>(9);  // used for 2.3

    list.addAtHead(fiveNode);
    list.addAtHead(4);
    list.addAtHead(4);
    list.addAtHead(2);
    list.addAtHead(6);
    list.addAtHead(6);
    list.addAtTail(8);
    list.addAtTail(9);
    list.print();

    list.removeAtHead();
    list.removeAtTail();
    list.removeAtTail();
    list.removeAtTail();
    list.removeAtTail();
    list.print();

    list.removeAtTail();
    list.print();

    list.has(2);
    list.has(3);

    list.removeDups();
    list.print();

    list.deleteNode(fiveNode);
    list.deleteNode(nineNode);
    list.print();

    list.addAtHead(4);
    list.addAtHead(3);
    list.addAtHead(2);
    list.addAtHead(1);
    list.addAtTail(5);
    list.addAtTail(1);
    list.addAtTail(2);
    list.addAtTail(3);
    list.addAtTail(4);
    list.print();

    list.partition(3);
    list.print();

    // System.out.println(list.nthFromLast(0));
    // System.out.println(list.nthFromLast(1));
    // System.out.println(list.nthFromLast(2));
    // System.out.println(list.nthFromLast(3));
    // System.out.println(list.nthFromLast(4));

    // System.out.println(list.nthFromLast2(0));
    // System.out.println(list.nthFromLast2(1));
    // System.out.println(list.nthFromLast2(2));
    // System.out.println(list.nthFromLast2(3));
    // System.out.println(list.nthFromLast2(4));
  }

}
