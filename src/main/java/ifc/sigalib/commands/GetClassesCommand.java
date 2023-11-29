package ifc.sigalib.commands;

import ifc.sigalib.SIGALIB;

public class GetClassesCommand implements Command {
    private SIGALIB sigalib;

    public GetClassesCommand(SIGALIB sigalib) {
        this.sigalib = sigalib;
    }

    @Override
    public void execute() {
        sigalib.getClassesCommand();
    }

}
