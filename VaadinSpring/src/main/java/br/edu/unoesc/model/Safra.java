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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "Safra")
@NamedQueries({ @NamedQuery(name = Safra.listarTodos, query = "select s from Safra s") })
public class Safra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "tipoSafra_codigo")
	private TipoSafra tipo;
	
	private Double tamanho;
	private String tipoSemente;
	private String observacao;
	private boolean emAtividade;
	private Date dataColheita;
	private Double qtdColhida;
	private Double valorVenda;
	
	@OneToMany(targetEntity = Procedimento.class, 
			fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
			private Set<Procedimento> procedimentos = new HashSet<Procedimento>();

	public static final String listarTodos = "buscarSafra";
	
	public Double valorGastoDurante() {
		return null;
	}
	
	public Double lucros() {
		return null;
	}

	public Safra(Long codigo, String descricao, TipoSafra tipo, Double tamanho, String tipoSemente, String observacao,
			boolean emAtividade, Date dataColheita, Double qtdColhida, Double valorVenda,
			Set<Procedimento> procedimentos) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.tipoSemente = tipoSemente;
		this.observacao = observacao;
		this.emAtividade = emAtividade;
		this.dataColheita = dataColheita;
		this.qtdColhida = qtdColhida;
		this.valorVenda = valorVenda;
		this.procedimentos = procedimentos;
	}

	public Safra() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoSafra getTipo() {
		return tipo;
	}

	public void setTipo(TipoSafra tipo) {
		this.tipo = tipo;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipoSemente() {
		return tipoSemente;
	}

	public void setTipoSemente(String tipoSemente) {
		this.tipoSemente = tipoSemente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isEmAtividade() {
		return emAtividade;
	}

	public void setEmAtividade(boolean emAtividade) {
		this.emAtividade = emAtividade;
	}

	public Date getDataColheita() {
		return dataColheita;
	}

	public void setDataColheita(Date dataColheita) {
		this.dataColheita = dataColheita;
	}

	public Double getQtdColhida() {
		return qtdColhida;
	}

	public void setQtdColhida(Double qtdColhida) {
		this.qtdColhida = qtdColhida;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	
	

}
