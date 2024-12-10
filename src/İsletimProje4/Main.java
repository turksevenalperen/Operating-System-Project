package İsletimProje4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 10, 1, 0));
        processes.add(new Process(2, 5, 3, 2));
        processes.add(new Process(3, 8, 2, 4));

        System.out.println("Round Robin Scheduling:");
        Scheduler roundRobin = new RoundRobinScheduler(4);
        roundRobin.schedule(processes);

       
        processes.clear();
        processes.add(new Process(1, 10, 1, 0));
        processes.add(new Process(2, 5, 3, 2));
        processes.add(new Process(3, 8, 2, 4));

        System.out.println("\nPriority Scheduling:");
        Scheduler priorityScheduler = new PriorityScheduler();
        priorityScheduler.schedule(processes);

       
        processes.clear();
        processes.add(new Process(1, 10, 1, 0));
        processes.add(new Process(2, 5, 3, 2));
        processes.add(new Process(3, 8, 2, 4));

        System.out.println("\nMulti-Level Queue Scheduling:");
        MultiLevelQueueScheduler multiLevelScheduler = new MultiLevelQueueScheduler();
        multiLevelScheduler.addQueue(new RoundRobinScheduler(4));
        multiLevelScheduler.addQueue(new PriorityScheduler());
        multiLevelScheduler.schedule(processes);
    }
}
