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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> nodeToBeDeleted = new HashSet<>();

        for(int node: to_delete){
            nodeToBeDeleted.add(node);
        }
        Map<TreeNode, Boolean> potentialRoots = new HashMap<>();
        buildNodeChildMap(root, nodeToBeDeleted, null, null, potentialRoots);

        //For Curr Root Node
        potentialRoots.put(root, potentialRoots.getOrDefault(root, false));

        List<TreeNode> rootsOfForest = new ArrayList<>();

        for(TreeNode node: potentialRoots.keySet()){
            if(!potentialRoots.get(node)){
                rootsOfForest.add(node);
            }
        }

        return rootsOfForest;
    }

    private void buildNodeChildMap(TreeNode root, Set<Integer> nodeToBeDeleted,
     TreeNode parent, Boolean isLeft, Map<TreeNode, Boolean> potentialRoots){
        if(root == null)    return;

        buildNodeChildMap(root.left, nodeToBeDeleted, root, true, potentialRoots);
        buildNodeChildMap(root.right, nodeToBeDeleted, root, false, potentialRoots);

        if(nodeToBeDeleted.contains(root.val)){
            potentialRoots.put(root, true);
            
            if(root.left != null)
                potentialRoots.put(root.left, potentialRoots.getOrDefault(root.left, false));

            if(root.right != null)
                potentialRoots.put(root.right, potentialRoots.getOrDefault(root.right, false));

            //Deleting
            if(isLeft != null && isLeft){
                parent.left = null;
            }
            else if(isLeft != null && !isLeft){
                parent.right = null;
            }
        }
    }
}