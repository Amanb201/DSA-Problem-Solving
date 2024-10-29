class Solution {
    private int findMaxMoves(int[][] grid, int rowInd, int colInd, int[][] memoizationDpArray){
        int rowMax = grid.length;
        int colMax = grid[0].length;

        if(colInd==colMax)
            return 0;

        int countMoves = 0, rightTop=0, rightBottom=0, rightMiddle=0;;

        if(memoizationDpArray[rowInd][colInd] != -1)
            return memoizationDpArray[rowInd][colInd];

        if(colInd == 0){

            for(int row=0; row<rowMax; row++){
                int col=0;
                if(row>0 && col<colMax-1 && (grid[row][col]<grid[row-1][col+1]))
                    rightTop = 1 + findMaxMoves(grid, row-1, col+1, memoizationDpArray);
                if(col<colMax-1 && (grid[row][col]<grid[row][col+1]))
                    rightMiddle = 1 + findMaxMoves(grid, row, col+1, memoizationDpArray);
                if(row<rowMax-1 && col<colMax-1 && (grid[row][col]<grid[row+1][col+1]))
                    rightBottom = 1 + findMaxMoves(grid, row+1, col+1, memoizationDpArray);

                countMoves = Math.max(countMoves, Math.max(rightTop, Math.max(rightMiddle, rightBottom)));
            }

        }else{
            if(rowInd>0 && colInd<colMax-1 && (grid[rowInd][colInd]<grid[rowInd-1][colInd+1]))
                rightTop = 1 + findMaxMoves(grid, rowInd-1, colInd+1, memoizationDpArray);
            if(colInd<colMax-1 && (grid[rowInd][colInd]<grid[rowInd][colInd+1]))
                rightMiddle = 1 + findMaxMoves(grid, rowInd, colInd+1, memoizationDpArray);
            if(rowInd<rowMax-1 && colInd<colMax-1 && (grid[rowInd][colInd]<grid[rowInd+1][colInd+1]))
                rightBottom = 1 + findMaxMoves(grid, rowInd+1, colInd+1, memoizationDpArray);

            countMoves = Math.max(countMoves, Math.max(rightTop, Math.max(rightMiddle, rightBottom)));
        }
        return memoizationDpArray[rowInd][colInd] = countMoves;
    }
    public int maxMoves(int[][] grid) {
        int rowMax = grid.length;
        int colMax = grid[0].length;

        int[][] memoizationDpArray = new int[rowMax][colMax];

        for(int i=0; i<rowMax; i++)
            for(int j=0; j<colMax; j++)
                memoizationDpArray[i][j] = -1;

        return findMaxMoves(grid, 0, 0, memoizationDpArray);
    }
}