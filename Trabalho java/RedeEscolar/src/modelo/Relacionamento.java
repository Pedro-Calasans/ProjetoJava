package modelo;

public class Relacionamento {
    private String aluno1;
    private String aluno2;
    private int nivelRelacao;

    public Relacionamento(String aluno1, String aluno2, int nivelRelacao) {
        this.aluno1 = aluno1;
        this.aluno2 = aluno2;
        this.nivelRelacao = nivelRelacao;
    }

    public String getAluno1() {
        return aluno1;
    }

    public void setAluno1(String aluno1) {
        this.aluno1 = aluno1;
    }

    public String getAluno2() {
        return aluno2;
    }

    public void setAluno2(String aluno2) {
        this.aluno2 = aluno2;
    }

    public int getNivelRelacao() {
        return nivelRelacao;
    }

    public void setNivelRelacao(int nivelRelacao) {
        this.nivelRelacao = nivelRelacao;
    }
}

 
  

   
