package modelo;


public class Aluno {
	private Integer idAluno;
    private String nome;
    private String prontuario;
    private String email;
    private String senha;
    
    public Aluno() {
    	
    }
    public Aluno(String nome, String prontuario, String email, String senha) {
    	this.nome = nome;
        this.prontuario = prontuario;
        this.email = email;
        this.senha = senha;
    }
    
    public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int id) {
		this.idAluno = id;
	}
	
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String toString() {
    	return String.format("%d\t%s\t%s\t%s\t%s", this.idAluno, this.nome, 
    			this.prontuario, this.email, this.senha);
    }
}
