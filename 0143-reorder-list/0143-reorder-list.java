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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode cur = head;
        int size = 0;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        int len1, len2;
        len1 = size/2;
        if(size%2 != 0){
            len1++;
        }
        int len = size/2;
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ListNode curr = head;
        while(len1>0){
            l1.add(curr.val);
            curr = curr.next;
            len1--;
        }
        len2 = size/2;
        while(len2>0){
            l2.add(curr.val);
            curr = curr.next;
            len2--;
        }
        Collections.reverse(l1);
        ListNode ans = head;
        int i=l1.size()-1;
        int j=l2.size()-1;
        while(ans != null){
            if(i>=0){
                ans.val = l1.get(i);
                i--;
                ans = ans.next;
            }
            if(ans == null){
                break;
            }
            if(j>=0){
                ans.val = l2.get(j);
                j--;
            }
            ans = ans.next;
        }
    }
}