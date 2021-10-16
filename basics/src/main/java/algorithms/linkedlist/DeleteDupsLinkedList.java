package algorithms.linkedlist;

import algorithms.datastructure.node.LinkedNode;

import java.util.Hashtable;

public class DeleteDupsLinkedList {

  public static LinkedNode deleteDups(LinkedNode linkedNode) {

    Hashtable hashtable = new Hashtable();
    LinkedNode previous = null;

    while (linkedNode.next != null) {
      if (hashtable.contains((Integer) linkedNode.data)) {
        previous.next = linkedNode.next.next;
      } else {
        hashtable.put((Integer) linkedNode.data, true);
        previous = linkedNode;
      }
      linkedNode = linkedNode.next;
    }
    return previous;
  }

  public static void main(String[] args) {
    LinkedNode linkedNode = new LinkedNode(10);
    linkedNode.appendToTail(20);
    linkedNode.appendToTail(30);
    linkedNode.appendToTail(40);
    linkedNode.appendToTail(50);
    linkedNode.appendToTail(50);
    linkedNode.appendToTail(40);
    linkedNode.appendToTail(30);

    LinkedNode linkedNode1 = deleteDups(linkedNode);
    linkedNode1.displayNodes();
  }
}
