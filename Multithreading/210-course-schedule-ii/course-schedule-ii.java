class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> adjList[] = new ArrayList[numCourses];

        for(int course=0; course<numCourses; course++){
            adjList[course] = new ArrayList<>();
        }

        for(int prereq=0; prereq<prerequisites.length; prereq++){
            int prereqCourse = prerequisites[prereq][1];
            int dependentCourse = prerequisites[prereq][0];

            List<Integer> dependentCourses = adjList[prereqCourse];
            dependentCourses.add(dependentCourse);

            adjList[prereqCourse] = dependentCourses;
        }

        return topologicalSort(adjList);
    }

    int[] topologicalSort(List<Integer> adjList[]){
        int numCourses = adjList.length;
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        Stack<Integer> topoSort = new Stack<>();

        for(int course=0; course<numCourses; course++){
            if(visited[course] == 0){
                if(dfsTraversal(course, adjList, visited, pathVisited, topoSort)){
                    return new int[0];
                }
            }
        }

        int[] orderedCourses = new int[numCourses];
        
        int index=0;
        while(!topoSort.isEmpty()){
            orderedCourses[index++] = topoSort.pop();
        }
        return orderedCourses;
    }

    boolean dfsTraversal(int node, List<Integer> adjList[], int[] visited, int[] pathVisited, Stack<Integer> topoSort){
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int neighbor: adjList[node]){
            if(visited[neighbor] == 0){
                if(dfsTraversal(neighbor, adjList, visited, pathVisited, topoSort))
                    return true;
            }
            else if(pathVisited[neighbor] == 1)
                return true;
        }

        pathVisited[node] = 0;
        topoSort.push(node);
        return false;
    }
}