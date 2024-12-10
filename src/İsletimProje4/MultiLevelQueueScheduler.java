package İsletimProje4;

import java.util.ArrayList;
import java.util.List;

public class MultiLevelQueueScheduler implements Scheduler {
    private List<Scheduler> queues;

    public MultiLevelQueueScheduler() {
        this.queues = new ArrayList<>();
    }

    public void addQueue(Scheduler scheduler) {
        this.queues.add(scheduler);
    }

 
    public void schedule(List<Process> processes) {
        List<Process> remainingProcesses = new ArrayList<>(processes);

        for (Scheduler scheduler : queues) {
            if (!remainingProcesses.isEmpty()) {
                scheduler.schedule(new ArrayList<>(remainingProcesses));
                remainingProcesses.removeIf(process -> process.getBurstTime() == 0);
            }
        }
    }
}
