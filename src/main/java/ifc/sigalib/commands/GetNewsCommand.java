package ifc.sigalib.commands;

import ifc.sigalib.SIGALIB;

public class GetNewsCommand {
    private SIGALIB sigalib;

    public GetNewsCommand(SIGALIB sigalib) {
        this.sigalib = sigalib;
    }

    public void execute() {
        sigalib.getNewsCommand();
    }

}
