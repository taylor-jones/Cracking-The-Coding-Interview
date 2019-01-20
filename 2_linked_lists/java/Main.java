import java.util.HashSet;

/**
 * Example calls to the various linked list method solutions.
 * 
 * Note: Many of the methods also print statements to the console
 * to help indicate exactly what changes are being made to the list.
 */
public class Main {
  public static void main(String[] args) {
    
    // 
    // Testing base functionality and populating lists.
    // 
    SinglyLinkedList list = new SinglyLinkedList(true);
    list.addAtHead(2);
    list.addAtHead(2);
    list.addAtHead(2);
    list.addAtTail(8);
    list.addAtTail(9);

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
    System.out.println("\n* Version 1 - List Size Known");
    System.out.println(list.nthFromLast(0));
    System.out.println(list.nthFromLast(1));
    System.out.println(list.nthFromLast(2));
    System.out.println(list.nthFromLast(3));
    System.out.println(list.nthFromLast(4));

    // V2
    System.out.println("\n* Version 2 - List Size Unknown");
    System.out.println(list.nthFromLast2(0));
    System.out.println(list.nthFromLast2(1));
    System.out.println(list.nthFromLast2(2));
    System.out.println(list.nthFromLast2(3));
    System.out.println(list.nthFromLast2(4));


    // 
    // Testing 2.3 - Delete Middle Node
    // 
    System.out.println("\n\n*** Testing : 2.3 - Delete Middle Node");
    SinglyLinkedListNode fiveNode = new SinglyLinkedListNode(5);
    SinglyLinkedListNode nineNode = new SinglyLinkedListNode(9);  // never added
    list.addAtHead(8);
    list.addAtTail(3);
    list.addAtHead(fiveNode);
    list.deleteNode(fiveNode);
    list.deleteNode(nineNode);


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
    list1.replaceWith(new SinglyLinkedList(true));
    list1.addAtHead(1);
    list1.addAtHead(2);
    list1.addAtHead(3);
    list1.addAtHead(2);
    list1.addAtHead(1);

    list2.replaceWith(new SinglyLinkedList(true));
    list2.addAtHead(1);
    list2.addAtHead(2);
    list2.addAtHead(3);
    list2.addAtHead(4);
    list2.addAtHead(5);

    System.out.println("Is list1 a palindrome? " + list1.isPalindrome());
    System.out.println("Is list2 a palindrome? " + list2.isPalindrome());
  }
}
