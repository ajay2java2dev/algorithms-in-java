package dev.algorithms.trees;

import dev.datastructure.node.BinaryNode;

// https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
// https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

//1) The maximum number of nodes at level ‘l’ of a binary tree is 2^(l-1).
  //1.a)Next level would have twice nodes, i.e. 2 * 2^(l-1)
//2) Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1. (Geometric Series)
//3) In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  ? Log2(N+1)
public class BinaryTree {

  static BinaryNode node = null;

  // display
  public void displayNode(BinaryNode node) {

    if (node == null) return; // base case
    if (node != null) {
      System.out.println(node.key);
      displayNode(node.left);
      displayNode(node.right);
    }
  }

  // traversal recurssion...
  public void travelPreOrder(BinaryNode node) {

    if (node == null) return; // base case
    if (node != null) {
      System.out.print(node.key + " ");
      travelPreOrder(node.left);
      travelPreOrder(node.right);
    }
  }

  public void travelInOrder(BinaryNode node) {

    if (node == null) return; // base case
    if (node != null) {
      travelInOrder(node.left);
      System.out.print(node.key + " ");
      travelInOrder(node.right);
    }
  }

  public void travelPostOrder(BinaryNode node) {
    if (node == null) return; // base case
    if (node != null) {
      travelPostOrder(node.left);
      travelPostOrder(node.right);
      System.out.print(node.key + " ");
    }
  }

  public void constructSampleBinaryTree() {
    node = new BinaryNode(10);
    node.left = new BinaryNode(5);
    node.left.left = new BinaryNode(3);
    node.left.left.left = new BinaryNode(2);
    node.left.left.right = new BinaryNode(4);

    node.right = new BinaryNode(30);
    node.right.left = new BinaryNode(15);
    node.right.right = new BinaryNode(40);
    node.right.left.left = new BinaryNode(12);
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
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
