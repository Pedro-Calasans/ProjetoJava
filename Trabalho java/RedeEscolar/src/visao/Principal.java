package visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ContatoAluno;
import dao.ContatoApostila;
import dao.ContatoDisciplina;
import dao.ContatoGrupo;
import dao.ContatoLivro;
import dao.ContatoMaterialWeb;
import modelo.Aluno;
import modelo.Apostila;
import modelo.Disciplina;
import modelo.Livro;
import modelo.MaterialWeb;
import modelo.Professor;
import dao.ContatoProfessor;
import dao.ContatoRelacionamento;
public class Principal {
		
	
	
	public static void main(String[] args) {
		ContatoAluno daoAluno = new ContatoAluno();
		ContatoProfessor daoProfessor = new ContatoProfessor();
		ContatoApostila daoApostila = new ContatoApostila();
		ContatoDisciplina daoDisciplina = new ContatoDisciplina();
		ContatoLivro  daoLivro = new ContatoLivro();
		ContatoMaterialWeb daoMaterialWeb = new ContatoMaterialWeb();
		ContatoRelacionamento daoRelacionamento = new ContatoRelacionamento();
		ContatoGrupo daoGrupo = new ContatoGrupo();
	
		String login = "";
    	String senha = "";
		Aluno aluno = new Aluno ( "Bruna",  "6666", "@gmail", "66" );
		Apostila apostila = new Apostila("a","a","a","a",5);
		Professor professor = new Professor("","","","","");
		Disciplina disciplina = new Disciplina("","","");
		Livro livro = new Livro("","","","",5);
		List<Apostila> apostilas = new ArrayList<Apostila>();	
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		List<Livro> livros = new ArrayList<Livro>();
		Scanner leitura = new Scanner(System.in);
		int res = 0;
		boolean a = false;
		boolean b = false;
		do{
            System.out.println("_________INFP_________");
            System.out.println("______________________");
            System.out.println("|  1 -    Login      |");
            System.out.println("|  2 -   Registrar   |");
            System.out.println("|  3 -    Sair       |");
            System.out.println("----------------------");
            res = leitura.nextInt();
            if (res == 1){
                do{
                    System.out.println(" - 1 Acessar como professor");
                    System.out.println(" - 2 Acessar como aluno");
                    System.out.println(" - 0 Voltar");
                    res = leitura.nextInt();

                    if (res == 1){
                    	System.out.println("Login");
                    	leitura = new Scanner(System.in);
                    	login = leitura.nextLine();
                    	a = daoProfessor.achar(daoProfessor.ObterTodos(), login);		
                		System.out.println("Senha");
                		senha = leitura.nextLine();
                		b = daoProfessor.acharSenha(daoProfessor.ObterTodos(), senha);
                    	
                        if (a == true && b == true){
                        	 System.out.println("Logado");
                        	 int menuProf = 0;
                        	 do{
                                 System.out.println("____________INFP_____________");
                                 System.out.println("_______Menu Professor________");
                                 System.out.println("|  1 - Inserir conteudo     |");
                                 System.out.println("|  2 - Meus conteudos       |");
                                 System.out.println("|  3 - Excluir conteudos    |");
                                 System.out.println("|  4 - Grupos               |");
                                 System.out.println("|  5-     Sair             |");
                                 System.out.println("|  6 - Excluir conta        |");
                                 System.out.println("-----------------------------");    
                                 menuProf = leitura.nextInt();
                                 switch(menuProf){
                                     case 1:
                                    	leitura = new Scanner(System.in);
                                     	System.out.println("1- Disciplinas");
                                        System.out.println("2- Livros");
                                        System.out.println("3- Apostila");
                                        System.out.println("4- Material Web");
                                        System.out.println("0- Sair");
                                        leitura = new Scanner(System.in);
                                        menuProf = leitura.nextInt();
                                             do{
                                                 if(menuProf == 1){
                                                 	leitura = new Scanner(System.in);
                                                     daoDisciplina.inserir(disciplina);
                                                     break;
                                                                   }
                                                 if(menuProf == 2){    
                                                 	leitura = new Scanner(System.in);
                                                     daoLivro.inserir(livro);
                                                     break;
                                                                   }
                                                 if(menuProf == 3){
                                                 	leitura = new Scanner(System.in);
                                                     daoApostila.inserir(apostila);
                                                     break;
                                                                   }
                                                 if(menuProf == 4){
                                                 	leitura = new Scanner(System.in);
                                                     daoMaterialWeb.inserir();
                                                     break;
                                                                    }   
                                                 }while(menuProf !=0);
                                         
                                                 
                                       
                                     break;
                                     case 2:
                                    	 leitura = new Scanner(System.in);
                                     	System.out.println("1- Disciplinas");
                                         System.out.println("2- Livros");
                                         System.out.println("3- Apostila");
                                         System.out.println("4- Material Web");
                                         System.out.println("0- Sair");
                                         menuProf = leitura.nextInt();
                                         switch(menuProf){
                                             case 1:
                                             	leitura = new Scanner(System.in);
                                                 daoDisciplina.achar(daoDisciplina.ObterTodos());
                                             	break;
                                             case 2:
                                             	leitura = new Scanner(System.in);
                                                 daoLivro.achar(daoLivro.ObterTodos());
                                              
                                                 break;
                                             case 3:
                                             	leitura = new Scanner(System.in);
                                                 daoApostila.achar(daoApostila.ObterTodos());
                                                 break;
                                             case 4:   
                                             	leitura = new Scanner(System.in);
                                                 daoMaterialWeb.achar(daoMaterialWeb.ObterTodos());
                                                 break;
                                         }
                                         menuProf = 8;
                                         break;
                                     case 3:
                                    	 leitura = new Scanner(System.in);
                                     	System.out.println("1- Disciplinas");
                                         System.out.println("2- Livros");
                                         System.out.println("3- Apostila");
                                         System.out.println("4- Material Web");
                                         System.out.println("0- Sair");
                                         menuProf = leitura.nextInt();
                                         switch(menuProf){
                                             case 1:
                                             	leitura = new Scanner(System.in);
                                                 daoDisciplina.excluirDisciplina(disciplina);
                                             	break;
                                             case 2:
                                             	leitura = new Scanner(System.in);
                                                 daoLivro.excluirLivro(livro);
                                                 break;
                                             case 3:
                                             	leitura = new Scanner(System.in);
                                                 daoApostila.excluirApostila(apostila);
                                                 break;
                                             case 4:   
                                             	leitura = new Scanner(System.in);
                                                 daoMaterialWeb.excluirMaterial(livro);
                                                 break;
                                         }
                                         break;
                                     case 4:
                                	    do {
                                	    	leitura = new Scanner(System.in);
		                                	System.out.println("_______________INFP__________________");
		                            	    System.out.println("_______________Grupos________________");
		                            	    System.out.println("|  1 - Criar grupos                   |");
		                            	    System.out.println("|  2 - Ver grupos                     |");
		                            	    System.out.println("|  3 - Disciplina com mais grupos     |");
		                            	    System.out.println("|  4 - Excluir grupos                 |");
		                            	    System.out.println("|  5 - Voltar                         |");
		                            	    System.out.println("______________________________________");
		                            	    menuProf = leitura.nextInt();
		                            	    switch(menuProf){
		                            	        case 1:
		                            	        	leitura = new Scanner(System.in);
		                            	            daoGrupo.inserir();
		                            	            break;
		                            	        case 2:
		                            	        	leitura = new Scanner(System.in);
		                            	            daoGrupo.verTodos();
		                            	            break;
		                            	        case 3:
		                            	        	leitura = new Scanner(System.in);
		                            	            daoGrupo.verDis();
		                            	            break;
		                            	        case 4:
		                            	        	leitura = new Scanner(System.in);
		                            	        	daoGrupo.excluirDisciplina();
		                            	        	break;
		                            	        default:
		                            	            System.out.println("Opção invalida");
		                            	            break;
		                            	    }
                                	    }while(menuProf != 5);  
                                	    menuProf = 0;
                                     case 5:
                                         
                                         break;
                                     case 6:
                                         daoProfessor.excluir(professor);
                                     default:
                                    	 System.out.println("Opção invalida");
                                    	 break;
                                 }

                             }while(menuProf !=5 && menuProf!=6);
                            }else {
                            	System.out.println("Login ou senha errados");
                            }
                            }  
                     if (res == 2){
                    	System.out.println("Login");
                    	leitura = new Scanner(System.in);
                    	login = leitura.nextLine();
                    	a = daoAluno.acharProntuario(daoAluno.ObterTodos(), login);                	  	
                 		System.out.println("Senha");
                 		senha = leitura.nextLine();
                 		b = daoAluno.acharSenha(daoAluno.ObterTodos(), senha);
                     	
                        if (a == true && b == true){
                        	int menuAluno = 0;
                        	leitura = new Scanner(System.in);
                        	do{   
                                System.out.println("____________INFP_____________");
                                System.out.println("___________Menu Aluno________");
                                System.out.println("|  1 - Inserir conteudo     |");
                                System.out.println("|  2 - Meus conteudos       |");
                                System.out.println("|  3 - Excluir conteudos    |");
                                System.out.println("|  4 - Relacionamento       |");
                                System.out.println("|  5 - Meus Relacionamentos |");
                                System.out.println("|  6 -     Sair             |");
                                System.out.println("|  7 - Excluir conta        |");
                                System.out.println("-----------------------------");
                                menuAluno = leitura.nextInt();
                                if(menuAluno == 1){
                                	leitura = new Scanner(System.in);
                                	System.out.println("1- Disciplinas");
                                    System.out.println("2- Livros");
                                    System.out.println("3- Apostila");
                                    System.out.println("4- Material Web");
                                    System.out.println("0- Sair");
                                    leitura = new Scanner(System.in);
                                    menuAluno = leitura.nextInt();
                                        do{
                                            if(menuAluno == 1){
                                            	leitura = new Scanner(System.in);
                                                daoDisciplina.inserir(disciplina);
                                                break;
                                                              }
                                            if(menuAluno == 2){    
                                            	leitura = new Scanner(System.in);
                                                daoLivro.inserir(livro);
                                                break;
                                                              }
                                            if(menuAluno == 3){
                                            	leitura = new Scanner(System.in);
                                                daoApostila.inserir(apostila);
                                                break;
                                                              }
                                            if(menuAluno == 4){
                                            	leitura = new Scanner(System.in);
                                                daoMaterialWeb.inserir();
                                                break;
                                                               }   
                                            }while(menuAluno !=0);
                                    
                                            }
                                if(menuAluno == 2){
                                	leitura = new Scanner(System.in);
                                	System.out.println("1- Disciplinas");
                                    System.out.println("2- Livros");
                                    System.out.println("3- Apostila");
                                    System.out.println("4- Material Web");
                                    System.out.println("0- Sair");
                                    menuAluno = leitura.nextInt();
                                    switch(menuAluno){
                                        case 1:
                                        	leitura = new Scanner(System.in);
                                            daoDisciplina.achar(daoDisciplina.ObterTodos());
                                        	break;
                                        case 2:
                                        	leitura = new Scanner(System.in);
                                            daoLivro.achar(daoLivro.ObterTodos());
                                         
                                            break;
                                        case 3:
                                        	leitura = new Scanner(System.in);
                                            daoApostila.achar(daoApostila.ObterTodos());
                                            break;
                                        case 4:   
                                        	leitura = new Scanner(System.in);
                                            daoMaterialWeb.achar(daoMaterialWeb.ObterTodos());
                                            break;
                                    }
                                    
                                     }
                                if(menuAluno == 3){
                                	leitura = new Scanner(System.in);
                                	System.out.println("1- Disciplinas");
                                    System.out.println("2- Livros");
                                    System.out.println("3- Apostila");
                                    System.out.println("4- Material Web");
                                    System.out.println("0- Sair");
                                    menuAluno = leitura.nextInt();
                                    switch(menuAluno){
                                        case 1:
                                        	leitura = new Scanner(System.in);
                                            daoDisciplina.excluirDisciplina(disciplina);
                                        	break;
                                        case 2:
                                        	leitura = new Scanner(System.in);
                                            daoLivro.excluirLivro(livro);
                                            break;
                                        case 3:
                                        	leitura = new Scanner(System.in);
                                            daoApostila.excluirApostila(apostila);
                                            break;
                                        case 4:   
                                        	leitura = new Scanner(System.in);
                                            daoMaterialWeb.excluirMaterial(livro);
                                            break;
                                    }
                                    
                                     }
                                
                                if(menuAluno == 4){
                                	leitura = new Scanner(System.in);
                                	System.out.println("Deseja criar um relacionamento? 1 = sim 2 = não");
                                	System.out.println("1 = sim |2 = não");
                                	res = leitura.nextInt();
                                	if (res == 1) {
                                		daoRelacionamento.inserir();
                                	}
                                    }
                                     
                                if(menuAluno == 5){
                                	leitura = new Scanner(System.in);
                                	System.out.println("______________INFP______________");
                                    System.out.println("|  1 - Ver meus relacionamentos  |");
                                    System.out.println("|  2 - Ver maior relacionado     |");
                                    System.out.println("|  3 - Ver todos relacionamentos |");
                                    System.out.println("|  4 - Sair                      |");
                                    System.out.println("--------------------------------");
                                    menuAluno = leitura.nextInt();
                                    switch(menuAluno){
                                        case 1:
                                        	leitura = new Scanner(System.in);
                                        	System.out.println("Confirme seu nome");
                                        	String nome = leitura.nextLine();
                                        	daoRelacionamento.achar(daoRelacionamento.ObterTodos(),nome );
                                            break;
                                        case 2:
                                        	leitura = new Scanner(System.in);
                                            daoRelacionamento.verMaiores();
                                            break;
                                        case 3:
                                        	leitura = new Scanner(System.in);
                                            daoRelacionamento.verTodos();
                                        	break;
                                        default:
                                            System.out.println("Menu invalido");
                                    }
                                            }
                                    
                                
                                if(menuAluno == 6){

                                    a = false;
                                   
                                }
                                if(menuAluno == 7){        
                                   daoAluno.excluir(aluno);                                                                       
                                }
                        }while(menuAluno != 6 && menuAluno != 7);
                                                                      
                        }else {
                        	System.out.println("Login ou senha errados");
                        }
                            }
                }while(res != 0);
            }
            if (res == 2){    
            	int res1 = 0;
            	do{
                     System.out.println("____________INFP___________");
                     System.out.println("__________Registro_________ ");
                     System.out.println("| - 1 Registrar professor |");
                     System.out.println("| - 2 Registrar aluno     |");
                     System.out.println("| - 0 Voltar              |");
                     System.out.println("___________________________");
                     res1 = leitura.nextInt();

                     if (res1 == 1){
                         daoProfessor.inserirProf(professor);
                         res1 = 0;
                         }
                     if (res1 == 2){
                         daoAluno.inserir(aluno);                        
                         res1 = 0;
                                 } 
                    }while(res1 != 0);
                  }
               
        }while(res != 3);
	//	for (Aluno aluno1 : daoAluno.ObterTodos()) { // Mostrar tabela professor do Banco
		//	System.out.println(aluno1);
		//}
	
		
		
		
		//for (Professor professor1 : daoProfessor.ObterTodos()) { // Mostrar tabela Aluno do Banco
			//System.out.println(professor1);
		//}
		
		
		
	}		
}	
