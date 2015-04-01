package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.entity.GrupoAM;

public class GrupoAmDAOImpl 
				extends DAOImpl<GrupoAM,Integer>
					implements GrupoAmDAO {

	public GrupoAmDAOImpl(EntityManager em) {
		super(em);
	}

}
