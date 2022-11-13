package org.sample.algorithms.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> {
    T value;
    LinkedNode<T> next = null;
    LinkedNode<T> prev = null;

    public LinkedNode(T value) {
        this.value = value;
    }

}
