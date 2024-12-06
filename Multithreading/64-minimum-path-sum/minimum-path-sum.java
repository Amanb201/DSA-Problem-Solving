class Solution {
    public int minPathSumInGrid(int[][] grid, int row, int col, int [][] memoizationDpArray){
        int rowSize = grid.length;
        int colSize = grid[0].length;

        if(row>=rowSize || col>=colSize)
            return Integer.MAX_VALUE;
        
        if(row == rowSize-1 && col==colSize-1)
            return grid[row][col];

        if(memoizationDpArray[row][col] != -1)
            return memoizationDpArray[row][col];

        int sumWithRightMove = Integer.MAX_VALUE, sumWithBottomMove = Integer.MAX_VALUE;
        if(col+1 < colSize)
            sumWithRightMove = minPathSumInGrid(grid, row, col+1, memoizationDpArray);

        if(row+1 < rowSize)
            sumWithBottomMove = minPathSumInGrid(grid, row+1, col, memoizationDpArray);

        return memoizationDpArray[row][col] = grid[row][col] + Math.min(sumWithRightMove, sumWithBottomMove);

    }

    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int [][] memoizationDpArray = new int[rowSize][colSize];

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++)
                memoizationDpArray[i][j] = -1;
        }

        return minPathSumInGrid(grid, 0, 0, memoizationDpArray);
    }
}