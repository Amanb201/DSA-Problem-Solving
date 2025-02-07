class Solution {
    class Pair{
        int node1;
        int node2;
        int wt;

        Pair (int n2, int n1, int wt){
            this.node2 = n2;
            this.node1 = n1;
            this.wt = wt;
        }
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList());
        }

        int minEdgeWt = Integer.MAX_VALUE; 
        int maxEdgeWt = Integer.MIN_VALUE;
        for(int i=0; i<edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int wt = edges[i][2];

            List<Pair> neighbors = adjList.get(node2);

            minEdgeWt = Math.min(minEdgeWt, wt);
            maxEdgeWt = Math.max(maxEdgeWt, wt);
            neighbors.add(new Pair(node2, node1, wt));
            adjList.set(node2, neighbors);
        }

        return binarySearchOnAnswer(minEdgeWt, maxEdgeWt, adjList);
    }

    int binarySearchOnAnswer(int low, int high, List<List<Pair>> adjList){
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isEdgeWtValid(mid, adjList)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    Boolean isEdgeWtValid(int wt, List<List<Pair>> adjList){
        int n = adjList.size();
        int [] visited = new int[n];
        
        for(int i=0; i<n; i++){
            visited[i] = -1;
        }

        dfs(wt, 0, adjList, visited);
        boolean isReachableToZero = true;
        for(int i=0; i<visited.length; i++)
            if(visited[i] == -1)
                 isReachableToZero = false;

        return isReachableToZero;
    }

    void dfs(int wt, int node, List<List<Pair>> adjList, int[] visited){
        visited[node] = 1;

        for(Pair pair: adjList.get(node)){
            if(visited[pair.node1] == -1 && pair.wt<=wt){
                dfs(wt, pair.node1, adjList, visited);
            }
        }
    }
}