class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for(String currToken: tokens){
            if(currToken.equals("+") || currToken.equals("-") || currToken.equals("/") || currToken.equals("*")){
                int first, second, result=0;
                if(!stk.isEmpty()){
                    second = stk.pop(); //or Pop??
                    first = stk.pop(); //or Pop??

                    //ToDo: Switch should be used over here
                    if(currToken.equals("+"))
                        result = first + second;
                    if(currToken.equals("-"))
                        result = first - second;
                    if(currToken.equals("*"))
                        result = first * second;
                    if(currToken.equals("/"))
                        result = first / second;

                    stk.push(result); //or push??    
                }
                else{
                    //Invalid Input
                    // return null;
                }
            }
            else{
                Integer currNum = Integer.parseInt(currToken);
                stk.push(currNum); //or push??
            }
        }

        //Stack should have only 1 item after all operations
        // if(stk.size() == 1)
            return stk.pop();
        // else
        //     return ;
    }
}