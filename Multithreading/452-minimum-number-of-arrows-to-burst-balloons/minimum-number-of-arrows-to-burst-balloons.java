class Solution {
    public int findMinArrowShots(int[][] points) {

        //Sorting the points based the starting point of each ballons
        Arrays.sort(points,(a,b)->{
                if(a[0]<=b[0])    return -1;
                return 1;
            }
        );

        int totalPoints= points.length;
        List<List<Integer>> mergedIntersectedPoints = new ArrayList<>();

        for(int point=0; point<totalPoints; point++){
            int lastMergedPoint = mergedIntersectedPoints.size() - 1;

            if(mergedIntersectedPoints.isEmpty() ||
                     mergedIntersectedPoints.get(lastMergedPoint).get(1) < points[point][0]){
                List<Integer> currPoint = new ArrayList<>();

                currPoint.add(points[point][0]);
                currPoint.add(points[point][1]);

                mergedIntersectedPoints.add(currPoint);
            }
            else{
                int start = Math.max(mergedIntersectedPoints.get(lastMergedPoint).get(0), points[point][0]);
                int end = Math.min(mergedIntersectedPoints.get(lastMergedPoint).get(1), points[point][1]);

                mergedIntersectedPoints.get(lastMergedPoint).set(0, start);
                mergedIntersectedPoints.get(lastMergedPoint).set(1, end);

            }

        }

        return mergedIntersectedPoints.size();
    }
}