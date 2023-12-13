package ifc.sigalib;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        SIGALIB sigalib = new SIGALIB("usuario", "senha");
        // System.out.println(sigalib.get_user_info());
        // System.out.println(sigalib.get_classes());
        // System.out.println(sigalib.get_schedule());
        // System.out.println(sigalib.get_frequency());
        System.out.println(sigalib.get_grades());

    }

}