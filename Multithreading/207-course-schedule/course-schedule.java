class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int totalPrerequisites = prerequisites.length;
        List<Integer>[] adjList = new ArrayList[numCourses];

        //Initializing Adjacency List
        for(int course=0; course<numCourses; course++){
            adjList[course] = new ArrayList<>();
        }

        //Preparing Adjaceny List
        for(int prereq=0; prereq<totalPrerequisites; prereq++){
            int prereqCourse = prerequisites[prereq][1];
            int dependentCourse = prerequisites[prereq][0];

            List<Integer> courses = adjList[prereqCourse];
            courses.add(dependentCourse);
            adjList[prereqCourse] = courses;
        }

        //If there is cycle in Directed Graph then Course Scheduling not possible
        return isCycleInDirectedGraph(adjList) == false;
        
    }

    boolean isCycleInDirectedGraph(List<Integer>[] adjList){
        int numCourses = adjList.length;

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for(int course=0; course<numCourses; course++){
            if(visited[course] == 0){
                if(dfsTraversal(course, adjList, visited, pathVisited))
                    return true;
            }
        }
        return false;
    }

    boolean dfsTraversal(int node, List<Integer>[] adjList, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int neighbor: adjList[node]){
            if(visited[neighbor] == 0){
                //If not visited
                if(dfsTraversal(neighbor, adjList, visited, pathVisited))
                    return true;;
            }
            else if(pathVisited[neighbor] == 1){
                //Node is both Visited and using the same path, so cycle exists
                return true;
            }
        }

        pathVisited[node] = 0;
        return false;
    }
}