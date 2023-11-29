package ifc.sigalib.commands;

import ifc.sigalib.SIGALIB;

public class GetScheduleCommand {
    private SIGALIB sigalib;

    public GetScheduleCommand(SIGALIB sigalib) {
        this.sigalib = sigalib;
    }

    public void execute() {
        sigalib.getScheduleCommand();
    }

}
