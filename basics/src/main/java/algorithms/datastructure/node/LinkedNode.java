package algorithms.datastructure.node;

public class LinkedNode {

  public LinkedNode next = null;
  public Integer data  = null;

  public LinkedNode(Integer data) {
    this.data = data;
  }

  public void appendToTail(int data) {
    LinkedNode newLinkedNode = new LinkedNode(data);
    LinkedNode linkedNode = this;
    while (linkedNode.next != null) {
      linkedNode = linkedNode.next;
    }
    linkedNode.next = newLinkedNode;
    linkedNode.next.next = null;
  }

  public LinkedNode deleteNode (Integer data) {
    LinkedNode head = this;
    if (head.data.equals(data)) {
      return head.next;
    }

    while (head.next != null) {
      if (head.next.data.equals(data)) {
        head.next = head.next.next;
        return head;
      }
      head = head.next;
    }
    return head;
  }

  public void displayNodes () {
    LinkedNode linkedNode = this;
    System.out.println(linkedNode.data);
  	while (linkedNode.next != null) {
      linkedNode = linkedNode.next;
      System.out.println(linkedNode.data);
    }
  }
}
