class Solution {
    /**
        [-1 , 5 ,0 ,6 ,7 ,0 ,0 , 0]
          0   1  2  3  4  5  6   7
        headID  = 0

        0 --> {2, 5, 6, 7}  |||  89
        5 --> {1}      |||  523
        6 --> {3}      |||  241 
        7 --- {4}     |||  

     */
    class Subordinate{
        List<Integer> subordinates;
        int infoTime;

        Subordinate(List<Integer> _sub, int _infoTime){
            this.subordinates = _sub;
            this.infoTime = _infoTime;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Subordinate> managerMap = new HashMap<>();

        //Building Directed Graph
        for(int i=0; i<n; i++){
            if(i != headID){
                int managerId = manager[i];

                Subordinate suboridate = managerMap.getOrDefault(managerId, new Subordinate(new ArrayList<>(), informTime[managerId]));
                suboridate.subordinates.add(i);
                managerMap.put(managerId, suboridate);
            }
        }

        // if(headID == 2){
        //     System.out.println("head " +headID);
    
        //     System.out.println(managerMap.get(2).subordinates);

        // }


        //List -> managerid, time
        Queue<List<Integer>> que = new LinkedList<>();
        List<Integer> managerWithTime = new ArrayList<>();
        managerWithTime.add(headID);
        managerWithTime.add(informTime[headID]);

        que.add(managerWithTime);

        int totalTime = 0;
        while(!que.isEmpty()){
            List<Integer> managerWithCost = que.poll();

            int managerId = managerWithCost.get(0);
            int informCost = managerWithCost.get(1);

            // System.out.println("managerId " +managerId +" informCost "+informCost);

            Subordinate suboridate = managerMap.getOrDefault(managerId, new Subordinate(new ArrayList<>(), informTime[managerId]));
            List<Integer> subordinates = suboridate.subordinates;

            if(subordinates.size() > 0){
                totalTime = Math.max(totalTime, informCost);
            }

            for(int subordinate: subordinates){
                List<Integer> managerWithTim = new ArrayList<>();
                managerWithTim.add(subordinate);
                managerWithTim.add(informTime[subordinate] + informCost);
                que.add(managerWithTim);
            }
        }
        return totalTime;
    }
}