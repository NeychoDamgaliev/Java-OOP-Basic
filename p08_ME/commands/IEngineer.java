package ex05_Interfaces.p08_ME.commands;

import ex05_Interfaces.p08_ME.impl.Repair;

import java.util.Set;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public interface IEngineer {
    Set<Repair> getRepairs();
    void addRepair(Repair repair);
}
