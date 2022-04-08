package view;

import java.awt.*;
import javax.swing.*;
import controle.ControleBooks;
/**
 * Modela a janela que mostra os books e alternativas
 * @author Milena Aires
 *
 */
public class TelaBooks {
	private  JFrame menuBooks = new JFrame("Books");
	private  JLabel titulo = new JLabel ("Books");
	private  JButton ebook =  new JButton("Ebook");
	private  JButton audiobook = new JButton("Audiobook");
	private  ControleBooks cbooks;
	/**
	 * construtor TelaBooks, constroi a janela de books
	 * @param cbooks classe de controle que manuseia os dados de books 
	 */
	public TelaBooks(ControleBooks cbooks) {
		this.cbooks = cbooks;

		menuBooks.setSize(400, 350);
		menuBooks.setResizable(false);
		menuBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuBooks.setLocationRelativeTo(null);
		menuBooks.setVisible(true);
		menuBooks.setLayout(null);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(155, 10, 150, 30);
		ebook.setBounds(125, 50, 140, 30);
		ebook.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		audiobook.setBounds(125, 100, 140, 30);
		audiobook.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		menuBooks.add(titulo);
		menuBooks.add(ebook);
		menuBooks.add(audiobook);

		ebook.addActionListener(f->{			
			JanelaEbook();					
		});
		audiobook.addActionListener(e->{
			JanelaAudiobook();
		});
	}
	/**
	 * Caracteriza o JFrame 
	 * @param f JFrame a ser caracterizado
	 */
	public void sets(JFrame f) {//configuracao padrao da janela
		f.setSize(400, 350);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		f.setLayout(new BorderLayout());
	}
	/**
	 * Constroi a janela de ebooks(informações e opções)
	 */
	public void JanelaEbook() {
		JPanel legenda = new JPanel();
		legenda.setLayout(new BorderLayout());
		JLabel legendaTexto = new JLabel("Titulo/Sinopse");
		legenda.add(legendaTexto, BorderLayout.WEST);
		JFrame detalheBook = new JFrame();
		sets(detalheBook);
		JList<Object> listaEbook = new JList<Object>(cbooks.getTitulosEbook());//chama a funcao que passa os titulos dos ebooks
		JScrollPane scrollEbook = new JScrollPane(listaEbook);
		listaEbook.setFixedCellHeight(30);
		listaEbook.setFixedCellWidth(385);// tamanho da lista
		detalheBook.add(scrollEbook, BorderLayout.WEST);
		detalheBook.add(legenda, BorderLayout.NORTH);
		JButton novo = new JButton("Novo");
		JButton pesquisar = new JButton("Pesquisar");
		JPanel panelBaixo = new JPanel();
		
		panelBaixo.setLayout(new FlowLayout());
		panelBaixo.add(novo);
		panelBaixo.add(pesquisar);
		detalheBook.add(panelBaixo, BorderLayout.SOUTH);

		novo.addActionListener(g->{
			detalheBook.dispose();
			new TelaDetalheBook().criarEbook(cbooks);
			menuBooks.dispose();
		});
		pesquisar.addActionListener(g->{
			JanelaPesquisaEbook();
		});
		listaEbook.addListSelectionListener( g ->{
			if(!g.getValueIsAdjusting()) {//evita que o evento ocorra masi de uma vez
				detalheBook.dispose();
				menuBooks.dispose();
				new TelaDetalheBook(cbooks, 1, listaEbook.getSelectedIndex());
				
			}
		});
	}
	/**
	 * Constroi a janela de audiobooks(info e opcoes)
	 */
	public void JanelaAudiobook(){
		JPanel legenda2 = new JPanel();
		legenda2.setLayout(new BorderLayout());
		JLabel legendaTexto2 = new JLabel("Titulo/Sinopse");
		legenda2.add(legendaTexto2, BorderLayout.WEST);
		JFrame detalheAudiobook = new JFrame();
		sets(detalheAudiobook);
		JList<Object> listaAudiobook = new JList<Object>(cbooks.getTitulosAudiobook());//chama a funcao que passa os titulos dos audiobooks
		JScrollPane scrollAudiobook = new JScrollPane(listaAudiobook);
		listaAudiobook.setFixedCellHeight(30);
		listaAudiobook.setFixedCellWidth(385);
		JButton novo = new JButton("Novo");
		JButton pesquisar = new JButton("Pesquisar");
		JPanel panelBaixo = new JPanel();
		panelBaixo.setLayout(new FlowLayout());
		
		panelBaixo.add(novo);
		panelBaixo.add(pesquisar);
		detalheAudiobook.add(panelBaixo, BorderLayout.SOUTH);
		detalheAudiobook.add(scrollAudiobook, BorderLayout.WEST);
		detalheAudiobook.add(legenda2, BorderLayout.NORTH);
		

		novo.addActionListener(g->{
			detalheAudiobook.dispose();
			new TelaDetalheBook().criarAudiobook(cbooks);
			menuBooks.dispose();
		});
		pesquisar.addActionListener(g->{
			JanelaPesquisaAudiobook();
		});
		listaAudiobook.addListSelectionListener( g ->{
			if(!g.getValueIsAdjusting()) {//evita que o evento mais de uma vez
				detalheAudiobook.dispose();
				menuBooks.dispose();
				new TelaDetalheBook(cbooks, 2, listaAudiobook.getSelectedIndex());
			}
		});
	}
	/**
	 * controi a janela da função de pesquisa sobre ebooks
	 */
	public void JanelaPesquisaEbook() {
		JFrame janelaPesquisa = new JFrame();
		JTextField nomePesquisa = new JTextField("");
		JLabel nome = new JLabel("Titulo: ");
		sets(janelaPesquisa);
		janelaPesquisa.setLayout(null);
		JLabel legenda = new JLabel("Escreva o titulo do ebook que deseja: ");
		legenda.setFont(new Font("Arial", Font.BOLD, 15));
		JButton ok = new JButton("Ok");
		legenda.setBounds(0, 0, 350, 30);
		nomePesquisa.setBounds(100, 70, 200, 30);
		nome.setBounds(30, 70, 200, 30);
		ok.setBounds(310, 70, 50, 30);
		janelaPesquisa.add(legenda);
		janelaPesquisa.add(nomePesquisa);
		janelaPesquisa.add(nome);
		janelaPesquisa.add(ok);
		ok.addActionListener(j ->{
			if(cbooks.pesquisarTitulosEbook (nomePesquisa.getText()) != -1) {
				new TelaDetalheBook(cbooks, 1, cbooks.pesquisarTitulosEbook(nomePesquisa.getText()));
				janelaPesquisa.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "O Ebook não foi encontrado", "Pesquisa", JOptionPane.CLOSED_OPTION);
				janelaPesquisa.dispose();
			}	
		});
	}
	/**
	 * controi a janela da função de pesquisa audiobooks
	 */
	public void JanelaPesquisaAudiobook() {
		JFrame janelaPesquisa = new JFrame();
		JTextField nomePesquisa = new JTextField("");
		JLabel nome = new JLabel("Titulo: ");
		sets(janelaPesquisa);
		janelaPesquisa.setLayout(null);
		JLabel legenda = new JLabel("Escreva o nome do Audiobook que deseja: ");
		legenda.setFont(new Font("Arial", Font.BOLD, 15));
		JButton ok = new JButton("Ok");
		legenda.setBounds(0, 0, 350, 30);
		nomePesquisa.setBounds(100, 70, 200, 30);
		nome.setBounds(30, 70, 200, 30);
		ok.setBounds(310, 70, 50, 30);
		janelaPesquisa.add(legenda);
		janelaPesquisa.add(nomePesquisa);
		janelaPesquisa.add(nome);
		janelaPesquisa.add(ok);
		ok.addActionListener(j ->{
			if(cbooks.pesquisarTitulosAudiobook(nomePesquisa.getText()) != -1) {
				new TelaDetalheBook(cbooks, 2, cbooks.pesquisarTitulosAudiobook(nomePesquisa.getText()));
				janelaPesquisa.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "O Audiobook não foi encontrado", "Pesquisa", JOptionPane.CLOSED_OPTION);
				janelaPesquisa.dispose();
			}	
		});
	}
}


