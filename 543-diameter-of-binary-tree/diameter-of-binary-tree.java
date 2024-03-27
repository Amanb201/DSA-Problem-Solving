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
    /**
        Time Complexity - O(N)
        Space Complexity - O(N) */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxLen = new int[1];
        maxLen[0] = 0;
        maxPathLength(root, maxLen);

        return maxLen[0];
    }

    int maxPathLength(TreeNode root, int[] maxLen){
        if(root == null)
            return 0;

        int leftHt = maxPathLength(root.left, maxLen);
        int rightHt = maxPathLength(root.right, maxLen);

        maxLen[0] = Math.max(maxLen[0], leftHt+rightHt);
        return 1 + Math.max(leftHt, rightHt);
    }
}