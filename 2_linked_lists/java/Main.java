import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
    SinglyLinkedListNode<Integer> fiveNode = new SinglyLinkedListNode<Integer>(5);

    ll.addAtHead(fiveNode);
    ll.addAtHead(4);
    ll.addAtHead(4);
    ll.addAtHead(2);
    ll.addAtHead(6);
    ll.addAtHead(6);
    ll.addAtTail(8);
    ll.print();

    ll.removeAtHead();
    ll.print();

    ll.removeAtTail();
    ll.print();

    ll.has(2);
    ll.has(3);

    ll.removeDups();
    ll.print();

    ll.deleteNode(fiveNode);
    ll.print();

    System.out.println(ll.nthFromLast(0));
    System.out.println(ll.nthFromLast(1));
    System.out.println(ll.nthFromLast(2));
    System.out.println(ll.nthFromLast(3));
    System.out.println(ll.nthFromLast(4));

    System.out.println(ll.nthFromLast2(0));
    System.out.println(ll.nthFromLast2(1));
    System.out.println(ll.nthFromLast2(2));
    System.out.println(ll.nthFromLast2(3));
    System.out.println(ll.nthFromLast2(4));
  }

}
