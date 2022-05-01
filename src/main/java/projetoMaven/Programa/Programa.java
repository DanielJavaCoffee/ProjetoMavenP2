package projetoMaven.Programa;

import java.util.List;

import projetoMaven.DAO.UsuarioDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaDeCadastroDeUsuario;
import projetoMaven.Telas.TelaDeLogin;
import projetoMaven.entity.Usuario;

public class Programa {

	public static void main(String[] args) {

		try {

			List<Usuario> lista = UsuarioDAO.findAll();

			if (lista != null && lista.size() > 0) {
				new TelaDeLogin(null);
			} else {
				new TelaDeCadastroDeUsuario(null);
			}
		} catch (Exception e) {
			Mensagem.exception(e);
		}
	}
}
