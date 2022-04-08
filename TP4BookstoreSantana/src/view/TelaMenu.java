package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;
/**
 * Modela a janela principal com todas as opções relacionadas a bookstore santana
 * @author MilenaAires
 *
 */
public class TelaMenu implements ActionListener{
    
    private static JFrame menu = new JFrame("BOOKSTORE SANTANA");
    private static JLabel titulo = new JLabel("Menu Principal");
    private static JButton book = new JButton("EBOOK");
    private static JButton cliente = new JButton("CLIENTE");
    private static JButton venda = new JButton("VENDA");
    private static JButton premium = new JButton("PREMIUM");
    private static JButton sair = new JButton("Sair");
    public static Dados dados = new Dados();
    private ControleBooks cbooks = new ControleBooks (dados);
    private ControleClientes cclientes = new ControleClientes(dados);
    private ControleVendas cvendas = new ControleVendas(dados);
    private ControlePremium cpremium = new ControlePremium(dados);
    /**
     * Construtor TelaMenu constroi a tela de menu
     */
    public TelaMenu(){
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(125, 10, 150, 30);
		book.setBounds(125, 50, 140, 30);
        book.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		cliente.setBounds(125, 100, 140, 30);
        cliente.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		venda.setBounds(125, 150, 140, 30);	
        venda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        premium.setBounds(125, 200, 140, 30);
        premium.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sair.setBounds(125, 250, 140, 30);	
        sair.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		menu.add(titulo);
        menu.add(book);
        menu.add(cliente);
        menu.add(venda);
        menu.add(premium);
        menu.add(sair);
		menu.setLayout(null);
		menu.setSize(400, 350);
        menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
		menu.setResizable(false);
    }
    public static void main(String[] args) {
        TelaMenu menu = new TelaMenu();
        cliente.addActionListener(menu);
        sair.addActionListener(menu);
        book.addActionListener(menu);
        venda.addActionListener(menu);
        premium.addActionListener(menu);
    }

    
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        int resposta;

        if(src == book){
        	new TelaBooks(cbooks);//chama a tela de books
        }

        if(src == cliente){
        	new TelaCliente(cclientes);//chama a tela de clientes 
        }

        if(src == venda){
        	new TelaVenda(cvendas, cclientes);//chama a tela de vendas
        }

        if(src == premium){
        	new TelaPremium(cpremium, cvendas, cclientes);//chama a tela de premium
        }

        if(src == sair){
            resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
            if(resposta == JOptionPane.YES_OPTION){
                menu.dispose();
                JOptionPane.showMessageDialog(null, "Saindo!\nObrigado, Volte sempre!\n BOOKSTORE SANTANA ");
            }
        }
    }
}