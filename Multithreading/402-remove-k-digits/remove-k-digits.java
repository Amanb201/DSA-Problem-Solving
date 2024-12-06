class Solution {
    public String removeKdigits(String num, int k) {
        if(num == "" || k>=num.length())
            return "0";

        Stack<Character> monotonicStack = new Stack<>();

        for(char ch: num.toCharArray()){

            if(!monotonicStack.isEmpty()){
                while(!monotonicStack.isEmpty() 
                            && k>0
                                && (ch-'0' < monotonicStack.peek()-'0')){

                    monotonicStack.pop();
                    k--;
                }
                monotonicStack.push(ch);
            }
            else{
                monotonicStack.push(ch);
            }
        }

        //Edge case - when after pushing all the digits, we still have remaining k deletions,
        // this happens for increasing series
        while(!monotonicStack.isEmpty() && k>0){
            monotonicStack.pop();
            k--;
        }

        StringBuilder strBuilder = new StringBuilder("");
        while(!monotonicStack.isEmpty()){
            char digit = monotonicStack.pop();
            strBuilder.append(digit);
        }

        //Stack contains digits in reverse order
        strBuilder.reverse();

        //To ignore leading zeroes
        int lastIndex = 0;
        while(lastIndex<strBuilder.length()){
            if(strBuilder.toString().charAt(lastIndex) == '0')
                lastIndex++;
            else
                break;
        }
        strBuilder.delete(0, lastIndex);

        if(strBuilder.length() == 0)
            return "0";

        return strBuilder.toString();
    }
}