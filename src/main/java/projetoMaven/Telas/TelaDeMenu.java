package projetoMaven.Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projetoMaven.JanelaPadrao.JanelaPadrao;
import projetoMaven.Ouvintes.OuvinteTelaDeMenu;

public class TelaDeMenu extends JanelaPadrao {

    OuvinteTelaDeMenu ouvinte = new OuvinteTelaDeMenu(this);
	
	private JButton buttonExcluir;
	private JMenuBar jMenuBar;

	public TelaDeMenu(String titulo) {
		super(titulo);
		adicionarTitulo();
		excluirUsuario();
		adicionarMenu();
		setVisible(true);

	}

	private void adicionarTitulo() {

		JLabel jLabel = new JLabel("TELA DE MENU", JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 50);
		jLabel.setBackground(Color.GRAY);
		jLabel.setOpaque(true);
		add(jLabel);
	}

	private void excluirUsuario() {

		buttonExcluir = new JButton("Excluir Usuário");
		buttonExcluir.setBounds(500, 370, 150, 30);
		buttonExcluir.addActionListener(excluir());
		add(buttonExcluir);
	}

	public ActionListener excluir() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                 ouvinte.actionPerformedExcluir(e);
			}
		};
	}

	private void adicionarMenu() {

		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		JMenu menuOp = new JMenu("Opçoes");
		jMenuBar.add(menuOp);

		JMenuItem cadastroDeCanal = new JMenuItem("Cadastrar Canal");
		menuOp.add(cadastroDeCanal);
		cadastroDeCanal.addActionListener(ouvinte);
		
		
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}

}
