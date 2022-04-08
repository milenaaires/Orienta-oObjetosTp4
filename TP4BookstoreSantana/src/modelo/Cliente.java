package modelo;

/**
 * Classe modelo para o objeto cliente
 * @author Milena Aires 
 *
 */
public class Cliente {
    protected String nome, cpf, qnt;
    
    /**
     * Contrutor Cliente 
     */
    
	public Cliente(){

	}
			
	/**
     * Obtém o nome
     * @return String que caracteriza o nome
     */
	
	public String getNome() {
		return nome;
	}
	
	 /**
     * Configura a String nome 
     * @param nome string com o nome a ser caracterizado 
     */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Obtém o cpf
	 * @return String que caracteriza o cpf
	 */
	
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Caracteriza o CPF
	 * @param cpf String com o CPF a ser caracterizado
	 */
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Obtém quantidade de clientes
	 * @return String Quantidade de clientes 
	 */
	
	public String getQnt() {
		return qnt;
	}
	
	/**
	 * Caracteriza a quantidade 
	 * @param qnt String com a quantidade de clientes 
	 */
	
	public void setQnt(String qnt) {
		this.qnt = qnt;
	}
	
}	