package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.IPrivate;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Private extends Soldier implements IPrivate {
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {

        return String.format("Name: %s %s Id: %s Salary: %.2f",super.getFirstName(),super.getLastName(),super.getId(), this.salary);
    }
}
