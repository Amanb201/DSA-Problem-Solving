class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int size = nums.length;

        //3 states required to track the cycle - Unvisited, Currently Exploring/Visiting, Visited
        int visited[] = new int[size];

        for(int i=0; i<size; i++){
            if(isPathContainsCycle(nums, visited, i))
                return true;
        }
        return false;
    }

    private boolean isPathContainsCycle(int[] nums, int[] visited, int node){
        //Already Visited via some other Path, So It's not a cycle
        if(visited[node] == 2)
            return false;
        
        //1 = currently exploring, and we are again here hence, it contains cycle
        if(visited[node] == 1)
            return true;

        /**
            To Handle Movement in Circular array in Left and Right Directions

            +ve Steps ==> (node+nums[node])%size
            -ve Steps ==> 

         */
        int nextNode = (((node+nums[node])%nums.length) + nums.length) % nums.length;

        //Self Loops/Cycle OR Cycle with moves in the same direction is allowed
        if(node == nextNode || nums[node]*nums[nextNode] < 0){
            visited[node] = 2;
            return false;
        }

        //Currently Exploring
        visited[node] = 1;
        boolean foundCycle = isPathContainsCycle(nums, visited, nextNode);

        if(foundCycle)
            return true;

        visited[node] = 2;
        return false;
    }
}