class Solution {
    class Pair{
        int start;
        int end;

        Pair(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public List<Integer> partitionLabels(String s) {
        Map<Character, Pair> posMap = new HashMap<>();

        for(int index=0; index<s.length(); index++){
            Pair pairPos = new Pair(index, index);
            if(posMap.containsKey(s.charAt(index))){
                pairPos = posMap.get(s.charAt(index));
                pairPos.end = index;
            }
            posMap.put(s.charAt(index), pairPos);
        } 

        Pair pairPos = new Pair(0, 0);
        List<Integer> ans = new ArrayList<>();

        for(int index=0; index<s.length(); index++){
            Pair currPairPos = posMap.get(s.charAt(index));

            if(pairPos.end>=currPairPos.start){
                pairPos.end = currPairPos.end>pairPos.end ? currPairPos.end : pairPos.end;
            }
            else{
                ans.add(pairPos.end - pairPos.start + 1);
                pairPos.start = currPairPos.start;
                pairPos.end = currPairPos.end;
            }
        }
        ans.add(pairPos.end - pairPos.start + 1);

        return ans;
    }
}