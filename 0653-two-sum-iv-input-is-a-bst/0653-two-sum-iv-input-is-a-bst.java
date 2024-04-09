/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int low = 0;
        int high = list.size()-1;
        while(low < high){
            int first = list.get(low);
            int last = list.get(high);
            int total = first + last;
            if(total == k){
                return true;
            }
            else if(total < k){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}