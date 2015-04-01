package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqGrupo",
sequenceName="SEQ_GRUPO_AM",allocationSize=1)
@Table(name="TDSA_GRUPO_AM")
public class GrupoAM {

	public GrupoAM() {
		//Inicializa a lista de aluno
		integrantes = new ArrayList<Aluno>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqGrupo")
	private int id;
	
	private String nome;
	
	//cascade -> realiza a operação configura em cascata
	@OneToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	private ProjetoAM projeto;

	//Relacionamento Bi-direcional Um para Muitos
	@OneToMany(mappedBy="grupo",
				cascade=CascadeType.PERSIST)
	private List<Aluno> integrantes;
	
	public void addAluno(Aluno aluno){
		//Adicionar o aluno na lista
		integrantes.add(aluno);
		//Adicionar o grupo no aluno
		aluno.setGrupo(this);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProjetoAM getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoAM projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Aluno> integrantes) {
		this.integrantes = integrantes;
	}
	
}
