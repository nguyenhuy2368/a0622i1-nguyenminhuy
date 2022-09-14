package ss4.stop_watch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime, endTime;

    public StopWatch() {
    }

    public StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public void start(){
        this.startTime = LocalTime.now();
    }
    public void stop(){
        this.endTime = LocalTime.now();
    }
    public int getElapsedTime(){
       return  ((this.endTime.getHour() - this.startTime.getHour()) * 3600 + (this.endTime.getMinute() - this.startTime.getMinute()) * 60 + (this.endTime.getSecond() - this.startTime.getSecond()) * 1000);
    }
}
