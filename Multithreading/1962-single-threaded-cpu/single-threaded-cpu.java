class Solution {

    class Task {
        int index;
        int enqueueTime;
        int processingTime;

        Task (int _index, int _enqueueTime, int _processingTime) {
            this.index = _index;
            this.enqueueTime = _enqueueTime;
            this.processingTime = _processingTime;
        }
    }
    /**
        [[1,2],[2,4],[3,2],[4,1]]
            0    1      2     3


           i=0 ==> Que (0,[1,2])
           i=1 ==> Que (0,[1,2]) (1, [2,4])
           i=2 ==> Que  (1, [2,4]) (2, [3,2])         ans [0]
           i=3 ==> Que  (1, [2,4]) (2, [3,2]) (3,[4,1])        ans [0]



           [[1,2],[2,4],[3,2],[4,1]]
                0    1   2      3


           t=0
           t=1 (0,[1,2])                => ans[0]   availableTime = 3
           t=2                          => ans[0]   availableTime = 3
           t=3  (1,[2,4]) (2,[3,2])     => ans[0,2]  availableTime = 5
           t=5  (1,[2,4]) (3,[4,1])     => ans[0,2,3]  availableTime = 6
           t=6  (1,[2,4])     => ans[0,2,3,1]  availableTime = 10

    
     */

    public int[] getOrder(int[][] tasks) {
        Task[] cpuTasks = new Task[tasks.length];

        for(int i=0; i<tasks.length; i++){
            cpuTasks[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }

        Arrays.sort(cpuTasks, (taskA, taskB)->taskA.enqueueTime-taskB.enqueueTime);

        Queue<Task> schedulingQueue = new PriorityQueue<>(
                                            (taskA, taskB)->taskA.processingTime!=taskB.processingTime
                                                                ?   taskA.processingTime-taskB.processingTime
                                                                :   taskA.index-taskB.index);

        //Will start processing at the first task with the min enqueueTime.
        int availableAt = cpuTasks[0].enqueueTime;
        int[] processingOrder = new int[tasks.length];

        int taskIndex=0;
        int processOrderIndex=0;
        while(taskIndex<cpuTasks.length || !schedulingQueue.isEmpty()){
            while(taskIndex<cpuTasks.length && cpuTasks[taskIndex].enqueueTime<=availableAt){
                schedulingQueue.add(cpuTasks[taskIndex]);
                taskIndex++;
            }

            if(!schedulingQueue.isEmpty()){
                Task currTask = schedulingQueue.poll();
                int index = currTask.index;
                int nextTaskProcessingTime = currTask.processingTime;

                availableAt += nextTaskProcessingTime;
                processingOrder[processOrderIndex++] = index;
            }
            else{
                availableAt = cpuTasks[taskIndex].enqueueTime;
            }
        }
        return processingOrder;
    }
}