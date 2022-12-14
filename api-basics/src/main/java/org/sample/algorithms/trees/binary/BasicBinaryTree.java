package org.sample.algorithms.trees.binary;

// https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

import api.core.structure.representation.BinaryNode;

//1) The maximum number of nodes at level ‘l’ of a binary tree is 2^(l-1).
  //1.a)Next level would have twice nodes, i.e. 2 * 2^(l-1)
//2) Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1. (Geometric Series)
//3) In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  ? Log2(N+1)
public class BasicBinaryTree {

  static BinaryNode node = null;

  // display
  public void displayNode(BinaryNode node) {
    travelPreOrder(node);
  }

  // traversal recurssion...
  public void travelPreOrder(BinaryNode node) {

    if (node == null)
      return;

    System.out.print(node.getKey() + " ");
    travelPreOrder(node.left);
    travelPreOrder(node.right);

  }

  public void travelInOrder(BinaryNode node) {

    if (node == null)
      return;

    travelInOrder(node.left);
    System.out.print(node.getKey() + " ");
    travelInOrder(node.right);

  }

  public void travelPostOrder(BinaryNode node) {
    if (node == null)
      return; // base case

    travelPostOrder(node.left);
    travelPostOrder(node.right);
    System.out.print(node.getKey() + " ");

  }

  public void constructSampleBinaryTree() {

    node = new BinaryNode(10,
            //left
            new BinaryNode(5,
                    new BinaryNode(3, null, null),
                    new BinaryNode(2, null, null)),
            //right
            new BinaryNode(30,
                    new BinaryNode(15, null, null),
                    new BinaryNode(40, null, null)));
  }

  public static void main(String[] args) {
    BasicBinaryTree tree = new BasicBinaryTree();
    tree.constructSampleBinaryTree();

    System.out.println("BinaryTree.displayNode ... ");
    tree.displayNode(node);
    System.out.println("\n");

    System.out.print("BinaryTree.travelPreOrder ... ");
    tree.travelPostOrder(node);
    System.out.println("\n");

    System.out.print("BinaryTree.travelInOrder ... ");
    tree.travelInOrder(node);
    System.out.println("\n");

    System.out.print("BinaryTree.travelPostOrder ... ");
    tree.travelPreOrder(node);
    System.out.println("\n");
  }
}
