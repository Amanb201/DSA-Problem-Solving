class Solution {
    public int[][] merge(int[][] intervals) {
        /**
        Time Complexity - O(N Log N) + O(N) sorting and merging intervals
        Space complexity -  O(N) for 2D array or list*/

        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
        
        // for (int[] row : intervals) {
        //     System.out.println(Arrays.toString(row));
        // }

        List<List<Integer>> mergedIntervals = new ArrayList<>();

        List<Integer> currInterval = new ArrayList<>();
        currInterval.add(intervals[0][0]); 
        currInterval.add(intervals[0][1]);
        mergedIntervals.add(currInterval);
        
        for(int interval=1; interval<intervals.length; interval++){
            int lastIndex = mergedIntervals.size()-1;

            int start =0, end =1;
            currInterval = mergedIntervals.get(lastIndex);
            // System.out.println("currInt "+ currInterval);
            if(intervals[interval][start] <= currInterval.get(end)){
                //Intervals are overlapping
                //Need to merge the currInterval with the lastMergedInterval inside
                //mergedInterval
                
                if(intervals[interval][end] > currInterval.get(end)){
                    currInterval.set(end, intervals[interval][end]);
                    mergedIntervals.set(lastIndex, currInterval);
                    // System.out.println(mergedIntervals);
                }
            }
            else{
                //Interval can't be merged with existing one, so add this as a new interval

                mergedIntervals
                    .add(Arrays.asList
                    (intervals[interval][start], intervals[interval][end]));
                // System.out.println(mergedIntervals);
            }
        }
        // System.out.println(mergedIntervals);
        int[][] arr = mergedIntervals.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return arr;
    }
}