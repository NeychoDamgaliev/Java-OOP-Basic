package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.IEngineer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Engineer extends SpecialisedSoldier implements IEngineer {
    private Set<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.repairs = new HashSet<>();
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:");
        this.getRepairs().stream()
                .forEach(rep ->sb.append(System.lineSeparator()).append("  ").append(rep.toString()));
        //        if (this.repairs.size() > 0) {
// //           sb.append(System.lineSeparator());
//            for (Repair repair : repairs) {
//                sb.append(System.lineSeparator()).append("  ").append(repair.toString());
//            }
//        }
        return sb.toString();
    }
}
