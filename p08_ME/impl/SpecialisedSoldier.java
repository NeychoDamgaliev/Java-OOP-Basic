package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.ISpecialisedSoldier;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private String corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    public void setCorps(String corps) {
        if ("Airforces".equals(corps) || "Marines".equals(corps)) {
            this.corps = corps;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
