class Solution {
    public String compressedString(String word) {
        String comp = "";

        int low=0, high = word.length();
        while(low<high){
            int count=1;
            int i = low+1;
            while( i<high && word.charAt(low) == word.charAt(i) && count<9){
                count++;
                i++;
            }
            
            int digitNum = '0' + count;
            char digitChar = (char) digitNum;
            // System.out.print(digitChar);
            comp += digitChar;
            comp += word.charAt(low);

            low = i;
        }
        return comp;
    }
}