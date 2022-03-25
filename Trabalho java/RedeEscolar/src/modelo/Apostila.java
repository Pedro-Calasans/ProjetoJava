package modelo;

public class Apostila extends MaterialWeb {
    private String materia;
    private int numPag;

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
       
    public Apostila(String prontuario,String nome, String autor,String materia, int numPag) {
		super(prontuario,nome, autor);
		this.materia = materia;
		this.numPag = numPag;
	}

	public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
}
