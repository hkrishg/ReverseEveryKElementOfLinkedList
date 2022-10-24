class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class Main {

  // Problem Statement #
  // Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized
  // sub-list starting from the head.

  // If, in the end, you are left with a sub-list with less than ‘k’ elements,
  // reverse it too.

  public static ListNode reverseEveryKElement(ListNode head, int k) {

    if (k <= 1 || head == null)
      return head;

    ListNode current = head;
    ListNode prev = null;

    while (true) {
      ListNode lastNodeOfFirstPart = prev;
      ListNode lastNodeOfSubList = current;
      ListNode next = null; // temporarily store
      // reverese k nodes
      for (int i = 0; current != null && i < k; i++) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }

      // connect with the first part
      if (lastNodeOfFirstPart != null)
        lastNodeOfFirstPart.next = prev;
      else // this means p==1 -> we are changing the first node
        head = prev;

      // connect with the last part
      lastNodeOfSubList.next = current;

      if (current == null)
        break;// break if we reached the end of the linked list
      // prepared for the next sublist
      prev = lastNodeOfSubList;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);
    ListNode result = (Main.reverseEveryKElement(head, 3));
    while (result != null) {
      System.out.println(result.value + " ");
      result = result.next;
    }
  }
}
