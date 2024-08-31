class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        List<Integer> visited = new ArrayList<>();
        for(int i=0; i<n; i++)
            visited.add(0);

        Queue<Integer> que = new LinkedList<>();
        for(int key: rooms.get(0))
            que.add(key);

        visited.set(0,1);
        while(!que.isEmpty()){
            int currKey = que.poll();
            if(visited.get(currKey) == 0){
                for(int key: rooms.get(currKey))
                    que.add(key);
                
                visited.set(currKey,1);
            }
        }  

        for(int i=0; i<n; i++)
            if(visited.get(i) == 0)
                return false;
        return true; 
    }
}