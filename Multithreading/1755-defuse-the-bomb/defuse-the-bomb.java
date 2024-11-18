class Solution {
    public int[] decrypt(int[] code, int k) {

        /**Brute Force: Circular Array Intuition
        
        
        int size = code.length;

        int decryptedCode[] = new int[size];

        for(int i=0; i<size; i++){

            int sum = 0;
            int steps = k;//Irrespective of sign maintaining how much steps we have to go on left direction
            
            // correctly handling modulus of number getting out of bound in circular array
            int currInd = (i+1)%size;            

            while(k>0 && steps>0){
                sum += code[currInd];

                currInd = (currInd+1)%size;
                steps--;
            }

            steps = k;//Irrespective of sign maintaining how much steps we have to go on left direction

             // correctly handling modulus of negative number in circular array
            currInd = (((i-1)%size)+size)%size;
            if(currInd<0)
                currInd = ((currInd%size)+size)%size;
            while(k<0 && steps<0){
                sum += code[currInd];

                currInd = (((currInd-1)%size)+size)%size;
                steps++;
            }

            if(k==0)
                sum = 0;

            decryptedCode[i] = sum;
        }

        return decryptedCode;
         */



         //Optimized Solution from Solutions
         int[] res = new int[code.length];
        if (k == 0) return res;
        //Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
        if (k < 0) {//If k < 0, the starting point will be end of the array.
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) sum += code[i];
        //Scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++end) % code.length];
        }
        return res;
    }
}