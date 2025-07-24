class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memoization = new int[s.length()];
        Arrays.fill(memoization, -1);

        return isValidBreak(s, wordDict, 0, memoization);
    }

    private boolean isValidBreak(String s, List<String> wordDict, int index, int[] memoization){
        int strLen = s.length();
        
        //If We've already exceeded the String length that means all the previous string has been matched with Dictionary words
        if(index >= strLen) return true;

        if(memoization[index] != -1)
            return memoization[index] == 1? true : false;

        for(String word: wordDict){
            int size = word.length();

            //Checking if this can go out of bound or not. If out of bound then we should not compare
            if(index+size-1 >= strLen)
                continue;

            //Trying to find a Valid Break Point (If any of the Dictionary word can be matched starting from the current index)
            //Then We can try the remain right partition if it has valid breaks recursively
            if(s.substring(index, index+size).equals(word) && isValidBreak(s, wordDict, index+size, memoization)){
                memoization[index] = 1;
                return true;
            }
        }

        memoization[index] = 0;
        return false;
    }
}