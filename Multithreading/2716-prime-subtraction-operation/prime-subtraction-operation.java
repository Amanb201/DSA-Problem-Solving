class Solution {
    public boolean primeSubOperation(int[] nums) {
        // int maxi = 0;

        // for(int i=0; i<nums.length; i++)
        //     maxi = Math.max(maxi, nums[i]);

        int[] primeNumbers = new int[1000+1];
        //1 - Not Visited(Or Invalid), 0 - Composited NUmber, 1 - Prime Number
        for(int i=0; i<=1000; i++)
            primeNumbers[i] = -1;

        for(int i=2; i<=1000; i++){
            if(primeNumbers[i] == -1){
                primeNumbers[i] = 1;

                for(int j=i*2; j<=1000; j=j+i)
                    primeNumbers[j] = 0;
            }
        }
        List<Integer> sortedNums = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            // System.out.println(sortedNums);
            if(i==0){
                boolean found = false;
                for(int prime=nums[i]-1; prime>1; prime--){
                    if(primeNumbers[prime] == 1){
                        sortedNums.add(nums[i]-prime);
                        found = true;
                        break;
                    }
                }
                if(found==false)
                    sortedNums.add(nums[i]);
            }
            else{
                boolean found = false;
                for(int prime=nums[i]-1; prime>1; prime--){
                    if(primeNumbers[prime] == 1 && (nums[i]-prime > sortedNums.get(i-1))){
                        sortedNums.add(nums[i]-prime);
                        found = true;
                        break;
                    }
                }

                if(found==false && nums[i] > sortedNums.get(i-1)){
                    sortedNums.add(nums[i]);
                    found = true;
                }

                if(found==false)    return false;
            }
        }

        return true; 
    }
}