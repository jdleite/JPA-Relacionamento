package br.com.fiap.view;

import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.ProjetoAmDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.dao.impl.ProjetoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAM;
import br.com.fiap.entity.ProjetoAM;
import br.com.fiap.singleton.EMFactorySingleton;

public class BuscaTestView {

	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton
				.getInstance().createEntityManager();
		
		//Buscar o grupo e exibir o tema do projeto
		GrupoAmDAO grupoDao = new GrupoAmDAOImpl(em);
		
		GrupoAM grupo = grupoDao.findById(1);
		System.out.println("Grupo: " + grupo.getNome());
		System.out.println("Tema: " +  grupo.getProjeto().getTema());
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println("Data Entrega: " +
//				sdf.format(grupo.getProjeto()
//						.getDataEntrega().getTime()));
		
		//Recuperar o projeto e exibir o nome do grupo
		ProjetoAmDAO projetoDao = new ProjetoAmDAOImpl(em);
		ProjetoAM projeto = projetoDao.findById(1);
		
		System.out.println("**************************");
		System.out.println("Tema: " + projeto.getTema());
		System.out.println("Grupo: " + 
							projeto.getGrupo().getNome());
		
		//Buscar um aluno e exibir o nome do grupo e o 
		//tema do projeto
		AlunoDAO alunoDao = new AlunoDAOImpl(em);
		Aluno aluno = alunoDao.findById("RM5252");
		System.out.println("**************************");
		System.out.println("Nome: " + aluno.getNome());
		System.out.println("Grupo: " + 
							aluno.getGrupo().getNome());
		System.out.println("Tema projeto: " +
				aluno.getGrupo().getProjeto().getTema());
		
		//Buscar o grupo e exibir os integrantes 
		//e a sua quantidade
		System.out.println("Quantidade de integrantes: " 
					+ grupo.getIntegrantes().size());
		System.out.println("Integrantes do grupo: "
									+ grupo.getNome());
		
		//Imprimir os nomes dos integrantes
		for (Aluno a : grupo.getIntegrantes()) {
			System.out.println(a.getRm() + " " +a.getNome());
		}
		
	}
	
	
}
