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
    public int convertBstToGst (TreeNode node, int sum) {
        if(node == null)
            return 0;

        int rightSubtreeSum = convertBstToGst(node.right, sum);
        int prevVal = node.val;
        node.val = rightSubtreeSum + node.val + sum;
        int leftSubtreeSum = convertBstToGst(node.left, node.val);
        
        return leftSubtreeSum + prevVal + rightSubtreeSum;
    }
    public TreeNode bstToGst(TreeNode root) {
        TreeNode currNode = root;
        convertBstToGst(currNode, 0);
        return root;
    }
}