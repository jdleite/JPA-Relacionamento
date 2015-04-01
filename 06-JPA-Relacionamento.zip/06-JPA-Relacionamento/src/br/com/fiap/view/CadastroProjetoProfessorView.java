package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.ProjetoAM;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroProjetoProfessorView {

	public static void main(String[] args) {
		//Cadastrar projetos e professores
		EntityManager em = EMFactorySingleton.
				getInstance().createEntityManager();
		
		ProjetoAM projeto1 = new ProjetoAM();
		projeto1.setTema("Agua");
		
		ProjetoAM projeto2 = new ProjetoAM();
		projeto2.setTema("Terra");
		
		Professor p1 = new Professor();
		p1.setCodigo("PF2515");
		p1.setNome("BI");
		
		Professor p2 = new Professor();
		p2.setCodigo("PF2516");
		p2.setNome("Humbertão");
		
		//Associar o projeto com os avaliadores
		projeto1.addAvaliador(p1);
		projeto1.addAvaliador(p2);
		
		projeto2.addAvaliador(p1);
		projeto2.addAvaliador(p2);
		
		//Cadastrar o projeto
		ProjetoAmDAO dao = new ProjetoAmDAOImpl(em);
		
		try {
			dao.create(projeto1);
			dao.create(projeto2);
		} catch (DBCommitException e) {
			e.printStackTrace();
		}
		
	}
	
}
