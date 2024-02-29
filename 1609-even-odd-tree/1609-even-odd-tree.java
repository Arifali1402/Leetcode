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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2 == 0){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int prevValue = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Check the conditions for even and odd levels
                if ((level % 2 == 0 && (curr.val % 2 == 0 || curr.val <= prevValue))
                        || (level % 2 == 1 && (curr.val % 2 == 1 || curr.val >= prevValue))) {
                    return false;
                }

                prevValue = curr.val;

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            level++;
        }
        return true;
    }
}

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public boolean isEvenOddTree(TreeNode root) {
//         if(root.val%2 == 0){
//             return false;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         int k = 0;
//         queue.add(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             List<Integer> list = new LinkedList<>();
//             for(int i=0;i<size;i++){
//                 TreeNode curr = queue.poll();
//                 list.add(curr.val);
//                 if(curr.left != null){
//                     queue.add(curr.left);
//                 }
//                 if(curr.right != null){
//                     queue.add(curr.right);
//                 }
//             }
//             if(k == 0){
//                 k++;
//                 continue;
//             }
//             // for even-index level
//             if(k%2 == 0){
                
//                 for(int j = 0;j<list.size()-1;j++){
//                     int first = list.get(j);
//                     int second = list.get(j+1);
//                     if(first%2 == 0 || second%2 == 0){
//                         return false;
//                     }
//                     if(first >= second){
//                         return false;
//                     }
//                 }
//             }
//             // for odd-index level
//             else{
                
//                 for(int j = 0;j<list.size()-1;j++){
//                     int first = list.get(j);
//                     int second = list.get(j+1);
//                     if(first%2 != 0 || second%2 != 0){
//                         return false;
//                     }
//                     if(first <= second){
//                         return false;
//                     }
//                 }
//             }
//             k++;
//         }
//         return true;
//     }
// }