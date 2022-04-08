package view;


import controle.*;
import java.awt.*;
import javax.swing.*;
/**
 * Constroi a janela com as funcionalidades da classe premium
 * @author Milena Aires
 *
 */
public class TelaPremium {
	private static ControleClientes cclientes;
	private static ControleVendas cvendas;
	private static ControlePremium  cpremium;
	private JFrame telaPrem = new JFrame();
	/**
	 * Construtor TelaPremium constroi a janela da tela premium, tem como argumento os objetos de manuseio de dados
	 * @param cpremium objeto que manipula os dados de premium
	 * @param cvendas objeto que manipula os dados de vendas
	 * @param cclientes objeto que manipula os dados de clientes
	 */
	public TelaPremium(ControlePremium cpremium, ControleVendas cvendas, ControleClientes cclientes) {
		this.cclientes = cclientes;
		this.cvendas= cvendas;
		this.cpremium =cpremium;
		String[] cs = {"teste", "teste2"};
		sets(telaPrem);
		telaPrem.setLayout(new BorderLayout());
		JList<Object> listaFide = new JList<Object>(cpremium.getPremium());
		JScrollPane scrollFide = new JScrollPane(listaFide);
		JButton voltar = new JButton("Voltar");
		telaPrem.add(scrollFide);
		telaPrem.add(voltar, BorderLayout.SOUTH);
		voltar.addActionListener(a -> telaPrem.dispose());
	}
	/**
	 * Caracteriza o JFrame 
	 * @param f JFrame a ser caracterizado
	 */
	public void sets(JFrame f) {
		f.setLayout(null);
		f.setSize(400, 350);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
	} 
}
