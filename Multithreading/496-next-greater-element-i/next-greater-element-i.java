class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums2NextGreater = new int[nums2.length];
        Map<Integer, Integer> nextGreaterElementInNums2 = new HashMap<>();
        int[] nextGreater = new int[nums1.length];
        
        findNextGreaterElement(nums2, nums2NextGreater, nextGreaterElementInNums2);
        for(int i=0; i<nums1.length; i++){
            nextGreater[i] = nextGreaterElementInNums2.get(nums1[i]);
        }
        return nextGreater;
    }

    private void findNextGreaterElement(int[] nums2, int[] nums2NextGreater, Map<Integer, Integer> nextGreaterElementInNums2){
        Stack<Integer> stk = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            if(stk.isEmpty()){
                nextGreaterElementInNums2.put(nums2[i], -1);
                // nums2NextGreater[i] = -1;
                stk.push(nums2[i]);
            }
            else{
                while(!stk.isEmpty() && stk.peek()<=nums2[i])
                    stk.pop();

                if(stk.isEmpty()){
                    nextGreaterElementInNums2.put(nums2[i], -1);
                    // nums2NextGreater[i] = -1;
                }   
                else{
                    nextGreaterElementInNums2.put(nums2[i], stk.peek());
                    // nums2NextGreater[i] = stk.peek();
                } 

                stk.push(nums2[i]);
            }
        }
    }
}