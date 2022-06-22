package algorithms.linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TestLinkedList {

    static void printLinkedList (LinkedNode linkedList) {
        while (linkedList != null) {
            System.out.println(linkedList.getValue());
            linkedList = linkedList.next;
        }
    }

    static LinkedNode reverseLinkedList(LinkedNode currentLinkedList) {
        LinkedNode prev = null;
        LinkedNode current = currentLinkedList;

        while (current != null) {
            LinkedNode next = current.next;
            current.next = prev;
            prev = current; // this step is for swapping
            current = next; //this step is to get increments
        }

        return prev;
    }

    static LinkedNode reverseSubLinkedList (LinkedNode head, int start, int end) {

        int currentPos = 1;
        LinkedNode currentNode = head, startNode = head;

        while (currentPos < start) {
            startNode = currentNode; // in the end startNode will be positioned in the end.
            currentNode = currentNode.next;
            currentPos++;
        }

        LinkedNode newNode = null;
        LinkedNode tail = currentNode;

        while (currentPos >= start && currentPos <= end) {
            LinkedNode next = currentNode.next;
            currentNode.next = newNode;
            newNode = currentNode;
            currentNode = next;
            currentPos++;
        }

        startNode.next = newNode;
        tail.next = currentNode;

        if (start > 1) {
            return head;
        }

        return newNode;
    }

    static String minRemoveToMakeValid(String str) {
        if (str==null || str.isBlank()) return null;

        String [] chars = str.split("");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].equalsIgnoreCase("(")) {
                stack.push(i); // push the bracket index
            } else if (chars[i].equalsIgnoreCase(")") && !stack.isEmpty()) {
                stack.pop();
            } else if (chars[i].equalsIgnoreCase(")")) {
                chars[i] = "";
            }
        }

        while (!stack.isEmpty()) {
            //while stack is still not empty
            int currIndex = stack.pop();
            chars[currIndex] = "";
        }

        String response = Arrays.asList(chars).stream().collect(Collectors.joining());
        return response;
    }

    public static void main(String[] args) {
        var newLinkedList = new LinkedNode<Integer>(10);
        newLinkedList.next = new LinkedNode<>(12);
        newLinkedList.next.next = new LinkedNode<>(12);
        printLinkedList(newLinkedList);
        printLinkedList(reverseLinkedList(newLinkedList));

        newLinkedList = new LinkedNode<Integer>(1);
        newLinkedList.next = new LinkedNode<>(2);
        newLinkedList.next.next = new LinkedNode<>(3);
        newLinkedList.next.next.next = new LinkedNode<>(4);
        newLinkedList.next.next.next.next = new LinkedNode<>(5);
        newLinkedList.next.next.next.next.next = new LinkedNode<>(6);
        newLinkedList.next.next.next.next.next.next = new LinkedNode<>(7);

        printLinkedList(reverseSubLinkedList(newLinkedList, 3, 5));


        System.out.println(minRemoveToMakeValid("a)bc(d"));
    }
}
