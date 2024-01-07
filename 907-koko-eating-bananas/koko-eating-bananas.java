class Solution {
    public boolean checkIfKokoCanFinishBananas(int[] piles, int h, int bananas){

        int totalHours = 0;
        for(int index=0; index<piles.length; index++){
            if(piles[index]<=bananas){
                if(totalHours>1000000000-1)
                    return false;
                totalHours++;
            }
            else{
                int hours = piles[index]%bananas==0 ? piles[index]/bananas : (piles[index]/bananas)+1;
                if(totalHours>1000000000-hours)
                    return false;
                totalHours += hours;
            }
        }
        return totalHours<=h;
    }
    public int minBananasPerHour(int[] piles, int h, int lowBananas, int highBananas){

        int minBananas = highBananas;
        while(lowBananas<=highBananas){
            int mid = (lowBananas+highBananas)/2;


            boolean isPossible = checkIfKokoCanFinishBananas(piles, h, mid);

            if(isPossible){
                minBananas = mid;
                highBananas = mid-1;
            }
            else{
                lowBananas = mid+1;
            }
        }
        return minBananas;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int pilesLen = piles.length;

        if(pilesLen==1){
            if(h==1)
                return piles[0];
            else if(piles[0]%h > 0)
                return piles[0]/h + 1;
            else
                return piles[0]/h;
        }

        int maxPileSize = 0;
        for(int index=0; index<pilesLen; index++){
            maxPileSize = maxPileSize>piles[index] ? maxPileSize : piles[index];
        }

        return minBananasPerHour(piles, h, 1, maxPileSize);
    }
}