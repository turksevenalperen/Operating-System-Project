package İsletimProje4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriorityScheduler implements Scheduler {

    public void schedule(List<Process> processes) {
        Collections.sort(processes, Comparator.comparingInt(Process::getPriority));
        int currentTime = 0;

        for (Process process : processes) {
            System.out.println(currentTime+".Saniye " +   ": Process " + process.getPid() + " Çalışıyor " + process.getBurstTime() + " ünite.");
            currentTime += process.getBurstTime();
            System.out.println(currentTime+".Saniye " +   ": Process " + process.getPid() + " Bitti.");
        }
    }
}
