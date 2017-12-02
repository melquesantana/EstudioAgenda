package br.com.dao;

 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.JPAUtil.JpaUtil;
 
import br.com.modelo.Cliente;

@SuppressWarnings("serial")
public class ClienteDao  extends DaoGenerico<Cliente> {
 

	public List<Cliente>ListarCliente(){
		EntityManager manager = JpaUtil.getEntityManager();
		@SuppressWarnings("unused")
		EntityTransaction tx = manager.getTransaction();		
	try {
		Query query = manager.createQuery("from Cliente");
		@SuppressWarnings("unchecked")
		List<Cliente>resultado = query.getResultList();
		return	resultado;
	} catch (RuntimeException erro) {
		erro.printStackTrace();
		
	}
	finally{
		manager.close();
		JpaUtil.close();
	}
	return ListarCliente();
	 
 
	}

	 


}
