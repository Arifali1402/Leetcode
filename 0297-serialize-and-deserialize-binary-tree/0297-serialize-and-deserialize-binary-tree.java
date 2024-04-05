/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        // Level Order Traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                str.append("# ");
                continue;
            }
            else{
                str.append(curr.val+" ");
            }
            // Always add left and right irrespective of null or not
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String arr[] = data.split(" ");
        // Root of the tree is always the first character in the dta string
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        for(int i=1;i<arr.length;i++){
            TreeNode parent = queue.poll();
            // If left node is not null
            if(!arr[i].equals("#")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = leftChild;
                queue.offer(leftChild);
            }
            // If right node is not null
            if(!arr[++i].equals("#")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = rightChild;
                queue.offer(rightChild);
            }
            // If both the conditions are false, then the null node will get automatically attached to the parent node
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));