package br.aluno.thiago.desafio.negocio;

import java.util.List;

public class Fachada {
	
	private UsuarioControlador usuarioControlador;
	
	private static Fachada instancia = null;
	
	public Fachada() {
		
		this.usuarioControlador = new UsuarioControlador();
	}
	
	public static Fachada getInstancia() {
		
		if(instancia == null) {
			
			instancia = new Fachada();
		}
		
		return instancia;
	}
	
	public void salvar(Usuario usuario) {
		
		this.usuarioControlador.salvar(usuario);
	}
	
	public List<Usuario>listar(){
		
		return this.usuarioControlador.listar();
	}
	
	public Usuario pesquisar(Long id) {
		
		return this.usuarioControlador.pesquisar(id);
	}
	
	public void excluir(Usuario usuario) {
		
		this.usuarioControlador.excluir(usuario);
	}
	
	public void editar(Usuario usuario) {
		
		this.usuarioControlador.editar(usuario);
	}
	
	public Usuario logar(String email, String senha) {
		
		return this.usuarioControlador.logar(email, senha);
				
	}


}
