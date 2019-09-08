package br.aluno.thiago.desafio.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.aluno.thiago.desafio.negocio.Fachada;
import br.aluno.thiago.desafio.negocio.Usuario;

public class UsuarioDaoTest {

	private Fachada fachada;

	private Usuario usuario;

	public UsuarioDaoTest() {

		this.fachada = Fachada.getInstancia();

		this.usuario = new Usuario();

	}

	@Test
	@Ignore
	public void salvar() {

		this.usuario.setNome("Bruno");

		this.usuario.setEmail("bruno@gmail.com");

		this.usuario.setSenha("123456");

		this.usuario.setDdd(81);

		this.usuario.setNumero("444444444");

		this.usuario.setTipo("Fixo");

		this.fachada.salvar(usuario);

	}

	@Test
	@Ignore
	public void listar() {

		List<Usuario> lista = this.fachada.listar();

		for (Usuario usuario : lista) {

			System.out.println(usuario.getNome() + " " + usuario.getEmail() + " " + usuario.getSenha() + " " +

					usuario.getDdd() + " " + usuario.getNumero() + " " + usuario.getTipo());
		}

	}

	@Test
	@Ignore
	public void buscar() {

		Usuario usuario = this.fachada.pesquisar(2L);

		System.out.println(usuario.getNome() + " " + usuario.getEmail() + " " + usuario.getSenha() + " " +

				usuario.getDdd() + " " + usuario.getNumero() + " " + usuario.getTipo());
	}

	@Test
	@Ignore
	public void excluir() {

		Usuario usuario = this.fachada.pesquisar(3L);

		this.fachada.excluir(usuario);

	}

	@Test
	@Ignore
	public void editar() {

		Usuario usuario = this.fachada.pesquisar(2L);

		usuario.setNome("BrunoM");

		usuario.setEmail("brunoM@gmail.com");

		usuario.setSenha("123456");

		usuario.setDdd(81);

		usuario.setNumero("444444444");

		usuario.setTipo("Celular");

		fachada.editar(usuario);

	}
	
	@Test
	public void logar() {
		
		Usuario usuario = this.fachada.logar("pacheco@gmail.com", "7891011");
		
		//System.out.println(usuario);
		
		Assert.assertNotNull(usuario);

		
	}

}
