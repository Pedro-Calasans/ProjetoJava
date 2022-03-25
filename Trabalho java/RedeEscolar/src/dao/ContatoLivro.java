package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import modelo.Livro;
import visao.ConexaoBD;

public class ContatoLivro {
	public boolean inserir(Livro livro) {
		Scanner leitura = new Scanner(System.in);
		String sql = "insert into livro (nome,prontuario, autor,  editora, numPag) values (?, ?,  ?, ?,?)";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Nome do Livro:");
		livro.setNome(leitura.nextLine());
		System.out.println("Prontuario:");
		livro.setProntuario(leitura.nextLine());
		System.out.println("Autor:");
		livro.setAutor(leitura.nextLine());
		System.out.println("Editora:");
		livro.setEditora(leitura.nextLine());
		System.out.println("Numero de Paginas:");
		livro.setNumPag(leitura.nextInt());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getProntuario());	
			stmt.setString(3, livro.getAutor());	
			stmt.setString(4, livro.getEditora());	
			stmt.setInt(5, livro.getNumPag());
			System.out.println("Gravado");
			stmt.execute();
			stmt.close();
			conn.close();
			
			return true;
		} catch (SQLException e) {
			System.out.println("Parametros errados");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Livro> ObterTodos() {
		String sql = "select * from livro"; 
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Livro> livros = new ArrayList<Livro>();
			while(resultado.next()) {
				Livro livro1 = new Livro("","","","",2);	
				livro1.setNome(resultado.getString("nome"));
				livro1.setProntuario(resultado.getString("prontuario"));
				livro1.setAutor(resultado.getString("autor"));
				livro1.setEditora(resultado.getString("editora"));
				livro1.setNumPag(resultado.getInt("numPag"));
				livros.add(livro1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return livros;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public boolean achar(List<Livro> livros) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		String prontuario;
		System.out.println("Digite seu prontuario");
		prontuario = leitura.nextLine();
		for(Livro livro : livros) {
			if(livro.getProntuario().equals(prontuario)) {
				if(a = false) {
					a = true;
				}
				System.out.println("___________Livros____________");	
				System.out.println("Nome: "+livro.getNome());
				System.out.println("Prontuario:"+livro.getProntuario());
				System.out.println("Autor: "+livro.getAutor());
				System.out.println("Editora:"+livro.getEditora());	
				System.out.println("Numero de paginas:"+livro.getNumPag());
				System.out.println("______________________________");
				System.out.println("");
				
			}
			if(a = false) {
				System.out.println("Não existe livros cadastradas nesse prontuario");
			}
		}
		return a;
	}
	
	public boolean excluirLivro(Livro livro) {
		Scanner leitura = new Scanner(System.in);
		List<Livro> livros = new ArrayList<Livro>();
		livros = ObterTodos();
		boolean a = false;
		String sql = "delete from livro where nome = ?"; 
		Connection conn = ConexaoBD.getConnection();
		a = achar(livros);
		if (a = true) {
			System.out.println("Digite o nome do livro que deseja excluir");
			livro.setNome(leitura.nextLine());
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, livro.getNome());
				stmt.execute();
				stmt.close();
				conn.close();
				System.out.println("Livro excluido");
				return true;
				
			} catch (SQLException e) {
				System.out.println("Nome invalido");
				e.printStackTrace();
				return false;
		 }
		}
		return a;
	}
	
	public void verTodos() {
		for(Livro l : ObterTodos()) {
			System.out.println("________Livros_________");
			System.out.println("Nome:" +l.getNome());
			System.out.println("Prontuario:" +l.getProntuario());
			System.out.println("Autor:" +l.getAutor());
			System.out.println("Editora:" +l.getEditora());
			System.out.println("Numero de Paginas:" +l.getNumPag());
			System.out.println("_______________________");
			System.out.println("");
		}
	}
}
