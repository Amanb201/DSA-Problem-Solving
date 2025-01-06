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
    public int diameterOfBTree(TreeNode root, int[] maxVal){
        if(root == null){
            return 0;
        }

        int leftSubtree = diameterOfBTree(root.left, maxVal);
        int rightSubtree = diameterOfBTree(root.right, maxVal);

        maxVal[0] = Math.max(leftSubtree + rightSubtree, maxVal[0]);
        return 1 + Math.max(leftSubtree, rightSubtree);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxVal = new int[1];
        maxVal[0] = 0;
        diameterOfBTree(root, maxVal);
        return maxVal[0];
    }
}