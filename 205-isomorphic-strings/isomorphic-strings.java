class Solution {
    /**Time Complexity - O(s.length())
        Space Complexity - O(s.length()) */
    public void mapCharEncoding(String s, String t, HashMap<Character, Character> charMap){
        for(int index=0; index<s.length(); index++){
            if(charMap.isEmpty()){
                charMap.put(s.charAt(index), t.charAt(index));
            }
            else if((charMap.containsKey(s.charAt(index)) == false) 
                            && (charMap.containsValue(t.charAt(index)) == false)){
                charMap.put(s.charAt(index), t.charAt(index));
            }
            else if(charMap.containsKey(s.charAt(index)) == false 
                                && charMap.containsValue(t.charAt(index))){
                break;
            }
            else if(charMap.get(s.charAt(index)) == t.charAt(index)){
                continue;
            }
            else{
                break;
            }
        }
    }

    public String replaceCharacters(String s, HashMap<Character, Character> charMap){
        String ans = "";
        for(int index=0; index<s.length(); index++){
            ans += charMap.get(s.charAt(index));
        }
        return ans;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();

        if(s.length() != t.length())
            return false;

        mapCharEncoding(s, t, charMap); //O(s.length())
        
        return t.equals(replaceCharacters(s, charMap)); //O(s.length())
    }
}