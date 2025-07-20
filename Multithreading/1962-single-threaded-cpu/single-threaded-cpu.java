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