package modelo;

public class Livro extends MaterialWeb {
    private int numPag;
    private String editora;
  

    public Livro(String prontuario, String nome, String autor,String editora, int numPag) {
		super(prontuario, nome, autor);
		this.editora = editora;
		this.numPag = numPag;
		// TODO Auto-generated constructor stub
	}

	public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

   

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
}
