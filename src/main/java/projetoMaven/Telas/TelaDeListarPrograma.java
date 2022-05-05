package projetoMaven.Telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.DAO.ProgramaDAO;
import projetoMaven.JanelaPadrao.JanelaPadrao;
import projetoMaven.Ouvintes.OuvinteTelaDeListarPrograma;
import projetoMaven.entity.Canal;
import projetoMaven.entity.Programa;

public class TelaDeListarPrograma extends JanelaPadrao {
	
	OuvinteTelaDeListarPrograma ouvinte = new OuvinteTelaDeListarPrograma(this);
	
	private JButton buttonVoltar;
	private JButton buttonExcluir;
	private JButton buttonAtualizar;
	private JTextField campoBusca;

	public TelaDeListarPrograma(String titulo) {
		super(titulo);
		adicionarJLabel();
		adicionarJButtonVoltar();
		adicionarJButtonAtualizar();
		adicionarJButtonExcluir();
		listarPrograma();
		setVisible(true);

	}

	private void adicionarJLabel() {

		JLabel jLabel = new JLabel("TELA DE LISTAR PROGRAMA, EXCLUIR E ATUALIZAR", JLabel.CENTER);
		jLabel.setBackground(Color.GRAY);
		jLabel.setOpaque(true);
		jLabel.setBounds(0, 0, 700, 50);
		add(jLabel);
	}


	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(30, 400, 100, 30);
		buttonVoltar.addActionListener(voltar());
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarJButtonAtualizar() {

		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBounds(450, 400, 100, 30);
		buttonAtualizar.addActionListener(atualizar());
		add(buttonAtualizar);
	}

	public ActionListener atualizar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedAtualizar(e);
			}
		};
	}

	private void adicionarJButtonExcluir() {

		buttonExcluir = new JButton("Excluir");
		buttonExcluir.setBounds(570, 400, 100, 30);
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

	private void listarPrograma() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("ID");
		modelo.addColumn("Forma De Assistir");
		modelo.addColumn("Link Do Canal");
		modelo.addColumn("Nome Do Canal");
		modelo.addColumn("Número Do Canal");

		ArrayList<Programa> programas = ProgramaDAO.findAll();

		Collections.sort(programas);

		Object[] linhas = new Object[programas.size()];
		for (Programa programa : programas) {
			Object[] linha = new Object[5];
			linha[0] = programa.getId();
			linha[1] = programa.getNomeDoPrograma();
			linha[2] = programa.getNomeDoCanal();
			linha[3] = programa.getDataDoPrograma();
			linha[4] = programa.getHorario();
			modelo.addRow(linha);
		}

		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(20, 60, 650, 190);
		add(painelTabela);
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}

	public JButton getButtonAtualizar() {
		return buttonAtualizar;
	}

	public JTextField getCampoBusca() {
		return campoBusca;
	}

}
