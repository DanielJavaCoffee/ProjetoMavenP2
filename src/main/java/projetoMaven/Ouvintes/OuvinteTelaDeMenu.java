package projetoMaven.Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projetoMaven.DAO.UsuarioDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaCadastroDeCanal;
import projetoMaven.Telas.TelaDeListarCanal;
import projetoMaven.Telas.TelaDeMenu;

public class OuvinteTelaDeMenu implements ActionListener {

	private TelaDeMenu telaDeMenu;

	public TelaDeMenu getTelaDeMenu() {
		return telaDeMenu;
	}

	public OuvinteTelaDeMenu(TelaDeMenu tela) {
		this.telaDeMenu = tela;
	}

	public void actionPerformed(ActionEvent clique) {
		
		String comando = clique.getActionCommand();
		if (comando.equals("Cadastrar Canal")) {
			new TelaCadastroDeCanal(null);
			telaDeMenu.setVisible(false);
		} else if(comando.equals("Listar Canal")) {
			new TelaDeListarCanal(null);
			telaDeMenu.setVisible(false);
		}
	}
    
	public void actionPerformedExcluir(ActionEvent clique) {

		Long id = Long.parseLong(JOptionPane.showInputDialog("ID do usuário: "));
		if(UsuarioDAO.excluirUsuario(id)) {
			Mensagem.usuarioExcluir();
		} else {
			Mensagem.usuarioNaoEncontrado();
		}
	}
}
