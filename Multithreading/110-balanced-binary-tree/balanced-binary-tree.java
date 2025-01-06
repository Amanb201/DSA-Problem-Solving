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
    public int isTreeBalanced(TreeNode node){
        if(node == null) return 0;

        int leftTreeHeight = isTreeBalanced(node.left);
        int rightTreeHeight = isTreeBalanced(node.right);

        if(leftTreeHeight < 0 || rightTreeHeight < 0 || Math.abs(leftTreeHeight - rightTreeHeight) > 1)   return -1;

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }

    public boolean isBalanced(TreeNode root) {

        return isTreeBalanced(root) >= 0;
        
    }
}