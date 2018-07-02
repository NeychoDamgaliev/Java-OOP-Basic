package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.ISpy;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Spy extends Soldier implements ISpy {

    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    private void setCodeNumber(String codeNumber) {

        this.codeNumber=codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s\n" +
                "Code Number: %s",super.getFirstName(),super.getLastName(),super.getId(),this.getCodeNumber());
    }
}
