class Solution {
    class Item{
        int price;
        int beauty;
        int maxBeauty;

        Item(int p, int b){
            this.price = p;
            this.beauty = b;
            this.maxBeauty = -1;
        }
    }

    /***
        1   2   3   3   5   price=2
        0   1   2   3   4

        mid = 2
     */

    private int binarySearchToFindIndex(Item[] sortedItems, int price){
        int low=0, high = sortedItems.length-1;

        int maxValidIndex = -1;
        while(low<high){
            int mid = (low+high)/2;

            if(sortedItems[mid].price<=price){
                //Go Right
                maxValidIndex = mid;
                low = mid+1;
            }
            else{
                //Go Left
                high = mid-1;
            }
        }
        if(low == high && (sortedItems[low].price<=price))
            maxValidIndex = low;
        return maxValidIndex;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int size = items.length;
        Item[] sortedItems = new Item[size];

        for(int i=0; i<size; i++){
            sortedItems[i] = new Item(items[i][0], items[i][1]);
        }

        Arrays.sort(sortedItems, (a, b)->a.price-b.price);

        //Finding the maximum beauty from 0 to ith index for every index
        int maxB = sortedItems[0].beauty;
        for(int i=0; i<size; i++){
            maxB = Math.max(maxB, sortedItems[i].beauty);
            sortedItems[i].maxBeauty = maxB;
        }
        
        Map<Integer, Integer> ansMap = new TreeMap<>();
        int[] ans = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            

            if(ansMap.containsKey(queries[i])){
                ans[i] = ansMap.get(queries[i]);
            }
            else{
                int index = binarySearchToFindIndex(sortedItems, queries[i]);

                int maxBeauty = 0;
                if(index != -1){
                    maxBeauty = sortedItems[index].maxBeauty;
                }
                ansMap.put(queries[i], maxBeauty);
                ans[i] = maxBeauty;
            }
        }
        return ans;
    }
}