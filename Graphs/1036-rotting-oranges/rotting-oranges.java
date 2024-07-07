class RottenOrangeNode{
    int row;
    int col;
    int time;

    RottenOrangeNode(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] visited = new int[rowSize][colSize];
        Queue<RottenOrangeNode> rottenOrangesQ = new LinkedList<>();

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                visited[i][j] = grid[i][j];

                if(grid[i][j] == 2){
                    rottenOrangesQ.add(new RottenOrangeNode(i, j, 0));
                }
            }
        }

        int minTimetoRott = 0;
        while(!rottenOrangesQ.isEmpty()){
            RottenOrangeNode currNode = rottenOrangesQ.poll();

            int row = currNode.row;
            int col = currNode.col;
            int time = currNode.time;

            if(row>0 && visited[row-1][col] == 1){
                //Top Cell
                visited[row-1][col] = 2;
                rottenOrangesQ.add(new RottenOrangeNode(row-1, col, time+1));
                minTimetoRott = minTimetoRott>(time+1) ? minTimetoRott: time+1;
            }
            if(row<rowSize-1 && visited[row+1][col] == 1){
                //bottom Cell
                visited[row+1][col] = 2;
                rottenOrangesQ.add(new RottenOrangeNode(row+1, col, time+1));
                minTimetoRott = minTimetoRott>(time+1) ? minTimetoRott: time+1;
            }
            if(col>0 && visited[row][col-1] == 1){
                //left Cell
                visited[row][col-1] = 2;
                rottenOrangesQ.add(new RottenOrangeNode(row, col-1, time+1));
                minTimetoRott = minTimetoRott>(time+1) ? minTimetoRott: time+1;
            }
            if(col<colSize-1 && visited[row][col+1] == 1){
                //Right Cell
                visited[row][col+1] = 2;
                rottenOrangesQ.add(new RottenOrangeNode(row, col+1, time+1));
                minTimetoRott = minTimetoRott>(time+1) ? minTimetoRott: time+1;
            }
        }

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                if(visited[i][j] == 1)
                    return -1;
            }
        }

        return minTimetoRott;
    }
}