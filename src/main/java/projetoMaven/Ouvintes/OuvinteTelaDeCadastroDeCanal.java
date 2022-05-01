package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		Canal c = new Canal(nomeDoCanal, null, nomeDoCanal);

		switch (c.getCanalForma()) {
		case CANAL_ABERTO:
			Canal canal = new Canal(nomeDoCanal, CanalForma.CANAL_ABERTO, nomeDoCanal);
		case BROADCASTING:
			canal = new Canal(nomeDoCanal, CanalForma.BROADCASTING, nomeDoCanal);
		case PACOTE_DE_ASSINATURA:
			canal = new Canal(nomeDoCanal, CanalForma.PACOTE_DE_ASSINATURA, nomeDoCanal);
		case ASSINATURA_INDIVIDUAL_DE_TELEVISAO:
			canal = new Canal(nomeDoCanal, CanalForma.ASSINATURA_INDIVIDUAL_DE_TELEVISAO, nomeDoCanal);
		case ASSINATURA_INDIVIDUAL_DE_BROADCASTING:
			canal = new Canal(nomeDoCanal, CanalForma.ASSINATURA_INDIVIDUAL_DE_BROADCASTING, nomeDoCanal);
			CanalDAO.saveUpDateCanal(canal);
			break;
		default:
			Mensagem.canalOpcaoInvalida();
			break;
		}
	}

	public void actionPerformedVoltar(ActionEvent e) {
		new TelaDeMenu(null);
		telaCadastroDeCanal.setVisible(false);
	}
}

/*
 * String[] opercao = { "canal aberto de televisão",
 * "broadcasting aberto na interne", "pacote de assinatura",
 * "assinatura individual de televisão", "assinatura individual de broadcasting"
 * }; String entrada = (String) JOptionPane.showInputDialog(null,
 * "Qual Forma De Canal.", "", JOptionPane.WARNING_MESSAGE, null, opercao,
 * opercao[0]);
 * 
 * if (entrada == opercao[0]) { String numeroDoCanal =
 * JOptionPane.showInputDialog("Número Do Canal: "); Canal canal = new
 * Canal(nomeDoCanal, CanalForma.CANAL_ABERTO, numeroDoCanal); } else if(entrada
 * == opercao[1]) { String link = JOptionPane.showInputDialog("Link: "); Canal
 * canal = new Canal(nomeDoCanal, CanalForma.BROADCASTING, link); } else
 * if(entrada == opercao[2]) { String numeroDoCanal =
 * JOptionPane.showInputDialog("Número Do Canal: "); Canal canal = new
 * Canal(nomeDoCanal, CanalForma.PACOTE_DE_ASSINATURA, numeroDoCanal); } else
 * if(entrada == opercao[3]) { String link =
 * JOptionPane.showInputDialog("Link: "); Canal canal = new Canal(nomeDoCanal,
 * CanalForma.ASSINATURA_INDIVIDUAL_DE_TELEVISAO, link); } else { String link =
 * JOptionPane.showInputDialog("Link: "); Canal canal = new Canal(nomeDoCanal,
 * CanalForma.ASSINATURA_INDIVIDUAL_DE_BROADCASTING, link); }
 */
