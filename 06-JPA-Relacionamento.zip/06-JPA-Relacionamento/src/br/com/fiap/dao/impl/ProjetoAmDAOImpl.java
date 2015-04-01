package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.entity.ProjetoAM;

public class ProjetoAmDAOImpl 
				extends DAOImpl<ProjetoAM, Integer>
					implements ProjetoAmDAO{

	public ProjetoAmDAOImpl(EntityManager em) {
		super(em);
	}

}


