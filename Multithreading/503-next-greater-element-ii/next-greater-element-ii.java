class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] nextGreater = new int[size];

        Stack<Integer> stk = new Stack<>();
        for(int i=size*2-1; i>=0; i--){
            int nextG = -1;
            if(stk.isEmpty()){
                stk.push(nums[i%size]);
            }
            else{
                while(!stk.isEmpty() && stk.peek()<=nums[i%size]){
                    stk.pop();
                }

                if(!stk.isEmpty())  nextG = stk.peek();
                stk.push(nums[i%size]);
            }

            if(i<size)
                nextGreater[i] = nextG;
        }

        return nextGreater;
    }
}