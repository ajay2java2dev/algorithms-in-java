package org.sample.algorithms.linkedlist;

import org.sample.structure.node.LinkedNode;

public class SimpleLinkedList {

  public static void main(String[] args) {
    LinkedNode linkedNode = new LinkedNode(10);
    linkedNode.appendToTail(20);
    linkedNode.appendToTail(30);
    linkedNode.appendToTail(40);
    linkedNode.appendToTail(50);
    System.out.println("*******************************");
    linkedNode.displayNodes();
    System.out.println("*******************************");
    linkedNode.deleteNode(30);
    System.out.println("*******************************");
    linkedNode.displayNodes();

    linkedNode.deleteNode(30);
    System.out.println("*******************************");
    linkedNode.displayNodes();
    System.out.println("*******************************");

    linkedNode.deleteNode(40);
    System.out.println("*******************************");
    linkedNode.displayNodes();
    System.out.println("*******************************");
  }
}
