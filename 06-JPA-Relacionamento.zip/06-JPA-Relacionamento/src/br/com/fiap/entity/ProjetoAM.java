package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqProjeto",
sequenceName="SEQ_PROJETO_AM",allocationSize=1)
@Table(name="TDSA_PROJETO_AM")
public class ProjetoAM {

	public ProjetoAM() {
		//Inicializa a lista de professores
		avaliadores = new ArrayList<Professor>();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqProjeto")
	private int codigo;
	
	private String tema;
	
	private Calendar dataEntrega;
	
	//Relacionamento bi-direcional
	@ManyToMany(mappedBy="projetos",
			cascade=CascadeType.PERSIST)
	private List<Professor> avaliadores;
	
	//Relacionamento bi-direcional: tem o mappedBy 
	//mappedBy -> nome do atributo que possui o relacionamento
	@OneToOne(mappedBy="projeto",cascade=CascadeType.ALL)
	private GrupoAM grupo;
	
	public void addAvaliador(Professor prof){
		//Adicionar o professor na lista
		avaliadores.add(prof);
		//Associar o professor com o projeto
		prof.getProjetos().add(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public GrupoAM getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAM grupo) {
		this.grupo = grupo;
	}

	public List<Professor> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Professor> avaliadores) {
		this.avaliadores = avaliadores;
	}
	
}
