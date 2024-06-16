class Trie{
    Trie tries[];
    int prefixCount;
    boolean endsHere;

    Trie(){
        tries = new Trie[26];
    }

    public static boolean trieContainsKey(char ch, Trie trie){
        return trie.tries[ch - 'a'] != null;
    }

    public Trie next(char ch){
        return tries[ch - 'a'];
    }

    public void add(char ch){
        tries[ch - 'a'] = new Trie();
    }

    public void markWordEndsHere(){
        endsHere = true;
    }

    public void increasePrefixCount(){
        prefixCount = prefixCount+1;
    }

    public static void addWord(String word, Trie trie){
        Trie currTrie = trie;

        for(char ch: word.toCharArray()){
            if(! Trie.trieContainsKey(ch, currTrie)){
                currTrie.add(ch);
            }
            currTrie = currTrie.next(ch);
            currTrie.increasePrefixCount();
        }
        currTrie.markWordEndsHere();
    }
}
class Solution {
    /**Writing this solution just to practice Trie data structure,
        This can be solved without using Trie, with the similar time complexity i.e
        O(M*N) where M is length of the maximum size string and
        N is number strings in the array.
    */
    /**
        Algorithm -
        Step -1 Add all the words from strs array into Trie (should be designed is such
        a way that it keeps tracks of prefix count at every Trie node i.e how many time
        this node has been inserted)
        Step -2 
     */
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        int wordCount = strs.length;

        for(String word: strs){
            Trie.addWord(word, trie);
        }
        String word = strs[0];
        String prefix = "";

        Trie currTrie = trie;
        for(int index=0; index<word.length(); index++){
            char currChar = word.charAt(index);
            if(Trie.trieContainsKey(currChar, currTrie)){
                currTrie = currTrie.next(currChar);
                if(currTrie.prefixCount == wordCount){
                    prefix += currChar;
                }
                else{
                    return prefix;
                }
            }
            else{
                return prefix;
            }
        }

        return prefix;
    }
}