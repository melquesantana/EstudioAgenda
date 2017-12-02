package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.JPAUtil.JpaUtil;
import br.com.modelo.Casamento;
 

public class CasamentoDao  extends DaoGenerico<Casamento>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Casamento>ListarCasamento(){
		EntityManager manager = JpaUtil.getEntityManager();
		@SuppressWarnings("unused")
		EntityTransaction tx = manager.getTransaction();		
	try {
		Query query = manager.createQuery("from Casamento");
		@SuppressWarnings("unchecked")
		List<Casamento>resultado = query.getResultList();
		return	resultado;
	} catch (RuntimeException erro) {
		erro.printStackTrace();
		
	}
	finally{
		manager.close();
		JpaUtil.close();
	}
	return ListarCasamento();
	 
 
	}

	 



}
