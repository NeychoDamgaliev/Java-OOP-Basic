package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.ICommando;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Commando extends SpecialisedSoldier implements ICommando {
    private Set<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.missions = new HashSet<>();
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorps()).append(System.lineSeparator());
        sb.append("Missions:");
        this.getMissions().stream()
                .forEach(m->sb.append(System.lineSeparator()).append("  ").append(m.toString()));
//        if (missions.size() > 0) {
//            sb.append(System.lineSeparator());
//            for (Mission mission : missions) {
//                sb.append("  ").append(mission.toString()).append(System.lineSeparator());
//            }
//        }
        return sb.toString();
    }
}
