package controle;


import java.util.ArrayList;

import modelo.*;

/**
 * Guarda todos os dados utilizados no sistema
 * @author Milena Aires
 *
 */
public class Dados {
	/**
	 * ArrayList para armazenar os audiobooks
	 */
    public ArrayList<Audiobook> Audiobooks = new ArrayList<Audiobook>();  
    /**
     * ArrayList para armazenar os ebooks
     */
    public ArrayList<Ebook> Ebooks = new ArrayList<Ebook>();
    /**
     * ArrayList para armazenar os nomes dos clientes
     */
    public ArrayList<String> nomeClientes = new ArrayList<String>();  
    /**
     * ArrayList para armazenar os CPFs dos clientes
     */
    public ArrayList<String> cpfClientes = new ArrayList<String>();      
    /**
     * ArrayList para armazenar os dados premium
     */
    public ArrayList<Premium> Premium = new ArrayList<Premium>();
    /**
     * ArrayList para armazenar a quantidade de ebooks vendidos ao cliente
     */
    public ArrayList<Integer> vendaEbooks = new ArrayList<Integer>();  
    /**
     * ArrayList para armazenar a quantidade de Audiobooks em voz masculina vendidos aos clientes
     */
    public ArrayList<Integer> vendaAudioMasc = new ArrayList<Integer>(); 
    /**
     * ArrayList para armazenar a quantidade de Audiobooks em voz feminina vendidos aos clientes
     */
    public ArrayList<Integer> vendaAudioFem = new ArrayList<Integer>();           
    /**
     * Classe para povoamento dos dados aleatorios
     */
    public Dados() {//dados pre cadastrados 
    	Premium premium = new Premium();
    	Ebook ebook1 = new Ebook("Divergente", "Na futurística cidade de Chicago, ao completar 16 anos, Beatrice precisa escolher entre as diferentes facções em que a cidade está dividida. Cada uma representa um valor diferente e, ao contrário de sua família, a jovem opta pela facção dos destemidos, a Audácia.",
    			"Ação/ Ficção Científica", 49.9f);
    	Ebooks.add(ebook1);
    	Ebook ebook2 = new Ebook("A culpa é das Estrelas", "Hazel e Augustus, adolescentes que se conhecem em um grupo de apoio para pacientes com câncer. Por causa da doença, Hazel sempre descartou a ideia de se envolver amorosamente, mas acaba cedendo ao se apaixonar por Augustus.",
          		"Romance/ Drama", 59.9f);
        Ebooks.add(ebook2);
        Audiobook audiobook1 = new Audiobook ("A vida como ela é", "Na obra, Nelson Rodrigues expõe tudo que há de pior e mais angustiante na natureza do ser humano.", 
          		"Voz Masculina", 34.9f, 42);
        Audiobooks.add(audiobook1);
        Audiobook audiobook2 = new Audiobook("O Príncipe", "Descreve estratégias que um príncipe deveria adotar para conquistar e manter o poder, foi um marco da ciência política na modernidade.",
          		"Voz Masculina", 22.9f, 240);
        Audiobooks.add(audiobook2);
        nomeClientes.add("Milena Aires ");
     	nomeClientes.add("Amanda Silva ");
     	cpfClientes.add("30998911");
     	cpfClientes.add("87641467");
     	vendaEbooks.add(5);
     	vendaAudioMasc.add(2);
     	vendaAudioFem.add(40);
     	vendaEbooks.add(3);
     	vendaAudioMasc.add(4);
     	vendaAudioFem.add(1);
     	for(int i=2; i<50; i++) {
    		vendaEbooks.add(0);
    		vendaAudioMasc.add(0);
    		vendaAudioFem.add(0);
    	}
     	for(int i=0; i<50; i++) {
     		premium.setPontos(0);
    		Premium.add(premium);
    	}
    }
}

