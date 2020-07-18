package dev.algorithms.datastructure.node;

public class BinaryNode {

  public int key;
  public BinaryNode left, right;

  public BinaryNode(int item) {
    key = item;
    left = right = null;
  }
}