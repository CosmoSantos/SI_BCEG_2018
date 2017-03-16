package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cardapioBean.Cardapio;

public class CardapioDAO {

	private Cardapio c; 
	private PreparedStatement stmt;
	private Connection con;

	public void conexao(String query) {
		try {
			con = ConnectionFactory.openConexao();
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Cardapio c) {

		String query = "insert into cardapio(categoria, descricao, valor_unit, disponibilidade)" + "values(?, ?, ?, ?)";

		try {
			conexao(query);

			stmt = con.prepareStatement(query);
			stmt.setString(1, c.getCategoria());
			stmt.setString(2, c.getDescricao());
			stmt.setDouble(3, c.getValorUnitario());
			stmt.setString(4, c.getDisponibilidade());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Cardapio c) {

		String query = "update cardapio set categoria =?, descricao =?, valor_unit =?, disponibilidade =?"
				+ "where idcardapio =? ";

		try {
			conexao(query);

			stmt.setString(1, c.getDescricao());
			stmt.setString(2, c.getCategoria());
			stmt.setDouble(3, c.getValorUnitario());
			stmt.setString(4, c.getDisponibilidade());
			stmt.setInt(5, c.getIdcardapio());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Integer idCardapio) {

		String query = "delete from cardapio where idcardapio = ?";

		try {
			conexao(query);

			stmt.setInt(1, idCardapio);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Cardapio consulta(Integer idCardapio) {

		String query = "select * from cardapio where idcardapio = ? ";

		try {
			conexao(query);
			ResultSet rs = stmt.executeQuery();

			stmt.setInt(1, idCardapio);
			rs = stmt.executeQuery();

			if (rs.next()) {

				c = new Cardapio();

				c.setIdcardapio(rs.getInt("idcardapio"));
				c.setCategoria(rs.getString("categoria"));
				c.setDescricao(rs.getString("descricao"));
				c.setValorUnitario(rs.getDouble("valor_unit"));
				c.setDisponibilidade(rs.getString("disponibilidade"));

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public List<Cardapio> carregarCardapio() {

		String query = "select * from cardapio order by categoria";

		List<Cardapio> lista = new ArrayList<Cardapio>();
		try {
			conexao(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				c = new Cardapio();

				c.setIdcardapio(rs.getInt("idcardapio"));
				c.setCategoria(rs.getString("categoria"));
				c.setDescricao(rs.getString("descricao"));
				c.setValorUnitario(rs.getDouble("valor_unit"));
				c.setDisponibilidade(rs.getString("disponibilidade"));
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
