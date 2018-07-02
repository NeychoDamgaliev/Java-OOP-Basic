package ex05_Interfaces.p08_ME;

import ex05_Interfaces.p08_ME.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        Map<Integer, Private> privates = new LinkedHashMap<>();
        while (!"End".equals(line = reader.readLine())) {

            String[] tokens = line.split("\\s+");

            String soldierType = tokens[0];
            switch (soldierType) {
                case "Private":
                    Private curPrivate = createPrivate(tokens);
                    privates.putIfAbsent(curPrivate.getId(), curPrivate);
                    System.out.println(curPrivate);
                    break;
                case "LeutenantGeneral":
                    LeutenantGeneral lg = createLeutenantGeneral(tokens, privates);
                    System.out.println(lg.toString());
                    break;
                case "Engineer":
                    try {
                        Engineer engineer = createEngineer(tokens);
                        System.out.println(engineer.toString());
                    } catch (IllegalArgumentException iae) {

                    }
                    break;
                case "Commando":
                    Commando commando = createCommando(tokens);
                    if (commando != null) {
                        System.out.println(commando.toString());
                    }
                    break;
                case "Spy":
                    Spy spy = createSpy(tokens);
                    System.out.println(spy.toString());
                    break;
            }
        }
    }

    private static Spy createSpy(String[] tokens) {
        int id =  Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        String codeNumber = tokens[4];
        return new Spy(id, firstName, lastName, codeNumber);
    }

    private static Commando createCommando(String[] tokens) {
        int id =  Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Commando commando = new Commando(id, firstName, lastName, salary);
        try {
            commando.setCorps(tokens[5]);
        } catch (IllegalArgumentException iae) {
            return null;
        }
        if (tokens.length > 5) {
            for (int i = 6; i < tokens.length; i += 2) {
                String missinonCodeName = tokens[i];
                String missinonState = tokens[i + 1];
                try {
                    Mission mission = new Mission(missinonCodeName, missinonState);
                    commando.addMission(mission);
                } catch (IllegalArgumentException iae) {
                    // log here
                }
            }
        }
        return commando;
    }

    private static Engineer createEngineer(String[] tokens) {
        int id =  Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Engineer engineer = new Engineer(id, firstName, lastName, salary);
        engineer.setCorps(tokens[5]);

        if (tokens.length > 5) {
            for (int i = 6; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int hoursWorked = Integer.parseInt(tokens[i + 1]);
                Repair repair = new Repair(partName, hoursWorked);
                engineer.addRepair(repair);
            }
        }
        return engineer;
    }

    private static LeutenantGeneral createLeutenantGeneral(String[] tokens, Map<Integer, Private> privates) {
        int id =  Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        LeutenantGeneral lg = new LeutenantGeneral(id, firstName, lastName, salary);
        if (tokens.length > 5) {
            for (int i = 5; i < tokens.length; i++) {
                int privateId = Integer.parseInt(tokens[i]);
                if (privates.containsKey(privateId)) {
                    lg.addPrivate(privates.get(privateId));
                }
            }
        }
        return lg;
    }

    private static Private createPrivate(String[] tokens) {
        int id =  Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        return new Private(id, firstName, lastName, salary);
    }
}
