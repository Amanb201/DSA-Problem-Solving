class TrieNode{
    char value;
    boolean isCompleteWord;
    TrieNode[] childs;
    
    TrieNode(){
        childs = new TrieNode[26];
    }

    TrieNode(char value){
        this.value = value;
        childs = new TrieNode[26];
    }
}

class Trie {
    TrieNode trieNode;
    public Trie() {
        trieNode = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currTrieNode = trieNode;

        for(char ch: word.toCharArray()){
            if(currTrieNode.childs[ch-'a'] == null){
                TrieNode newTrieNode = new TrieNode(ch);
                currTrieNode.childs[ch-'a'] = newTrieNode; 
            }
            currTrieNode = currTrieNode.childs[ch-'a'];
        }
        currTrieNode.isCompleteWord = true;
    }
    
    public boolean search(String word) {
        TrieNode currTrieNode = trieNode;
        // AM ---- AMAN
        for(char ch: word.toCharArray()){
            if(currTrieNode.childs[ch-'a'] == null){
                return false; 
            }
            currTrieNode = currTrieNode.childs[ch-'a'];
        }
        return currTrieNode.isCompleteWord;
    }
    
    public boolean startsWith(String word) {
        TrieNode currTrieNode = trieNode;

        for(char ch: word.toCharArray()){
            if(currTrieNode.childs[ch-'a'] == null){
                return false; 
            }
            currTrieNode = currTrieNode.childs[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */