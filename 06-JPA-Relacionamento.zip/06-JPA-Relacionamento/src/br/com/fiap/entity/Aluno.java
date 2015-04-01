package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TDSA_ALUNO")
public class Aluno {

	@Id
	private String rm;
	
	private String nome;
	
	private boolean ativo;
	
	//Relacionamento Muitos para um
	@ManyToOne
	private GrupoAM grupo;

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public GrupoAM getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoAM grupo) {
		this.grupo = grupo;
	}
	
}
