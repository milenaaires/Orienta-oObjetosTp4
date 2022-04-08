package modelo;

/**
 * Classe pai (abstrata) de ebook e audiobook
 * @author Milena Aires
 *
 */
public abstract class Book {
    
    protected String titulo, sinopse;
    protected Float valor;
    
    //----------Gets and Sets--------------
    /**
     * Obtém o titulo
     * @return String que caracteriza o titulo
     */
    public String getTitulo() {
		return this.titulo;
	}
    
    /**
     * Caracteriza a String titulo 
     * @param titulo string com o titulo a ser caracterizado 
     */
    
    public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    
    /**
     * Obtém a sinopse
     * @return String que caracteriza a sinopse
     */
    
    public String getSinopse() {
		return this.sinopse;
	}
    
    /**
     * Caracteriza a String sinopse 
     * @param sinopse string com a sinopse a ser caracterizada 
     */
    
    public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
    
    /**
     * Obtém o valor
     * @return Float que caracteriza o valor
     */
     public Float getValor() {
		return this.valor;
	}
     
     /**
      * Configura o Float valor 
      * @param preco Float com o valor a ser caracterizado 
      */
     
    public void setValor(Float valor) {
		this.valor = valor;
	}
}
