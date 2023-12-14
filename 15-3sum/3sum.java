class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /** Time Complexity = O(N^2) 2Pointer Approach iterating over array N*N
                                +
                              O(N Log N) sorting
                            = O(N^2) //Overall time complexity    
            Space Complexity = O(N) + O(N) for set & 2D List // total #triplets at max
                               + 
                               O(1) for triplet arrayList */
        List<List<Integer>> triplets = new ArrayList<>();
        Set<List<Integer>> tripletSet = new HashSet<List<Integer>>();

        Arrays.sort(nums);

        for(int index=0; index<nums.length-2; index++){
            int low = index+1;
            int high = nums.length-1;
            while(low<high){
                if(nums[index]+nums[low]+nums[high] == 0)
                {   
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[index]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    tripletSet.add(triplet);
                    
                    if((low<high-1 && nums[low] == nums[low+1]) || nums[low] == 0)
                        low++;
                    else if((low+1<high && nums[high] == nums[high-1]) || nums[high] == 0)
                        high--;
                    else
                    {
                        low++; high--;
                    };
                }
                else if(nums[index]+nums[low]+nums[high] < 0){
                    low++;
                }
                else
                    high--;
            }
        }

        for(List<Integer> triplet: tripletSet)
            triplets.add(triplet);

        return triplets;   
    }
}