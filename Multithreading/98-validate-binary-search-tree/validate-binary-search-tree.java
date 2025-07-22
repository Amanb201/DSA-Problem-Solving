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
    public boolean isValidBST(TreeNode root) {
        // if(root.left == null && root.right == null) return true;

        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValidBST (TreeNode root, long minValue, long maxValue){
        if(root == null)    return true;

        if(root.val <= minValue || root.val >= maxValue) return false;

        boolean isLstValid = checkValidBST (root.left, minValue, root.val);
        boolean isRstValid = checkValidBST (root.right, root.val, maxValue);

        return isLstValid && isRstValid;
    }
}