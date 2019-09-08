package br.aluno.thiago.desafio.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.aluno.thiago.desafio.negocio.Fachada;
import br.aluno.thiago.desafio.negocio.Usuario;

@ManagedBean
@SessionScoped
public class LogarBean {
	
	private Usuario usuario;
	
	private Fachada fachada;
	
	public LogarBean() {
		
		this.usuario = new Usuario();
		
		this.fachada = Fachada.getInstancia();
	}
	
	public void logar() {

		try {

			usuario = this.fachada.logar(this.usuario.getEmail(), this.usuario.getSenha());

			if (usuario == null) {

				Messages.addFlashGlobalError("E-mail ou senha invalidos");

			} else {

				Messages.addGlobalInfo("Logado com sucesso");
				
				Faces.redirect("./pages/principal.xhtml");

			}

		} catch (Exception e) {

			Messages.addFlashGlobalError("Ocorreu erro ao logar");

		}
		

	}

	


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
	

}
