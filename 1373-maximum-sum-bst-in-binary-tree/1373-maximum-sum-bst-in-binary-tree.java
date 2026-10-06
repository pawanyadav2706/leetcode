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
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    // min(0), max(1), sum
    public int[] dfs(TreeNode root){
        // base case
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE,0};
        }
        int leftsubtree[] = dfs(root.left);
        int rightsubtree[] = dfs(root.right);

        // check if curr subtree is BST
        if(root.val > leftsubtree[1] && root.val < rightsubtree[0]){
            int currentsum = leftsubtree[2] + rightsubtree[2] + root.val;
            ans  = Math.max(ans, currentsum);
            int minval = Math.min(root.val, leftsubtree[0]);
            int maxval = Math.max(root.val, rightsubtree[1]);

            return new int[]{minval, maxval, currentsum};
        }
        int maxsum = Math.max(leftsubtree[2], rightsubtree[2]);
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, maxsum};
    }
}