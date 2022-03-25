package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Aluno;
import modelo.Disciplina;
import visao.ConexaoBD;

public class ContatoDisciplina {
	public boolean inserir(Disciplina disciplina) {
		Scanner leitura = new Scanner(System.in);
		
		String sql = "insert into disciplina (disciplina,prontuario,status) values (?, ?,?)";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Disciplina:");
		disciplina.setDisciplina(leitura.nextLine());
		System.out.println("Prontuario:");
		disciplina.setProntuario(leitura.nextLine());
		System.out.println("Status:");
		disciplina.setStatus(leitura.nextLine());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, disciplina.getDisciplina());
			stmt.setString(2, disciplina.getProntuario());
			stmt.setString(3, disciplina.getStatus());
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
	
	public boolean excluirDisciplina(Disciplina disciplina) {
		Scanner leitura = new Scanner(System.in);
		boolean a = false;
		String sql = "delete from disciplina where prontuario = ?"; 
		Connection conn = ConexaoBD.getConnection();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas = ObterTodos();
		a = achar(disciplinas);
		if (a = true) {
			System.out.println("Digite o nome da disciplina que deseja excluir");
			disciplina.setDisciplina(leitura.nextLine());
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, disciplina.getDisciplina());
				stmt.execute();
				stmt.close();
				conn.close();
				System.out.println("disciplina excluida");
				return true;
				
			} catch (SQLException e) {
				System.out.println("Nome invalido");
				e.printStackTrace();
				return false;
		 }
		}
		return a;
	}
	
	public List<Disciplina> ObterTodos() {
		String sql = "select * from disciplina";
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			while(resultado.next()) {
				Disciplina disciplina1 = new Disciplina("","","");
				disciplina1.setId(resultado.getInt("idDisciplina"));
				disciplina1.setDisciplina(resultado.getString("disciplina"));			
				disciplina1.setStatus(resultado.getString("status"));
				disciplina1.setProntuario(resultado.getString("prontuario"));
				
				
				disciplinas.add(disciplina1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return disciplinas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public boolean achar(List<Disciplina> disciplinas) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		String prontuario;
		System.out.println("Digite seu prontuario");
		prontuario = leitura.nextLine();
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getProntuario().equals(prontuario)) {
				System.out.println("___________Disciplina____________");
				System.out.println("Disciplina:" +disciplina.getDisciplina());
				System.out.println("Prontuario:" +disciplina.getProntuario());
				System.out.println("Status: " +disciplina.getStatus());
				System.out.println("Id: " +disciplina.getId());
				System.out.println("______________________________");
				System.out.println("");
				a = true;
			}
			if(a = false) {
				System.out.println("Não existe disciplina cadastrada nesse prontuario");
			}
		}
		return a;
	}
	public boolean acharDisciplina(List<Disciplina> disciplinas,String dis) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Disciplina disciplina : disciplinas) {
			if(disciplina.getDisciplina().equals(dis)) {
				
					a = true;
				
			}
		}
		return a;
	}

	public void verTodos() {
		for(Disciplina d : ObterTodos()) {
		System.out.println("_______Disciplinas__________");
		System.out.println("Disciplina:" +d.getDisciplina());
		System.out.println("Prontuario:" +d.getProntuario());
		System.out.println("Status:" +d.getStatus());
		System.out.println("Id:" +d.getId());
		System.out.println("__________________________");
		System.out.println("");
	}
	}
}
