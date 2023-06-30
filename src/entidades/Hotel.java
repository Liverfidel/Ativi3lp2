package entidades;

public class Hotel {
	
	private int idhotel;
	private String nome;
	private String endereco;
	private int cep;
	
	public Hotel(String nome, String endereco, int cep) {
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		
	}
	
	public Hotel(int idhotel, String nome, String endereco, int cep) {
		this.idhotel = idhotel;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
	}

	public int getIdhotel() {
		return idhotel;
	}

	public void setIdhotel(int idhotel) {
		this.idhotel = idhotel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	
}
