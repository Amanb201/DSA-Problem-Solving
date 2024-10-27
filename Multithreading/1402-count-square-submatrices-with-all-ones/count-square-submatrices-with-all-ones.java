class Solution {
    private boolean isSquareWithAllOnes(int[][] matrix, int index1, int index2, int m, int n){
        for(int i=index1; i<m; i++){
            for(int j=index2; j<n; j++){
                if(matrix[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    private int countSquaresWithSideLen(int[][] matrix, int sides){
        int m=matrix.length;
        int n= matrix[0].length;

        // if(index1 == m || index2 == n)  return 0;

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean isSquareValid = false;

                if(i+sides<=m && j+sides<=n)
                    isSquareValid = isSquareWithAllOnes(matrix, i, j ,i+sides, j+sides);

                if(isSquareValid)
                    count++;
            }
        }
        return count;
    }
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;

        int maxSides = m<n ? m : n;

        int ans = 0;
        for(int i=1; i<=maxSides; i++){
            ans += countSquaresWithSideLen(matrix, i);
        }
        return ans;
    }
}