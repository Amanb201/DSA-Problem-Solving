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
        Space Complexity -O(N) */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return p==q;

        Boolean left = isSameTree(p.left, q.left);
        Boolean right = isSameTree(p.right, q.right);

        return (left && right && p.val == q.val);
    }
}