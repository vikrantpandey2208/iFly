package com.ifly;

public class a2_home_item_container {
    String slot, work;
    boolean current;

    public a2_home_item_container(String slot, String work, boolean current) {
        this.slot = slot;
        this.work = work;
        this.current = current;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
