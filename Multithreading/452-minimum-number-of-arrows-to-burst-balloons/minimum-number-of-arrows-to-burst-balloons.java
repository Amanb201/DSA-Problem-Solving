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

            // System.out.println("point="+point +" size="+mergedIntersectedPoints.size());

            if(lastMergedPoint ==  0){
                System.out.println(mergedIntersectedPoints.get(lastMergedPoint).get(1) < points[point][0]);
                System.out.println("mergedIntersectedPoints.get(lastMergedPoint).get(1)="+mergedIntersectedPoints.get(lastMergedPoint).get(1));
                System.out.println("points[point][0]="+points[point][0]);

            }

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
                System.out.println("INSIDE point="+point +" size="+mergedIntersectedPoints.size());

            }
            System.out.println("point="+point +" size="+mergedIntersectedPoints.size());

        }

        return mergedIntersectedPoints.size();
    }
}