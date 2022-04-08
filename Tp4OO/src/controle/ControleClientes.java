package controle;


/**
 * Manuseia os dados dos cliente
 * @author Milena Aires
 *
 */
public class ControleClientes {
	public Dados dados;
	/**
	 * Construtor ControleClientes
	 * @param dados Dados que serão manuseados pela classe
	 */
	public ControleClientes(Dados dados) {
		this.dados = dados;
	}
	
	/**
	 * Obtém todos os dados dos clientes(nome e cpf)
	 * @return String[] que caracteriza os dados dos clientes
	 */
	public String[] getNomesClientes() {	
		String[] nomes = new String[dados.nomeClientes.size()];
			for(int i = 0; i < dados.nomeClientes.size(); i++) {
				nomes[i] = dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i);
			}
		return nomes;		
	}
	
	/**
	 * Remove o cliente do arraylist a partir do indice
	 * @param i int com o indice do cliente a ser removido
	 */
	public void delCliente(int i) {
		dados.nomeClientes.remove(i);
		dados.cpfClientes.remove(i);
	}
	/**
	 * Adiciona o cliente na arraylist
	 * @param nome String com o nome a ser armazenado no arraylist
	 * @param cpf String com o CPF a ser armazenado no arraylist
	 */
	
	public void addCliente(String nome, String cpf) {
		dados.nomeClientes.add(nome);
		dados.cpfClientes.add(cpf);
	}
	
	/**
	 * Obtém o nome do cliente 
	 * @param i indice que indica o local do cliente na arraylist
	 * @return String que especifica o nome do cliente 
	 */
	public String getNome(int i) {		
		return dados.nomeClientes.get(i);
	}
	/**
	 * Obtém o CPF do cliente 
	 * @param i indice que indica o local do cliente na arraylist
	 * @return String que especifica o CPF do cliente 
	 */
	public String getCpf(int i) {
		return dados.cpfClientes.get(i);
	}
	
	/**
	 * Configura os dados do cliente 
	 * @param i indice que indica o local do cliente da arraylist
	 * @param name String com o nome a ser configurado 
	 * @param cpf String com o CPF a ser configurado 
	 */
	public void setCliente(int i, String nome, String cpf) {
		dados.nomeClientes.set(i, nome);
		dados.cpfClientes.set(i, cpf);
	}
	
}