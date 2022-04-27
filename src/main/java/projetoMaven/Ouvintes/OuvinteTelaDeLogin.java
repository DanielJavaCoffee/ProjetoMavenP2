package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projetoMaven.DAO.UsuarioDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaDeCadastroDeUsuario;
import projetoMaven.Telas.TelaDeLogin;
import projetoMaven.entity.Usuario;
import projetoMaven.model.MensageiroEmail;

public class OuvinteTelaDeLogin implements ActionListener {

	private TelaDeLogin telaDeLogin;

	public TelaDeLogin getTelaDeLogin() {
		return telaDeLogin;
	}

	public OuvinteTelaDeLogin(TelaDeLogin tela) {
		this.telaDeLogin = tela;
	}

	public void actionPerformed(ActionEvent proseguir) {

		String email = telaDeLogin.getCampoEmail().getText();
		String senha = telaDeLogin.getCampoEmail().getText();
		
		if(email.isBlank() || senha.isBlank()) {
			Mensagem.usuarioCampoVazio();
		} 
	}

	public void actionPerformedSenha(ActionEvent senha) {
		
		long id = Long.parseLong(JOptionPane.showInputDialog(telaDeLogin, "Informe o nome do usuário: "));
		if(UsuarioDAO.existeUsuario(id) != null) {
			
			MensageiroEmail.enviarMensagemAoCliente("Sua Senha", UsuarioDAO.existeUsuario(id).getEmail(), 
					UsuarioDAO.existeUsuario(id).getSenha() + UsuarioDAO.existeUsuario(id).getEmail());
			Mensagem.emailEnviadoUsuario();
			
		} else {
			Mensagem.usuarioNaoEncontrado();
		}
	}
}
