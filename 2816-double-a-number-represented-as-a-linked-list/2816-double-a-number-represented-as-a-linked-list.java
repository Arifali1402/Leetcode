/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reversed(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode revHead = reversed(head);
        ListNode curr = revHead;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int carry = 0;

        while(curr != null){
            int doubledValue = 2*(curr.val) + carry;
            carry = doubledValue/10;
            result.next = new ListNode(doubledValue%10);
            result = result.next;
            curr = curr.next;
        }
        // If there any carry remain
        if(carry != 0){
            result.next = new ListNode(carry);
        }
        return reversed(dummy.next);
    }
}