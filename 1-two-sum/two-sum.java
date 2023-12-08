class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int first=0; first<nums.length; first++)
        {
            for(int second=first+1; second<nums.length; second++)
            {
                if(nums[first]+nums[second] == target)
                {
                    int[] resultArray = new int[2];
                    resultArray[0] = first;
                    resultArray[1] = second;
                    return resultArray;
                }
            }
        }
        return new int[2];
    }
}