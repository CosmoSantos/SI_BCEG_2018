package service;

import cardapioBean.CardapioTO;
import persistence.CardapioDAO;

public class CardapioService {

	CardapioDAO dao;

	public CardapioService() {
		dao = new CardapioDAO(); 
	}

	public void insert(CardapioTO to) {
		try {
			dao.insert(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(CardapioTO to) {
		try {
			dao.update(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer idCardapio) {
		try {
			dao.delete(idCardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select(Integer idCardapio) {
		try {
			dao.consulta(idCardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		try {
			dao.carregarCardapio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
