class Solution {
    public void sortColors(int[] nums) {
        /**1st Approach
        count occurence of 0, 1, 2 and fill/update the nums array with those many times in
        the same order i.e. first 0 then 1 and at last 2.
        Time Complexity -> O(N) 
        //2 iteration - one for counting occurences and other for updating items
        Space Complexity -> O(1)
         */

        int[] Frequency = {0,0,0};
        for(int index=0; index<nums.length; index++)
            Frequency[nums[index]]++;

        for(int index=0; index<nums.length; index++){
            if(Frequency[0]>0){
                nums[index] = 0;
                Frequency[0]--;
            }
            else if(Frequency[1]>0){
                nums[index] = 1;
                Frequency[1]--;
            }
            else if(Frequency[2]>0){
                nums[index] = 2;
                Frequency[2]--;
            }
        }    

        /**2nd Approach (1 Pass Approach) ??????
        Time Complexity -> O(N) 
        Space Complexity -> O(1)
        */
    }
}