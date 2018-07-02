package ex05_Interfaces.p08_ME.commands;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public interface IMission {
    String getCodeName();
    String getState();
    void completeMission();
}
