class Solution {
    /**
        Time Complexity - O(NLogN) Sorting + O(N) Iterating over each intervals once = O(NLogN)
        Space Complexity - O(N)
     */
    class Interval{
        int start;
        int end;

        public Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public int[][] merge(int[][] intervals) {
        // return mergeIntervals(intervals);
        return practiceMerge(intervals);
    }

    public int[][] practiceMerge(int[][] intervals) {
        Arrays.sort(intervals, (interA, interB)->interA[0] - interB[0]);

        List<List<Integer>> mergedIntervals = new ArrayList<>();
        int size = intervals.length;

        for(int i=0; i<size; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int lastIndex = mergedIntervals.size()-1;

            if(lastIndex<0 || mergedIntervals.get(lastIndex).get(1)<currStart){
                mergedIntervals.add(new ArrayList<>(List.of(currStart, currEnd)));
            }
            else{
                int start = mergedIntervals.get(lastIndex).get(0) < currStart 
                                        ? mergedIntervals.get(lastIndex).get(0)
                                        : currStart;

                int end = mergedIntervals.get(lastIndex).get(1) > currEnd
                                        ? mergedIntervals.get(lastIndex).get(1)
                                        : currEnd;
                mergedIntervals.set(lastIndex, new ArrayList<>(List.of(start, end)));
            }
        }

        int mergedSize = mergedIntervals.size();
        int mergedIntervalArr[][] = new int[mergedSize][2];
        for(int i=0; i<mergedSize; i++){
            mergedIntervalArr[i][0] = mergedIntervals.get(i).get(0);
            mergedIntervalArr[i][1] = mergedIntervals.get(i).get(1);
        }
        return mergedIntervalArr;
    }

    private int[][] mergeIntervals(int[][] intervals) {
        int intervalSize = intervals.length;

        Interval[] intervalsArr = new Interval[intervalSize];

        for(int i=0; i<intervalSize; i++)
            intervalsArr[i] = new Interval(intervals[i][0], intervals[i][1]);

        Arrays.sort(intervalsArr, (a,b)->a.start-b.start);

        List<Interval> mergedIntervals = new ArrayList<>();

        for(int i=0; i<intervalSize; i++){
            int lastInterval = mergedIntervals.size()-1;

            if(mergedIntervals.isEmpty() ||
                     mergedIntervals.get(lastInterval).end<intervalsArr[i].start){
                //Pushing the 1st interval or the Subsequent Interval which can't be merged

                mergedIntervals.add(new Interval(intervalsArr[i].start, intervalsArr[i].end));
            }
            else {
                int start = mergedIntervals.get(lastInterval).start;
                int end = Math.max(mergedIntervals.get(lastInterval).end, intervalsArr[i].end);

                mergedIntervals.set(lastInterval, new Interval(start, end));
            }
        }

        int ansIntervalsCount = mergedIntervals.size();
        int[][] mergerdIntervalAns = new int[ansIntervalsCount][2];

        for(int i=0; i<ansIntervalsCount; i++){
            mergerdIntervalAns[i][0] = mergedIntervals.get(i).start;
            mergerdIntervalAns[i][1] = mergedIntervals.get(i).end;
        }

        return mergerdIntervalAns;
    }
}