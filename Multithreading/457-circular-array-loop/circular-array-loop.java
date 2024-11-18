class Solution {
    public boolean circularArrayLoop(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(cycleExists(i, map, nums)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleExists(int index, HashMap<Integer, Boolean> map, int[] nums) {
        if(map.containsKey(index)) {
            return map.get(index);
        }

        map.put(index, true); // mark as true to indicate currently visiting
        int next = Math.floorMod((index + nums[index]), nums.length);
        //OR
        //int next = (((index+nums[index])%nums.length) + nums.length) % nums.length;
        
        if(next != index /* ensure cycle's length > 1 */
                 && nums[next] * nums[index] > 0 /* ensure single direction */) {
            if(cycleExists(next, map, nums)) {
                return true;
            }
        }
        
        map.put(index, false); // mark as false to indicate done visiting, no cycle found
        return false;
    }
}