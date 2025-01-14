class Solution {
    class Pair{
        int value;
        int index;

        Pair(int val, int ind){
            this.value = val;
            this.index = ind;
        }
    }
    public int[] twoSum(int[] nums, int target) {

        //Approach-1 O(N^2)
        // int[] twoSumAns = new int[2];
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i]  + nums[j] == target){
        //             twoSumAns[0] = i;
        //             twoSumAns[1] = j;
        //             return twoSumAns;
        //         }
        //     }
        // }

        // return twoSumAns;

        Pair[] numsPair = new Pair[nums.length];
        for(int i=0; i<nums.length; i++){
            numsPair[i] = new Pair(nums[i], i);
        }

        Arrays.sort(numsPair, (a,b)->a.value-b.value);

        int low =0, high = nums.length-1;
        int[] twoSumAns = new int[2];

        while(low<high){
            if(numsPair[low].value + numsPair[high].value < target){
                low++;
            }
            else if(numsPair[low].value + numsPair[high].value > target){
                high--;
            }
            else{
                twoSumAns[0] = numsPair[low].index;
                twoSumAns[1] = numsPair[high].index;
                return twoSumAns;
            }
        }
        return twoSumAns;
    }
}