package projetoMaven.Application;

import java.util.ArrayList;
import java.util.List;

import projetoMaven.DAO.CanalDAO;
import projetoMaven.DAO.UsuarioDAO;
import projetoMaven.Mensagem.Mensagem;
import projetoMaven.Telas.TelaDeCadastroDeUsuario;
import projetoMaven.Telas.TelaDeLogin;
import projetoMaven.entity.Canal;
import projetoMaven.entity.Usuario;
import projetoMaven.model.ClassePDF;

public class Main {

	public static void main(String[] args) {

		try {

			List<Usuario> lista = UsuarioDAO.findAll();
			ArrayList<Canal> canal = CanalDAO.findAll();

			ClassePDF.geradorDePDF(canal, "PDF canal");
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
