class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int minLen = 1000000;

        int left=0, right=0;
        for(right=0; right<nums.length; right++){
            currSum += nums[right];
           
            while(currSum>=target){
                minLen = Math.min(minLen, right-left+1);
                
                currSum -= nums[left++];
            }
        }

        return minLen==1000000?0:minLen;
    }
}