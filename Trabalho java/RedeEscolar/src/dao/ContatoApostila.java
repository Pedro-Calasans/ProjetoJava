package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Apostila;
import modelo.Professor;
import visao.ConexaoBD;

public class ContatoApostila {
	public boolean inserir(Apostila apostila) {
		Scanner leitura = new Scanner(System.in);
		
		String sql = "insert into apostila (prontuario,nome, materia,  autor, numPag) values (?, ?,  ?, ?,?)";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Prontuario:");
		apostila.setProntuario(leitura.nextLine());
		System.out.println("Nome da apostila:");
		apostila.setNome(leitura.nextLine());
		System.out.println("Materia:");
		apostila.setMateria(leitura.nextLine());
		System.out.println("Autor:");
		apostila.setAutor(leitura.nextLine());
		System.out.println("Numero de Paginas:");
		apostila.setNumPag(leitura.nextInt());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, apostila.getProntuario());	
			stmt.setString(2, apostila.getNome());
			stmt.setString(3, apostila.getMateria());	
			stmt.setString(4, apostila.getAutor());	
			stmt.setInt(5, apostila.getNumPag());
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
	
	public boolean excluirApostila(Apostila apostila) {
		Scanner leitura = new Scanner(System.in);
		List<Apostila> apostilas = new ArrayList<Apostila>();
		apostilas = ObterTodos();
		boolean a = false;
		String sql = "delete from apostila where nome = ?"; 
		Connection conn = ConexaoBD.getConnection();
		a = achar(apostilas);
		if (a = true) {
			System.out.println("Digite o nome da apostila que deseja excluir");
			apostila.setNome(leitura.nextLine());
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, apostila.getNome());
				stmt.execute();
				stmt.close();
				conn.close();
				System.out.println("Apostila excluida");
				return true;
				
			} catch (SQLException e) {
				System.out.println("Nome invalido");
				e.printStackTrace();
				return false;
		 }
		}
		return a;
	}
	
	public List<Apostila> ObterTodos() {
		String sql = "select * from apostila"; 
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Apostila> apostilas = new ArrayList<Apostila>();
			while(resultado.next()) {
				Apostila apostila1 = new Apostila("","","","",2);
				apostila1.setProntuario(resultado.getString("prontuario"));
				apostila1.setNome(resultado.getString("nome"));
				apostila1.setMateria(resultado.getString("materia"));
				apostila1.setAutor(resultado.getString("autor"));
				apostila1.setNumPag(resultado.getInt("numPag"));
				apostilas.add(apostila1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return apostilas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public boolean achar(List<Apostila> apostilas) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		String prontuario;
		System.out.println("Digite seu prontuario");
		prontuario = leitura.nextLine();
		for(Apostila apostila : apostilas) {
			if(apostila.getProntuario().equals(prontuario)) {
				if(a = false) {
					a = true;
				}
				System.out.println("___________Apostilas____________");
				System.out.println("Prontuario:"+apostila.getProntuario());
				System.out.println("Nome: "+apostila.getNome());
				System.out.println("Materia: "+apostila.getMateria());
				System.out.println("Autor:"+apostila.getAutor());	
				System.out.println("Numero de paginas:"+apostila.getNumPag());
				System.out.println("______________________________");
				System.out.println("");
				
			}
			if(a = false) {
				System.out.println("Não existe apostilas cadastradas nesse prontuario");
			}
		}
		return a;
	}
	
	public void verTodos() {
		for(Apostila apo : ObterTodos()) {
			System.out.println("_________Apostila_______");
			System.out.println("Nome:" +apo.getNome());
			System.out.println("Prontuario:" +apo.getProntuario());
			System.out.println("Materia:" +apo.getMateria());
			System.out.println("Autor:" +apo.getAutor());
			System.out.println("Numero de páginas:" +apo.getNumPag());
			System.out.println("________________________");
			System.out.println("");
				}
	}
}
