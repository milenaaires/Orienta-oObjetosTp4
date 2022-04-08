package modelo;

/**
 * Implementa o modelo do objeto Ebook, herda atributos e metodos da classe pai(abstrata) Book
 * @author Milena Aires
 *
 */
public class Ebook extends Book {
	private String genero;
	
	/**
	 * Construtor Ebook
	 * @param titulo titulo do ebook
	 * @param sinopse sinopse do ebook
	 * @param genero genero do ebook
	 * @param valor valor do ebook
	 */
	 public Ebook (String titulo, String sinopse, String genero, Float valor){
		 this.titulo = titulo;
	     this.sinopse = sinopse;
	     this.valor = valor;
	     this.genero = genero;
	
	 }
	 /**
	  * Construtor Ebook sem argumentos
	  */
	 public Ebook(){
	   
	 }
	
     //----------Gets and Sets------------
  
  	 /**
  	  * Obtém o genero 
  	  * @return String que caracteriza o genero 
  	  */
     public String getGenero() {
		 return this.genero;
	 }
     
     /**
      * Configura a String genero 
      * @param genero string com o genero a ser caracterizado 
      */
     
     public void setGenero(String genero) {
	 	this.genero = genero;
	 }
     
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
     
     public void setTitulo (String titulo) {
		this.titulo = titulo;
	 }
     
     /**
      * Obtém a sinopse
      * @return String que especifica a sinopse
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
      * caracteriza o Float valor 
      * @param valor Float com o valor a ser caracterizado 
      */
     public void setValor(Float valor) {
		this.valor = valor;
	 }
}