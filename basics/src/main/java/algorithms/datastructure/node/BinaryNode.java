package algorithms.datastructure.node;

public class BinaryNode<T> {

  private T key;
  public BinaryNode left, right;

  public BinaryNode(T key) {
    this.key = key;
    this.left = this.right = null;
  }

  public T getKey() {
    return key;
  }

  public void setKey(T key) {
    this.key = key;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }
}