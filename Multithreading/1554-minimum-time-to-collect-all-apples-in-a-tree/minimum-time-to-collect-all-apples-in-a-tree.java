class Solution {
    private int dfs(Map<Integer, List<Integer>> adjMap, boolean[] visited, int index, List<Boolean> hasApple){
        List<Integer> neighbours = adjMap.get(index) != null? adjMap.get(index) : new ArrayList<>();

        int currCount = 0;
        System.out.println("index="+index);

        if(!visited[index]){
            visited[index] = true;

            for(int neigh: neighbours){
                int countEdges = 0;
                
                if(!visited[neigh]){
                    countEdges = dfs(adjMap, visited, neigh, hasApple);

                    if(hasApple.get(neigh) || countEdges>0)
                        countEdges += 2;
                }
                currCount += countEdges;

                // if(index == 0)
                //     System.out.println("index="+index+" currCount="+currCount + " neigh="+neigh);

            }
            // System.out.println("index="+index+"currCount="+currCount);
        }
        return currCount;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        int size = hasApple.size();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        boolean[] visited = new boolean[size];

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            List<Integer> neighbours = new ArrayList<>();
            if(adjMap.containsKey(u)){
                neighbours = adjMap.get(u);
                neighbours.add(v);
            }else{
                neighbours.add(v);
            }
            adjMap.put(u, neighbours);

            neighbours = new ArrayList<>();
            if(adjMap.containsKey(v)){
                neighbours = adjMap.get(v);
                neighbours.add(u);
            }else{
                neighbours.add(u);
            }
            adjMap.put(v, neighbours);

        }

        int ans = 0;
        ans = dfs(adjMap, visited, 0, hasApple);

        return ans;
    }
}