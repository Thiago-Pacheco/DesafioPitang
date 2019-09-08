package br.aluno.thiago.desafio.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.aluno.thiago.desafio.negocio.Fachada;
import br.aluno.thiago.desafio.negocio.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;

	private Fachada fachada;

	private List<Usuario> lista;

	public UsuarioBean() {

		this.usuario = new Usuario();

		this.fachada = Fachada.getInstancia();
	}

	public void salvar() {

		try {

			this.fachada.salvar(usuario);

			Messages.addGlobalInfo("Cadastro com sucesso");

		} catch (RuntimeException re) {

			Messages.addGlobalError("Erro ao listar");

			re.printStackTrace();
		}

	}

	public void listar() {

		try {

			this.lista = this.fachada.listar();

		} catch (RuntimeException re) {

			Messages.addGlobalError("Erro ao listar");

			re.printStackTrace();
		}
	}

	public void novo() {

		usuario = new Usuario();
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void excluir(ActionEvent actionEvent) {

		try {

			usuario = (Usuario) actionEvent.getComponent().getAttributes().get("usuarioSelecionado");

			this.fachada.excluir(usuario);

			Messages.addGlobalInfo("Removido com sucesso");

		} catch (RuntimeException re) {

			Messages.addFlashGlobalError("Ocorreu erro ao excluir");

			re.printStackTrace();

		}

	}

	public String sair() {

		usuario = null;

		return "./pages/logar.xhtml?faces-redirect=true";
	}
	public void editar(ActionEvent actionEvent) {

		usuario = (Usuario) actionEvent.getComponent().getAttributes().get("usuarioSelecionado");

	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
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
