package service;

import cardapioBean.Cardapio;
import persistence.CardapioDAO;

public class CardapioService {

	CardapioDAO dao;

	public CardapioService() {
		dao = new CardapioDAO(); 
	}

	public void insert(Cardapio to) {
		dao.insert(to);
	}

	public void update(Cardapio to) {
		dao.update(to);
	}

	public void delete(Integer idCardapio) {
		dao.delete(idCardapio);
	}

	public void select(Integer idCardapio) {
		dao.consulta(idCardapio);
	}

	public void selectAll() {
		dao.carregarCardapio();
	}

}
