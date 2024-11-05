class Solution {
    public int minChanges(String s) {
        int low=1, high=s.length();

        int changes = 0;
        int repeatCount = 1;
        while(low<high){
            if(s.charAt(low) == s.charAt(low-1)){
                repeatCount++;
            }
            else{
                // System.out.println("Before index="+low+"   changes= "+changes+"  RepeatCount="+repeatCount);

                if(repeatCount%2 != 0){
                    low = low+1;
                    changes++;
                }

                //Just counting where it needs to be changes but not changing anything.

                repeatCount = 1;
                // System.out.println("After index="+low+"   changes= "+changes+"  RepeatCount="+repeatCount);
            }
            low++;
                // System.out.println("last index="+low+"   changes= "+changes+"  RepeatCount="+repeatCount);

        }   
        return changes;
    }
}