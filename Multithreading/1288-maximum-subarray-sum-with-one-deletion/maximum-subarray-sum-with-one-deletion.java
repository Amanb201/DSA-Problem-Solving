class Solution {
    public int maximumSum(int[] arr) {
        int size = arr.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxSumWithZeroDeletion = Integer.MIN_VALUE;
        int[] maxSumFromLeftToRight = new int[size];

        for(int i=0; i<size; i++){
            currSum += arr[i];

            maxSum = Math.max(currSum, maxSum);

            if(currSum<0)   currSum=0;
            maxSumFromLeftToRight[i] = currSum;
        }


        maxSumWithZeroDeletion = maxSum;
        maxSum = Integer.MIN_VALUE;
        int[] maxSumFromRightToLeft = new int[size];
        
        currSum = 0;
        for(int i=size-1; i>=0; i--){
            currSum += arr[i];

            maxSum = Math.max(currSum, maxSum);

            if(currSum<0)   currSum=0;
            maxSumFromRightToLeft[i] = currSum;
        }

        maxSum = maxSumWithZeroDeletion;
        for(int i=0; i<=size-3; i++){
            int sumWithDel = maxSumFromLeftToRight[i] + maxSumFromRightToLeft[i+2];

            if(sumWithDel != 0)
                maxSum = Math.max(maxSum, sumWithDel);
        } 

        return maxSum;  
    }
}