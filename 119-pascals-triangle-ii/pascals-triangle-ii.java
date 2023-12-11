class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRowArray = new ArrayList<>();

        for(int row=0; row<=rowIndex; row++){
            List<Integer> currRowArray = new ArrayList<>();
            
            for(int i=0; i<=row; i++)
                currRowArray.add(1);

            if(row!=0)
                for(int index=1; index<row; index++)
                    currRowArray.set(index, prevRowArray.get(index-1)+prevRowArray.get(index));

            if(row == rowIndex)
                return currRowArray;

            prevRowArray = currRowArray;
        }
        return prevRowArray;
    }
}