class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> stk = new Stack<>();
        int stkOpenBracket = 0;

        int index=0;

        int insertionCount = 0;
        while(index<s.length()){
            if(s.charAt(index) == '('){
                // stk.push('(');
                stkOpenBracket++;
            }
            else{
                // if(!stk.isEmpty()){
                if(stkOpenBracket>0){    
                    // stk.pop();
                    stkOpenBracket--;
                }
                else{
                    insertionCount++;
                }
            }
            index++;
        }

        // insertionCount += stk.size();
        insertionCount += stkOpenBracket;

        return insertionCount;
    }
}