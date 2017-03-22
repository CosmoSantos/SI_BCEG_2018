package managdBeans;

import java.util.List;

import entites.Cliente;
import persistes.ClienteDAO;

public class ManagdBeansCliente {
	
	private List<Cliente> listagemCliente;
	
	public List<Cliente> getListagemCliente() {
		ClienteDAO d = new ClienteDAO();
		listagemCliente = d.carregaTodos();
		
		return listagemCliente;
	}

}
