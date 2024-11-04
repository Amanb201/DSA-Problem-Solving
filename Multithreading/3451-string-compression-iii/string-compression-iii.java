class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder("");

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
            comp.append(digitChar);
            comp.append(word.charAt(low));

            low = i;
        }
        return comp.toString();
    }
}