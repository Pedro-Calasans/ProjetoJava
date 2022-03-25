package modelo;

public class MaterialWeb {
    private String nome;
    private String autor;
    private String prontuario;	
 
    
    public MaterialWeb(String prontuario,String nome, String autor) {
    	this.prontuario = prontuario;
    	this.nome = nome;
    	this.autor = autor;// TODO Auto-generated constructor stub
	}

	

    
    
    
    public String getProntuario() {
		return prontuario;
	}






	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}






	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
