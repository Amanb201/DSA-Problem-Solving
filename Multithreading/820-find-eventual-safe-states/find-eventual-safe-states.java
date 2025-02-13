class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int verticesCount = graph.length;
        int[] visited = new int[verticesCount];
        int[] pathVisited = new int[verticesCount];
        int[] isSafeNode = new int[verticesCount];

        Stack<Integer> topoSortStack = new Stack<>();
        List<Integer> safeNodes = new ArrayList<>();
        
        for(int vertex=0; vertex<verticesCount; vertex++){
            if(visited[vertex] == 0)
                topologicalSort(vertex, graph, visited, pathVisited, topoSortStack, isSafeNode);
        }

        for(int v=0; v<verticesCount; v++){
            if(isSafeNode[v] == 1)
                safeNodes.add(v);
        }
        //Sort the topological Sort order in ascending order the for final answer 
        // while(!topoSortStack.isEmpty())
        //     safeNodes.add(topoSortStack.pop());

        // Collections.sort(safeNodes);

        return safeNodes;
    }

    boolean topologicalSort(int vertex, int[][] graph, int[] visited, int[] pathVisited, Stack<Integer> topoSortStack, int[] isSafeNode){
        visited[vertex] = 1;
        pathVisited[vertex] = 1;

        for(int adjVertex: graph[vertex]){
            if(visited[adjVertex] == 0){
                if(topologicalSort(adjVertex, graph, visited, pathVisited, topoSortStack, isSafeNode)){
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
        isSafeNode[vertex] = 1;
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