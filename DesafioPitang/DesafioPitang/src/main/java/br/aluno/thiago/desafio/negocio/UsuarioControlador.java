package br.aluno.thiago.desafio.negocio;

import java.util.List;

import br.aluno.thiago.desafio.dao.UsuarioDao;

public class UsuarioControlador {

	private UsuarioDao usuarioDao;

	public UsuarioControlador() {
		
		this.usuarioDao = new UsuarioDao();
		
	}
	
	public void salvar(Usuario usuario) {
		
		this.usuarioDao.salvar(usuario);
	}
	
	public List<Usuario>listar(){
		
		return this.usuarioDao.listar();
	}
	
	public Usuario pesquisar(Long id) {
		
		return this.usuarioDao.pesquisar(id);
	}
	
	public void excluir(Usuario usuario) {
		
		this.usuarioDao.excluir(usuario);
	}
	
	public void editar(Usuario usuario) {
		
		this.usuarioDao.editar(usuario);
	}
	
	public Usuario logar(String email, String senha) {
		
		return this.usuarioDao.logar(email, senha);
	}


}
