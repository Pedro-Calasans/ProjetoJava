
package modelo;

public class Grupo {
    private String disciplina;
    private String nomeGrupo;
    private String Aluno1;
    private String Aluno2;
    private String Aluno3;
    private String aluno4;
    private String aluno5;
    private int idGrupo;

    public Grupo(String disciplina, String nomeGrupo, String Aluno1, String Aluno2, String Aluno3, String aluno4, String aluno5) {
        this.disciplina = disciplina;
        this.nomeGrupo = nomeGrupo;
        this.Aluno1 = Aluno1;
        this.Aluno2 = Aluno2;
        this.Aluno3 = Aluno3;
        this.aluno4 = aluno4;
        this.aluno5 = aluno5;
    }
    
    public String getAluno1() {
        return Aluno1;
    }

    public void setAluno1(String Aluno1) {
        this.Aluno1 = Aluno1;
    }

    public String getAluno2() {
        return Aluno2;
    }

    public void setAluno2(String Aluno2) {
        this.Aluno2 = Aluno2;
    }

    public String getAluno3() {
        return Aluno3;
    }

    public void setAluno3(String Aluno3) {
        this.Aluno3 = Aluno3;
    }

    public String getAluno4() {
        return aluno4;
    }

    public void setAluno4(String aluno4) {
        this.aluno4 = aluno4;
    }

    public String getAluno5() {
        return aluno5;
    }

    public void setAluno5(String aluno5) {
        this.aluno5 = aluno5;
    }
   
    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

  
    
}
