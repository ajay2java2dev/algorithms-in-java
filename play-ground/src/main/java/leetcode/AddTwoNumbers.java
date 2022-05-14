package leetcode;

import java.math.BigInteger;


/**
 * Definition for singly-linked list.
**/
public class AddTwoNumbers {

    /* Below works for small soltions but not for bigger strings */
    public ListNode bruteForceSolution(ListNode l1, ListNode l2) {
        ListNode outNode = null;
        if (l1 == null || l2 == null) {
            return outNode;
        }

        StringBuilder val1Str = new StringBuilder().append(l1.val);
        while (l1.next != null) {
            l1 = l1.next;
            val1Str.append(l1.val);
        }
        StringBuilder val2Str = new StringBuilder().append(l2.val);
        while (l2.next != null) {
            l2 = l2.next;
            val2Str.append(l2.val);
        }

        long val1 = Long.parseLong(val1Str.reverse().toString());
        long val2 = Long.parseLong(val2Str.reverse().toString());
        String valOut = new StringBuilder().append(val1 + val2).toString();

        String[] outSplit = valOut.split("");
        for (int i = 0; i < outSplit.length; i++) {
            Long v1 = Long.parseLong(outSplit[i]);
            outNode = new ListNode(v1.intValue(), outNode);
        }
        return outNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); //initial node set as dummy.
        ListNode p = l1, q = l2, curr = dummyHead; // p and q assigned with l1 and l2
        int carry = 0; //Carry logic for handling large numbers

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y; //hmmm no reverse the list ???
            carry = sum / 10;
            curr.next = new ListNode (sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);

        AddTwoNumbers s1 = new AddTwoNumbers();
        ListNode l7 = s1.bruteForceSolution(l3, l6);
        while (l7.next != null) {
            System.out.println(l7.val);
            l7 = l7.next;
        }
        System.out.println(l7.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}