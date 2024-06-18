class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itineraryList = new ArrayList<>();
        Map<String, PriorityQueue<String>> adjacencyMap = new HashMap<>();

        for(int index=0; index<tickets.size(); index++){
            List<String> currEdge = tickets.get(index);

            String source = currEdge.get(0);
            String dest = currEdge.get(1);

            PriorityQueue<String> currPqueue = new PriorityQueue<>();
            if(adjacencyMap.containsKey(source)){
                currPqueue = adjacencyMap.get(source);
            }
            
            currPqueue.add(dest);
            adjacencyMap.put(source, currPqueue);
        }

        /**
            JFK ---> {KUL, NRT}
            NRT ---> {JFK}
         */
        String source = "JFK";
        //Applying DFS Traversal
        DfsTraversal(source, adjacencyMap, itineraryList);

        return itineraryList;
    }

    public void DfsTraversal(String source, Map<String, PriorityQueue<String>> adjacencyMap,
        List<String> itineraryList){
            PriorityQueue<String> currPqueue = adjacencyMap.get(source);
            
            while((currPqueue != null) && (!currPqueue.isEmpty())){
                String currNode = currPqueue.poll();
                DfsTraversal(currNode, adjacencyMap, itineraryList);   
            }
            itineraryList.addFirst(source);
    }
}