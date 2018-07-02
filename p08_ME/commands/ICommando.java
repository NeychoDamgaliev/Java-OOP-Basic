package ex05_Interfaces.p08_ME.commands;

import ex05_Interfaces.p08_ME.impl.Mission;

import java.util.Set;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public interface ICommando {
    Set<Mission> getMissions();
    void addMission(Mission mission);
}
