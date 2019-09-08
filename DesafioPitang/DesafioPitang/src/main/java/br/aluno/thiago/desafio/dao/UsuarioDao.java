package br.aluno.thiago.desafio.dao;

import org.hibernate.Query;
import org.hibernate.Session;


import br.aluno.thiago.desafio.negocio.Usuario;
import br.aluno.thiago.desafio.util.HibernateUtil;

public class UsuarioDao extends GenericoDao<Usuario>{
	
	public Usuario logar(String email, String senha) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Usuario usuario = null;

		try {

			Query consulta = session.getNamedQuery("Usuario.login");

			consulta.setString("email", email);
			
			consulta.setString("senha", senha);

			usuario = (Usuario) consulta.uniqueResult();
			

		} catch (RuntimeException re) {

			throw re;

		} finally {

			session.close();
		}
		
		return usuario;
	}

}
