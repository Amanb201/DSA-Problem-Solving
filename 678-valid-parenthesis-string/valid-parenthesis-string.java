class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();

        for(int index=0; index<s.length(); index++){
            if(s.charAt(index)=='('){
                stk1.push(index);
            }
            else if(s.charAt(index)=='*'){
                stk2.push(index);
            }
            else{
                if(!stk1.empty()){
                    stk1.pop();
                }
                else if(!stk2.empty()){
                    stk2.pop();
                }
                else
                    return false;
            } 
        }

        while(!stk1.empty() && !stk2.empty() && (stk1.peek()<stk2.peek())){

            stk1.pop();
            stk2.pop();    
        }

        return stk1.empty();
    }
}
// **((()