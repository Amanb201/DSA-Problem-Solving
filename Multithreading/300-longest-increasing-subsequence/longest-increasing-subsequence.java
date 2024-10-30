class Solution {
    private int longestIncreasingSubsequence(int[] nums, int index, int prevItemIndex,
             int[][] memoizationDpArray){
        int size = nums.length;

        if(index==size) return 0;
        
        if(memoizationDpArray[index+1][prevItemIndex+1] != -1)
            return memoizationDpArray[index+1][prevItemIndex+1];

        int lenTaking = 0, lenNotTaking=0;
        if(prevItemIndex==-1 || nums[index]>nums[prevItemIndex])
            lenTaking = 1 + longestIncreasingSubsequence(nums, index+1, index, memoizationDpArray);
            
        lenNotTaking = longestIncreasingSubsequence(nums, index+1, prevItemIndex, memoizationDpArray);
        return memoizationDpArray[index+1][prevItemIndex+1] = Math.max(lenTaking, lenNotTaking);
    }
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;

        int[][] memoizationDpArray = new int[size+1][size+1];
        for(int i=0; i<=size; i++)
            for(int j=0; j<=size; j++)
                memoizationDpArray[i][j] = -1;

        return longestIncreasingSubsequence(nums, 0, -1, memoizationDpArray);
    }
}