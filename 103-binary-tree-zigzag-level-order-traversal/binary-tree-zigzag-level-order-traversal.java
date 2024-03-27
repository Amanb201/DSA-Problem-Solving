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
        Time  Complexity - O(N)
        Space Complexity - O(N)*/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> traversal = new LinkedList<List<Integer>>();

        if(root == null)
            return traversal;

        que.add(root);
        levelOrderTraversal(que, traversal);
        return traversal;
    }

    void levelOrderTraversal(Queue<TreeNode> que, List<List<Integer>> traversal){
        Boolean leftToRight = true;
        
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> currLevelItems = new ArrayList<>();
            
            for(int iter=0; iter<size; iter++){
                TreeNode currNode = que.poll();
                
                currLevelItems.add(currNode.val);

                if(currNode.left!=null)
                    que.add(currNode.left);
                if(currNode.right!=null)
                    que.add(currNode.right);
            }

            if(leftToRight){
                //Travesal is Left to right
                traversal.add(currLevelItems);
            }
            else{
                //Travesal is Right to Left
                List<Integer> currLevelItemsReversed = new ArrayList<>();
                int lastIndex =currLevelItems.size()-1;

                for(int iter=lastIndex; iter>=0; iter--)
                    currLevelItemsReversed.add(currLevelItems.get(iter));
                
                traversal.add(currLevelItemsReversed);
            }
            leftToRight = !leftToRight;
        }
    }
}