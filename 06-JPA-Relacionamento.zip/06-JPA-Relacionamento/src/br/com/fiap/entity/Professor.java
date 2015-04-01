package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TDSA_PROFESSOR_AM")
public class Professor {

	public Professor() {
		//Inicializa a lista de projetos
		projetos = new ArrayList<ProjetoAM>();
	}
	
	@Id
	private String codigo;
	
	private String nome;
	
	private Sexo sexo;
	
	//Relacionamento Muitos para Muitos
	//JoinTable é opcional
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="TDSA_PROF_PROJ_AM_AVALIACAO"
		,joinColumns={@JoinColumn(name="CD_PROF")},
		inverseJoinColumns={@JoinColumn(name="CD_PROJETO")})
	private List<ProjetoAM> projetos;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<ProjetoAM> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<ProjetoAM> projetos) {
		this.projetos = projetos;
	}
	
}
