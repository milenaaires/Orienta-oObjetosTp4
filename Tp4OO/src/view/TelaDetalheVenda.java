package view;



import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.*;
/**
 * Modela a janela de detalhes do objeto venda
 * @author Milena Aires
 *
 */
public class TelaDetalheVenda {
	private static ControleClientes cclientes;
	private static ControleVendas cvendas;
	private static Valida valida = new Valida();
	/**
	 * Construtor TelaDetalheVenda, recebe como argumento os objetos de manuseio de dados 
	 * @param cvendas
	 * @param cclientes
	 */
	public TelaDetalheVenda(ControleVendas cvendas, ControleClientes cclientes) {
		this.cvendas = cvendas;
		this.cclientes = cclientes;
	}
	/**
	 * modela a janela que mostra todos os dados dos clientes
	 */
	public void listarClientes() { //Funcao para listar os clientes e suas vendas na aba de Listar Vendas
		//Definicao dos elementos graficos
		JFrame janela = new JFrame("Lista de Clientes");
		JLabel legenda = new JLabel("Nome / CPF (Selecione o cliente desejado)");
		JList<Object> lista = new JList<Object>(cvendas.getVendas());
		JPanel botoes = new JPanel();
		JPanel subPanel = new JPanel();
		JButton voltar = new JButton("Voltar");
		JButton refresh = new JButton("Refresh");
		
		//Estiliza os elementos
		botoes.setLayout(new BorderLayout());
		subPanel.add(voltar);
		subPanel.add(refresh);		
		botoes.add(subPanel, BorderLayout.EAST);
		janela.add(legenda, BorderLayout.NORTH);
		janela.add(lista, BorderLayout.CENTER);
		janela.add(botoes, BorderLayout.SOUTH);
		sets(janela);
		
		//Adicionar eventos aos botoes
		voltar.addActionListener(a -> janela.dispose());
		refresh.addActionListener(b -> {
			janela.dispose();
			listarClientes();
		});
		
		//Evento ao clicar na opcao da lista
		lista.addListSelectionListener(c -> {
			if(!c.getValueIsAdjusting()) {
				editaVenda(lista.getSelectedIndex());
			}
		});
	}
	/**
	 * Modela a janela que implementa a funcionalidade de edicao de clientes
	 * @param index indice que indica o cliente a ser editado
	 */
	public void editaVenda(int index) { //Funcao de editar/excluir os dados de uma venda
		//Criar os elementos graficos
		JFrame menu = new JFrame("Cadastrar Venda");
		JLabel ebook = new JLabel("Ebook: ");
		JLabel audioMasc = new JLabel("AudioMasc: ");
		JLabel audioFem = new JLabel("AudioFem: ");
		JTextField textEbook = new JTextField(cvendas.getEbook(index));
		JTextField textAudioMasc = new JTextField(cvendas.getAudioMasc(index));
		JTextField textAudioFem = new JTextField(cvendas.getAudioFem(index));
		JButton save = new JButton("Salvar");
		JButton excluir = new JButton("Excluir");
		
		//Estilizar elementos
		textEbook.setBounds(130,5,165,30);
		textAudioMasc.setBounds(130,40,165,30);
		textAudioFem.setBounds(130,75,165,30);
		ebook.setFont(new Font("Arial", Font.BOLD, 20));
		ebook.setBounds(10, 5, 165, 30);
		audioMasc.setFont(new Font("Arial", Font.BOLD, 20));
		audioMasc.setBounds(10, 40, 165, 30);
		audioFem.setFont(new Font("Arial", Font.BOLD, 20));
		audioFem.setBounds(10, 75, 165, 30);
		save.setBounds(40, 115, 80, 20);
		excluir.setBounds(180, 115, 80, 20);

		//Adicionar tudo ao JFrame
		menu.add(save);
		menu.add(excluir);
		menu.add(textEbook);
		menu.add(textAudioMasc);
		menu.add(textAudioFem);
		menu.add(ebook);
		menu.add(audioMasc);
		menu.add(audioFem);
		menu.setLayout(null);
		menu.setSize(320, 180);
		menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setResizable(false);
        
		//Eventos dos botoes
        save.addActionListener(a -> {
        	if(textEbook.getText().isEmpty() || textAudioMasc.getText().isEmpty() || textAudioFem.getText().isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Os campos nao podem estar em branco");
        	}else{
				if(valida.validaFloat(textEbook.getText()) || valida.validaFloat(textAudioMasc.getText()) || valida.validaFloat(textAudioFem.getText())){
					if(valida.validaVenda(Integer.parseInt(textEbook.getText()), Integer.parseInt(textAudioMasc.getText()), Integer.parseInt(textAudioFem.getText()))) {
						cvendas.editVenda(index, Integer.parseInt(textEbook.getText()), Integer.parseInt(textAudioMasc.getText()), Integer.parseInt(textAudioFem.getText()));
						menu.dispose();
						JOptionPane.showMessageDialog(null, "Venda Editada");
					}else {
						JOptionPane.showMessageDialog(null, "Dados de venda invalidos \n Coloque valores positivos");
					} 
				}else{
					JOptionPane.showMessageDialog(null, "Dados invalidos, insira numeros");
				}
        		     
        	}
        });

		excluir.addActionListener(a -> {
			cvendas.remVenda(index, Integer.parseInt(textEbook.getText()), Integer.parseInt(textAudioMasc.getText()), Integer.parseInt(textAudioFem.getText()));
			menu.dispose();
			JOptionPane.showMessageDialog(null, "Venda Excluida");
		});
	}
	/**
	 * Modela a janela para listar clientes para cadastrar uma nova venda
	 */
	public void cadastroVenda() { //Funcao listar clientes para cadastrar uma nova venda
		//Criar elementos
		JFrame janela = new JFrame("Lista de Clientes");
		JLabel legenda = new JLabel("Nome / CPF (Selecione o cliente desejado)");
		JList<Object> lista = new JList<Object>(cclientes.getNomesClientes());
		JPanel botoes = new JPanel();
		JPanel subPanel = new JPanel();
		JButton voltar = new JButton("Voltar");
		JButton refresh = new JButton("Refresh");
		
		//Estilizar elementos
		botoes.setLayout(new BorderLayout());
		subPanel.add(voltar);
		subPanel.add(refresh);		
		botoes.add(subPanel, BorderLayout.EAST);
		janela.add(legenda, BorderLayout.NORTH);
		janela.add(lista, BorderLayout.CENTER);
		janela.add(botoes, BorderLayout.SOUTH);
		sets(janela);
		
		//Eventos dos botoes
		voltar.addActionListener(a -> janela.dispose());
		refresh.addActionListener(b -> {
			janela.dispose();
			cadastroVenda();
		});
		
		lista.addListSelectionListener(c -> {
			if(!c.getValueIsAdjusting()) {
				janelaCadastro(lista.getSelectedIndex());
			}
		});
	}
	/**
	 * Modela a Janela de cadastro de cliente
	 * @param index indice
	 */
	public void janelaCadastro(int index) { //Janela de cadastro de cliente
		//Criar elementos novos
		JFrame menu = new JFrame("Cadastrar Venda");
		JLabel ebook = new JLabel("Ebook: ");
		JLabel audioMasc = new JLabel("AudioMasc: ");
		JLabel audioFem = new JLabel("AudioFem: ");
		JTextField textEbook = new JTextField();
		JTextField textAudioMasc = new JTextField();
		JTextField textAudioFem = new JTextField();
		JButton save = new JButton("Salvar");
		
		//Estilizar Elementos
		textEbook.setBounds(130,5,165,30);
		textAudioMasc.setBounds(130,40,165,30);
		textAudioFem.setBounds(130,75,165,30);
		ebook.setFont(new Font("Arial", Font.BOLD, 20));
		ebook.setBounds(10, 5, 165, 30);
		audioMasc.setFont(new Font("Arial", Font.BOLD, 20));
		audioMasc.setBounds(10, 40, 165, 30);
		audioFem.setFont(new Font("Arial", Font.BOLD, 20));
		audioFem.setBounds(10, 75, 165, 30);
		save.setBounds(110, 115, 80, 20);

		//Adicionar tudo ao JFrame
		menu.add(save);
		menu.add(textEbook);
		menu.add(textAudioMasc);
		menu.add(textAudioFem);
		menu.add(ebook);
		menu.add(audioMasc);
		menu.add(audioFem);
		menu.setLayout(null);
		menu.setSize(320, 180);
		menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setResizable(false);
        
		//Evento aos botoes
        save.addActionListener(a -> {
        	if(textEbook.getText().isEmpty() || textAudioMasc.getText().isEmpty() || textAudioFem.getText().isEmpty()) {
        		JOptionPane.showMessageDialog(null, "Os campos nao podem estar em branco");
        	}else{
				if(valida.validaFloat(textEbook.getText()) || valida.validaFloat(textAudioMasc.getText()) || valida.validaFloat(textAudioFem.getText())){
					if(valida.validaVenda(Integer.parseInt(textEbook.getText()), Integer.parseInt(textAudioMasc.getText()), Integer.parseInt(textAudioFem.getText()))) {
						cvendas.setVenda(index, Integer.parseInt(textEbook.getText()), Integer.parseInt(textAudioMasc.getText()), Integer.parseInt(textAudioFem.getText()));
						menu.dispose();
						JOptionPane.showMessageDialog(null, "Venda Cadastrada");
					} else {
						JOptionPane.showMessageDialog(null, "Dados de venda invalidos \n Coloque valores positivos");
					} 
				}else{
					JOptionPane.showMessageDialog(null, "Dados invalidos, insira numeros");
				}
        		
        	}
        });
	}
	/**
	 * Caracteriza o JFrame 
	 * @param f JFrame a ser caracterizado
	 */
	public void sets(JFrame f) { //Padronizar o estilo dos JFrames primarios
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	} 
}
