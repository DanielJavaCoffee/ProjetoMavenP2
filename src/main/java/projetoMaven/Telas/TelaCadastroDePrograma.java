package projetoMaven.Telas;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.JanelaPadrao.JanelaTelaCadastroDePrograma;
import projetoMaven.Ouvintes.OuvinteTelaDeCadastroDePrograma;
import projetoMaven.entity.Canal;

public class TelaCadastroDePrograma extends JanelaTelaCadastroDePrograma {

	OuvinteTelaDeCadastroDePrograma ouvinte = new OuvinteTelaDeCadastroDePrograma(this);

	private JTextField campoNomeDoPrograma;
	private JTextField campoIDCanal;
	private JFormattedTextField campoData;
	private JFormattedTextField campoHorario;
	private Button buttonVoltar;
	private Button buttonSalvar;

	public TelaCadastroDePrograma(String titulo) {
		super(titulo);
		adicionarTitulo();
		listarPrograma();
		adicionarJLabel();
		adicionarJTextFild();
		adicionarButtonVoltar();
		adicionarButtonSalvar();
		setVisible(true);
	}

	private void adicionarTitulo() {
		JLabel jLabel = new JLabel("CADASTRO DE PROGRAMA", JLabel.CENTER);
		jLabel.setBounds(0, 0, 900, 50);
		jLabel.setBackground(Color.GRAY);
		jLabel.setOpaque(true);
		add(jLabel);
	}

	private void listarPrograma() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("ID");
		modelo.addColumn("Forma De Assistir");
		modelo.addColumn("Link Do Canal");
		modelo.addColumn("Nome Do Canal");
		modelo.addColumn("Número Do Canal");

		ArrayList<Canal> canais = CanalDAO.findAll();

		Collections.sort(canais);

		Object[] linhas = new Object[canais.size()];
		for (Canal canal : canais) {
			Object[] linha = new Object[5];
			linha[0] = canal.getId();
			linha[1] = canal.getForma();
			linha[2] = canal.getLinkDocanal();
			linha[3] = canal.getNomeDoCanal();
			linha[4] = canal.getNumeroDoCanal();
			modelo.addRow(linha);
		}

		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(40, 100, 800, 190);
		add(painelTabela);

	}

	private void adicionarJLabel() {

		JLabel nome = new JLabel("Nome Do Programa: ");
		nome.setBounds(40, 300, 130, 30);
		add(nome);

		JLabel id = new JLabel("ID Do Canal: ");
		id.setBounds(40, 350, 130, 30);
		add(id);

		JLabel data = new JLabel("Data Do Programa: ");
		data.setBounds(40, 400, 130, 30);
		add(data);

		JLabel horario = new JLabel("Horario Do Programa: ");
		horario.setBounds(40, 450, 130, 30);
		add(horario);
	}

	private void adicionarJTextFild() {

		campoNomeDoPrograma = new JTextField();
		campoNomeDoPrograma.setBounds(180, 300, 200, 30);
		add(campoNomeDoPrograma);

		campoIDCanal = new JTextField();
		campoIDCanal.setBounds(180, 350, 200, 30);
		add(campoIDCanal);

		try {
			campoData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		campoData.setBounds(180, 400, 70, 30);
		add(campoData);

		try {
			campoHorario = new JFormattedTextField(new MaskFormatter("##:##"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		campoHorario.setBounds(180, 450, 70, 30);
		add(campoHorario);
	}

	private void adicionarButtonVoltar() {

		buttonVoltar = new Button("Voltar");
		buttonVoltar.setBounds(40, 600, 100, 30);
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

	private void adicionarButtonSalvar() {

		buttonSalvar = new Button("Salvar");
		buttonSalvar.setBounds(720, 600, 100, 30);
		buttonSalvar.addActionListener(salvar());
		add(buttonSalvar);
	}

	public ActionListener salvar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedSalvar(e);
			}
		};
	}

	public JTextField getCampoNomeDoPrograma() {
		return campoNomeDoPrograma;
	}

	public JTextField getCampoIDCanal() {
		return campoIDCanal;
	}

	public JFormattedTextField getCampoData() {
		return campoData;
	}

	public JFormattedTextField getCampoHorario() {
		return campoHorario;
	}

	public Button getButtonVoltar() {
		return buttonVoltar;
	}

	public Button getButtonSalvar() {
		return buttonSalvar;
	}
}
