package controle;


import modelo.Audiobook;
import modelo.Ebook;
/**
 * Manuseia os dados de book, ebook e audiobook
 * @author Milena Aires
 *
 */
public class ControleBooks {
	Dados dados;
	/**
	 * Construtor ControleBooks com os dados que serão manuseados
	 * @param dados Dados a serem manuseados 
	 */
	public ControleBooks (Dados dados) {
		this.dados = dados;
	}
	
	/**
	 * Obtém os dados de todos os ebooks cadastrados 
	 * @return String[] com os dados
	 */
	public String[] getTitulosEbook() {	
		String[] nomes = new String[dados.Ebooks.size()];
			for(int i = 0; i < dados.Ebooks.size(); i++) {
				nomes[i] = dados.Ebooks.get(i).getTitulo() +" - "+ dados.Ebooks.get(i).getSinopse() + " - R$" + dados.Ebooks.get(i).getValor();
			}
		return nomes;
		
	}
	/**
	 * Obtém os dados de todas os audiobooks cadastrados 
	 * @return String[] com os dados
	 */
	public String[] getTitulosAudiobook() {	
		String[] titulos = new String[dados.Audiobooks.size()];
		for(int i = 0; i < dados.Audiobooks.size(); i++) {
			titulos[i] = dados.Audiobooks.get(i).getTitulo() +" "+ dados.Audiobooks.get(i).getMinutosAudio()+"Sinopse : " + dados.Audiobooks.get(i).getSinopse() + " - R$" + dados.Audiobooks.get(i).getValor();
		}
		return titulos;
		
	}
	
	 /**
	  * Obtém os dados do ebook especifico a partir do titulo
	  * @param titulo String com o titulo pesquisado 
	  * @return int com o indice do book encontrado ou -1 para book não encontrado
	  */
	public int pesquisarTitulosEbook(String titulo) {	
		int index =-1;
			for(int i = 0; i < dados.Ebooks.size(); i++) {
				if(titulo.equalsIgnoreCase(dados.Ebooks.get(i).getTitulo())) {
					index = i;
					break;
				}
			}
		return index;
	}
	/**
	  * Obtém os dados do audiobook a partir do titulo pesquisado
	  * @param titulo String com o titulo a ser pesquisado 
	  * @return int com o indice do book encontrado ou -1 para book não encontrado
	  */
	public int pesquisarTitulosAudiobook(String titulo) {	
		int index =-1;
			for(int i = 0; i < dados.Audiobooks.size(); i++) {
				if(titulo.equalsIgnoreCase(dados.Audiobooks.get(i).getTitulo())) {
					index = i;
					break;
				}
			}
		return index;
	}
	/**
	 * Obtém o titulo do book
	 * @param index indice que indica o local do book na arraylist
	 * @param op opção 1 para ebook e 2 para audiobook
	 * @return String que caracteriza o titulo
	 */
	public String getTitulo(int index, int op) {
		String titulo;
		if(op == 1) {
			titulo = dados.Ebooks.get(index).getTitulo();
		}else {
			titulo = dados.Audiobooks.get(index).getTitulo();
		}
		
		return titulo;
	}
	/**
	 * Obtém o sinopse do produto
	 * @param index indice que indica o local do book na arraylist
	 * @param op opção 1 para ebook e 2 para audiobook
	 * @return String que caracteriza a sinopse
	 */
	public String getSinopse(int index, int op) {
		String sinopse;
		if(op == 1) {
			sinopse = dados.Ebooks.get(index).getSinopse();
		}else {
			sinopse = dados.Audiobooks.get(index).getSinopse();
		}
		return sinopse;
	}
	/**
	 * Obtém o valor do produto
	 * @param index indice que indica o local do book na arraylist
	 * @param op opção 1 para ebook e 2 para audiobook
	 * @return Float que caracteriza valor 
	 */
	public Float getValor(int index, int op) {
		Float valor;
		if(op == 1) {
			valor = dados.Ebooks.get(index).getValor();
		}else {
			valor = dados.Audiobooks.get(index).getValor();
		}
		return valor;
	}
	/**
	 * obtém o minutos do audiobook
	 * @param index indice que indica o local do book na arraylist
	 * @return Float que caracteriza minutos 
	 */
	public int getMinutosAudio(int index) {
		int minutosAudio;
		minutosAudio = dados.Audiobooks.get(index).getMinutosAudio();
		return minutosAudio;
	}
	/**
	 * Obtém a voz (mas ou fem)
	 * @param index indice que indica o local do book na arraylist 
	 * @return um String caracterizando a voz
	 */
	public String getVoz(int index) {
		String voz;
		voz = dados.Audiobooks.get(index).getVoz();
		return voz;
	}
	 /**
 	  * Obtém os generos 
 	  * @param index indice que indica o local do book na arraylist
 	  * @return String que caracteriza os generos
 	  */
	public String getGenero(int index) {
		String genero;
		genero = dados.Ebooks.get(index).getGenero();
		return genero;
	}
	
	/**
	 * Configura o ebook
	 * @param e ebook com os dados a ser caracterizado
	 * @param i indice que indica o local do book na arraylist
	 */
	public void editarEbook(Ebook e, int i){
		dados.Ebooks.set(i, e);
	}
	/**
	 * Configura o Audiobook 
	 * @param a Audiobook com os dados a ser caracterizado
	 * @param i indice que indica o local do produto na arraylist
	 */
	public void editarAudiobook(Audiobook a, int i){
		dados.Audiobooks.set(i, a);
	}
	
	/**
	 * Adiciona um novo ebook na arraylist
	 * @param e ebook a ser adicionado 
	 */
	public void criarEbook(Ebook e) {
		dados.Ebooks.add(e);
	}
	/**
	 * Adiciona um novo audiobook na arraylist
	 * @param a audiobook a ser adicionado
	 */
	public void criarAudiobook (Audiobook a) {
		dados.Audiobooks.add(a);
	}
	/**
	 * Exclui o ebook da arraylist 
	 * @param index indice que indica o local do book na arraylist
	 */
	public void excluirEbook(int index) {
		dados.Ebooks.remove(index);
	}
	/**
	 * Exclui o audiobook da arraylist 
	 * @param index indice que indica o local do book na arraylist
	 */
	public void excluirAudiobook(int index) {
		dados.Audiobooks.remove(index);
	}
}