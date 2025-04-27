class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxPoint = 0;
        int size = cardPoints.length;

        int left = size - k;
        int right = left;

        int currPoint = 0;
        while(right<size){
            currPoint += cardPoints[right++];
        }
        maxPoint = currPoint;

        for(left = size - k; left<size; left++){
            currPoint = currPoint - cardPoints[left] + cardPoints[right%size];
            right++;

            maxPoint = Math.max(currPoint, maxPoint);
        }
        return maxPoint;
    }
}