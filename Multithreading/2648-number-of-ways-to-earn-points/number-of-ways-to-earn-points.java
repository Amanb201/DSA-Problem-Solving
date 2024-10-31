class Solution {
    private int findSubsetTargetSum(int[][] types, int index, int target, int[][] memoizationDpArray){
        if(target==0)
            return 1;
        if(index<0)
            return 0;


        if(memoizationDpArray[index][target] != -1)
            return memoizationDpArray[index][target];

        int MODULO_CONST = (int) Math.pow(10, 9) + 7;
        int countWaysTargetSum = 0;

        int totalQues = types[index][0];
        int marksForEachQ = types[index][1]; 
        for(int questionAttempted=0; questionAttempted<=totalQues; questionAttempted++){
            if((target - questionAttempted*marksForEachQ) >= 0){
                int currWays = 
                    findSubsetTargetSum(types, index-1,
                                             (target - questionAttempted * marksForEachQ), memoizationDpArray);
                countWaysTargetSum = (countWaysTargetSum + currWays) % MODULO_CONST;
            }
                    
        }
        return memoizationDpArray[index][target] = countWaysTargetSum;
    }
    public int waysToReachTarget(int target, int[][] types) {
        int[][] memoizationDpArray = new int[types.length][target+1];

        for(int i=0; i<types.length; i++)
            for(int j=0; j<=target; j++)
                memoizationDpArray[i][j] = -1;

        return findSubsetTargetSum(types, types.length - 1, target, memoizationDpArray);
    }
}