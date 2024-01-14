class Solution {
    /**Time Complexity - O(num.length())
        Space Complexity - O(1) */
    public boolean checkIfOdd(Character digit){
        int number = Character.getNumericValue(digit);

        return (number%2 != 0);
    }

    public String largestOddNumber(String num) {

        int lastOddDigitIndex = -1;
        for(int index = num.length()-1; index>=0; index--){
            if(checkIfOdd(num.charAt(index))){
                lastOddDigitIndex = index;
                break;
            }
        }

        if(lastOddDigitIndex == -1)
            return "";

        return num.substring(0, lastOddDigitIndex+1);
    }
}