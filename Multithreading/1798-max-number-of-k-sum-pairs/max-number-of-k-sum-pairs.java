class Solution {
    /**
    [3,1,3,4,3] k =6
    1 3 3 3 4


     */
    public int maxOperations(int[] nums, int k) {
        // Arrays.sort(nums);

        // int count = 0;

        // int size = nums.length;
        // int low =0, high = size-1;

        // while(low<high){
        //     if(nums[low] + nums[high] == k){
        //         count++;
        //         low++;
        //         high--;
                
        //     }
        //     else if(nums[low] + nums[high] > k){
        //         high--;
        //     }
        //     else{
        //         low++;
        //     }
        // }
        // return count;

        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for(int index=0; index<nums.length; index++){
            int second = k - nums[index];
            if(freqMap.containsKey(second) && freqMap.get(second)>0){
                count++;
                int currFreq = freqMap.get(second);
                freqMap.put(second, currFreq-1);
            }else{
                if(freqMap.containsKey(nums[index])){
                    int currFreq = freqMap.get(nums[index]);
                    freqMap.put(nums[index], currFreq+1);
                }
                else
                    freqMap.put(nums[index], 1);
            }
        }
        return count;

        /**
    [3,1,3,4,3] k =6
    3 - 1
    1 - 1
    3 - 0, 3->1
    4 ->1



     */
    }
}