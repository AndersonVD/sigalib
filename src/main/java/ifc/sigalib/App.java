package ifc.sigalib;

public class App {
    public static void main(String[] args) {

        SIGALIB sigalib = new SIGALIB("seuUsuario", "suaSenha");
        System.out.println(sigalib.getPage());

    }

}