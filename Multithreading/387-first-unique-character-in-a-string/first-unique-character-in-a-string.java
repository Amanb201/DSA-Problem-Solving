class Solution {
    public int firstUniqChar(String s) {
        //Approach-1 Using HashMap to count the freq and check the in the string
        // for every char and find 1st char whose freq ==1 
        /**
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
        */

        int[] charFreqMap = new int[255];
        for(int i=0; i<s.length(); i++){
            int ascii = s.charAt(i);
            charFreqMap[ascii] += 1;
        }

        for(int i=0; i<s.length(); i++){ 
            int ascii = s.charAt(i);
            if(charFreqMap[ascii] == 1)
                return i;
        }       
        return -1;
    }
}