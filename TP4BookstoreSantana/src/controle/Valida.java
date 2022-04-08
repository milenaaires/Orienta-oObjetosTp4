package controle;

/**
 * Classe para validar os dados inseridos 
 * @author Milena Aires
 *
 */
public class Valida {
	
	/**
	 * Valida o nome e cpf do cliente
	 * @param nome String do nome do cliente 
	 * @param cpf String do CPF do cliente 
	 * @return boolean true para dados certo e false para dados errados
	 */
	public boolean validaCliente(String nome, String cpf) {
		if(nome.length() < 3 || cpf.length() != 11) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Valida a quantidade de books nas vendas
	 * @param numAudioMac Int do valor de AudioMasc vendido
	 * @param numAudioFem Int do valor de AudioFem vendido
	 * @return boolean true para dados certos e false para dados errados 
	 */
	public boolean validaVenda(int numEbook, int numAudioMasc, int numAudioFem) {
		if(numEbook < 0 || numAudioMasc < 0 || numAudioFem < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * valida o valor e os minutos do audiobook
	 * @param valor Int do valor da audiobook
	 * @param minutosAudio Int de minutos do audiobook
	 * @return boolean true para dados certos e false para dados errados 
	 */
	public boolean validaAudiobook (float valor, int minutosAudio) {
		if(valor < 0 || minutosAudio < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * valida o valor do ebook
	 * @param valor Int do valor do ebook
	 * @return boolean true para dados certos e false para dados errados
	 */
	public boolean validaEbook(float valor) {
		if(valor < 0) {
			return false;
		}else {
			return true;
		}
	}

	/**
	 * valida o campo de valores
	 * @param valor String do JTextField que for inserido nos campos de valores
	 * @return boolean true caso nao tenha nenhuma letra ou sinal e false caso tenha
	 */
	public boolean validaFloat(String valor) {
		char[] a = valor.toCharArray();
		int verifica = 1;
		if(a[0] == '.'){
				return false;
		}
		for(int i=0; i < valor.length(); i++){
			if(a[i] != '.' && a[i] != '0' && a[i] != '1' && a[i] != '2' && a[i] != '3' && a[i] != '4' && a[i] != '5' && a[i] != '6' && a[i] != '7' && a[i] != '8' && a[i] != '9'){
				verifica = 0;
			}
		}
		if(verifica == 1){
			return true;
		}else{
			return false;
		}
	}
}