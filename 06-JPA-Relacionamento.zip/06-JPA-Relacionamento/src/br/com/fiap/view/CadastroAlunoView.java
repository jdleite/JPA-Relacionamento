package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAM;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroAlunoView {

	public static void main(String[] args) {
		//Cadastrar os alunos em um grupo
		EntityManager em = 
				EMFactorySingleton.getInstance()
				.createEntityManager();
		
		AlunoDAO alunoDao = new AlunoDAOImpl(em);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Thiago");
		aluno1.setRm("RM8965");
		aluno1.setAtivo(true);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Carlos");
		aluno2.setRm("RM9875");
		aluno2.setAtivo(true);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Ana");
		aluno3.setRm("RM8785");
		aluno3.setAtivo(true);
		
		//Associar o aluno a um grupo
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		GrupoAM grupo = grupoDao.findById(1);
		
		aluno1.setGrupo(grupo);
		aluno2.setGrupo(grupo);
		aluno3.setGrupo(grupo);
		
		//Persiste os alunos
		try {
			alunoDao.create(aluno1);
			alunoDao.create(aluno2);
			alunoDao.create(aluno3);
		} catch (DBCommitException e) {
			e.printStackTrace();
		}
		
	}
	
}
