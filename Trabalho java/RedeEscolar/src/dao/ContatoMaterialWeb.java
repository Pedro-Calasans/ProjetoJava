package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.MaterialWeb;
import visao.ConexaoBD;

public class ContatoMaterialWeb {
	public boolean inserir() {
		MaterialWeb material = new MaterialWeb("","","");
		Scanner leitura = new Scanner(System.in);
		String sql = "insert into materialWeb (nome,prontuario, autor) values (?, ?, ?)";
		Connection conn = ConexaoBD.getConnection();
		System.out.println("Nome do material:");
		material.setNome(leitura.nextLine());
		System.out.println("Prontuario:");
		material.setProntuario(leitura.nextLine());
		System.out.println("Autor:");
		material.setAutor(leitura.nextLine());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, material.getNome());
			stmt.setString(2, material.getProntuario());	
			stmt.setString(3, material.getAutor());	;
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
	
	public List<MaterialWeb> ObterTodos() {
		String sql = "select * from materialWeb"; 
		Connection conn = ConexaoBD.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			List<MaterialWeb> materiais = new ArrayList<MaterialWeb>();
			while(resultado.next()) {
				MaterialWeb material1 = new MaterialWeb("","","");	
				material1.setNome(resultado.getString("nome"));
				material1.setProntuario(resultado.getString("prontuario"));
				material1.setAutor(resultado.getString("autor"));
				materiais.add(material1);
			}
			stmt.execute();
			stmt.close();
			conn.close();
			
			return materiais;
		} catch (SQLException e) {
			System.out.println("Não foi possivel adicionar");
			e.printStackTrace();
			return null;
		}	
	}
	
	public boolean achar(List<MaterialWeb> materiais) {
		boolean a = false;
		Scanner leitura = new Scanner(System.in);
		String prontuario;
		System.out.println("Digite seu prontuario");
		prontuario = leitura.nextLine();
		for(MaterialWeb material : materiais) {
			if(material.getProntuario().equals(prontuario)) {
				if(a = false) {
					a = true;
				}
				System.out.println("__________MaterialWeb_________");	
				System.out.println("Nome: "+material.getNome());
				System.out.println("Prontuario:"+material.getProntuario());
				System.out.println("Autor: "+material.getAutor());
				System.out.println("______________________________");
				System.out.println("");
				
			}
			if(a = false) {
				System.out.println("Não existe livros cadastradas nesse prontuario");
			}
		}
		return a;
	}
	
	public boolean excluirMaterial(MaterialWeb material) {
		Scanner leitura = new Scanner(System.in);
		List<MaterialWeb> materiais = new ArrayList<MaterialWeb>();
		materiais = ObterTodos();
		boolean a = false;
		String sql = "delete from materialWeb where nome = ?"; 
		Connection conn = ConexaoBD.getConnection();
		a = achar(materiais);
		if (a = true) {
			System.out.println("Digite o nome do material que deseja excluir");
			material.setNome(leitura.nextLine());
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, material.getNome());
				stmt.execute();
				stmt.close();
				conn.close();
				System.out.println("Material excluido");
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
		for(MaterialWeb mat : ObterTodos()) {
			System.out.println("_______MaterialWeb______");
			System.out.println("Nome:" +mat.getNome());
			System.out.println("Prontuario:" +mat.getProntuario());
			System.out.println("Autor:" +mat.getAutor());			
			System.out.println("________________________");
			System.out.println("");
				}
		
	}
}
