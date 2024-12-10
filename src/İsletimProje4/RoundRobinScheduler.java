package İsletimProje4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class RoundRobinScheduler implements Scheduler {
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    
    public void schedule(List<Process> processes) {
        Queue<Process> queue = new LinkedList<>(processes);
        int currentTime = 0;

        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();
            int burstTime = currentProcess.getBurstTime();

            if (burstTime > timeQuantum) {
                System.out.println(currentTime+".saniye "   + ": Process " + currentProcess.getPid() + " Çalışıyor " + timeQuantum + " ünite.");
                currentProcess.setBurstTime(burstTime - timeQuantum);
                currentTime += timeQuantum;
                queue.offer(currentProcess);
            } else {
                System.out.println(currentTime+".saniye " +  ": Process " + currentProcess.getPid() + " Çalışıyor " + burstTime + " ünite ve bitti.");
                currentTime += burstTime;
            }
        }
    }
}
