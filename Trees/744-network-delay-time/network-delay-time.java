class Solution {

    public void populateAdjacencyList(int[][] times,
                Map<Integer, List<Pair<Integer, Integer>>> adjacencyList){
        for(int index=0; index<times.length; index++){
            int source = times[index][0];
            int dest = times[index][1];
            int cost = times[index][2];

            List<Pair<Integer, Integer>> neighbors = new ArrayList<>();
            if(adjacencyList.containsKey(source)){
                neighbors = adjacencyList.get(source);
                neighbors.add(new Pair(cost, dest));
                adjacencyList.put(source, neighbors);
            }
            else{
                neighbors.add(new Pair(cost, dest));
                adjacencyList.put(source, neighbors);
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        /**
            Source->[{cost, dest}, .....]
         */
        Map<Integer, List<Pair<Integer, Integer>>> adjacencyList = new HashMap<>();
        
        populateAdjacencyList(times, adjacencyList);

        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        for(int index=0; index<=n; index++)
            cost[index] = Integer.MAX_VALUE;

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(k);
        cost[k] = 0;
        visited[k] = true;

        while(!bfsQueue.isEmpty()){
            int currNode = bfsQueue.poll();

            if(adjacencyList.containsKey(currNode)){
                List<Pair<Integer, Integer>> neighbors = adjacencyList.get(currNode);

                for(Pair<Integer, Integer> edge: neighbors){
                    int prevCost = edge.getKey();
                    int destNode = edge.getValue();
                    
                    int newCost = cost[currNode];
                    newCost += prevCost;

                    if(newCost<cost[destNode]){
                        cost[destNode] = newCost;

                        visited[destNode] = true;
                        bfsQueue.add(destNode);
                    }
                }
            }
        }

        /**
            Total min cost would be equal to the cost to reach the last node or
             the node with maximum cost 
        */
        int totalMinCost = 0;
        for(int index=1; index<=n; index++){
            if(!visited[index])
                return -1;
            else
                totalMinCost = cost[index]>totalMinCost?cost[index] :totalMinCost;
        }

        return totalMinCost;
    }
}