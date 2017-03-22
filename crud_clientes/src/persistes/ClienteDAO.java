package persistes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entites.Cliente;

public class ClienteDAO {
	public int criar(Cliente cliente) {
		String sqlInsert = "INSERT INTO cliente(nome, fone, email) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getFone());
			stm.setString(3, cliente.getEmail());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cliente.setIdCliente(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente.getIdCliente();
	}

	public void atualizar(Cliente cliente) {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, email=? WHERE idcliente=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getFone());
			stm.setString(3, cliente.getEmail());
			stm.setInt(4, cliente.getIdCliente());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cliente WHERE idcliente = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cliente carregar(int id) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(id);
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE idcliente = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cliente.getIdCliente());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente.setNome(rs.getString("nome"));
					cliente.setFone(rs.getString("fone"));
					cliente.setEmail(rs.getString("email"));
				} else {
					cliente.setIdCliente(-1);
					cliente.setNome(null);
					cliente.setFone(null);
					cliente.setEmail(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cliente;
	}
	
	public List<Cliente> carregaTodos() {
		
		String query = "select * from cliente";
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(query);){
			try (ResultSet rs = stm.executeQuery();) {
				
				while(rs.next()) {
					Cliente c = new Cliente();
					
					c.setIdCliente(rs.getInt("idcliente"));
					c.setNome(rs.getString("nome"));
					c.setFone(rs.getString("fone"));
					c.setEmail(rs.getString("email"));
					lista.add(c);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}










