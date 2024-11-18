class Solution {
    class Interval{
        int start;
        int end;

        public Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public int[][] merge(int[][] intervals) {
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