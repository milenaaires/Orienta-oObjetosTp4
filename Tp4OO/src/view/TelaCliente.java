package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.ControleClientes;
/**
 * Modela a janela que mostra o campo clientes
 * @author Milena Aires
 *
 */
public class TelaCliente implements ActionListener {

	private JFrame janela = new JFrame("Clientes");
	private JLabel titulo = new JLabel("clientes");
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton listar = new JButton("Listar");
	private JButton voltar = new JButton("Voltar");
	private ControleClientes cclientes;
	/**
	 * Construtor TelaCliente
	 * @param cclientes manuseia os dados de cliente
	 */
	public TelaCliente(ControleClientes cclientes) { //Funcao principal
		this.cclientes = cclientes;
		//Estiliza os elementos
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 165, 30);
		cadastrar.setBounds(125, 50, 140, 30);
        cadastrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        listar.setBounds(125, 100, 140, 30);
        listar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        voltar.setBounds(125, 250, 140, 30);	
        voltar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
		//Eventos aos botoes
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
	public void sets(JFrame f) { //Funcao para setar o estilo dos JFrames primarios
		f.setLayout(null);
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	}    
	    
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastrar)
			new TelaDetalheCliente(cclientes).cadastrar(1);
		if(src == voltar)
			janela.dispose();
		if(src == listar)
			new TelaDetalheCliente(cclientes).listar();
	}
}

