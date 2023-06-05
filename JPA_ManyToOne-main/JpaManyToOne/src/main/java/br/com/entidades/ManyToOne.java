package br.com.entidades;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ManyToOne {

	public static void main( String[ ] args ) throws IOException 
	   {		
		  
		//LOGGER
		Log meuLogger = new Log("Log.txt");
		try {
			//Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informa√ß√£o");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");
			

		} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();//escrever no console o erro

		}
	   
		Employee emp; 		
		
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "ManyToOne" ); //criar o gerenciador da f√°brica de entidades
        EntityManager entitymanager = emfactory.createEntityManager( ); //criar uma entidade
       
        meuLogger.logger.info("\nA entidade manager factory ManyToOne foi criada!!");//escrever no log / para utilizar os outros mÈtodos comentar aqui.
	      
        entitymanager.getTransaction( ).begin( ); //abrir um conex√£o para o bd com a entidade criada

        //Criando a entidade departamento
        Department department = new Department();
        department.setId(1); //setar o nome do departamento desenvolvedor
        department.setName("Development"); //setar o nome do departamento desenvolvedor
        entitymanager.persist(department); //salvar o departamento do bd
        
        //Criando a entidade do empregado 1
        Employee employee1 = new Employee();
        employee1.setEname("Jo„o");
        employee1.setSalary(45000.0);
        employee1.setDeg("Desenvolvedor");
        employee1.setDepartment(department);

        //Criando a entidade do empregado 2
        Employee employee2 = new Employee();
        employee2.setEname("Allan");
        employee2.setSalary(45000.0);
        employee2.setDeg("Suporte");
        employee2.setDepartment(department);

        //Criando a entidade do empregado 3
        Employee employee3 = new Employee();
        employee3.setEname("Roberto");
        employee3.setSalary(50000.0);
        employee3.setDeg("Diretor");
        employee3.setDepartment(department);

        //Armazenando no bd os empregados 1,2 e 3 
        entitymanager.persist(employee1);
        entitymanager.persist(employee2);
        entitymanager.persist(employee3);

        entitymanager.getTransaction().commit();//fechar a conex√£o com o bd
        entitymanager.close(); //Encerrar o gerenciador da entidade
        emfactory.close(); //fechar a f√°brica de entidades / para utilizar os outros metodos termine o coment·rio aqui.
        
		// Consulta
        /*entitymanager.getTransaction().begin(); //abrir transacao com o db
		emp = entitymanager.find(Employee.class, 2); //'find' serve para pesquisar nesse caso obter pelo id 
		System.out.println(emp);
		entitymanager.getTransaction().commit();
		meuLogger.logger.info("\n Consulta executada com sucesso!");//escrever no log*/
        
        //Alterar
		/*entitymanager.getTransaction().begin(); //abrir transacao com o db
		emp = entitymanager.find(Employee.class, 2); //'find' serve para pesquisar nesse caso obter pelo id 
		System.out.println("Employee: "+emp);
		emp.setEname("AndrÈ"); //'set' serve para atualizar na tabela o mesmo que 'UPDATE'		
		entitymanager.getTransaction().commit();
		meuLogger.logger.info("\n Nome alterado com sucesso!");//escrever no log*/
        
		//Remover
        /*entitymanager.getTransaction().begin(); //abrir transacao com o db
		emp = entitymanager.find(Employee.class, 3); //'find' serve para pesquisar nesse caso obter pelo id 
		System.out.println("Employee: "+emp);
		entitymanager.remove(emp);
		entitymanager.getTransaction().commit();
		meuLogger.logger.info("\n Usu·rio removido com sucesso!");//escrever no log*/
   }
}
