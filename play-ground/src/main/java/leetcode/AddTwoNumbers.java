package leetcode;

import java.math.BigInteger;


/**
 * Definition for singly-linked list.
**/
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {

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

    /* The above solution is good but can be better */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        StringBuilder build1 = new StringBuilder();
        while (l1 != null) {
            build1.append(l1.val);
            l1 = l1.next;

        }

        StringBuilder build2 = new StringBuilder();
        while (l2 != null) {
            build2.append(l2.val);
            l2 = l2.next;
        }

        System.out.println(build1.toString());
        System.out.println(build2.toString());


        BigInteger val1 = new BigInteger(build1.reverse().toString());
        BigInteger val2 = new BigInteger(build2.reverse().toString());

        BigInteger final12 =  val1.add(val2);
        String final12Str = new StringBuilder().append(final12).reverse().toString();

        ListNode node12 = null;
        ListNode node12Parent = null;

        for (char c : final12Str.toCharArray()) {

            if (node12 == null) {

                node12 = new ListNode(Integer.parseInt(""+c));
                node12Parent = node12;

            } else {

                node12.next = new ListNode(Integer.parseInt(""+c));
                node12 = node12.next;
            }
        }
        return node12Parent;
    }
}