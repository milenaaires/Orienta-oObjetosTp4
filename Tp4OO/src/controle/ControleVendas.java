package controle;


/**
 * Manuseia os dados de vendas dos clientes
 * @author Milena Aires
 * 
 */
public class ControleVendas {
	public Dados dados;
	/**
	 * Construtor ControleVendas com os dados que serão manuseados 
	 * @param dados Dados a serem manuseados 
	 */
	public ControleVendas(Dados dados) {
		this.dados = dados;
	}
	/**
	 * Classe para pegar os dados de vendas dos clientes
	 * @return vetor da quantidade de cada book vendido
	 */
	public String[] getVendas() {
		String[] nomes = new String[dados.nomeClientes.size()];
		for(int i = 0; i < dados.nomeClientes.size(); i++) {
			nomes[i] = dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i) + " - " + dados.vendaEbooks.get(i) + " Ebooks - " + dados.vendaAudioMasc.get(i) + " Audiobook, voz masculina  - "
					+ dados.vendaAudioFem.get(i) + "Audiobook, voz feminina";
		}
		return nomes;
	}

	/**
	 * Classe para adicionar uma nova venda
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @param numEbook quantidade de ebooks que o usuario deseja adicionar
	 * @param numAudioMasc quantidade de AudioMasc que o usuario deseja adicionar
	 * @param numAudioFem quantidade de AudioFem que o usuario deseja adicionar
	 */
	public void setVenda(int index, int numEbook, int numAudioMasc, int numAudioFem) {
		dados.vendaEbooks.set(index, dados.vendaEbooks.get(index) + numEbook);
		dados.vendaAudioMasc.set(index,  dados.vendaAudioMasc.get(index) + numAudioMasc);
		dados.vendaAudioFem.set(index, dados.vendaAudioFem.get(index) + numAudioFem);
	}

	/**
	 * Classe para remover books vendidos
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @param numEbook quantidade de ebooks que o usuario deseja remover
	 * @param numAudioMasc quantidade de AudiobookMasc que o usuario deseja remover
	 * @param numAudioFem quantidade de AudiobookFem que o usuario deseja remover
	 */
	public void remVenda(int index, int numEbook, int numAudioMasc, int numAudioFem) {
		dados.vendaEbooks.set(index, dados.vendaEbooks.get(index) - numEbook);
		dados.vendaAudioMasc.set(index,  dados.vendaAudioMasc.get(index) - numAudioMasc);
		dados.vendaAudioFem.set(index, dados.vendaAudioFem.get(index) - numAudioFem);
	}
	
	/**
	 * Classe para editar o numero de books vendidos
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @param numEbook a quantidade de ebooks que o usuario deseja colocar no lugar do valor de antes
	 * @param numAudioMasc a quantidade de AudioMasc que o usuario deseja colocar no lugar do valor de antes
	 * @param numAudioFem a quantidade de AudioFem que o usuario deseja colocar no lugar do valor de antes
	 */
	public void editVenda(int index, int numEbook, int numAudioMasc, int numAudioFem) {
		dados.vendaEbooks.set(index, numEbook);
		dados.vendaAudioMasc.set(index,  numAudioMasc);
		dados.vendaAudioFem.set(index, numAudioFem);
	}
	
	/**
	 * Obtem o numero de ebooks comprados pelo cliente
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @return int do valor de ebooks vendidos
	 */
	public String getEbook(int index){
		String valor = ("" + dados.vendaEbooks.get(index));
		return valor;
	}

	/**
	 * Obtem o numero de AudioMasc comprados pelo cliente
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @return int do valor de AudioMasc vendidos
	 */
	public String getAudioMasc(int index){
		String valor = ("" + dados.vendaAudioMasc.get(index));
		return valor;
	}

	/**
	 * Obtem o numero de AudioFem comprados pelo cliente
	 * @param index posição do arraylist correspondente ao usuario selecionado
	 * @return int do valor de AudioFem  vendidos
	 */
	public String getAudioFem (int index){
		String valor = ("" + dados.vendaAudioFem.get(index));
		return valor;
	}
}