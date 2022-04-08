package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;
/**
 * Modela a janela de vendas (funcoes e vendas)
 * @author Milena Aires
 *
 */
public class TelaVenda implements ActionListener{
	
	private JFrame janela = new JFrame("");
	private JLabel titulo = new JLabel("Vendas");
	private JButton cadastrar = new JButton("Cadastrar Venda");
	private JButton listar = new JButton("Listar Vendas");
	private JButton voltar = new JButton("Voltar");
	private static ControleClientes cclientes;
	private static ControleVendas cvendas;
	/**
	 * Construtor TelaVenda, recebe as classes de manuseio dos dados de vendas e cliente
	 * @param cvendas objeto que manuseia os dados de venda
	 * @param cclientes objeto que manuseia os dados de cliente
	 */
	public TelaVenda(ControleVendas cvendas, ControleClientes cclientes) {
		this.cclientes = cclientes;
		this.cvendas = cvendas;
		
		//Estiliza os botoes e labels
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 165, 30);
		cadastrar.setBounds(125, 50, 140, 30);
        cadastrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        listar.setBounds(125, 100, 140, 30);
        listar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        voltar.setBounds(125, 250, 140, 30);	
        voltar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
		//Adiciona o evento aos botoes
        cadastrar.addActionListener(this);
        voltar.addActionListener(this);
        listar.addActionListener(this);
		

		//Adicionar tudo ao JFrame
        sets(janela);
        janela.add(titulo);
        janela.add(cadastrar);
        janela.add(listar);
        janela.add(voltar);		
	}
	/**
	 * Caracteriza o JFrame 
	 * @param f JFrame a ser caracterizado
	 */
	public void sets(JFrame f) { //Funcao para definir o padrao dos JFrames
		f.setLayout(null);
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	}   
	
	public void actionPerformed(ActionEvent e) { //Funcao resposta aos eventos dos botoes
		Object src = e.getSource();
		
		if(src == cadastrar)
			new TelaDetalheVenda(cvendas, cclientes).cadastroVenda();//chama a janela de cadastro de venda
		if(src == voltar)
			janela.dispose();
		if(src == listar)
			new TelaDetalheVenda(cvendas, cclientes).listarClientes();//chama a janela de detalhes da venda
	}
}
