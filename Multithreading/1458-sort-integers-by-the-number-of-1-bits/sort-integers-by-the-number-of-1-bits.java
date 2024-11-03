class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);

        Map<Integer, List<Integer>> sortByBitsMap = new TreeMap<>();

        for(int i=0; i<arr.length; i++){
            int bitWith1Count = Integer.bitCount(arr[i]);

            List<Integer> nums = new ArrayList<>();
            if(sortByBitsMap.containsKey(bitWith1Count)){
                nums = sortByBitsMap.get(bitWith1Count);
            }
            nums.add(arr[i]);
            sortByBitsMap.put(bitWith1Count, nums);
        }

        int[] ans = new int[arr.length];

        int index=0;
        for(int key: sortByBitsMap.keySet()){
            List<Integer> nums = sortByBitsMap.get(key);

            for(int num: nums){
                ans[index] = num;
                index++;
            }
        }
        return ans;
    }
}