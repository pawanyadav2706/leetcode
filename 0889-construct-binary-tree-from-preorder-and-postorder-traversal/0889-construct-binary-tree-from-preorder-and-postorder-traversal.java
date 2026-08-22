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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 0){
            return null;
        }
        int root = preorder[0];

        TreeNode node = new TreeNode(root);
        if(preorder.length == 1){
            return node;
        }
        int leftroot = preorder[1];
        //postorder me leftroot ka index find out kro
        int index = 0;
        for(int i =0; i< postorder.length; i++){
            if(postorder[i] == leftroot){
                index = i;
            }
        }
        int leftsize = index + 1;

        node.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, leftsize + 1), 
        Arrays.copyOfRange(postorder,0,leftsize));
        node.right = constructFromPrePost(Arrays.copyOfRange(preorder,leftsize + 1, preorder.length), 
        Arrays.copyOfRange(postorder,leftsize, postorder.length - 1));
        return node;
    }
}