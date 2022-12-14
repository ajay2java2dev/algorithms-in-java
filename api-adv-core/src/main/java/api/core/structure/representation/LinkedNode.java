package api.core.structure.representation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> {
    public T value;
    public LinkedNode<T> next = null;
    public LinkedNode<T> prev = null;

    public LinkedNode(T value) {
        this.value = value;
    }

}
