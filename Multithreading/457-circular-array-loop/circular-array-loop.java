class Solution {
    public boolean circularArrayLoop(int[] nums) {
        return approach1(nums);
        // return optmialApproach(nums);
    }

    /***
        Floyd's Cycle Detection (Tortoise and Hare) [Slow/Fast pointers]
        Time Complexity - O(N);
        Space Complexity - O(1);
     */
    private boolean optmialApproach(int[] nums){
        int n = nums.length;

        for(int i=0; i<n; i++){
            //If Node is already visited
            if(nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean isForward = nums[i]>0;

            while(true){
                //1 Step Forward
                slow = getNext(nums, isForward, slow);
                //2 Step Forward
                fast = getNext(nums, isForward, getNext(nums, isForward, fast));

                //Cycle Not Possible (either self loop or Opposite Direction Move)
                if(slow == -1 || fast == -1)    break;

                //Cycle Detected [Tortoise and HARE]
                if(slow == fast) return true;
            }

            //Mark the reachable nodes in the path starting from curr node as visited, so, that we don't have to re-visit
            markVisited(nums, i);
        }

        //No Cycle Detected
        return false;
    }

    private int getNext(int[] nums, boolean isForward, int currNode){
        //Cycle not possible
        if(currNode == -1) return -1;

        boolean direction = nums[currNode]>0;
        //Opposite direction Move not allowed in Cycle as per question
        if(isForward != direction) return -1; 
        //Circular Wrap
        int next = Math.floorMod(currNode + nums[currNode], nums.length);

        //Self Loop Not allowed in cycle
        if(currNode == next)    return -1;
        
        return next;
    }

    private void markVisited(int[] nums, int currNode){
        int n = nums.length;
        boolean isForward = nums[currNode]>0;

        int index = currNode;
        while(true){
            boolean direction = nums[index]>0;

            //Opposite Direction not allowed OR if Index is already visited
            if(isForward != direction || nums[index] == 0)
                break;
            //Circular Wrap
            int next = Math.floorMod(index + nums[index], n);
            
            nums[index] = 0;
            //Self Loop
            if(index == next) break;

            index = next;
        }
        
    }

    /***
        DFS Cycle Detection Technique
        Time Complexity - O(N);
        Space Complexity - O(N);
     */
    private boolean approach1(int[] nums){
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
            -ve Steps ==> ((node+nums[node])%size)+size
            for both ==> (((node+nums[node])%size)+size)%size

         */
        //  int nextNode = Math.floorMod((node + nums[node]), nums.length);
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