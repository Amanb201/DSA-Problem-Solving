class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for(int index=1; index<=numRows; index++){
            List<Integer> row = new ArrayList<>();

            if(index==1)
                row.add(1);
            else{
                List<Integer> prevRow = new ArrayList<>();
                prevRow = pascalTriangle.get(index-2);

                int currRowSize = index;
                for(int i=0; i<currRowSize; i++)
                    row.add(1);

                for(int rowIndex=1; rowIndex<currRowSize-1; rowIndex++){
                    row.set(rowIndex, prevRow.get(rowIndex-1)+prevRow.get(rowIndex));
                }
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}