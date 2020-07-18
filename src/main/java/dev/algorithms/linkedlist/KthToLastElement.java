package dev.algorithms.linkedlist;

import dev.algorithms.datastructure.node.LinkedNode;

public class KthToLastElement {

  public int kthToLastElementR1(LinkedNode node, int k) {

    if (node == null) {
      return 0;
    }

    int val = kthToLastElementR1(node.next, k) + 1;

    if (val == k) {
      System.out.println("Found kth element --> " + node.data);
    }

    return val;
  }

  class IntWrapper {
    int val = 0;
  }


  // Oh this was great... still need to understand how it worked out.
  // The last stack def may not be the stack which contained the right answer, but inspite of that
  //
  public LinkedNode kthToLastElementR2(LinkedNode head, int k, IntWrapper i) {

    if (head == null) {
      return null;
    }

    LinkedNode node = kthToLastElementR2(head.next, k, i);
    i.val = i.val + 1;
    if (i.val == k) {
      return head;
    }

    return node;
  }

  public static void main(String[] args) {
    LinkedNode linkedNode = new LinkedNode(10);
    linkedNode.appendToTail(20);
    linkedNode.appendToTail(30);
    linkedNode.appendToTail(40);
    linkedNode.appendToTail(50);

    // here the problem is we are not able to return a counter and a index at same time.
    KthToLastElement kthToLastElement = new KthToLastElement();
    kthToLastElement.kthToLastElementR1(linkedNode, 1);
    kthToLastElement.kthToLastElementR1(linkedNode, 2);
    kthToLastElement.kthToLastElementR1(linkedNode, 3);
    kthToLastElement.kthToLastElementR1(linkedNode, 4);
    kthToLastElement.kthToLastElementR1(linkedNode, 5);
    kthToLastElement.kthToLastElementR1(linkedNode, 6); // not found.

    KthToLastElement.IntWrapper intWrapper = kthToLastElement.new IntWrapper();
    LinkedNode node = kthToLastElement.kthToLastElementR2(linkedNode, 5, intWrapper);
    System.out.println(
        "KthToLastElement.main --> " + node != null ? node.data : "Aiyooo node not" + " found");

    intWrapper = kthToLastElement.new IntWrapper();
    node = kthToLastElement.kthToLastElementR2(linkedNode, 3, intWrapper);
    System.out.println(
        "KthToLastElement.main --> " + node != null ? node.data : "Aiyooo node not" + " found");

    intWrapper = kthToLastElement.new IntWrapper();
    node = kthToLastElement.kthToLastElementR2(linkedNode, 2, intWrapper);
    System.out.println(
        "KthToLastElement.main --> " + node != null ? node.data : "Aiyooo node not" + " found");

    intWrapper = kthToLastElement.new IntWrapper();
    node = kthToLastElement.kthToLastElementR2(linkedNode, 1, intWrapper);
    System.out.println(
        "KthToLastElement.main --> " + node != null ? node.data : "Aiyooo node not" + " found");

    intWrapper = kthToLastElement.new IntWrapper();
    node = kthToLastElement.kthToLastElementR2(linkedNode, 4, intWrapper);
    System.out.println(
        "KthToLastElement.main --> " + node != null ? node.data : "Aiyooo node not" + " found");

    intWrapper = kthToLastElement.new IntWrapper();
    node = kthToLastElement.kthToLastElementR2(linkedNode, 6, intWrapper);
    if (node != null) {
      System.out.println(
          "KthToLastElement.main --> " + node != null ? node.data : "Aiyooo node not" + " found");
    }
  }
}
