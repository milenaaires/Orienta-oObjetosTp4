package controle;

/**
 * Manuseia os dados de premium, venda e cliente
 * @author Milena Aires
 *
 */
public class ControlePremium {
	private  Dados dados;
	/**
	 * Contrutor ControlePremium com os dados a ser manuseados
	 * @param dados Dados que serão manuseados 
	 */
	public ControlePremium (Dados dados) {
		this.dados = dados;
		
	}
	/**
	 * Obtém os dados de Premium e cliente, como nome e cpf do cliente, nivel, pontos e recompensa de Premium
	 * @return String[] com os dados de Premium
	 */
	public String[] getPremium() {
		String[] premium = new String[dados.nomeClientes.size()];
		int pontos;
		int lvl;
		for(int i = 0; i < dados.nomeClientes.size(); i++) {
			pontos = (dados.vendaEbooks.get(i) * 5) + (dados.vendaAudioMasc.get(i)* 3)+(dados.vendaAudioFem.get(i)*2); //pontos do cliente
			dados.Premium.get(i).setPontos(pontos);
			lvl = dados.Premium.get(i).getNivel();
			dados.Premium.get(i).setRecompensa(lvl);//recompensa do cliente a partir do nivel 
			premium[i] = (dados.nomeClientes.get(i) + " - " + dados.cpfClientes.get(i) + " Lvl " + dados.Premium.get(i).getNivel() +"("+dados.Premium.get(i).getPontos() 
							+ ") - " + dados.Premium.get(i).getRecompensa());
		}
		return premium;
	}

}