package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.singleton.EMFactorySingleton;

public class CadastrarTudoView {

	public static void main(String[] args) {
		//Cadastrar todas as entidades relacionadas
		EntityManager em = EMFactorySingleton.
				getInstance().createEntityManager();
		
		
	}
	
}
