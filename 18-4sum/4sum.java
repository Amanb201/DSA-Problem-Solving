class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
        Time Complexity - O(N^3) //for 3 nested loop iterating over entire array
        Space Complexity - O(N) + O(N) for 2D array and SET */

        List<List<Integer>> quadruplets = new ArrayList<>();
        Set<List<Integer>> quadSet = new HashSet<>();

        Arrays.sort(nums);

        for(int a=0; a<nums.length-3; a++){
            for(int b=a+1; b<nums.length-2; b++){
                int low = b+1;
                int high = nums.length-1;
                while(low<high){
                    //Handle Integer Overflow
                    long currSum = (long)nums[a]+(long)nums[b]+(long)nums[low]+(long)nums[high];
                    
                    //Handle Integer Overflow
                    if(currSum > Integer.MAX_VALUE){
                        high--;
                    }
                    else if(currSum == target){
                        ArrayList<Integer> quadruplet = new ArrayList<>();

                        quadruplet.add(nums[a]);
                        quadruplet.add(nums[b]);
                        quadruplet.add(nums[low]);
                        quadruplet.add(nums[high]);
                        quadSet.add(quadruplet);
                        low++; high--;
                    }
                    else if(currSum < target){
                        low++;
                    }
                    else if(currSum > target){
                        high--;
                    }
                }
            }
        }

        for(List<Integer> quadruplet: quadSet)
            quadruplets.add(quadruplet);

        return quadruplets;
    }
}