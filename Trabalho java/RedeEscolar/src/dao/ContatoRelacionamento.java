package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import modelo.Aluno;
import modelo.Relacionamento;
import modelo.Relacionamento;
import modelo.Relacionamento;
import visao.ConexaoBD;
import dao.ContatoAluno;

public class ContatoRelacionamento {
	public boolean inserir() {
		Relacionamento relacionamento = new Relacionamento("","",5);
		Scanner leitura = new Scanner(System.in);
		ContatoAluno dao = new ContatoAluno();
		boolean a = false;
		String aluno1 = "";
		String aluno2 = "";
		int nivel = 0;
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = dao.ObterTodos();
		String sql = "insert into relacionamento (aluno1,aluno2,nivel) values (?, ?, ?)";
		Connection conn = ConexaoBD.getConnection();
		do {	
			System.out.println("Aluno 1:");
			aluno1 = leitura.nextLine();
			a = dao.acharNome(alunos, aluno1);
			System.out.println(a);
		}while( a != true);
		relacionamento.setAluno1(aluno1);
		do {	
			System.out.println("Aluno 2:");
			aluno2 = leitura.nextLine();
			a = dao.acharNome(alunos, aluno2);
			System.out.println(a);
		}while( a != true);
		relacionamento.setAluno2(aluno2);
		do {
			System.out.println("Nivel do relacionamento (1 até 5):");
			nivel = leitura.nextInt();
		}while(nivel <=0 || nivel>5);
		relacionamento.setNivelRelacao(nivel);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, relacionamento.getAluno1());
			stmt.setString(2, relacionamento.getAluno2());	
			stmt.setInt(3, relacionamento.getNivelRelacao());	;
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

	public boolean achar(List<Relacionamento> relacionamentos,String nome) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		for(Relacionamento relacionamento : relacionamentos) {
			if(relacionamento.getAluno1().equals(nome)) {
				if(a = false) {
					a = true;
				}
				System.out.println("________Relacionamento_________");	
				System.out.println("Aluno1: "+relacionamento.getAluno1());
				System.out.println("Aluno2:"+relacionamento.getAluno2());
				System.out.println("Nivel da relação: "+relacionamento.getNivelRelacao());
				System.out.println("______________________________");
				System.out.println("");
				
			}
			if(relacionamento.getAluno2().equals(nome)) {
				if(a = false) {
					a = true;
				}
				System.out.println("________Relacionamento_________");	
				System.out.println("Aluno1: "+relacionamento.getAluno1());
				System.out.println("Aluno2:"+relacionamento.getAluno2());
				System.out.println("Nivel da relação: "+relacionamento.getNivelRelacao());
				System.out.println("______________________________");
				System.out.println("");
				
			}
			if(a = false) {
				System.out.println("Não existe relacionamentos cadastrados no seu nome");
			}
		}
		return a;
	}
	
	public List<Relacionamento> ObterTodos() {
		String sql = "select * from relacionamento"; 
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Relacionamento> relacionamentos = new ArrayList<Relacionamento>();
			while(resultado.next()) {
				Relacionamento relacionamento1 = new Relacionamento("","",5);	
				relacionamento1.setAluno1(resultado.getString("aluno1"));
				relacionamento1.setAluno2(resultado.getString("aluno2"));
				relacionamento1.setNivelRelacao(resultado.getInt("nivel"));
				relacionamentos.add(relacionamento1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return relacionamentos;
		} catch (SQLException e) {
			System.out.println("Não foi possivel adicionar");
			e.printStackTrace();
			return null;
		}	
	}
	
	public boolean excluirRelacionamento() {
		Scanner leitura = new Scanner(System.in);
		Relacionamento relacionamento = new Relacionamento("","",4);
		List<Relacionamento> relacionamentos = new ArrayList<Relacionamento>();
		relacionamentos = ObterTodos();
		boolean a = false;
		String sql = "delete from relacionamento where aluno1 like ? and aluno2 like ?"; 
		String aluno1 = "";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Digite o seu nome");
		aluno1 = leitura.nextLine();
		relacionamento.setAluno1(aluno1);
		a = achar(relacionamentos,aluno1);
		if (a = true) {
			System.out.println("Digite o nome do aluno2 do relacionamento que deseja excluir");
			relacionamento.setAluno2(leitura.nextLine());
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, relacionamento.getAluno1());
				stmt.setString(2, relacionamento.getAluno2());
				stmt.execute();
				stmt.close();
				conn.close();
				System.out.println("Relacionamento excluido");
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
		for(Relacionamento r : ObterTodos()) {
			System.out.println("______Relacionamento______");
			System.out.println("Aluno1:" +r.getAluno1());
			System.out.println("Aluno2:" +r.getAluno2());
			System.out.println("Nivell:" +r.getNivelRelacao());			
			System.out.println("________________________");
			System.out.println("");
				}
		
	}
	
	public List<Relacionamento> acharMaior() {
		String sql = "FROM\r\n"
				+ "    (SELECT LOWER(aluno1) AS maior FROM relacionamento   \r\n"
				+ "     UNION ALL\r\n"
				+ "     SELECT LOWER(aluno2) AS maior FROM relacionamento\r\n"
				+ "    ) maioraluno # #3necessário nomear o union para funcinonar\r\n"
				+ "GROUP BY\r\n"
				+ "    maior\r\n"
				+ "order by MAX(maior) \r\n"
				+ "limit 3;"; 
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<Relacionamento> relacionamentos = new ArrayList<Relacionamento>();
			while(resultado.next()) {
				Relacionamento relacionamento1 = new Relacionamento("","",5);	
				relacionamento1.setAluno1(resultado.getString("aluno1"));
				relacionamento1.setAluno2(resultado.getString("aluno2"));
				relacionamento1.setNivelRelacao(resultado.getInt("nivel"));
				relacionamentos.add(relacionamento1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return relacionamentos;
		} catch (SQLException e) {
			System.out.println("Não foi possivel adicionar");
			e.printStackTrace();
			return null;
		}	
		
	}
	
	public void verMaiores() {
		int cont = 0;
		int index = 0;
		for(Relacionamento r : ObterTodos()) {
			if(index == 0) {
			System.out.println("______Aluno com mais relacionamentos______");
			System.out.println("Aluno:" +r.getAluno2());		
			index = index + 1;
			}
			cont = cont +1;
				}
		System.out.println("Numero de relacionamentos:"+cont);
		System.out.println("__________________________________________");
		System.out.println("");
		
		for(Relacionamento r : ObterTodos()) {
			System.out.println("______Todos os relacionamentos______");
			System.out.println("Aluno1:" +r.getAluno1());
			System.out.println("Aluno2:" +r.getAluno2());	
			System.out.println("Nivel:" +r.getNivelRelacao());	
			System.out.println("__________________________________________");
			System.out.println("");
							}
	}
}
