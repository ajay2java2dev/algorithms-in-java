package algorithms.datastructure.node;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class BinaryNode<T> {

  private T key;
  public BinaryNode left, right;

  public BinaryNode(T key) {
    this.key = key;
    this.left = this.right = null;
  }
}