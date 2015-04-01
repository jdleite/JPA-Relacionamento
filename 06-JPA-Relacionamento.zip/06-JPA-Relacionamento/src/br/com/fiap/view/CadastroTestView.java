package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.GrupoAM;
import br.com.fiap.entity.ProjetoAM;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroTestView {

	public static void main(String[] args) {
		//Cadastrar um projeto e um grupo de AM
		EntityManager em =
				EMFactorySingleton.getInstance()
				.createEntityManager();
		
		ProjetoAmDAO projetoDao = new ProjetoAmDAOImpl(em);
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		
		GrupoAM grupo = new GrupoAM();
		grupo.setNome("D doubles");
		
		ProjetoAM projeto = new ProjetoAM();
		projeto.setTema("Sistema de controle de compras");
		projeto.setDataEntrega(
				new GregorianCalendar(2015,Calendar.MAY,28));
		
		//Associar o grupo com o projeto
		grupo.setProjeto(projeto);
		projeto.setGrupo(grupo);
		
		try {
			projetoDao.create(projeto); //realizado em cascata
			//grupoDao.create(grupo);
		} catch (DBCommitException e) {
			e.printStackTrace();
		}
	}
	
}









