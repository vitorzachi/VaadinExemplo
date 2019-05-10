package br.edu.unoesc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private Date dataNascimento;
	
	@OneToMany(targetEntity = Safra.class, 
			fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
			private Set<Safra> safras = new HashSet<Safra>();
	
	public Usuario() {

	}

	public Usuario(Long codigo, String nome, String sobrenome, String email, String senha, Date dataNascimento,
			Set<Safra> safras) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.safras = safras;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date data) {
		this.dataNascimento = data;
	}

	public Set<Safra> getSafras() {
		return safras;
	}

	public void setSafras(Set<Safra> safras) {
		this.safras = safras;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", senha=" + senha + ", dataNascimento=" + dataNascimento + ", safras=" + safras + "]";
	}
	
	
	
}
