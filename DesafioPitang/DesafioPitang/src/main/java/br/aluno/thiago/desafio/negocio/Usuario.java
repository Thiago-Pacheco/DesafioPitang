package br.aluno.thiago.desafio.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.login", query="SELECT usuario FROM Usuario usuario WHERE usuario.email = :email AND usuario.senha = :senha")
	
})
public class Usuario extends Generico {

	@Column(length = 30, nullable = false)
	@NotEmpty(message="Campo obrigatorio")
	private String nome;

	@Column(length = 30, nullable = false)
	@NotEmpty(message="Campo obrigatorio")
	private String email;

	@Column(length = 30, nullable = false)
	@NotEmpty(message="Campo obrigatorio")
	private String senha;
	
	@Column(nullable = false)
	@NotNull(message="Campo obrigatorio")
	@Min(value = 0,message="Numero deve ser maior que zero")
	private Integer ddd;
	
	@Column(length = 9, nullable = false)
	@NotEmpty(message="Campo obrigatorio")
	private String numero;
	
	@Column(length = 10, nullable = false)
	@NotEmpty(message="Campo obrigatorio")
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
