package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.JPAUtil.JpaUtil;
import br.com.modelo.Freelancer;

public class FreelancerDao extends DaoGenerico<Freelancer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Freelancer> ListarFreelancer() {
		EntityManager manager = JpaUtil.getEntityManager();
		@SuppressWarnings("unused")
		EntityTransaction tx = manager.getTransaction();
		try {
			Query query = manager.createQuery("from Freelancer");
			@SuppressWarnings("unchecked")
			List<Freelancer> resultado = query.getResultList();
			return resultado;
		} catch (RuntimeException erro) {
			erro.printStackTrace();

		} finally {
			manager.close();
			JpaUtil.close();
		}
		return ListarFreelancer();

	}
}
