package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaCadastroDeCanal;
import projetoMaven.Telas.TelaDeMenu;
import projetoMaven.entity.Canal;
import projetoMaven.enums.CanalForma;

public class OuvinteTelaDeCadastroDeCanal implements ActionListener {

	private TelaCadastroDeCanal telaCadastroDeCanal;

	public TelaCadastroDeCanal getTelaCadastroDeCanal() {
		return telaCadastroDeCanal;
	}

	public OuvinteTelaDeCadastroDeCanal(TelaCadastroDeCanal tela) {
		this.telaCadastroDeCanal = tela;
	}

	public void actionPerformed(ActionEvent e) {

		String nomeDoCanal = telaCadastroDeCanal.getCampoNome().getText();
	//	String valor = telaCadastroDeCanal.getCampoFormaDeAssistir().getText();
   //  	String canalOuLink = telaCadastroDeCanal.getCampoNumeroOuLink().getText();

		String[] operacao = { "canal aberto de televisão", "broadcasting aberto na interne", "pacote de assinatura",
				"assinatura individual de televisão", "Assinatura Individual De Broadcasting" };
		String entrada = (String) JOptionPane.showInputDialog(null, "Qual Forma De Canal.", "",
				JOptionPane.WARNING_MESSAGE, null, operacao, operacao[0]);;

		if (entrada == operacao[0]) {
			String numeroDoCanal = JOptionPane.showInputDialog("Número Do Canal: ");
			Canal c = new Canal(nomeDoCanal, CanalForma.CANAL_ABERTO.toString(), numeroDoCanal, null);
			CanalDAO.saveUpDateCanal(c);
		} else if (entrada == operacao[1]) {
			String link = JOptionPane.showInputDialog("Link: ");
			Canal c = new Canal(nomeDoCanal, CanalForma.BROADCASTING.toString(), null, link);
			CanalDAO.saveUpDateCanal(c);
		} else if (entrada == operacao[2]) {
			String numeroDoCanal = JOptionPane.showInputDialog("Número Do Canal: ");
			Canal c = new Canal(nomeDoCanal, CanalForma.PACOTE_DE_ASSINATURA.toString(), numeroDoCanal, null);
			CanalDAO.saveUpDateCanal(c);
		} else if (entrada == operacao[3]) {
			String link = JOptionPane.showInputDialog("Link: ");
			Canal c = new Canal(nomeDoCanal, CanalForma.ASSINATURA_INDIVIDUAL_DE_TELEVISAO.toString(), null, link);
			CanalDAO.saveUpDateCanal(c);
		} else {
			String link = JOptionPane.showInputDialog("Link: ");
			Canal c = new Canal(nomeDoCanal, CanalForma.ASSINATURA_INDIVIDUAL_DE_BROADCASTING.toString(), null, link);
			CanalDAO.saveUpDateCanal(c);
		}
		telaCadastroDeCanal.setVisible(false);
		new TelaCadastroDeCanal(null);

	}

	public void actionPerformedVoltar(ActionEvent e) {
		new TelaDeMenu(null);
		telaCadastroDeCanal.setVisible(false);
	}
}
/*
 * /* String[] operação = { "canal aberto de televisão",
 * "broadcasting aberto na interne", "pacote de assinatura",
 * "assinatura individual de televisão", "assinatura individual de radiodifusão"
 * }; String entrada = (String) JOptionPane.showInputDialog(null,
 * "Qual Forma De Canal.", "", JOptionPane.WARNING_MESSAGE, null, operação,
 * operação[0]);
 *
 * if (entrada == operacao[0]) { String numeroDoCanal =
 * JOptionPane.showInputDialog("Número Do Canal: "); Canal do canal = novo
 * Canal(nomeDoCanal, CanalForma.CANAL_ABERTO, numeroDoCanal); } else if(entrada
 * == operação[1]) { String link = JOptionPane.showInputDialog("Link: "); Canal
 * canal = new Canal(nomeDoCanal, CanalForma.BROADCASTING, link); } senão
 * if(entrada == operação[2]) { String numeroDoCanal =
 * JOptionPane.showInputDialog("Número Do Canal: "); Canal do canal = novo
 * Canal(nomeDoCanal, CanalForma.PACOTE_DE_ASSINATURA, numeroDoCanal); } senão
 * if(entrada == operação[3]) { String link =
 * JOptionPane.showInputDialog("Link: "); Canal canal = novo Canal(nomeDoCanal,
 * CanalForma.ASSINATURA_INDIVIDUAL_DE_TELEVISAO, link); } else { String link =
 * JOptionPane.showInputDialog("Link: "); Canal canal = novo Canal(nomeDoCanal,
 * CanalForma.ASSINATURA_INDIVIDUAL_DE_BROADCASTING, link); }
 */


/*
switch (canal.getCanalForma()) {
case CANAL_ABERTO:

	String getCurrency = CanalForma.CANAL_ABERTO.toString();
	Canal canals = new Canal(nomeDoCanal, getCurrency, canalOuLink);
	CanalDAO.saveUpDateCanal(canals);
	break;
case BROADCASTING:
	canals = new Canal(nomeDoCanal, CanalForma.BROADCASTING, canalOuLink);
	CanalDAO.saveUpDateCanal(canals);
	break;
case PACOTE_DE_ASSINATURA:
	canals = new Canal(nomeDoCanal, CanalForma.PACOTE_DE_ASSINATURA, canalOuLink);
	CanalDAO.saveUpDateCanal(canals);
	break;
case ASSINATURA_INDIVIDUAL_DE_TELEVISAO:
	canals = new Canal(nomeDoCanal, CanalForma.ASSINATURA_INDIVIDUAL_DE_TELEVISAO, canalOuLink);
	CanalDAO.saveUpDateCanal(canals);
	break;
case ASSINATURA_INDIVIDUAL_DE_BROADCASTING:
	canals = new Canal(nomeDoCanal, CanalForma.ASSINATURA_INDIVIDUAL_DE_BROADCASTING, canalOuLink);
	CanalDAO.saveUpDateCanal(canals);
	break;
default:
	Mensagem.canalOpcaoInvalida();
	break;
}*/