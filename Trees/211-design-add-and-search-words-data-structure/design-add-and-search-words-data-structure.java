class Trie{
    Trie tries[];
    boolean endsWith;

    Trie(){
        tries = new Trie[26];
    }
}

class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public boolean containsKey(char ch, Trie trie){
        return trie.tries[ch - 'a'] != null;
    }

    public void addWord(String word) {
        Trie currTrie = trie;

        for(char ch: word.toCharArray()){
            if(!containsKey(ch, currTrie)){
                currTrie.tries[ch - 'a'] = new Trie();
            }
            currTrie = currTrie.tries[ch - 'a'];
        }

        currTrie.endsWith = true;
    }
    
    public boolean search(String word) {
        
        return searchWithEscapeDots(word, trie);
    }

    public boolean searchWithEscapeDots(String word, Trie trie){
        Trie currTrie = trie;

        for(int index = 0; index < word.length(); index++){
            /**For dot we have to skip the character otherwise we'll check for the match once the iteration has been completed, we can infer that word has been matched
            but need to explicity check whether word is ending over here or not**/
            if(word.charAt(index) == '.'){
                /*
                    If char is dot, then We have to check for all the Tries skipping the curr character, to find a match.
                    if we find a match in between we simply return true otherwise we iterate for all the tries (actual tries with non null values)
                    at last we return false if our iteration is over, till this point we have not returned true that means words doesn't exits
                    even with ignoring the char corresponding to dot.
                **/
                for(Trie iterTrie: currTrie.tries){
                    //For real tries node only we'll move forward, so this null check is mandatory.
                    if(iterTrie != null){
                        //Here we have to pass the subString by removing the current prefix.
                        String subWord = word.substring(index+1);

                        if(searchWithEscapeDots(subWord,iterTrie)){
                            return true;
                        }
                    }
                }
                return false;
            }
            else{
                if(!containsKey(word.charAt(index), currTrie)){
                    return false;
                }
            }
            currTrie = currTrie.tries[word.charAt(index) - 'a'];
        }

        return currTrie.endsWith;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */