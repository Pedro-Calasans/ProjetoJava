package modelo;

public class Professor extends Aluno{
    private String area;
    private Integer idProfessor;
    
 

	public Professor( String nome, String prontuario,  String email, String senha,String area) {
	    super(nome, prontuario,email, senha);
        this.area = area;
	    }

	public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}
    
}
