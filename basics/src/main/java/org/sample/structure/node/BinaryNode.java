package org.sample.structure.node;

import lombok.Data;

@Data
public class BinaryNode<T> {

  private T key;
  public BinaryNode left, right;

  public BinaryNode(T key, BinaryNode<T> left, BinaryNode<T> right) {
    this.key = key;
    this.left = left;
    this.right = right;
  }
}