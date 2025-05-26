class Solution {
    /***
        ab, ba, cc

            a    b   c
        a   0    1   0

        b   1    0   0
         
        c   0    0   1


    
     */
    public int longestPalindrome(String[] words) {
        // return approach1(words);
        return approach2(words);
    }

    private int approach2(String[] words){
        int[][] freqMap = new int[26][26];

        int palindromeLen = 0;

        for(String word: words){
            int row = word.charAt(0) - 'a';
            int col = word.charAt(1) - 'a';

            if(freqMap[col][row]>0){
                palindromeLen += 4;
                freqMap[col][row]--;
            }
            else{
                freqMap[row][col] += 1;  
            }
        }

        for(int row=0; row<26; row++){
            if(freqMap[row][row]>0){
                palindromeLen += 2;
                break;
            }
        }
        return palindromeLen;
    }

    private int approach1(String[] words){
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> repeatedCharsFreqMap = new HashMap<>();

        int palindromeLen = 0;
        for(String word: words){
            if(word.charAt(0) == word.charAt(1)){
                repeatedCharsFreqMap.put(word, repeatedCharsFreqMap.getOrDefault(word,0)+1);
            }
            else{
                map.put(word, map.getOrDefault(word,0)+1);

                StringBuilder strBuilder = new StringBuilder(word);
                strBuilder.reverse();
                
                if(map.containsKey(strBuilder.toString()) && map.get(strBuilder.toString())>0){
                    palindromeLen += 4;

                    map.put(strBuilder.toString(), map.get(strBuilder.toString())-1);
                    map.put(word, map.get(word)-1);
                }
            }
        }

        // System.out.println("palindromeLen="+palindromeLen);
        boolean isOdd = false;
        for(String word: repeatedCharsFreqMap.keySet()){
            int freq = repeatedCharsFreqMap.get(word);

            if(freq%2 != 0){
                isOdd = true;
            }

            palindromeLen += (freq/2)*4;
            // System.out.println("palindromeLen="+palindromeLen);
        }

        if(isOdd){
            palindromeLen += 2;
        }

        return palindromeLen;
    }
}