class Solution {
    private int longestIncreasingSubsequenceRightToLeft(int[] nums, int index, int prevItemIndex, int[][] rightToLeftDp){
        if(index==nums.length)
            return 0;

        if(rightToLeftDp[index+1][prevItemIndex+1] != -1)
            return rightToLeftDp[index+1][prevItemIndex+1];

        int lenAfterTaking = 0, lenAfterSkipping=0;
        if(prevItemIndex == -1 || nums[index] < nums[prevItemIndex])
            lenAfterTaking = 1 + longestIncreasingSubsequenceRightToLeft(nums, index+1, index, rightToLeftDp);

        lenAfterSkipping = longestIncreasingSubsequenceRightToLeft(nums, index+1, prevItemIndex, rightToLeftDp);

        return rightToLeftDp[index+1][prevItemIndex+1] = Math.max(lenAfterTaking, lenAfterSkipping); 
    }
    private int longestIncreasingSubsequenceLeftToRight(int[] nums, int index, int nextItemIndex, int[][] leftToRightDp){
        if(index==-1)
            return 0;

        if(leftToRightDp[index+1][nextItemIndex+1] != -1)
            return leftToRightDp[index+1][nextItemIndex+1];

        int lenAfterTaking = 0, lenAfterSkipping=0;
        if(nextItemIndex == -1 || nums[index] < nums[nextItemIndex])
            lenAfterTaking = 1 + longestIncreasingSubsequenceLeftToRight(nums, index-1, index, leftToRightDp);

        lenAfterSkipping = longestIncreasingSubsequenceLeftToRight(nums, index-1, nextItemIndex, leftToRightDp);

        return leftToRightDp[index+1][nextItemIndex+1] = Math.max(lenAfterTaking, lenAfterSkipping); 
    }

    public int minimumMountainRemovals(int[] nums) {
        int size = nums.length;

        /**Row (i+1)th contains the LIS length till at ith index of nums arr from left to right. 
        Index is shifted by 1 to handle -1 in the previousItemIndex**/
        int[][] leftToRightDp = new int[size+1][size+1]; 

        /**Row (i+1)th contains the LIS length till at ith index of nums arr from right to left. 
        Index is shifted by 1 to handle -1 in the previousItemIndex**/
        int[][] rightToLeftDp = new int[size+1][size+1];

        //Memoization Dp table initialization
        for(int i=0; i<=size; i++){
            for(int j=0; j<=size; j++){
                leftToRightDp[i][j] = -1;
                rightToLeftDp[i][j] = -1;
            }
        }
        longestIncreasingSubsequenceLeftToRight(nums, size-1, -1, leftToRightDp);
        longestIncreasingSubsequenceRightToLeft(nums, 0, -1, rightToLeftDp);


        // for(int i=0; i<=size; i++){
        //     for(int j=0; j<=size; j++){
        //         // System.out.println("leftToRightDp[" + i + "][" + j +"] =" + leftToRightDp[i][j]);
        //         // System.out.println("rightToLeftDp[" + i+ "][" +j + "] =" + rightToLeftDp[i][j]);
        //     }
        // }

        
        //leftToRightDp[i+1][0] contains maximum length of increasing subsequence for arr[i] in Left to Right Direction
        //rightToLeftDp[i+1][0] contains maximum length of increasing subsequence for arr[i] in Right to left Direction

        int maxMoutainLen = 0;
        for(int i=1; i<size-1; i++){
            int currMountain = 0;
            if(leftToRightDp[i+1][0]>1 && rightToLeftDp[i+1][0]>1)
                currMountain = leftToRightDp[i+1][0] +rightToLeftDp[i+1][0] - 1;

            maxMoutainLen = Math.max(currMountain, maxMoutainLen);
        }
        System.out.println("maxMoutainLen "+ maxMoutainLen);
        return size-maxMoutainLen;
    }
}