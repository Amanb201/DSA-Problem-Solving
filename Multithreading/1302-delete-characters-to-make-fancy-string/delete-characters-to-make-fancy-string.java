class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        
        //String concatenation gives TLE for larger string so, we have to use StringBuilder class to do
        // string modification in more efficient way.
        // String ans = "";
        // ans += s.charAt(0);
        
        int currCount = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currCount++;
                
                if(currCount<3)
                    ans.append(s.charAt(i));
                else
                    currCount--;
    
            }else{
                currCount = 1;
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}