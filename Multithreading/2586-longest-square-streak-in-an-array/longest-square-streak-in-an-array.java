class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap();

        for(int i=0; i<nums.length; i++){
            numsMap.put(nums[i], 1);
        }

        int longestStreak = -1;
        for(int num: numsMap.keySet()){
            int currStreak = 0;
            int currNum = num;

            if(currNum > Math.pow(10,3))
                continue;
                
            while(numsMap.containsKey(currNum*currNum)){
                if(currStreak==0) currStreak = 2;
                else currStreak++;

                currNum = currNum*currNum;
                longestStreak = Math.max(longestStreak, currStreak);
                if(currNum > Math.pow(10,3))
                    break;
            }
        }

        return longestStreak;
    }
}