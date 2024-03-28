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
class VerticalPosNode{
    TreeNode node;
    Integer verPos;
    Integer level;

    VerticalPosNode(TreeNode node, Integer pos, Integer level){
        this.node = node;
        this.verPos = pos;
        this.level = level;
    }
}
class Solution {
    /**
        Time Complexity - O(N) [Level Order Traversal] + O(N)[Verticals] * O(N)[Levels] ??????Approximate time complexity??
        Space Complexity - O(N)[Queue] + O(N) [Vertical Map]
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<VerticalPosNode> que = new LinkedList<VerticalPosNode>();
        List<List<Integer>> verticalTraversalArr = new ArrayList<List<Integer>>();

        //verPos-->{level-->node.val[]}
        Map<Integer, TreeMap<Integer, List<Integer>>> map = 
                                            new TreeMap<Integer, TreeMap<Integer, List<Integer>>>();
        
        if(root!=null){
            que.add(new VerticalPosNode(root, 0, 0));
        }

        while(!que.isEmpty()){
            VerticalPosNode currVerticalPosNode = que.poll();
            Integer pos = currVerticalPosNode.verPos;
            Integer level = currVerticalPosNode.level;
            TreeNode node = currVerticalPosNode.node;
            Integer val = node.val;

            if(!map.containsKey(pos)){
                //VerticalPos is being traversed for first time
                List<Integer> valList = new ArrayList<Integer>();
                valList.add(val);
                TreeMap<Integer, List<Integer>> levelMap = new TreeMap<Integer, List<Integer>>();

                levelMap.put(level,valList);
                map.put(pos, levelMap);
            }
            else if(map.containsKey(pos) && !map.get(pos).containsKey(level)){
                //VerticalPos is already visited but this level is traversed for first time
                List<Integer> valList = new ArrayList<Integer>();
                valList.add(val);
                Map<Integer, List<Integer>> levelMap = map.get(pos);

                levelMap.put(level,valList);
            }
            else{
                //VerticalPos and Level both have been visited but this level contains multiple items in same VerticalPos
                Map<Integer, List<Integer>> levelMap = map.get(pos);
                List<Integer> valList = levelMap.get(level);
                valList.add(val);
            }

            if(node.left!=null)
                que.add(new VerticalPosNode(node.left, pos-1, level+1));

            if(node.right!=null)
                que.add(new VerticalPosNode(node.right, pos+1, level+1));    
        }

        for(Integer pos: map.keySet()){//Worst Case N/2 => O(N) Verticals can be there in complete binary tree at leaf nodes
            Map<Integer, List<Integer>> levelMap = map.get(pos);
            ArrayList<Integer> currVerticalItems = new ArrayList<>();
            for(Integer level: levelMap.keySet()){
                /**
                Length of this List can be somewhere around LogN i.e. maximum no of overlapping nodes at 
                particular level in the same vertical
                 */
                List<Integer> currItems = levelMap.get(level); 
                Collections.sort(currItems);

                for(int index=0; index<currItems.size(); index++){
                    currVerticalItems.add(currItems.get(index));
                }
            }
            verticalTraversalArr.add(currVerticalItems);
        }

        return verticalTraversalArr;
    }
}