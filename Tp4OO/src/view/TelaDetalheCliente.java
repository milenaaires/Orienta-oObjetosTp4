package view;


import java.awt.*;
import javax.swing.*;
import controle.*;
/**
 * Modela a janela que mostra os dados de detalhe de cliente
 * @author Milena Aires
 *
 */
public class TelaDetalheCliente{
	private static ControleClientes cclientes;
	private static Valida valida = new Valida();
	/**
	 * Construtor TelaDetalheCliente
	 * @param cclientes manuseia os dados de cliente
	 */
	public TelaDetalheCliente(ControleClientes cclientes) {
		this.cclientes = cclientes;
	}
	/**
	 *  Modela a janela que recebe os dados para o cadastro de novo cliente 
	 * @param index indice que indica o local do objeto na arraylist
	 */
	public void cadastrar(int index){	//Funcao cadastrar novo cliente
		//Criar elementos
		JFrame menu = new JFrame("");
		JLabel nome = new JLabel("Nome: ");
		JLabel cpf = new JLabel("CPF: ");
		JTextField textNome = new JTextField(50);
		JTextField textCPF = new JTextField(50);
		JButton save = new JButton("Salvar");
		
		//Estilizar elementos
		textNome.setBounds(100,5,165,30);
		textCPF.setBounds(100,35,165,30);
		nome.setFont(new Font("Arial", Font.BOLD, 20));
		nome.setBounds(30, 5, 165, 30);
		cpf.setFont(new Font("Arial", Font.BOLD, 20));
		cpf.setBounds(30, 35, 165, 30);
		save.setBounds(110, 77, 80, 20);

		//Adicionar tudo ao JFrame
		menu.add(save);
		menu.add(textCPF);
		menu.add(textNome);
		menu.add(nome);
		menu.add(cpf);
		menu.setLayout(null);
		menu.setSize(300, 150);
		menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setResizable(false);
        
		//Eventos aos botoes
        save.addActionListener(a -> {
        	if(valida.validaCliente(textNome.getText(),textCPF.getText())) {
        		cclientes.addCliente(textNome.getText(), textCPF.getText());
            	menu.dispose();
        	}else {
        		JOptionPane.showMessageDialog(null, "Dados do cliente invalidos\nO nome deve ter no minimo 3 letras e o CPF 11 numeros");
        	}
        	
        });
		
	}
	/**
	 * Modela a janela que mostra os dados que podem ser editados
	 * @param index indice que indica o local do objeto na arraylist
	 */
	public void editar(int index) { //Funcao de editar os dados do cliente
		//Criar os elementos
		JFrame frame = new JFrame("Editar Cliente");
		JLabel nome = new JLabel("Nome: ");
		JLabel cpf = new JLabel("CPF: ");
		JTextField textNome = new JTextField(cclientes.getNome(index));
		JTextField textCPF = new JTextField(cclientes.getCpf(index));
		JButton save = new JButton("Salvar");
		JButton excluir = new JButton("Excluir");
		
		//Estilizar os elementos
		textNome.setBounds(100,5,165,30);
		textCPF.setBounds(100,35,165,30);
		nome.setFont(new Font("Arial", Font.BOLD, 20));
		nome.setBounds(30, 5, 165, 30);
		cpf.setFont(new Font("Arial", Font.BOLD, 20));
		cpf.setBounds(30, 35, 165, 30);
		save.setBounds(50, 77, 80, 20);
		excluir.setBounds(150, 77, 80, 20);

		//Adicionar ao JFrame
		frame.add(save);
		frame.add(excluir);
		frame.add(textCPF);
		frame.add(textNome);
		frame.add(nome);
		frame.add(cpf);
		frame.setLayout(null);
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//Evento dos botoes
		save.addActionListener(a -> {
			cclientes.setCliente(index, textNome.getText(), textCPF.getText());
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Editado");
		});
		
		excluir.addActionListener(b -> {
			cclientes.delCliente(index);
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Excluido");
		});
	}
	/**
	 * Modela a janela que mostra os clientes
	 */
	public void listar() { //Funcao de listar os clientes
		//Criar elementos
		JFrame janela = new JFrame("Lista de Clientes");
		JLabel legenda = new JLabel("Nome / CPF (Selecione o cliente para editar ou apagar)");
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
		
		//Evento aos botoes
		voltar.addActionListener(a -> janela.dispose());
		refresh.addActionListener(b -> {
			janela.dispose();
			listar();
		});
		
		lista.addListSelectionListener(c -> {
			if(!c.getValueIsAdjusting()) {
				editar(lista.getSelectedIndex());
			}
		});
		
		
	}
	/**
	 * Caracteriza o JFrame 
	 * @param f JFrame a ser caracterizado
	 */
	
	public void sets(JFrame f) { //Funcao para padronizar os JFrames principais
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	}   

}
