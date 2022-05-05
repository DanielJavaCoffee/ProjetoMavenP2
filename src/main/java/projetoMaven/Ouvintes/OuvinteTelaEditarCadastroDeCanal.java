package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.Telas.TelaDeListarCanal;
import projetoMaven.Telas.TelaEditarCadastroDeCanal;
import projetoMaven.entity.Canal;

public class OuvinteTelaEditarCadastroDeCanal implements ActionListener {

	public TelaEditarCadastroDeCanal telaEditarCadastroDeCanal;
	
	public TelaEditarCadastroDeCanal getTelaEditarCadastroDeCanal() {
		return telaEditarCadastroDeCanal;
	}
	
	public OuvinteTelaEditarCadastroDeCanal(TelaEditarCadastroDeCanal tela) {
		this.telaEditarCadastroDeCanal = tela;
	}

	public void actionPerformed(ActionEvent e) {
		
      String nome = telaEditarCadastroDeCanal.getCampoNome().getText();
      String campo = telaEditarCadastroDeCanal.getCampoFormaDeAssistir().getText();
      String linkOuCanal = telaEditarCadastroDeCanal.getCampoNumeroOuLink().getText();
      String numero = telaEditarCadastroDeCanal.getCampoFormaDeAssistir().getText();
	}

	public void actionPerformedVoltar(ActionEvent e) {	
		new TelaDeListarCanal(null);
		telaEditarCadastroDeCanal.setVisible(false);
	}
}
