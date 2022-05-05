package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaCadastroDeCanal;
import projetoMaven.Telas.TelaDeListarCanal;
import projetoMaven.Telas.TelaDeMenu;
import projetoMaven.Telas.TelaEditarCadastroDeCanal;

public class OuvinteTelaDeListarCanal implements ActionListener {

	private TelaDeListarCanal telaDeListarCanal;

	public TelaDeListarCanal getTelaDeListarCanal() {
		return telaDeListarCanal;
	}

	public OuvinteTelaDeListarCanal(TelaDeListarCanal tela) {
		this.telaDeListarCanal = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaDeListarCanal.setVisible(false);
	}

	public void actionPerformedExcluir(ActionEvent e) {
		try {
			Long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID: "));
			if (CanalDAO.excluirCanal(id)) {
				Mensagem.canalExcluido();
				telaDeListarCanal.setVisible(false);
				new TelaDeListarCanal(null);
			} else {
				Mensagem.canalNaoEncontardo();
			}
		} catch (NumberFormatException erro) {
			Mensagem.numberFormatException(erro);
		}
	}

	public void actionPerformedAtualizar(ActionEvent e) {
		try {

			Long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID: "));
			if (CanalDAO.existeCanal(id) != null) {
                new TelaEditarCadastroDeCanal(null, CanalDAO.existeCanal(id));
				telaDeListarCanal.setVisible(false);
			} else {
				Mensagem.canalNaoEncontardo();
			}
		} catch (NumberFormatException erro) {
			Mensagem.numberFormatException(erro);
		}
	}

}
