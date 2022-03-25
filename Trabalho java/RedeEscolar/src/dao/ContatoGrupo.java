package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ContatoDisciplina;
import modelo.Disciplina;
import modelo.Grupo;

import modelo.Grupo;
import visao.ConexaoBD;

public class ContatoGrupo {
	public boolean inserir() {
		Scanner leitura = new Scanner(System.in);	
		String sql = "insert into grupo (disciplina,nomeGrupo,aluno1,aluno2,aluno3,aluno4,aluno5) values (?,?,?,?,?,?,?)";
		Connection conn = ConexaoBD.getConnection();
		String dis = "";
		String aluno = "";
		Grupo grupo = new Grupo("","","","","","","");
		int res = 0;
		ContatoAluno daoAluno = new ContatoAluno();
		ContatoDisciplina  daoDisciplina  = new ContatoDisciplina();
		boolean a = false;
		do {
			System.out.println("Disciplina:");
			dis = leitura.nextLine();
			a = daoDisciplina.acharDisciplina(daoDisciplina.ObterTodos(), dis);
		}while(a != true);
		grupo.setDisciplina(dis);
		a = false;
		System.out.println("Nome do grupo:");
		grupo.setNomeGrupo(leitura.nextLine());
		do {
			System.out.println("Aluno 1:");
			aluno = leitura.nextLine();
			a = daoAluno.acharNome(daoAluno.ObterTodos(), aluno);
		}while(a != true);
		a = false;
		grupo.setAluno1(aluno);
		do {
			System.out.println("Aluno 2:");
			aluno = leitura.nextLine();
			a = daoAluno.acharNome(daoAluno.ObterTodos(), aluno);
		}while(a != true);
		a = false;
		grupo.setAluno2(aluno);
		do {	
			System.out.println("Deseja inserir mais um aluno? 1 = S 2 = N");
			res = leitura.nextInt();
		}while(res >2 || res <1);
		if (res == 1) {
			do {
				System.out.println("Aluno 3:");
				aluno = leitura.nextLine();
				a = daoAluno.acharNome(daoAluno.ObterTodos(), aluno);
			}while(a != true);
			a = false;
			grupo.setAluno3(aluno);
			do {	
				System.out.println("Deseja inserir mais um aluno? 1 = S 2 = N");
				res = leitura.nextInt();
			}while(res >2 || res <1);
			if(res == 1) {
				do {
					System.out.println("Aluno 4:");
					aluno = leitura.nextLine();
					a = daoAluno.acharNome(daoAluno.ObterTodos(), aluno);
				}while(a != true);
				a = false;
				grupo.setAluno4(aluno);
				do {	
					System.out.println("Deseja inserir mais um aluno? 1 = S 2 = N");
					res = leitura.nextInt();
				}while(res >2 || res <1);
				if(res == 1) {
					do {
						System.out.println("Aluno 5:");
						aluno = leitura.nextLine();
						a = daoAluno.acharNome(daoAluno.ObterTodos(), aluno);
					}while(a != true);
					a = false;
					grupo.setAluno5(aluno);
				}else {
					grupo.setAluno5(null);
				}
			}else {
				grupo.setAluno4(null);
				grupo.setAluno5(null);
			}
		}else {
			grupo.setAluno3(null);
			grupo.setAluno4(null);
			grupo.setAluno5(null);
		}
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, grupo.getDisciplina());
			stmt.setString(2, grupo.getNomeGrupo());
			stmt.setString(3, grupo.getAluno1());
			stmt.setString(4, grupo.getAluno2());
			stmt.setString(5, grupo.getAluno3());
			stmt.setString(6, grupo.getAluno4());
			stmt.setString(7, grupo.getAluno5());			
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
	
