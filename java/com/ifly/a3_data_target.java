package com.ifly;

public class a3_data_target {
    String targetName,expectedDate ;
    int totalWork, doneWork, dayRemaining, targetId;


    public a3_data_target(int targetId,String targetName, int totalWork, int doneWork, int dayRemaining, String expectedDate) {
        this.targetId = targetId;
        this.targetName = targetName;
        this.totalWork = totalWork;
        this.doneWork = doneWork;
        this.dayRemaining = dayRemaining;
        this.expectedDate = expectedDate;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getTotalWork() {
        return totalWork;
    }

    public void setTotalWork(int totalWork) {
        this.totalWork = totalWork;
    }

    public int getDoneWork() {
        return doneWork;
    }

    public void setDoneWork(int doneWork) {
        this.doneWork = doneWork;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public int getDayRemaining() {
        return dayRemaining;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public int getTargetId() {
        return targetId;
    }
}
