package modelo;

public class Disciplina {
    private String disciplina;
    private String status;
    private String prontuario;
    private int id;
    
    public Disciplina(String disciplina, String status,String prontuario) {
		super();
		this.disciplina = disciplina;
		this.status = status;
		this.prontuario = prontuario;
	}

	public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

  

        
}
