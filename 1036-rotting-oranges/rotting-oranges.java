class Solution {
    public int rotNeighbouringOranges(int[][] grid, int[][] visited, 
        Queue<Pair<Pair<Integer, Integer>, Integer>> queue, int rowInd, int colInd, int time, int minTime){
        int rowSize = grid.length, colSize = grid[0].length;
        int[] deltaRow = {-1,0,1,0};
        int[] deltaCol = {0,1,0,-1};

        for(int i=0; i<4; i++){ //O(1)
            int nrow = rowInd+deltaRow[i], ncol = colInd+deltaCol[i];

            if(nrow>=0 && nrow<rowSize && ncol>=0 && ncol<colSize && 
                (visited[nrow][ncol] != 2) && (grid[nrow][ncol] != 0)){
                    queue.add(new Pair(new Pair(nrow, ncol), time+1));

                    visited[nrow][ncol] = 2;
                    minTime = (minTime>(time+1))? minTime : time+1;
            }
        }
        return minTime;
    }

    public int minimumMinsToRotOrange(int[][] grid, int[][] visited,
        Queue<Pair<Pair<Integer, Integer>, Integer>> queue ){
            int rowSize = grid.length, colSize = grid[0].length;            

            int minTime = 0;
            while(!queue.isEmpty()){ //O(M*N)
                Pair<Pair<Integer, Integer>, Integer> queueItem = queue.poll();
                int rowInd = queueItem.getKey().getKey(), colInd = queueItem.getKey().getValue();
                int time = queueItem.getValue();

                //O(1)
                minTime = rotNeighbouringOranges(grid, visited, queue, rowInd, colInd, time, minTime);
            }

            for(int row=0; row<rowSize; row++){ //O(M*N)
                for(int col=0; col<colSize; col++){
                    if(grid[row][col] == 1 && visited[row][col] != 2)
                        return -1;
                }
            }

            return minTime;
    }

    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length, rottRow = 0;
        int colSize = grid[0].length, rottCol = 0;
        Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new LinkedList<>(); //O(M*N)
        int[][] visited = new int[rowSize][colSize]; //O(M*N)

        Boolean isFreshOrangeAvailable = false;
        for(rottRow = 0; rottRow<rowSize; rottRow++){//O(M*N)
            Boolean stop = false;
            for(rottCol = 0; rottCol<colSize; rottCol++){
                if(grid[rottRow][rottCol] == 2){
                    queue.add(new Pair(new Pair(rottRow, rottCol), 0));
                    visited[rottRow][rottCol] = 2;
                }
                if(!isFreshOrangeAvailable && grid[rottRow][rottCol] == 1)
                    isFreshOrangeAvailable = true;
            }
        }
        if(!isFreshOrangeAvailable)
            return 0;
            
        if(queue.isEmpty())
            return -1;

        return minimumMinsToRotOrange(grid, visited, queue); //O(M*N)
    }
}