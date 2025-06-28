class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        for(int row=0; row<n; row++){
            int currMax = Integer.MIN_VALUE;
            for(int col=0; col<n; col++){   
                currMax = Math.max(currMax, grid[row][col]);
            }
            rowMax[row] = currMax;
        }

        for(int col=0; col<n; col++){
            int currMax = Integer.MIN_VALUE;
            for(int row=0; row<n; row++){   
                currMax = Math.max(currMax, grid[row][col]);
            }
            colMax[col] = currMax;
        }

        int maxSum = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                int potentialMax = Math.min(rowMax[row], colMax[col]);
                maxSum += (grid[row][col]<potentialMax) 
                                ? potentialMax - grid[row][col] 
                                : 0;   
            }
        }

        return maxSum;
    }
}