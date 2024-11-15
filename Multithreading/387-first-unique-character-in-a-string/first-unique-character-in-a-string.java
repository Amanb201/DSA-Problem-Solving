class Solution {
    public int firstUniqChar(String s) {
        Map<String, Integer> freq = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            String word = s.substring(i,i+1);

            if(freq.containsKey(word)){
                int count = freq.get(word);
                freq.put(word, count+1);
            }
            else{
                freq.put(word, 1);
            }
        }

        for(int i=0; i<s.length(); i++){
            String word = s.substring(i,i+1);

            if(freq.get(word) == 1)
                return i;
        }

        return -1;
    }
}