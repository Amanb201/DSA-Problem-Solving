class Solution {
    public void findRowsColsWithZero(int[][] matrix, HashSet<Integer> rowSet,    
        HashSet<Integer> colSet, int row_size, int col_size){
        /*finding all the rows and columns which contains zero and putting those 
            inside set*/
        for(int row=0; row<row_size; row++){
            for(int col=0; col<col_size; col++){
                if(matrix[row][col]==0){
                    rowSet.add(row);
                    colSet.add(col);
                }
            }
        }
    }

    public void setRowsToZero(int[][] matrix, int col_size, int rowIndex){
        //Setting the required rows to zero
        for(int col=0; col<col_size; col++){
            matrix[rowIndex][col] = 0;
        }
    }

    public void setColsToZero(int[][] matrix, int row_size, int colIndex){
        //Setting the required columns to zero
        for(int row=0; row<row_size; row++){
            matrix[row][colIndex] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        int row_size = matrix.length;
        int col_size = matrix[0].length;

        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        /*finding all the rows and columns which contains zero and putting those 
            inside set*/
        findRowsColsWithZero(matrix, rowSet, colSet, row_size, col_size);

        //Setting the required rows to zero
        for(int rowIndex : rowSet)
            setRowsToZero(matrix, col_size, rowIndex);

        //Setting the required columns to zero
        for(int colIndex : colSet)
            setColsToZero(matrix, row_size, colIndex);
    }
}