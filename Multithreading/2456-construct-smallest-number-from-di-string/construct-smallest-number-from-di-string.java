class Solution {
    public String smallestNumber(String pattern) {
        /**
        "IIIDIDDD"


        IDID

          i=0   str="1"     []
          i=1   str="1"     [2]
          i=2   str="132"   []
          i=3   str="132"   [4]
          i=4   str="13254" []
          

        
         */

         Stack<Integer> stk = new Stack<>();
         int n = pattern.length();

        String ans = "";
        int count = 1;

        for(int i=0; i<=n; i++){
            stk.push(i+1);

            if(i==n || pattern.charAt(i) == 'I'){
                while(!stk.isEmpty())
                ans += stk.pop();
            }
        }

        return ans;
    }
    //     boolean[] isUsed = new boolean[10];

    //     int len = pattern.length();
    //     int left=0, right=0;
    //     String num = "";

    //     char currPattern = pattern.charAt(0);
    //     while(right<len){
    //         while(right<len && pattern.charAt(right) == currPattern){
    //             right++;
    //         }

    //         int currPatlen = right - left + 1;

    //         if(currPattern == 'I'){
    //             //Increasing
    //             num = buildIncreasingPatternForLen(num, isUsed, currPatlen-1);
    //         }
    //         else{
    //             //Decreasing
    //             num = buildDecreasingPatternForLen(num, isUsed, currPatlen);
    //         }
    //         left = right;
            
    //         if(right < len)
    //             currPattern = pattern.charAt(right);
    //     }
    //     return num;
    // }

    // private String buildIncreasingPatternForLen(String str, boolean[] isUsed, int len){
    //     int firstAvailable = -1;
    //     for(int num=1; num<10; num++){
    //         if(!isUsed[num]){
    //             firstAvailable = num;
    //             break;
    //         }
    //     }

    //     if(firstAvailable == -1)
    //         return str;

    //     //Building
    //     for(int num=firstAvailable; num<10; num++){
    //         if(len>0 && !isUsed[num]){
    //             str += num;
    //             isUsed[num] = true;
    //             len--;
    //         }
    //     }
    //     return str;
    // }

    // private String buildDecreasingPatternForLen(String str, boolean[] isUsed, int len){
    //     int lastIndex = -1;
    //     int currLen = 0;
    //     for(int num=1; num<10; num++){
    //         if(!isUsed[num] && currLen<len){
    //             currLen++;
    //         }
    //         if(currLen == len){
    //             lastIndex = num;
    //             break;
    //         }
    //     }

    //     if(lastIndex == -1)
    //         return str;

    //     //Building
    //     for(int num=lastIndex; num>0; num--){
    //         if(len>0 && !isUsed[num]){
    //             str += num;
    //             isUsed[num] = true;
    //             len--;
    //         }
    //     }
    //     return str;
    // }

}