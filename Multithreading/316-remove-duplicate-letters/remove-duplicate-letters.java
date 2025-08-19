class Solution {
    /**
        cbacdcbc

        c-> 4 -> 3
        b->2->1
        a->1
        d-1



        set- [a, c, d, b]

        c b a c d c b c
        0 1 2 3 4 5 6 7 
        [c]
        [b]
        [a]
        [a, c]
        [a, c, d]
        [a, c, d, b]



        b c a b c
        0 1 2 3 4

        b - 2
        c - 2
        a - 1

        stk = b c 
        set = b c


        b b c a a c
        0 1 2 3 4 5

        b - 2
        c - 2
        a - 2

        stk = b a
        set = b a
     */
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char letter: s.toCharArray()){
            freqMap.put(letter, freqMap.getOrDefault(letter, 0)+1);
        }

        Set<Character> set = new HashSet<>();
        Stack<Character> stk = new Stack<>();

        for(char letter: s.toCharArray()){
            if(!set.contains(letter)){
                while(!stk.isEmpty() && stk.peek()>letter && freqMap.get(stk.peek()) > 1){
                    char top = stk.peek();
                    set.remove(top);
                    freqMap.put(top, freqMap.getOrDefault(top, 0)-1);
                    stk.pop();

                    if(freqMap.get(top)<=0)
                        freqMap.remove(top);
                }

                stk.add(letter);
                set.add(letter);
            }
            else{
                freqMap.put(letter, freqMap.getOrDefault(letter, 0)-1);
            }
        }

        String str = "";
        while(!stk.isEmpty()){
            str = stk.pop() + str;
        }

        return str;
    }
}