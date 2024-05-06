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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        Stack<Integer> newStack = new Stack<>();

        int bigElement = stack.pop();
        newStack.push(bigElement);

        while(!stack.isEmpty()){
            if(bigElement > stack.peek()){
                stack.pop();
            }
            else if(bigElement <= stack.peek()){
                bigElement = stack.peek();
                newStack.push(stack.pop());
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!newStack.isEmpty()){
            list.add(newStack.pop());
        }
        // Collections.reverse(list);

        ListNode newHead = new ListNode(list.get(0));
        ListNode curr = newHead;
        for(int i=1;i<list.size();i++){
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        return newHead;
    }
}