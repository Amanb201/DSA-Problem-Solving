class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for(int i=0; i<groupSizes.length; i++){
            int groupSize = groupSizes[i];

            List<List<Integer>> groups = map.getOrDefault(groupSize, new ArrayList<>());

            int totalGroups = groups.size();
            if(totalGroups>0 && groups.get(totalGroups-1).size() < groupSize){
                List<Integer> group = groups.get(totalGroups-1);
                group.add(i);
            }
            else{
                List<Integer> group = new ArrayList<>();
                group.add(i);
                groups.add(group);
                map.put(groupSize, groups);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int groupSize: map.keySet()){
            for(List<Integer> group: map.get(groupSize)){
                ans.add(group);
            }
        }
        return ans;
    }
}