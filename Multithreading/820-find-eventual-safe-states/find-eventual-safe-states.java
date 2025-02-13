class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int verticesCount = graph.length;
        int[] visited = new int[verticesCount];
        int[] pathVisited = new int[verticesCount];

        Stack<Integer> topoSortStack = new Stack<>();
        for(int vertex=0; vertex<verticesCount; vertex++){
            if(visited[vertex] == 0)
                topologicalSort(vertex, graph, visited, pathVisited, topoSortStack);
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!topoSortStack.isEmpty())
            safeNodes.add(topoSortStack.pop());

        Collections.sort(safeNodes);

        return safeNodes;
    }

    boolean topologicalSort(int vertex, int[][] graph, int[] visited, int[] pathVisited, Stack<Integer> topoSortStack){
        visited[vertex] = 1;
        pathVisited[vertex] = 1;

        for(int adjVertex: graph[vertex]){
            if(visited[adjVertex] == 0){
                if(topologicalSort(adjVertex, graph, visited, pathVisited, topoSortStack)){
                    //Cycle exists i.e. Node is unsafe.
                    return true;
                }
            }
            else if (pathVisited[adjVertex] == 1){
                //Node is visited and visited through the same path i.e. Cycle exists
                return true; 
            }
        }

        pathVisited[vertex] = 0;
        topoSortStack.push(vertex);
        return false;
    }
}

/**
0->1,2
1->2,3
2->5
3->0
4->5
5->[]
6->[]

 */