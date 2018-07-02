package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.ILeutenantGeneral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private pr) {
        this.privates.add(pr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:");
        this.getPrivates().stream()
                .sorted((p1,p2) -> Integer.compare(p2.getId(),p1.getId()))
                .forEach(pr -> sb.append(System.lineSeparator()).append("  ").append(pr.toString()));
        return sb.toString();
    }
}
