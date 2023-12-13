package ifc.sigalib.models;

public class Aluno {
    private String nome;
    private int matricula;
    private String curso;
    private String nivel;
    private String status;
    private String email;
    private String entrada;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", matricula='" + getMatricula() + "'" +
                ", curso='" + getCurso() + "'" +
                ", nivel='" + getNivel() + "'" +
                ", status='" + getStatus() + "'" +
                ", email='" + getEmail() + "'" +
                ", entrada='" + getEntrada() + "'" +
                "}";
    }

}
