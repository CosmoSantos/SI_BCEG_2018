package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entites.Cliente;
import persistes.ClienteDAO;


@WebServlet("/ClienteServelet")
public class ClienteServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ClienteServelet() {
    	
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	if(acao != null) {
    		if(acao.equalsIgnoreCase("cadastrar")) {
    			
    			try {
    				
    				Cliente c = new Cliente();
    				
    				c.setNome(request.getParameter("nome"));
    				c.setFone(request.getParameter("fone"));
    				c.setEmail(request.getParameter("email"));
    				
    				ClienteDAO d = new ClienteDAO();
    				d.criar(c);
    				
    				request.setAttribute("mensagem", "Cliente: " + c.getNome() + " Cadastrado com Sucesso");
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro." + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("excluir")) {
    			
    			try {
    				
    				Integer idCliente = Integer.parseInt(request.getParameter("id"));
    				Cliente c = new Cliente();
    				ClienteDAO d = new ClienteDAO();
    				d.excluir(idCliente);
    				
    				request.setAttribute("mensagem", "Cliente excluído com Sucesso");
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro" + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("consultaCliente.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("editar")) {
    			try {
    				
    				Integer idCliente = Integer.parseInt(request.getParameter("id"));
    				
    				ClienteDAO clienteDao = new ClienteDAO();
    				Cliente cliente = clienteDao.carregar(idCliente);
    				
    				request.setAttribute("cliente", cliente);
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro. " + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("atualizaCliente.jsp").forward(request, response);
    			}
    		} else if(acao.equalsIgnoreCase("atualizar")) {
    			
    			try {
    				
    				Cliente cliente = new Cliente();
    				
    				cliente.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
    				cliente.setNome(request.getParameter("nome"));
    				cliente.setFone(request.getParameter("fone"));
    				cliente.setEmail(request.getParameter("email"));
    				
    				ClienteDAO clienteDao = new ClienteDAO();
    				clienteDao.atualizar(cliente);
    				
    			} catch(Exception e) {
    				request.setAttribute("mensagem", "Erro. " + e.getMessage());
    			} finally {
    				request.getRequestDispatcher("consultaCliente.jsp").forward(request, response);
    			}
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
