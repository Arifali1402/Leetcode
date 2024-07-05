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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null || head.next.next.next == null){
            return new int[]{-1,-1};
        }
        ArrayList<Integer> list = new ArrayList<>();
        // List<Integer> l = new LinkedList<>();
        ListNode temp = head.next;
        int prev = head.val;
        int next = temp.next.val;
        int i = 2; 
        while(temp.next != null){
            if(temp.val > prev && temp.val > next){
                list.add(i);
            }
            else if(temp.val < prev && temp.val < next){
                list.add(i);
            }
            prev = temp.val;
            temp = temp.next;
            if(temp.next == null){
                break;
            }
            next = temp.next.val;
            i++;
        }
        // for(int j=0;j<list.size();j++){
        //     System.out.print(list.get(j)+" ");
        // }
        if(list.size()<2){
            return new int[]{-1,-1};
        }
        int mini = list.get(list.size()-1) - list.get(list.size()-2);
        int maxi = list.get(list.size()-1) - list.get(0);
        for(int k=1;k<list.size();k++){
            mini = Math.min(mini, list.get(k)-list.get(k-1));
        }
        return new int[]{mini, maxi};
    }
}