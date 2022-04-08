package modelo;

/**
 * classe modelo para o objeto venda
 * @author Milena Aires
 *
 */
public class Venda {
	private Cliente cliente = new Cliente();
	
	/**
	 * Contrutor Venda sem argumentos
	 */
	
	public Venda(){
		
	}
	
	/**
	 * Obtém o cliente 
	 * @return Cliente o cliente
	 */
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	/**
	 * caracteriza o cliente 
	 * @param cliente cliente com o cliente a ser caracterizado 
	 */
	
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
