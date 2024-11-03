class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;

        String concatS = s + s;

        if(concatS.indexOf(goal) != -1)
            return true;
        return false;
    }
}