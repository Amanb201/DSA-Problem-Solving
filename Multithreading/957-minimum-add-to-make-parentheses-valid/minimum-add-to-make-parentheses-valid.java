class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();

        int index=0;

        int insertionCount = 0;
        while(index<s.length()){
            if(s.charAt(index) == '('){
                stk.push('(');
            }
            else{
                if(!stk.isEmpty()){
                    stk.pop();
                }
                else{
                    insertionCount++;
                }
            }
            index++;
        }

        insertionCount += stk.size();
        return insertionCount;
    }
}