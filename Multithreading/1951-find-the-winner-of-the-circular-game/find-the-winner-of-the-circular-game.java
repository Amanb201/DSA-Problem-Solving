class Solution {
    public int findTheWinner(int n, int k) {
        /***

                0   1    2   3  4
                0   0    0   0  0
           k=3  0   0    1   0  0
                1   0    1   0  1
                1   0    1   0  1
                1   1    1   0  1 
        
         */
        List<Integer> circularArr = new ArrayList<>();

        for(int i=0; i<n; i++)
            circularArr.add(i);

        int index =0;
        for(int i=0; i<n-1; i++){
            index = Math.floorMod(index+k-1, circularArr.size());

            circularArr.remove(index);
        }

        return circularArr.get(0)+1;
    }

    private int approach1(int n, int k){
        
        int[] circularArr = new int[n];

        int index =0;
        for(int i=0; i<n-1; i++){
            //Eliminationg n-1 players
            int pos = 1;
            while(pos<k){
                //Circular Array Wrap
                if(circularArr[index] == 0){
                    pos++;
                    System.out.println("index="+index +"    pos="+pos);
                }

                index = Math.floorMod(index+1, n);
            }
            
            System.out.println("index="+index);
            //kth player
            circularArr[index] = 1; // 1-INACTIVE, 0-ACTIVE
            
            while(circularArr[index] == 1)
                //Circular Array Wrap
                index = Math.floorMod(index+1, n);
        }

        for(int i=0; i<n; i++)
            if(circularArr[i] == 0)
                return i+1;

        return -1;
    }
}