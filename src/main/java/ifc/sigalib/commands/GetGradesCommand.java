package ifc.sigalib.commands;

import ifc.sigalib.SIGALIB;

public class GetGradesCommand {
    private SIGALIB sigalib;

    public GetGradesCommand(SIGALIB sigalib) {
        this.sigalib = sigalib;
    }

    public void execute() {
        sigalib.getGradesCommand();
    }

}
