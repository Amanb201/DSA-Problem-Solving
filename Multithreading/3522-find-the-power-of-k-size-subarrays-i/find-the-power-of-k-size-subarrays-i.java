class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int arrSize = nums.length;

        int[] ans = new int[nums.length-k+1];
        int ansInd = 0;

        for(int i=0; i<=arrSize-k; i++){
            int maxNum = nums[i];
                
            boolean sorted = true;
            for(int j=i+1; j<i+k; j++){
                maxNum = Math.max(maxNum, nums[j]);

                if(nums[j] == nums[j-1] +1){
                    continue;
                }
                else{
                    ans[ansInd] = -1;
                    ansInd++;
                    sorted = false;
                    break;
                }
            }

            if(sorted){
                ans[ansInd] = maxNum;
                ansInd++;
            }

        }

        return ans;
    }
}