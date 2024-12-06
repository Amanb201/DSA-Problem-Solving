class Solution {
    private int lcs(String s){
        int sLen = s.length();
        StringBuilder strBuilder = new StringBuilder(s);
        String revStr = strBuilder.reverse().toString();

        int[][] tabulationDp = new int[sLen+1][sLen+1];

        for(int i=0; i<=sLen; i++)
            tabulationDp[i][0] = 0;
        for(int i=0; i<=sLen; i++)
            tabulationDp[0][i] = 0;

        for(int i=1; i<=sLen; i++){
            for(int j=1; j<=sLen; j++){
                if(s.charAt(i-1) == revStr.charAt(j-1)){
                    tabulationDp[i][j] = tabulationDp[i-1][j-1]+1;
                }
                else{
                    tabulationDp[i][j] = Math.max(tabulationDp[i-1][j], tabulationDp[i][j-1]);
                }
            }
        }
        return tabulationDp[sLen][sLen];
    }

    private int longestPalindromeSubsequence(String s){
        int sLen = s.length();
        String sRev = "";

        for(int i=sLen-1; i>=0; i--)
            sRev += s.charAt(i);

        //Finding LCS
        int[][] tabulationDpArray = new int[sLen+1][sLen+1];

        for(int i=0; i<=sLen; i++)
            tabulationDpArray[i][0] = 0;

        for(int i=0; i<=sLen; i++)
            tabulationDpArray[0][i] = 0;

        //Using Shifted Index
        for(int i=1; i<=sLen; i++){
            for(int j=1; j<=sLen; j++){
                if(s.charAt(i-1) == sRev.charAt(j-1)){
                    tabulationDpArray[i][j] = tabulationDpArray[i-1][j-1] + 1;
                }
                else{
                    tabulationDpArray[i][j] = Math.max(tabulationDpArray[i][j-1], tabulationDpArray[i-1][j]);
                }
            }
        }
        return tabulationDpArray[sLen][sLen];
    }

    public int minInsertions(String s) {
        int sLen = s.length();

        return (sLen - lcs(s));
    }
}