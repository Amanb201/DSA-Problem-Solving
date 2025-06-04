class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;

        Map<Character, Integer> targetCharFreq = new HashMap<>();
        
        for(Character alphabet: s1.toCharArray()){
            targetCharFreq.put(alphabet, targetCharFreq.getOrDefault(alphabet, 0)+1);
        }

        Map<Character, Integer> currCharFreq = new HashMap<>();
        // int left=0, right;
        // for(right=0; right<s2.length(); right++){
        //     if(targetCharFreq.containsKey(s2.charAt(right))){
        //         char alphabet = s2.charAt(right);
        //         currCharFreq.put(alphabet, currCharFreq.getOrDefault(alphabet, 0)+1);

        //         boolean flag = true;
        //         for(Character letter: targetCharFreq.keySet()){
        //             if(!currCharFreq.containsKey(letter)){
        //                 flag = false;
        //                 break;
        //             }
        //             else if(currCharFreq.get(letter) < targetCharFreq.get(letter)){
        //                 flag = false;
        //                 break;
        //             }
        //         }

        //         if(flag)
        //             return true;
        //     }
        //     else{
        //         currCharFreq.clear();
        //     }
        // }
        // return false;

        int left=0, right;
        for(right=0; right<s1.length(); right++){
            if(targetCharFreq.containsKey(s2.charAt(right))){
                char alphabet = s2.charAt(right);
                currCharFreq.put(alphabet, currCharFreq.getOrDefault(alphabet, 0)+1);
            }
        }

        for(right=right; right<s2.length(); right++){
            boolean flag = true;
            for(Character letter: targetCharFreq.keySet()){
                if(!currCharFreq.containsKey(letter)){
                    flag = false;
                    break;
                }
                else if(currCharFreq.get(letter) < targetCharFreq.get(letter)){
                    flag = false;
                    break;
                }
            }

            if(flag)
                return true;
            
            char charAtLeft = s2.charAt(left);
            if(currCharFreq.containsKey(charAtLeft)){
                currCharFreq.put(charAtLeft, currCharFreq.getOrDefault(charAtLeft, 0)-1);

                if(currCharFreq.get(charAtLeft)<=0)
                    currCharFreq.remove(charAtLeft);
            }
            left++;

            char charAtRight = s2.charAt(right);
            currCharFreq.put(charAtRight, currCharFreq.getOrDefault(charAtRight, 0)+1);            
        }

        boolean flag = true;
        for(Character letter: targetCharFreq.keySet()){
            if(!currCharFreq.containsKey(letter)){
                flag = false;
                break;
            }
            else if(currCharFreq.get(letter) < targetCharFreq.get(letter)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}