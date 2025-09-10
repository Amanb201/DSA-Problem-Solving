class Solution {
    public int rob(int[] nums) {
        int totalHouses = nums.length;

        int[] memoizationDp = new int[totalHouses];
        Arrays.fill(memoizationDp, -1);

        return getMaxMoneyLoot(totalHouses-1, memoizationDp, nums);
    }

    private int getMaxMoneyLoot(int index, int[] memoizationDp, int[] nums){
        if(index == 0)    return nums[index];
        if(index < 0) return 0;

        if(memoizationDp[index] != -1)  return memoizationDp[index];

        int robCurrHouse = nums[index] + getMaxMoneyLoot(index-2, memoizationDp, nums);
        int skipCurrHouse = getMaxMoneyLoot(index-1, memoizationDp, nums);

        return memoizationDp[index] = Math.max(robCurrHouse, skipCurrHouse);
    }
}