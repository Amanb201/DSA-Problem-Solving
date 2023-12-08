class Solution {
    boolean isBoardEntryValid(char[][] board, int row, int col){
        return (board[row][col] >= 49 && board[row][col] <= 57);
    }

    public boolean areColsValid(char[][] board){
        //Check for every row
        for(int row=0; row<9; row++){   
            //Check for individual row that if some digit is repeated or not
            /*declare an empty set
                or maybe we can use the 1-D Array of size 10
            */ 
            boolean[] checkRow = {false, false, false, false, false, false, 
                                    false, false, false, false};
            for(int col=0; col<9; col++)
            {
                //step-0 check if the item board[row][col] is valid
                if(board[row][col] == '.')
                    continue;
                if(isBoardEntryValid(board, row, col)){
                    //step-1 check if item board[row][col] exists into set
                    /*step-2 if item board[row][col] does exist into set
                        means sudoku is invalid*/
                    if(checkRow[board[row][col] - 49]) 
                        return false;

                    /*step-2 if item board[row][col] doesn't exist into set
                    then push the item into the set*/    
                    checkRow[board[row][col] - 49] = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean areRowsValid(char[][] board){
        //Check for every column
        for(int col=0; col<9; col++){   
        //Check for individual column that if some digit is repeated or not
            /*declare an empty set
                or maybe we can use the 1-D Array of size 10
            */ 
            boolean[] checkCol = {false, false, false, false, false, false, 
                                    false, false, false, false};
            for(int row=0; row<9; row++)
            {
                //step-0 check if the item board[row][col] is valid
                if(board[row][col] == '.')
                    continue;
                if(isBoardEntryValid(board, row, col)){
                    //step-1 check if item board[row][col] exists into set
                    /*step-2 if item board[row][col] does exist into set
                        means sudoku is invalid*/
                    if(checkCol[board[row][col] - 49]) 
                        return false;

                    /*step-2 if item board[row][col] doesn't exist into set
                    then push the item into the set*/    
                    checkCol[board[row][col] - 49] = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean areGridsValid(char[][] board){
        for(int gridRowIndex =0; gridRowIndex<9; gridRowIndex=gridRowIndex+3){
            for(int gridColIndex =0; gridColIndex<9; gridColIndex=gridColIndex+3 ){
                
                boolean[] checkGrid = {false, false, false, false, false, false, 
                                    false, false, false, false};
                
                for(int row=gridRowIndex; row<=gridRowIndex+2; row++){
                    for(int col=gridColIndex; col<=gridColIndex+2; col++){
                        if(board[row][col] == '.')
                            continue;
                        if(isBoardEntryValid(board, row, col)){
                            if(checkGrid[board[row][col] - 49]) 
                                return false;

                            checkGrid[board[row][col] - 49] = true;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        return (areRowsValid(board) && 
                    areColsValid(board) &&
                        areGridsValid(board));

    }
}