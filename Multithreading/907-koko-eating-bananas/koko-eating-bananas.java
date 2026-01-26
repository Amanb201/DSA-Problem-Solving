class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length > h) return -1;

        int high=Integer.MIN_VALUE;
        for(int pile: piles)
            high = Math.max(high, pile);

        int low = 1;

        int minValidSpeed = Integer.MAX_VALUE;
        while(low<=high){

            int mid = low + (high-low)/2;

            if(isSpeedValid(piles, mid, h)){
                minValidSpeed = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }    
        return minValidSpeed;
    }

    private boolean isSpeedValid(int[] piles, int speed, int limitHour){
        int hours = 0;

        for(int pile: piles){
            hours += Math.ceil(pile*1.0/speed);
        }

        return hours <= limitHour;
    }
}