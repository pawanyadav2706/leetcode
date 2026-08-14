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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean x1 = false;
            boolean y1 = false;

            for(int i =0; i<size; i++){
                TreeNode node = queue.remove();
                if(node.left != null && node.right != null){
                    if((node.left.val == x && node.right.val == y) ||
                    (node.left.val == y && node.right.val == x)){
                        return false;
                    }
                }
                // check x
                if(node.val == x){
                    x1 = true;
                }
                // check y
                if(node.val == y){
                    y1 = true;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                 if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(x1 && y1){
                return true;
            }
            if(x1 || y1){
                return false;
            }
        }
        return false;
    }
}