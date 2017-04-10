package br.com.bv.negocio;

import br.com.bv.dados.VisitanteDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        VisitanteDao dao = new VisitanteDao();
		dao.adicionar("Bruno", "123zzz", "bv@hot.com", "deu certo?");
	}

}
