package br.com.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//classe para conexao com o banco de dados
public class JpaUtil {
	private static EntityManagerFactory factory;
	static {
// nome da persistence unit no persitence.xml
		factory = Persistence.createEntityManagerFactory("exemploPU");
	}
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
		//Connection con = new ConnectionFactory().getConnection();
	}
	
	public static void close() {
		//factory.close();
	}
	 
	 
	 
	

}


