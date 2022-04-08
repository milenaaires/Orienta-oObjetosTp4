package modelo;

/**
 * Implementa o modelo do objeto Audiobook, herda atributos e metodos da classe pai(abstrata) Book
 * @author Milena Aires
 * @version 2.0
 */
public class Audiobook extends Book {

    private String voz;
    private int minutosAudio;
    
    /**
     * Construtor Audiobook
     * @param titulo o titulo do Audiobook
     * @param sinopse a sinopse do Audiobook 
     * @param autor o autor do Audiobook
     * @param valor o valor do Audiobook em reais
     * @param minutosAudio o minutosAudio do Audiobook em minutos
     */
	public Audiobook (String titulo, String sinopse, String voz, Float valor, int minutosAudio){
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.voz = voz;
		this.valor = valor;
		this.minutosAudio = minutosAudio;
	}
	/**
	 * Construtor Audiobook sem argumentos
	 */
	public Audiobook (){
		
	}
	
    //----------Gets and Sets------------
	/**
	 * Obtém a voz 
	 * @return uma String especificando a voz
	 */
	
    public String getVoz() {
		return this.voz;
	}
    
    /**
     * Caracteriza a voz
     * @param voz a voz a ser caracterizada
     */
    
    public void setVoz(String voz) {
		this.voz = voz;
	}
    
    /**
     * Obtém os minutosAudio
     * @return um int que caracteriza os minutosAudio
     */
    
    public int getMinutosAudio() {
		return this.minutosAudio;
	}
    
   /**
    * Caracteriza os minutosAudio
    * @param segundosAudio um int com os minutosAudio a ser caracterizado
    */
    
    public void setMinutosAudio(int minutosAudio) {
		this.minutosAudio = minutosAudio;
	}
    
    /**
     * Obtém a sinopse
     * @return um String que caracteriza a sinopse 
     */
    
	public String getSinopse() {
		return this.sinopse;
	}
	
	/**
	 * Caracteriza a sinopse
	 * @param sinopse String que recebe a sinopse a ser caracterizada
	 */
	
    public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
    
    /**
     * Obtém o valor 
     * @return um float que caracteriza o valor
     */
    
    public Float getValor() {
		return this.valor;
	}
    
    /**
     * Caracteriza o valor
     * @param valor Float que caracteriza o valor
     */
    
    public void setValor(Float valor) {
		this.valor = valor;
	}
}