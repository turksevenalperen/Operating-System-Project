package İsletimProje4;

class Process {
    private int pid; // Process ID
    private int burstTime; // CPU Burst Time
    private int priority; // Priority of the process
    private int arrivalTime; // Arrival time of the process
    
    public Process(int pid, int burstTime, int priority, int arrivalTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    // Getter and Setter methods

    public int getPid() {
        return pid;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Process [pid=" + pid + ", burstTime=" + burstTime + ", priority=" + priority + ", arrivalTime=" + arrivalTime + "]";
    }
}
