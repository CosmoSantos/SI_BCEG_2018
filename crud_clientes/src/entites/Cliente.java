package entites;

public class Cliente {

	private Integer idCliente;
	private String nome;
	private String fone;
	private String email;

	public Cliente() {

	}

	public Cliente(Integer idCliente, String nome, String fone, String email) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer id) {
		this.idCliente = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Id:" + getIdCliente() + "\n Nome: " + getNome() + "\nTelefone: " + getFone() + "\nEmail:" + getEmail();
	}

}
