class Solution {
    public String resultingString(String s) {
        // return approach1(s);
        return approach2(s);
    }
    
    private String approach2(String s){
        StringBuilder str = new StringBuilder("");
        str.append(s.charAt(0));

        int index=1;
        while(index<s.length()){
            int strLen = str.length();
            if(strLen>0 && (Math.abs(s.charAt(index)-str.charAt(strLen-1)) == 1 
                   || Math.abs(s.charAt(index)-str.charAt(strLen-1)) == 25))
            {
                str.deleteCharAt(strLen-1);
            }
            else{
                str.append(s.charAt(index));
            }
            index++;
        }
        return str.toString();
    }
    
    private String approach1(String s){
        StringBuilder str = new StringBuilder(s);

        int i=0;
        while(i<str.length()){
            //First Issue
            int index = getIndexOfConsecutiveAlphabet(str.toString(), i);
            
            if(index == -1){
                return str.toString();
            }
            else{
                str.delete(index-1, index+1);
                // str.deleteCharAt(index-1);
                // str.deleteCharAt(index-1);
                
                i = index-1;
                if(i>0)
                    i = i-1;
            }
        }
        return str.toString();
    }

    private int getIndexOfConsecutiveAlphabet(String s, int index){
        for(int i=index+1; i<s.length(); i++){
            if(Math.abs(s.charAt(i-1)-s.charAt(i)) == 1 || Math.abs(s.charAt(i-1)-s.charAt(i)) == 25){
                return i;
            }
        }
        return -1;
    }
}