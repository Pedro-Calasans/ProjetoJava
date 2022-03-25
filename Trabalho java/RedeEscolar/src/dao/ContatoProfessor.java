package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.*;
import visao.ConexaoBD;

public class ContatoProfessor {
	
	public boolean inserirProf(Professor professor) {
		Scanner leitura = new Scanner(System.in);

		String sql = "insert into professor (nome, prontuario,  email, senha, area) values (?, ?,  ?, ?,?)";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Digite seu nome: ");
		professor.setNome(leitura.nextLine());
		System.out.println("Digite seu prontuario: ");
		professor.setProntuario(leitura.nextLine());
		System.out.println("Digite seu email: ");
		professor.setEmail(leitura.nextLine());
		System.out.println("Digite sua senha: ");
		professor.setSenha(leitura.nextLine());
		System.out.println("Digite sua area: ");
		professor.setArea(leitura.nextLine());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, professor.getNome());			
			stmt.setString(2, professor.getProntuario());	
			stmt.setString(3, professor.getEmail());	
			stmt.setString(4, professor.getSenha());
			stmt.setString(5, professor.getArea());
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
	
	public boolean alterar(Professor aluno) {
		Scanner leitura = new Scanner(System.in);
		String sql = "update aluno set nome = ?, prontuario = ?, email = ?, senha = ? where idAluno = ? "; 
		Connection conn = ConexaoBD.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getProntuario());
			stmt.setString(3, aluno.getEmail());
			stmt.setString(4, aluno.getSenha());
			stmt.setInt(5, aluno.getIdAluno());
			stmt.execute();
			stmt.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean excluir(Professor professor) {
		Scanner leitura = new Scanner(System.in);
		String sql = "delete from professor where prontuario = ?"; 
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Confirme seu Prontuario: ");
		professor.setProntuario(leitura.nextLine());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, professor.getProntuario());
			stmt.execute();
			stmt.close();
			conn.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Prontuario invalido");
			e.printStackTrace();
			return false;
		 }
	}
		
	public List<Professor> ObterTodos() {
			String sql = "select * from professor";
			Connection conn = ConexaoBD.getConnection();
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet resultado = stmt.executeQuery();
				List<Professor> professores = new ArrayList<Professor>();
				while(resultado.next()) {
					Professor professor1 = new Professor("","","","","");
					professor1.setIdAluno(resultado.getInt("idProfessor"));
					professor1.setNome(resultado.getString("nome"));
					professor1.setProntuario(resultado.getString("prontuario"));
					professor1.setEmail(resultado.getString("email"));
					professor1.setSenha(resultado.getString("senha"));
					professor1.setArea(resultado.getString("area"));
					professores.add(professor1);
					
				}
				stmt.execute();
				stmt.close();
				conn.close();
				
				return professores;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
		}
		
	public boolean achar(List<Professor> professores,String professor1) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Professor aluno : professores) {
			if(aluno.getProntuario().equals(professor1)) {
				
					a = true;
				
			}
		}
		return a;
	}
	
	public boolean acharSenha(List<Professor> professores,String senha) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Professor professor : professores) {
			if(professor.getSenha().equals(senha)) {
				
					a = true;
				
			}
		}
		return a;
	}
}