	public boolean achar(List<Grupo> Grupos) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		String nome;
		System.out.println("Digite o nome do Grupo");
		nome = leitura.nextLine();
		for(Grupo grupo : Grupos) {
			if(grupo.getNomeGrupo().equals(nome)) {
				System.out.println("___________Grupos____________");
				System.out.println("Disciplina:" +grupo.getDisciplina());
				System.out.println("Nome:" +grupo.getNomeGrupo());
				System.out.println("ID:" +grupo.getIdGrupo());
				System.out.println("Aluno1: " +grupo.getAluno1());
				System.out.println("Aluno2: " +grupo.getAluno2());
				System.out.println("Aluno3: " +grupo.getAluno3());
				System.out.println("Aluno4: " +grupo.getAluno4());
				System.out.println("Aluno5: " +grupo.getAluno5());
				System.out.println("______________________________");
				System.out.println("");
				a = true;
			}
			if(a = false) {
				System.out.println("Não existe um gruopo com eses nome");
			}
		}
		return a;
	}
	
	public List<Grupo> ObterTodos() {
		String sql = "select * from grupo";
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Grupo> grupos = new ArrayList<Grupo>();
			while(resultado.next()) {
				Grupo grupo1 = new Grupo("","","","","","","");
				grupo1.setDisciplina(resultado.getString("disciplina"));
				grupo1.setNomeGrupo(resultado.getString("nomeGrupo"));		
				grupo1.setIdGrupo(resultado.getInt("idGrupo"));
				grupo1.setAluno1(resultado.getString("aluno1"));
				grupo1.setAluno1(resultado.getString("aluno2"));
				grupo1.setAluno1(resultado.getString("aluno3"));
				grupo1.setAluno1(resultado.getString("aluno4"));
				grupo1.setAluno1(resultado.getString("aluno5"));
				
				grupos.add(grupo1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return grupos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public void verTodos() {
		for(Grupo r : ObterTodos()) {
			System.out.println("____________Grupos______");
			System.out.println("Nome do Grupo:" +r.getNomeGrupo());
			System.out.println("Discipina:" +r.getDisciplina());
			System.out.println("ID:" +r.getIdGrupo());
			System.out.println("Aluno1:" +r.getAluno1());
			System.out.println("Aluno2:" +r.getAluno2());
			System.out.println("Aluno3:" +r.getAluno3());
			System.out.println("Aluno4:" +r.getAluno4());
			System.out.println("Aluno5:" +r.getAluno5());
			System.out.println("________________________");
			System.out.println("");
				}
	}
	public boolean excluirDisciplina() {
		Grupo grupo = new Grupo("","","","","","","");
		Scanner leitura = new Scanner(System.in);
		boolean a = false;
		String sql = "delete from grupo where idGrupo = ?"; 
		Connection conn = ConexaoBD.getConnection();
		List<Grupo> grupos = new ArrayList<Grupo>();
		grupos = ObterTodos();
		a = achar(grupos);
		if (a = true) {
			System.out.println("Digite o id do grupo para excluir");
			grupo.setIdGrupo(leitura.nextInt());
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, grupo.getIdGrupo());
				stmt.execute();
				stmt.close();
				conn.close();
				System.out.println("Grupo excluido");
				return true;
				
			} catch (SQLException e) {
				System.out.println("Nome invalido");
				e.printStackTrace();
				return false;
		 }
		}
		return a;
	}
	
	public List<Grupo> acharDisMaior() {
		String sql = "SELECT disciplina , COUNT(disciplina ) FROM grupo\r\n"
				+ "GROUP BY disciplina\r\n"
				+ "ORDER BY COUNT(disciplina ) DESC\r\n"
				+ "LIMIT 1;";
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Grupo> grupos = new ArrayList<Grupo>();
			while(resultado.next()) {
				Grupo grupo1 = new Grupo("","","","","","","");	
				grupo1.setDisciplina(resultado.getString("disciplina"));
				grupo1.setNomeGrupo(resultado.getString("nomeGrupo"));
				grupo1.setIdGrupo(resultado.getInt("idGrupo"));
				grupo1.setAluno1(resultado.getString("aluno1"));
				grupo1.setAluno2(resultado.getString("aluno2"));
				grupo1.setAluno3(resultado.getString("aluno3"));
				grupo1.setAluno4(resultado.getString("aluno4"));
				grupo1.setAluno5(resultado.getString("aluno5"));
				
				grupos.add(grupo1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return grupos;
		} catch (SQLException e) {
			System.out.println("Não foi possivel adicionar");
			e.printStackTrace();
			return null;
		}	
		
	}
	
	public void verDis() {
		int cont = 0;
		int index = 0;
		for(Grupo g : ObterTodos()) {
			if(index == 0) {
			System.out.println("______Disciplina com maior numero de grupos______");
			System.out.println("Disciplina:" +g.getDisciplina());		
			index = index + 1;
			}
			cont = cont +1;
				}
		System.out.println("Numero de grupos:"+cont);
		System.out.println("__________________________________________");
		System.out.println("");
		
		for(Grupo r : ObterTodos()) {
			System.out.println("______Todos os grupos dessa disciplina______");
			System.out.println("Disciplina:" +r.getDisciplina());
			System.out.println("Nome:" +r.getNomeGrupo());
			System.out.println("Aluno1:" +r.getAluno1());
			System.out.println("Aluno2:" +r.getAluno2());	
			System.out.println("Aluno3:" +r.getAluno3());
			System.out.println("Aluno2:" +r.getAluno4());
			System.out.println("Aluno5:" +r.getAluno5());
			System.out.println("ID:" +r.getIdGrupo());	
			System.out.println("__________________________________________");
			System.out.println("");
							}
	}
}
