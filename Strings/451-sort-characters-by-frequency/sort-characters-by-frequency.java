class Solution {
    /**Time  Complexity - O(N Log N)
        Space Complexity - O(N) */
    public void countFrequency(HashMap<Character, Integer> mapFrequency, String s){
        int index=0;
        while(index<s.length()){

            Character currChar = s.charAt(index);
            if(mapFrequency.isEmpty()){
                mapFrequency.put(currChar, 1);
            }
            else if(mapFrequency.containsKey(currChar)){
                mapFrequency.put(currChar, mapFrequency.get(currChar)+1);
            }
            else
                mapFrequency.put(currChar, 1);
            
            index++;
        }
    }

    public String sortedChars(PriorityQueue<Pair<Character, Integer>> maxHeap){
        String sortedString = "";

        // System.out.println("Inside sortedChars");
        // System.out.println(maxHeap.isEmpty());
        while(!maxHeap.isEmpty()){
            Pair<Character, Integer> frequencyMap = maxHeap.poll();
            Character currChar = frequencyMap.getKey();
            int frequency = frequencyMap.getValue();
            // System.out.println(currChar);
            // System.out.println(frequency);
            while(frequency>0){
                sortedString += currChar;

                frequency--;
            }
        }
        return sortedString;
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> mapFrequency = new HashMap<>(); // Space O(N) worst case
        ArrayList<Pair<Character, Integer>> frequencies = new ArrayList<>(); //Space O(N) worst case
        
        PriorityQueue<Pair<Character, Integer>> maxHeap
                            = new PriorityQueue<>((a,b)->b.getValue()-a.getValue()); //Space O(N) worst case

        countFrequency(mapFrequency, s); //O(N)

        for(Character key: mapFrequency.keySet()){ //O(UniqueChars) -> worst case O(N)
            int count = mapFrequency.get(key);
            frequencies.add(new Pair(key, count));
        }
        
        int size = frequencies.size();

        for(int index=0; index<size; index++) //O(N Log N)
            maxHeap.add(frequencies.get(index));

        // System.out.println(maxHeap.isEmpty());
        return sortedChars(maxHeap); //O(N)
    }
}