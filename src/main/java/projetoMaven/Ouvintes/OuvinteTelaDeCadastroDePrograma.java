package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.DAO.ProgramaDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaCadastroDePrograma;
import projetoMaven.Telas.TelaDeMenu;
import projetoMaven.entity.Programa;

public class OuvinteTelaDeCadastroDePrograma implements ActionListener {

	private TelaCadastroDePrograma telaCadastroDePrograma;

	public TelaCadastroDePrograma getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDePrograma(TelaCadastroDePrograma tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaCadastroDePrograma.setVisible(false);
	}

	public void actionPerformedSalvar(ActionEvent e) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
		Long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
		Date date = null;
		try {
			 date = (Date) sdf1.parse(telaCadastroDePrograma.getCampoData().getText());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String horario = telaCadastroDePrograma.getCampoHorario().getText();
		
		if(CanalDAO.existeCanal(id) != null) {
			Programa programa = new Programa(nome, CanalDAO.existeCanal(id), date, horario);
			ProgramaDAO.saveUpDate(programa);
		} else {
			Mensagem.canalNaoEncontardo();
		}
	}
}
