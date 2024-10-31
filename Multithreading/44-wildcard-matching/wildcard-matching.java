class Solution {
    private boolean isWildcardMatchSuccessful(String start, String pat, int index1, int index2,
     int[][] memoizationDpArray){
        //if both the strings are exhausted i.e. pattern is matched completely
        if(index1<0 && index2<0)    return true; 
        //If pattern string is exhausted but source string has some chars, so it can't be matched further
        if(index1>=0 && index2<0)   return false ;

        //if source string is exhausted, we have to check whether all the remaining char 
        //are '*' or not, if it * then it can be matched with emtpy char '', otherwise match is failed
        if(index1<0 && index2>=0){
            // System.out.println("index1="+index1+" index2="+index2+ "  (pat.charAt(index2)!='*')= "+(pat.charAt(index2)!='*'));

            if(pat.charAt(index2)!='*')
                return false; 
            return isWildcardMatchSuccessful(start, pat, index1, index2-1, memoizationDpArray);
        }

        
        //Memoization
        if(memoizationDpArray[index1][index2] != -1)
            return memoizationDpArray[index1][index2]==1 ? true: false;

        boolean match = false, singleWildcardMatch = false, sequenceWildcardMatch = false;

        if(start.charAt(index1) == pat.charAt(index2)){
            match = isWildcardMatchSuccessful(start, pat, index1-1, index2-1, memoizationDpArray);
        }
        else if(pat.charAt(index2) == '?'){
            singleWildcardMatch = isWildcardMatchSuccessful(start, pat, index1-1, index2-1, memoizationDpArray);
        }
        else if(pat.charAt(index2) == '*'){
            //First matching * with empty character, it has be computed first, othewise, right most * can match 
            //all the chars in first string and store false in DP array
            sequenceWildcardMatch = isWildcardMatchSuccessful(start, pat, index1, index2-1, memoizationDpArray);

            //Matching with every other char.
            for(int i=index1; i>=0; i--){
                if(isWildcardMatchSuccessful(start, pat, i-1, index2-1, memoizationDpArray))
                    sequenceWildcardMatch = true;
                // System.out.println("sequenceWildcardMatch="+sequenceWildcardMatch+" index1="+(i-1)+" index2="+(index2-1));
            }
        }
        // if((match || singleWildcardMatch || sequenceWildcardMatch))
        //     System.out.println("index1="+index1+" index2="+index2);
        memoizationDpArray[index1][index2] = (match || singleWildcardMatch || sequenceWildcardMatch)? 1 : 0;
        return match || singleWildcardMatch || sequenceWildcardMatch;
    }


    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[][] memoizationDpArray = new int[m][n];

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                memoizationDpArray[i][j] = -1;

        return isWildcardMatchSuccessful(s, p, m-1, n-1, memoizationDpArray);
    }
}