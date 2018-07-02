package ex05_Interfaces.p08_ME.impl;

import ex05_Interfaces.p08_ME.commands.IMission;

/**
 * Created by Neycho Damgaliev on 7/1/2018.
 */
public class Mission implements IMission {

    private String codeName;
    private String state;

    public Mission(String codeName,String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {
        if(!"inProgress".equals(state) && !"Finished".equals(state)) {
            throw new IllegalArgumentException();
        }

        this.state =state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.codeName,this.state);
    }
}
