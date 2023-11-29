package ifc.sigalib.commands;

import ifc.sigalib.SIGALIB;

public class GetFrequencyCommand {
    private SIGALIB sigalib;

    public GetFrequencyCommand(SIGALIB sigalib) {
        this.sigalib = sigalib;
    }

    public void execute() {
        sigalib.getFrequencyCommand();
    }

}