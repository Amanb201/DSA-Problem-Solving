class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // int maxConsecutiveTrue =
        return Math.max(maxLenConsecutiveChar(answerKey, k, 'T'), maxLenConsecutiveChar(answerKey, k, 'F'));
    }

    private int maxLenConsecutiveChar(String answerKey, int k, char targetChar){
        int maxLen = 0;
        int flipCount=0;
        
        int left=0, right=0;
        for(right=0; right<answerKey.length(); right++){
            if(answerKey.charAt(right) == targetChar){
                maxLen = Math.max(maxLen, right-left+1);
                // System.out.println("MATCH Left="+left+" right="+right+" maxLen="+maxLen);
            }
            else if(flipCount<k){
                flipCount++;
                maxLen = Math.max(maxLen, right-left+1);
                // System.out.println("UNMATCH&FLIP Left="+left+" right="+right+" maxLen="+maxLen+" flipCount="+flipCount);
            }
            else{
                while(answerKey.charAt(left) == targetChar)
                    left++;
                
                // flipCount--;
                left++;
                // System.out.println("Left="+left+" right="+right+" maxLen="+maxLen+" flipCount="+flipCount);
            }
        }
        return maxLen;
    }
}