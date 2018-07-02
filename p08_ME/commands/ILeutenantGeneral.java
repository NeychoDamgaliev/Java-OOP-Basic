package ex05_Interfaces.p08_ME.commands;

import ex05_Interfaces.p08_ME.impl.Private;

import java.util.List;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public interface ILeutenantGeneral {
    List<Private> getPrivates();
    void addPrivate(Private pr);
}
