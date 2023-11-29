package ifc.sigalib.commands;

import ifc.sigalib.SIGALIB;

public class GetUserInfoCommand {
    private SIGALIB sigalib;

    public GetUserInfoCommand(SIGALIB sigalib) {
        this.sigalib = sigalib;
    }

    public void execute() {
        sigalib.getUserInfoCommand();
    }

}
