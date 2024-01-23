class Solution {
    /**Time Complexity - O(N)
        Space Complexity - O(N) */
    public boolean isValid(String s) {
        int size = s.length();
        if(size%2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        int index = 0;

        while(index<size){
            if(s.charAt(index) == '(' 
                    || s.charAt(index) == '{' 
                        || s.charAt(index) == '['){
                stack.push(s.charAt(index));
            }
            else if(stack.empty()){
                return false;
            }
            else{
                Character top = stack.pop();

                if(!((top == '(' && s.charAt(index) == ')')
                        || (top == '{' && s.charAt(index) == '}')
                            || (top == '[' && s.charAt(index) == ']')))
                    return false;
            }
            index++;
        }

        return stack.empty();
    }
}