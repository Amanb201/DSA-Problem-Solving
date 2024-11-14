class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> wordsFreqMap = new HashMap<>();

        for(int i=0; i<words.length; i++){
            String word = words[i];

            if(wordsFreqMap.containsKey(word)){
                int count = wordsFreqMap.get(word);
                wordsFreqMap.put(word, count+1);
            }
            else{
                wordsFreqMap.put(word, 1);
            }
        }

        Queue<Pair<String, Integer>> pq = new PriorityQueue<>((a,b)->{
            return b.getValue() == a.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue();
        });

        for(String word:wordsFreqMap.keySet()){
            pq.add(new Pair<String, Integer>(word, wordsFreqMap.get(word)));
        }

        List<String> ans = new ArrayList<>();
        while(k>0){
            ans.add(pq.poll().getKey());
            k--;
        }

        return ans;
    }
}