package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAM;
import br.com.fiap.entity.ProjetoAM;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

public class CadastroGrupoAlunoView {

	public static void main(String[] args) {
		//Cadastrar o Grupo e os Alunos em cascata
		EntityManager em = EMFactorySingleton.
				getInstance().createEntityManager();
		
		GrupoAM grupo = new GrupoAM();
		grupo.setNome("FIAP Smart Solutions");
		
		ProjetoAM projeto = new ProjetoAM();
		projeto.setTema("Soluções Mágicas");
		
		Aluno a1 = new Aluno();
		a1.setRm("RM2525");
		a1.setNome("Thiago");
		
		Aluno a2 = new Aluno();
		a2.setRm("RM5252");
		a2.setNome("Yamamoto");
		
		//Associar os relacionamentos
		grupo.setProjeto(projeto);
		grupo.addAluno(a1);
		grupo.addAluno(a2);
		
		//Persistir o grupo, o resto vai em cascata
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		
		try {
			dao.create(grupo);
		} catch (DBCommitException e) {
			e.printStackTrace();
		}
		
	}
	
}
