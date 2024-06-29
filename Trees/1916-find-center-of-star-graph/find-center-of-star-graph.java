class Solution {
    public void addNeighbor(int vertex1, int vertex2, Map<Integer, List<Integer>> adjacencyList){
            List<Integer> neighbors = new ArrayList<>();
            
            if(adjacencyList.containsKey(vertex1)){
                neighbors = adjacencyList.get(vertex1);
                neighbors.add(vertex2);
                adjacencyList.put(vertex1, neighbors);
            }
            else{
                neighbors.add(vertex2);
                adjacencyList.put(vertex1, neighbors);
            }
    }

    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        int totalEdges = edges.length;
        for(int edge=0; edge<totalEdges; edge++){
            int vertex1 = edges[edge][0];
            int vertex2 = edges[edge][1];
            addNeighbor(vertex1, vertex2, adjacencyList);
            addNeighbor(vertex2, vertex1, adjacencyList);
        }

       for(int node: adjacencyList.keySet()){
            int sizeNeighbors = adjacencyList.get(node).size();

            if(sizeNeighbors == totalEdges)
                return node;
       } 

       return -1;
    }
}