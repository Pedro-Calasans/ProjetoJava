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

public class ContatoAluno {
	
	public boolean inserir(Aluno aluno) {
		Scanner leitura = new Scanner(System.in);

		String sql = "insert into aluno (nome, prontuario,  email, senha) values (?, ?,  ?, ?)";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Digite seu nome: ");
		aluno.setNome(leitura.nextLine());
		System.out.println("Digite seu prontuario: ");
		aluno.setProntuario(leitura.nextLine());
		System.out.println("Digite seu email: ");
		aluno.setEmail(leitura.nextLine());
		System.out.println("Digite sua senha: ");
		aluno.setSenha(leitura.nextLine());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());			
			stmt.setString(2, aluno.getProntuario());	
			stmt.setString(3, aluno.getEmail());	
			stmt.setString(4, aluno.getSenha());
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
	
	public boolean alterar(Aluno aluno) {
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
	
	public boolean excluir(Aluno aluno) {
		Scanner leitura = new Scanner(System.in);
		String sql = "delete from aluno where prontuario = ?"; 
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Confirme seu Prontuario: ");
		aluno.setProntuario(leitura.nextLine());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getProntuario());
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
		
	public List<Aluno> ObterTodos() {
			String sql = "select * from aluno"; 
			Connection conn = ConexaoBD.getConnection();
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet resultado = stmt.executeQuery();
				List<Aluno> alunos = new ArrayList<Aluno>();
				while(resultado.next()) {
					Aluno aluno = new Aluno();
					aluno.setIdAluno(resultado.getInt("idAluno"));
					aluno.setNome(resultado.getString("nome"));
					aluno.setProntuario(resultado.getString("prontuario"));
					aluno.setEmail(resultado.getString("email"));
					aluno.setSenha(resultado.getString("senha"));
					alunos.add(aluno);
					
				}
				stmt.execute();
				stmt.close();
				conn.close();
				
				return alunos;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
		}
		
	public Aluno obterPorId(Integer idAluno) {
			String sql = "select * from aluno where idAluno = ?"; 
			Connection conn = ConexaoBD.getConnection();
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, idAluno); 
				ResultSet resultado = stmt.executeQuery();
					if(resultado.next()) {
						Aluno aluno = new Aluno();
						aluno.setIdAluno(resultado.getInt("idAluno"));
						aluno.setNome(resultado.getString("nome"));
						aluno.setProntuario(resultado.getString("prontuario"));
						
						aluno.setEmail(resultado.getString("email"));
						aluno.setSenha(resultado.getString("senha"));
						stmt.close();
						conn.close();
						return aluno;
						
					} else {
						return null;
					}	
			} catch (SQLException e) {
					e.printStackTrace();
					return null;
			}	
		}

	public boolean acharNome(List<Aluno> alunos,String aluno1) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Aluno aluno : alunos) {
			if(aluno.getNome().equals(aluno1)) {
				
					a = true;
				
			}
		}
		return a;
	}
	
	public boolean acharProntuario(List<Aluno> alunos,String aluno1) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Aluno aluno : alunos) {
			if(aluno.getProntuario().equals(aluno1)) {
				
					a = true;
				
			}
		}
		return a;
	}
	public boolean acharSenha(List<Aluno> alunos,String senha) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Aluno aluno : alunos) {
			if(aluno.getSenha().equals(senha)) {
				
					a = true;
				
			}
		}
		return a;
	}
}

	
	

