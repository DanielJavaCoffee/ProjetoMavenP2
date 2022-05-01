package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projetoMaven.DAO.UsuarioDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaDeCadastroDeUsuario;
import projetoMaven.Telas.TelaDeMenu;
import projetoMaven.entity.Usuario;

public class OuvinteTelaDeCadastroDeUsuario implements ActionListener{
	
	private TelaDeCadastroDeUsuario telaDeCadastroDeUsuario;

	public TelaDeCadastroDeUsuario getTelaDeCadastroDeUsuario() {
		return telaDeCadastroDeUsuario;
	}
	
	public OuvinteTelaDeCadastroDeUsuario(TelaDeCadastroDeUsuario tela) {
		this.telaDeCadastroDeUsuario = tela;
	}

	public void actionPerformed(ActionEvent e) {
		
		// salvarUsuario
		String nome = telaDeCadastroDeUsuario.getCampoNome().getText();
		String email = telaDeCadastroDeUsuario.getCampoEmail().getText();
		String senha01 = telaDeCadastroDeUsuario.getCampoSenha01().getText();
		String senha02 = telaDeCadastroDeUsuario.getCampoSenha02().getText();
		
		if(nome.isBlank() || email.isBlank() || senha01.isBlank() || senha02.isBlank()) {
			Mensagem.usuarioCampoVazio();
		} else if(!senha01.equals(senha02)) {
			Mensagem.usuarioSenhaErrada();
		} else {
			Usuario usuario = new Usuario(nome, email, senha01);
			UsuarioDAO.saveUpDate(usuario);
			new TelaDeMenu(null);
			telaDeCadastroDeUsuario.setVisible(false);
		}
	}	
}
