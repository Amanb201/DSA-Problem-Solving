class Solution {
    public long minEnd(int n, int x) {

        // for(int i=0; i<32; i++){

        //     if(x & 1<<i){
        //         //i the bit of x is already set, so we can't change it as AND of all nums element must result in X,
        //         //So need all the SET bit from X to every element.
        //         continue;
        //     }else{
        //         //Now wherever bit is unset in X, can be used to generte elements of nums also in order.
        //         //So, all the non set bits can be used to generate n-1 elements.

        //         /***
        //             n=3, x=4
        //             n = 3 ==> mean elements in array from 0th to n-1 index
        //             x = 4 in bits
        //                             ith num from nums array
        //             4 ===> 1 0 0   

        //                    1 0 0   0 (0000) ===> 1 0 0 [4] 
        //                    1 0 0   1 (0001) ===> 1 0 1 [4, 5]
        //                    1 0 0   2 (0010) ===> 1 1 0 [4, 5, 6] if n=3 ans= 6
        //                    1 0 0   3 (0011) ===> 1 1 1 [4, 5, 6, 7] if n=4 ans= 7
        //         */
        //     }


        /***
            e.g. 
            n=2, x=7
            n = 2 ==> mean elements in array from 0th to n-1 index
            x = 7 in bits
                            ith num from nums array
            7 ===> 1 1 1   

                  0 0 1 1 1   0 (0000) ===> 1 1 1 [7] 
                  0 0 1 1 1   1 (0001) ===> 1 1 1 1 [7, 15]
                  0 0 1 1 1   2 (0010) ===> 1 0 1 1 1 [7, 15, 23] if n=3 ans= 23
                  0 0 1 1 1   3 (0011) ===> 1 1 1 1 1 [7, 15, 23, 31] if n=4 ans= 31
        
        */


        //Approach -1 (Failing some test cases wher X and N are large ~10^7)
        // long nth = n-1;
        // long merged = x;
        // int k = 0;
        // for(int i=0; i<32; i++){
        //     if((x & 1<<i) == 0){
        //         //moving bit kth bit of number (n-1) to the ith(as it is unset in X) position 
        //         //And finally merging it with X to generate nth element of nums array.
        //         //This is the Mask = (nth & (1<<k))
        //         //Moving the mask to ith bit (nth & (1<<k) << (i-k))
        //         merged = merged | ((nth & (1<<k)) << (i-k));
        //         k++;
        //     }
        // }

        // return merged;

        long merged1 = x;
        //Approach -2
        for(int i=1; i<n; i++){
            merged1 = (merged1 + 1) | x;
        }
        return merged1;
    }
}