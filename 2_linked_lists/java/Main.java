public class Main {
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<Integer>();

    ll.addAtHead(4);
    ll.addAtHead(4);
    ll.addAtHead(2);
    ll.addAtHead(6);
    ll.addAtHead(6);
    ll.addAtTail(8);
    // ll.print();

    // ll.removeAtHead();
    // ll.print();

    // ll.removeAtTail();
    // ll.print();

    // ll.has(2);
    // ll.has(3);

    ll.dedupe();
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
