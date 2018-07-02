package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.IRepairs;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Repair implements IRepairs {

    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.setPartName(partName);
        this.setHoursWorked(hoursWorked);
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",this.partName,this.hoursWorked);
    }
}
