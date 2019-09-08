package br.aluno.thiago.desafio.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.aluno.thiago.desafio.util.HibernateUtil;

public class GenericoDao<Entidade> {

	@SuppressWarnings("unused")
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericoDao() {

		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	public void salvar(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.merge(entidade);

			transaction.commit();

		} catch (RuntimeException re) {

			if (transaction != null) {

				transaction.rollback();
			}

			throw re;

		} finally {

			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);

			List<Entidade> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException re) {

			throw re;

		} finally {

			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade pesquisar(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);

			consulta.add(Restrictions.idEq(id));

			Entidade resultado = (Entidade) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException re) {

			throw re;

		} finally {

			session.close();
		}
	}

	public void excluir(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.delete(entidade);

			transaction.commit();

		} catch (RuntimeException re) {

			if (transaction != null) {

				transaction.rollback();
			}

			throw re;

		} finally {

			session.close();
		}
	}

	public void editar(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.update(entidade);

			transaction.commit();

		} catch (RuntimeException re) {

			if (transaction != null) {

				transaction.rollback();
			}

			throw re;

		} finally {

			session.close();
		}

	}
	
	public void merge(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.merge(entidade);

			transaction.commit();

		} catch (RuntimeException re) {

			if (transaction != null) {

				transaction.rollback();
			}

			throw re;

		} finally {

			session.close();
		}
		
		
	}

}
