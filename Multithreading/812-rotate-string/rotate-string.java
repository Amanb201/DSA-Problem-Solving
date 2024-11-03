class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.equals(s))
            return true;

        for(int i=0; i<s.length()-1; i++){
            String part1 = s.substring(0, i+1);
            String part2 = s.substring(i+1);

            if(goal.equals(part2+part1))
                return true;
        }
        return false;
    }
}