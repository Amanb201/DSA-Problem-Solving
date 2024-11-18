class Solution {
    public int[] decrypt(int[] code, int k) {
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
    }
}