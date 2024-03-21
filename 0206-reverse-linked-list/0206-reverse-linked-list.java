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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            ListNode x = curr.next;
            curr.next = prev;
            prev = curr;
            curr = x;
        }
        head.next = null;
        head = prev;
        return head;
    }
}