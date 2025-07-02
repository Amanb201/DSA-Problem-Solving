class Solution {
    public int maxCoins(int[] piles) {
        /**
        2,4,1,2,7,8
        8 7 4 2 2 1

        8 7 4 3 2 1 => 7 + 3
         */

         int totalPilesPersonGet = piles.length/3;
         Integer[] pilesArr = new Integer[piles.length];
         for(int i=0; i<piles.length; i++)
            pilesArr[i] = piles[i];

         Arrays.sort(pilesArr, (a, b)->(b-a));

         int maxCoins = 0;
         for(int i=0; i<totalPilesPersonGet*2; i++){
            if(i%2 != 0){
                maxCoins += pilesArr[i];
            }
         }

         return maxCoins;
    }
}