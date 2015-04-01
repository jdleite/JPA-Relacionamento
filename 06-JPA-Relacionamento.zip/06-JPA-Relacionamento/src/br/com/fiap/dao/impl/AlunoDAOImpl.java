package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl 
				extends DAOImpl<Aluno, String>
 								implements AlunoDAO{

	public AlunoDAOImpl(EntityManager em) {
		super(em);
	}

}
