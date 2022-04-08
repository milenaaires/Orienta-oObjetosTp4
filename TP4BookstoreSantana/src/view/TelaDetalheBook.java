package view;

import java.awt.*;
import javax.swing.*;
import controle.*;
import modelo.*;
/**
 * Manuseia a janela que mostra os detalhes do book
 * @author Milena Aires
 *
 */
public class TelaDetalheBook {
	private static Font padrao = new Font("Arial", Font.BOLD, 20);
	private static Valida valida = new Valida();
	/**
	 * Construtor TelaDetalheBook sem argumentos
	 */
	public TelaDetalheBook() {
		
	}
	/**
	 * Construtor TelaDetalheBook
	 * @param cbooks manipula os dados de books
	 * @param op opcao 1 para ebook e 2 para audiobook
	 * @param index indice que mostra o local do book na arraylist
	 */
	public TelaDetalheBook (ControleBooks cbooks, int op, int index){
		switch (op){
			case 1:
				JFrame detalheEbook = new JFrame("Ebook");//mostra os detalhes do ebook
				sets(detalheEbook);//chama a funcao que caracteriza o JFrame
				Ebook bufferEbook = new Ebook();//Variavel que guardar os dados do ebook 
				JTextField tituloEbookField = new JTextField(cbooks.getTitulo(index, op));
				JLabel tituloEbookLabel = new JLabel("Titulo: ");
				tituloEbookLabel.setFont(padrao);
				JTextField generoEbookField = new JTextField(cbooks.getGenero(index));
				JLabel generoEbookLabel = new JLabel("Genero: ");
				generoEbookLabel.setFont(padrao);
				JTextField valorEbookField = new JTextField("" + cbooks.getValor(index, op));
				JLabel valorEbookLabel = new JLabel("Valor: ");
				valorEbookLabel.setFont(padrao);
				JTextArea sinopseEbookField = new JTextArea(cbooks.getSinopse(index,op));
				JLabel sinopseEbookLabel = new JLabel("Sinopse: ");
				JButton salvar = new JButton("Salvar");
				JButton excluir = new JButton("Excluir");

				sinopseEbookLabel.setFont(padrao);
				tituloEbookField.setBounds(150, 30, 200, 30);
				tituloEbookLabel.setBounds(20, 30, 200, 30);
				generoEbookField.setBounds(150,70, 200, 30);
				generoEbookLabel.setBounds(20, 70, 200, 30);
				valorEbookField.setBounds(150, 110, 200, 30);
				valorEbookLabel.setBounds(20, 110, 200, 30);
				sinopseEbookField.setBounds(150, 150, 200, 90);
				sinopseEbookLabel.setBounds(20, 150, 200, 30);
				salvar.setBounds(190, 270, 80, 30);
				excluir.setBounds(280, 270, 80, 30);

				detalheEbook.add(tituloEbookField);
				detalheEbook.add(sinopseEbookField);
				detalheEbook.add(valorEbookField);
				detalheEbook.add(generoEbookField);
				detalheEbook.add(tituloEbookLabel);
				detalheEbook.add(sinopseEbookLabel);
				detalheEbook.add(valorEbookLabel);
				detalheEbook.add(generoEbookLabel);
				detalheEbook.add(salvar);
				detalheEbook.add(excluir);

				salvar.addActionListener(e -> {
					if(tituloEbookField.getText().isEmpty() || sinopseEbookField.getText().isEmpty() || valorEbookField.getText().isEmpty() || generoEbookField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Dados do Book invalidos, Nao deve haver lugar em branco");
					}else {
						if(valida.validaFloat(valorEbookField.getText())){
							if(valida.validaEbook(Float.parseFloat(valorEbookField.getText()))) {
								bufferEbook.setTitulo(tituloEbookField.getText());
								bufferEbook.setSinopse(sinopseEbookField.getText());
								bufferEbook.setValor(Float.parseFloat(valorEbookField.getText()));
								bufferEbook.setGenero(generoEbookField.getText());
								cbooks.editarEbook(bufferEbook, index);//chama a funcao que edita o ebook
								JOptionPane.showMessageDialog(null, "O Cadastro foi feito!", "Cadastro", JOptionPane.CLOSED_OPTION);
								detalheEbook.dispose();//fecha a janela 
								new TelaBooks(cbooks).JanelaEbook();//chama uma nova tela com a lista de books
							}else {
								JOptionPane.showMessageDialog(null, "Dados do book invalidos, digite um valor positivo");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Dados do book invalidos, digite numeros");
						}							
					}
				});

				excluir.addActionListener(e->{
					Object[] options = { "Excluir", "Cancelar" };
					int resposta= JOptionPane.showOptionDialog( null, "Deseja deletar?","Confirma",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1] );
		            if(resposta == JOptionPane.YES_OPTION){
		            	cbooks.excluirEbook(index);//chama a funcaoo que exclui o ebook
						detalheEbook.dispose();
						new TelaBooks(cbooks).JanelaEbook();//chama uma nova tela lista de books
		            }
					
				});
				
				break;
			case 2:
				JFrame detalheAudiobook = new JFrame("Audiobook");
				sets(detalheAudiobook);
				Audiobook bufferAudiobook = new Audiobook();

				JTextField tituloAudiobookField = new JTextField(cbooks.getTitulo(index, op));
				JLabel tituloAudiobookLabel = new JLabel("Titulo: ");
				tituloAudiobookLabel.setFont(padrao);

				JTextField sinopseAudiobookField = new JTextField(cbooks.getSinopse(index, op));
				JLabel sinopseAudiobookLabel = new JLabel("Sinopse: ");
				sinopseAudiobookLabel.setFont(padrao);

				JTextField vozAudiobookField = new JTextField(cbooks.getVoz(index));
				JLabel vozAudiobookLabel = new JLabel("Voz: " );
				vozAudiobookLabel.setFont(padrao);

				JTextField valorAudiobookField = new JTextField("" + cbooks.getValor(index, op));
				JLabel valorAudiobookLabel = new JLabel("Valor: ");
				valorAudiobookLabel.setFont(padrao);

				JTextField minutosAudioAudiobookField = new JTextField("" + cbooks.getMinutosAudio(index));
				JLabel minutosAudioAudiobookLabel = new JLabel("Minutos Audio: ");
				JButton salvar1 = new JButton("Salvar");
				JButton excluir1 = new JButton("Excluir");

				minutosAudioAudiobookLabel.setFont(padrao);
				tituloAudiobookField.setBounds(150, 30, 200, 30);
				tituloAudiobookLabel.setBounds(20, 30, 200, 30);
				sinopseAudiobookField.setBounds(150,70, 200, 30);
				sinopseAudiobookLabel.setBounds(20, 70, 200, 30);
				vozAudiobookField.setBounds(150,110, 200, 30);
				vozAudiobookLabel.setBounds(20,110, 200, 30);	
				valorAudiobookField.setBounds(150, 150, 200, 30);
				valorAudiobookLabel.setBounds(20, 150, 200, 30);
				minutosAudioAudiobookField.setBounds(150, 190, 200, 30);
				minutosAudioAudiobookLabel.setBounds(20, 190, 200, 30);
				salvar1.setBounds(190, 270, 80, 30);
				excluir1.setBounds(280, 270, 80, 30);

				detalheAudiobook.add(tituloAudiobookField);
				detalheAudiobook.add(sinopseAudiobookField);
				detalheAudiobook.add(valorAudiobookField);
				detalheAudiobook.add(minutosAudioAudiobookField);
				detalheAudiobook.add(vozAudiobookField);
				detalheAudiobook.add(tituloAudiobookLabel);
				detalheAudiobook.add(sinopseAudiobookLabel);
				detalheAudiobook.add(valorAudiobookLabel);
				detalheAudiobook.add(minutosAudioAudiobookLabel);
				detalheAudiobook.add(vozAudiobookLabel);
				detalheAudiobook.add(salvar1);
				detalheAudiobook.add(excluir1);
				
				salvar1.addActionListener(e -> {
					if(valorAudiobookField.getText().isEmpty() || minutosAudioAudiobookField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Dados do book invalidos, Nao deve haver campos em branco");
					}else{
						if(valida.validaFloat(valorAudiobookField.getText()) && valida.validaFloat(minutosAudioAudiobookField.getText())){
							if(valida.validaAudiobook(Float.parseFloat(valorAudiobookField.getText()), Integer.parseInt(minutosAudioAudiobookField.getText()))) {
								bufferAudiobook.setTitulo(tituloAudiobookField.getText());
								bufferAudiobook.setSinopse(sinopseAudiobookField.getText());
								bufferAudiobook.setVoz(vozAudiobookField.getText());
								bufferAudiobook.setValor(Float.parseFloat(valorAudiobookField.getText()));
								bufferAudiobook.setMinutosAudio(Integer.parseInt(minutosAudioAudiobookField.getText()));
								cbooks.editarAudiobook(bufferAudiobook, index);
								JOptionPane.showMessageDialog(null, "O Cadastro foi salvo com sucesso!", "Cadastro", JOptionPane.CLOSED_OPTION);
								detalheAudiobook.dispose();
								new TelaBooks(cbooks).JanelaAudiobook();
							}else {
								JOptionPane.showMessageDialog(null, "Dados do book invalidos, digite um valor e positivos");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Dados do book invalidos, Digite numeros");
						}
						
					}
				});
				
				excluir1.addActionListener(e->{
					Object[] options = { "Excluir", "Cancelar" };
					int resposta= JOptionPane.showOptionDialog( null, "Deseja excluir?","Confirma",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1] );
		            if(resposta == JOptionPane.YES_OPTION){
		            	cbooks.excluirAudiobook(index);
						detalheAudiobook.dispose();
					new TelaBooks(cbooks).JanelaAudiobook();
		            }
				});
		}
	}
	/**
	 * Caracteriza o JFrame 
	 * @param f JFrame a ser caracterizado
	 */
	public void sets(JFrame f) {
		f.setSize(400, 350);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		f.setLayout(null);
	}
	/**
	 * Modela a janela que recebe o cadastro de um novo ebook
	 * @param cbooks objeto que manuseia os dados de book
	 * @return Objeto ebook que sera cadastrado
	 */
	public Ebook criarEbook(ControleBooks cbooks) {
		Ebook novoEbook = new Ebook();
		JFrame detalheEbook = new JFrame("Ebook");
		sets(detalheEbook);
		Ebook bufferEbook = new Ebook();

		JTextField tituloEbookField = new JTextField();
		JLabel tituloEbookLabel = new JLabel("Titulo:");
		tituloEbookLabel.setFont(padrao);

		JTextField generoEbookField = new JTextField();
		JLabel generoEbookLabel = new JLabel("Genero: ");
		generoEbookLabel.setFont(padrao);

		JTextField valorEbookField = new JTextField();
		JLabel valorEbookLabel = new JLabel("Valor");
		valorEbookLabel.setFont(padrao);

		JTextArea sinopseEbookField = new JTextArea();
		JLabel sinopseEbookLabel = new JLabel("Sinopse: ");
		JButton salvar = new JButton("Salvar");
		
		sinopseEbookLabel.setFont(padrao);
		tituloEbookField.setBounds(150, 30, 200, 30);
		tituloEbookLabel.setBounds(20, 30, 200, 30);
		generoEbookField.setBounds(150,70, 200, 30);
		generoEbookLabel.setBounds(20, 70, 200, 30);
		valorEbookField.setBounds(150, 110, 200, 30);
		valorEbookLabel.setBounds(20, 110, 200, 30);
		sinopseEbookField.setBounds(150, 150, 200, 90);
		sinopseEbookLabel.setBounds(20, 150, 200, 30);
		salvar.setBounds(220, 270, 70, 30);
		
		detalheEbook.add(tituloEbookField);
		detalheEbook.add(sinopseEbookField);
		detalheEbook.add(valorEbookField);
		detalheEbook.add(generoEbookField);
		detalheEbook.add(tituloEbookLabel);
		detalheEbook.add(sinopseEbookLabel);
		detalheEbook.add(valorEbookLabel);
		detalheEbook.add(generoEbookLabel);
		detalheEbook.add(salvar);
		
		salvar.addActionListener(e -> {
			if(tituloEbookField.getText().isEmpty() || sinopseEbookField.getText().isEmpty() || valorEbookField.getText().isEmpty() || generoEbookField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Dados do book invalidos, Não deve haver campos em branco");
			}else {
				if(valida.validaFloat(valorEbookField.getText())){
					if(valida.validaEbook(Float.parseFloat(valorEbookField.getText()))) {
						novoEbook.setTitulo(tituloEbookField.getText());
						novoEbook.setSinopse(sinopseEbookField.getText());
						novoEbook.setValor(Float.parseFloat(valorEbookField.getText()));
						novoEbook.setGenero(generoEbookField.getText());
						System.out.print(bufferEbook.toString());
						cbooks.criarEbook(novoEbook);
						detalheEbook.dispose();
						new TelaBooks(cbooks).JanelaEbook();
					}else {
						JOptionPane.showMessageDialog(null, "Dados do book invalidos, digite um valor positivo");
					}					
				}else{
					JOptionPane.showMessageDialog(null, "Dados do book invalidos, Digite numeros");
				}				
			}			
		});
		return novoEbook;
	}
	/**
	 * Modela a janela que recebe os dados para cadastro de um novo cliente
	 * @param cprodutos manuseia os dados de books
	 * @return o objeto Audiobook sera cadastrado
	 */
	public Audiobook criarAudiobook(ControleBooks cbooks) {
		Audiobook novoAudiobook = new Audiobook();
		JFrame detalheAudiobook = new JFrame("Audiobook");
		sets(detalheAudiobook);
		Audiobook bufferAudiobook = new Audiobook();
		JTextField tituloAudiobookField = new JTextField();
		JLabel tituloAudiobookLabel = new JLabel("Audiobook:");
		tituloAudiobookLabel.setFont(padrao);

		JTextField sinopseAudiobookField = new JTextField();
		JLabel sinopseAudiobookLabel = new JLabel("Sinopse: ");
		sinopseAudiobookLabel.setFont(padrao);

		JTextField vozAudiobookField = new JTextField();
		JLabel vozAudiobookLabel = new JLabel("Voz: ");
		vozAudiobookLabel.setFont(padrao);

		JTextField valorAudiobookField = new JTextField();
		JLabel valorAudiobookLabel = new JLabel("Valor: ");
		valorAudiobookLabel.setFont(padrao);

		JTextField minutosAudioAudiobookField = new JTextField();
		JLabel minutosAudioAudiobookLabel = new JLabel("Minutos Audio: ");
		JButton salvar1 = new JButton("Salvar");
		minutosAudioAudiobookLabel.setFont(padrao);

		tituloAudiobookField.setBounds(150, 30, 200, 30);
		tituloAudiobookLabel.setBounds(20, 30, 200, 30);
		
		sinopseAudiobookField.setBounds(150,70, 200, 30);
		sinopseAudiobookLabel.setBounds(20, 70, 200, 30);
		
		vozAudiobookField.setBounds(150,110, 200, 30);
		vozAudiobookLabel.setBounds(20,110, 200, 30);
		
		valorAudiobookField.setBounds(150, 150, 200, 30);
		valorAudiobookLabel.setBounds(20, 150, 200, 30);
		
		minutosAudioAudiobookField.setBounds(150, 190, 200, 30);
		minutosAudioAudiobookLabel.setBounds(20, 190, 200, 30);
		
		salvar1.setBounds(220, 230, 70, 30);
		
		detalheAudiobook.add(tituloAudiobookField);
		detalheAudiobook.add(sinopseAudiobookField);
		detalheAudiobook.add(valorAudiobookField);
		detalheAudiobook.add(minutosAudioAudiobookField);
		detalheAudiobook.add(vozAudiobookField);
		detalheAudiobook.add(tituloAudiobookLabel);
		detalheAudiobook.add(sinopseAudiobookLabel);
		detalheAudiobook.add(valorAudiobookLabel);
		detalheAudiobook.add(minutosAudioAudiobookLabel);
		
		detalheAudiobook.add(vozAudiobookLabel);
		detalheAudiobook.add(salvar1);
		
		salvar1.addActionListener(e -> {
			if(tituloAudiobookField.getText().isEmpty() || vozAudiobookField.getText().isEmpty() || sinopseAudiobookField.getText().isEmpty() || valorAudiobookField.getText().isEmpty() || minutosAudioAudiobookField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Dados do book invalidos, Nao deve haver campos em branco");
			}else{
				if(valida.validaFloat(valorAudiobookField.getText()) && valida.validaFloat(minutosAudioAudiobookField.getText())){
					if(valida.validaAudiobook(Float.parseFloat(valorAudiobookField.getText()), Integer.parseInt(minutosAudioAudiobookField.getText()))) {
						bufferAudiobook.setTitulo(tituloAudiobookField.getText());
						bufferAudiobook.setSinopse(sinopseAudiobookField.getText());
						bufferAudiobook.setVoz(vozAudiobookField.getText());
						bufferAudiobook.setValor(Float.parseFloat(valorAudiobookField.getText()));
						bufferAudiobook.setMinutosAudio(Integer.parseInt(minutosAudioAudiobookField.getText()));
						System.out.print(bufferAudiobook.toString());
						cbooks.criarAudiobook(bufferAudiobook);
						detalheAudiobook.dispose();
						new TelaBooks(cbooks).JanelaAudiobook();
					}else {
						JOptionPane.showMessageDialog(null, "Dados do book invalidos, digite um valor e minutos positivos");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Dados do book invalidos, digite numeros");
				}
				
			}			
		});
		return novoAudiobook;
	}
}