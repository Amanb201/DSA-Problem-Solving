class Solution {
    private boolean isDistributionValid(int n, int[] quantities, int maxAlloc){
        for(int num: quantities){
            n = n - (num%maxAlloc == 0 ? num/maxAlloc : num/maxAlloc + 1);
        }
        return n>=0;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int maxi = 0;
        for(int num: quantities)
            maxi = Math.max(maxi, num);

        int low = 1, high = maxi;

        int maxDist = maxi;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(isDistributionValid(n, quantities, mid)){
                maxDist = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return maxDist;
    }
}