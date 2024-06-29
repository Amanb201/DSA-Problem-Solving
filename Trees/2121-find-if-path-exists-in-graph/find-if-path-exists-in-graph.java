class Solution {
    public void addNeighbor(int vertex1, int vertex2, Map<Integer, List<Integer>> adjacenyList){
            if(adjacenyList.containsKey(vertex1)){
                List<Integer> neighbors = adjacenyList.get(vertex1);
                neighbors.add(vertex2);
                adjacenyList.put(vertex1, neighbors);
            }
            else{
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(vertex2);
                adjacenyList.put(vertex1, neighbors);
            }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjacenyList = new HashMap<>();
        int edgesLen = edges.length;

        if(source == destination)
            return true;
            
        if(edgesLen==0)
            return false;

        for(int edge=0; edge<edgesLen; edge++){
            int vertex1 = edges[edge][0];
            int vertex2 = edges[edge][1];

            addNeighbor(vertex1, vertex2, adjacenyList);
            addNeighbor(vertex2, vertex1, adjacenyList);
        }

        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        bfsQueue.add(source);
        visited[source] = true;

        while(!bfsQueue.isEmpty()){
            int currNode = bfsQueue.poll();

            List<Integer> neighbors = adjacenyList.get(currNode);
            for(int index=0; index<neighbors.size(); index++){
                System.out.println("Source "+currNode+" "+neighbors.get(index));
                if(neighbors.get(index) == destination)
                    return true;

                if(!visited[neighbors.get(index)]){
                    visited[neighbors.get(index)] = true;
                    bfsQueue.add(neighbors.get(index));
                }
            }
        }
        return false;
    }
}